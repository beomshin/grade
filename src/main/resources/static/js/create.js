const categoryMap = {
    lck_2026_person: 0,
    car: 1,
    it: 2,
    estate: 3,
    lck_2026_rank: 5
};

let currentCategory = 'lck_2026_rank';
let draggedElement = null;

// 페이지 로드 시 초기화
document.addEventListener('DOMContentLoaded', () => {
    initializePage();
});

function initializePage() {
    // 카테고리 탭 이벤트
    document.querySelectorAll('.tab-btn').forEach((btn, index) => {
        btn.addEventListener('click', (e) => {
            document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
            e.target.classList.add('active');
            currentCategory = e.target.dataset.category;

            if (document.getElementById('itemsPool')) {
                document.querySelectorAll(".tier-item").forEach(item => {
                    item.style.display = "none";
                });

                const targetClass = `.item-${e.target.dataset.number}`;
                document.querySelectorAll(targetClass).forEach(item => {
                    item.style.display = "flex";  // 혹은 block, inline-flex 등 UI에 맞게
                });
            }
        });
    });



    // 등급표 작성 페이지
    if (document.getElementById('itemsPool')) {
        // loadCreatePage();
        initializeDragAndDrop();

        // 버튼 이벤트
        document.getElementById('resetBtn').addEventListener('click', resetTiers);
        document.getElementById('submitBtn').addEventListener('click', submitRanking);
        document.getElementById('closeModal')?.addEventListener('click', closeModal);
    }



}

document.querySelectorAll(".tab-btn").forEach(btn => {
    btn.addEventListener("click", () => {
        document.querySelectorAll(".tab-btn").forEach(b => b.classList.remove("active"));
        btn.classList.add("active");

        document.querySelectorAll(".tier-pyramid").forEach(tp => tp.classList.remove("active"));
    });
});

// 공유 버튼 클릭
document.getElementById("shareBtn").addEventListener("click", async () => {
    const shareData = {
        title: document.title,
        text: "등급표 보러가기!",
        url: window.location.href
    };

    // Web Share API 지원 시
    if (navigator.share) {
        try {
            await navigator.share(shareData);
        } catch (e) {
            console.log("공유 취소", e);
        }
        return;
    }

    // 지원 안되면 → fallback 모달 오픈
    document.getElementById("shareModal").style.display = "flex";
});


// 드래그 앤 드롭 초기화
function initializeDragAndDrop() {
    document.addEventListener('dragstart', handleDragStart);
    document.addEventListener('dragend', handleDragEnd);
    document.addEventListener('dragover', handleDragOver);
    document.addEventListener('drop', handleDrop);
    document.addEventListener('dragleave', handleDragLeave);

    // Mobile Touch Events
    document.addEventListener('touchstart', handleTouchStart, { passive: true });
    document.addEventListener('touchmove', handleTouchMove, { passive: false });
    document.addEventListener('touchend', handleTouchEnd);
    document.addEventListener('touchcancel', handleTouchEnd);
}

function handleDragStart(e) {
    if (e.target.classList.contains('tier-item')) {
        draggedElement = e.target;
        e.target.classList.add('dragging');
        e.dataTransfer.effectAllowed = 'move';
    }
}

function handleDragEnd(e) {
    if (e.target.classList.contains('tier-item')) {
        e.target.classList.remove('dragging');
    }
}

function handleDragOver(e) {
    if (e.preventDefault) {
        e.preventDefault();
    }

    const dropZone = e.target.closest('.drop-zone') || e.target.closest('.pool-items');
    if (dropZone) {
        dropZone.classList.add('drag-over');
        e.dataTransfer.dropEffect = 'move';
    }

    return false;
}

function handleDragLeave(e) {
    const dropZone = e.target.closest('.drop-zone') || e.target.closest('.pool-items');
    if (dropZone) {
        dropZone.classList.remove('drag-over');
    }
}

function handleDrop(e) {
    if (e.stopPropagation) {
        e.stopPropagation();
    }

    const dropZone = e.target.closest('.drop-zone') || e.target.closest('.pool-items');

    if (dropZone && draggedElement) {
        dropZone.classList.remove('drag-over');
        dropZone.appendChild(draggedElement);
    }

    return false;
}

// ---------------- Mobile Touch ----------------

function handleTouchStart(e) {
    const item = e.target.closest('.tier-item');
    if (!item) return;

    draggedElement = item;
    isTouchDragging = true;

    item.classList.add('dragging');
}

function handleTouchMove(e) {
    if (!isTouchDragging || !draggedElement) return;

    e.preventDefault(); // 중요: 스크롤 방지

    const touch = e.touches[0];
    const target = document.elementFromPoint(touch.clientX, touch.clientY);

    const dropZone = target?.closest('.drop-zone') || target?.closest('.pool-items');
    if (!dropZone) return;

    dropZone.classList.add('drag-over');

    // 위치에 따른 삽입 방식
    const items = [...dropZone.querySelectorAll('.tier-item')];

    const insertIndex = items.findIndex(child => {
        const rect = child.getBoundingClientRect();
        return touch.clientX < rect.left + rect.width / 2;
    });

    if (insertIndex === -1 || insertIndex >= items.length) {
        dropZone.appendChild(draggedElement);
    } else {
        dropZone.insertBefore(draggedElement, items[insertIndex]);
    }
}

function handleTouchEnd(e) {
    if (draggedElement) draggedElement.classList.remove('dragging');

    document.querySelectorAll('.drag-over').forEach(el => el.classList.remove('drag-over'));

    draggedElement = null;
    isTouchDragging = false;
}

// 초기화
function resetTiers() {
    if (confirm('정말 초기화하시겠습니까?')) {
        location.reload()
    }
}

// 제출
function submitRanking() {
    const resultArray = [];
    let totalItems = 0;

    const categoryNumber = categoryMap[currentCategory]; // 현재 카테고리 번호 변환

    document.querySelectorAll('.drop-zone').forEach(zone => {
        const tier = zone.dataset.tier;  // S, A, B, C, D, F
        const items = Array.from(zone.querySelectorAll('.tier-item'));

        items.forEach(el => {
            resultArray.push({
                id: el.dataset.id,
                name: el.dataset.item,
                grade: tier,
                category: categoryNumber
            });
        });

        totalItems += items.length;
    });

    if (totalItems === 0) {
        alert('최소 1개 이상의 항목을 배치해주세요!');
        return;
    }

    $.ajax({
        url: '/vote',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            ranks: resultArray
        }),

        success: function (response) {
            console.log("서버 응답:", response);

            // 성공 모달 표시
            const modal = document.getElementById('successModal');
            modal.classList.add('show');

            // 리다이렉트
            setTimeout(() => {
                window.location.replace('/');
            }, 5000);
        },

        error: function (xhr, status, error) {
            console.error("AJAX 오류:", error);
            console.error(xhr.responseText);
            alert("서버 전송 중 오류가 발생했습니다.");
        }
    });

}


function closeModal() {
    const modal = document.getElementById('successModal');
    modal.classList.remove('show');
    window.location.replace('/');
}
