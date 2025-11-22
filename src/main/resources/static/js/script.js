// 데이터
const data = {
    lck: [
        { name: 'Faker', image: 'https://i.pravatar.cc/150?img=1' },
        { name: 'Chovy', image: 'https://i.pravatar.cc/150?img=2' },
        { name: 'Keria', image: 'https://i.pravatar.cc/150?img=3' },
        { name: 'Doran', image: 'https://i.pravatar.cc/150?img=4' },
        { name: 'Canyon', image: 'https://i.pravatar.cc/150?img=5' },
        { name: 'Delight', image: 'https://i.pravatar.cc/150?img=6' },
        { name: 'Zeka', image: 'https://i.pravatar.cc/150?img=7' },
        { name: 'Gumayusi', image: 'https://i.pravatar.cc/150?img=8' },
        { name: 'Zeus', image: 'https://i.pravatar.cc/150?img=9' },
        { name: 'Oner', image: 'https://i.pravatar.cc/150?img=10' },
        { name: 'Peyz', image: 'https://i.pravatar.cc/150?img=11' },
        { name: 'ShowMaker', image: 'https://i.pravatar.cc/150?img=12' },
        { name: 'Ruler', image: 'https://i.pravatar.cc/150?img=13' },
        { name: 'Deft', image: 'https://i.pravatar.cc/150?img=14' },
        { name: 'Peanut', image: 'https://i.pravatar.cc/150?img=15' }
    ],
    car: [
        { name: '벤츠', image: 'https://logo.clearbit.com/mercedes-benz.com' },
        { name: 'BMW', image: 'https://logo.clearbit.com/bmw.com' },
        { name: '아우디', image: 'https://logo.clearbit.com/audi.com' },
        { name: '제네시스', image: 'https://logo.clearbit.com/genesis.com' },
        { name: '테슬라', image: 'https://logo.clearbit.com/tesla.com' },
        { name: '포르쉐', image: 'https://logo.clearbit.com/porsche.com' },
        { name: '렉서스', image: 'https://logo.clearbit.com/lexus.com' },
        { name: '페라리', image: 'https://logo.clearbit.com/ferrari.com' },
        { name: '람보르기니', image: 'https://logo.clearbit.com/lamborghini.com' },
        { name: '현대', image: 'https://logo.clearbit.com/hyundai.com' },
        { name: '기아', image: 'https://logo.clearbit.com/kia.com' },
        { name: '토요타', image: 'https://logo.clearbit.com/toyota.com' },
        { name: '폭스바겐', image: 'https://logo.clearbit.com/vw.com' },
        { name: '볼보', image: 'https://logo.clearbit.com/volvo.com' },
        { name: '재규어', image: 'https://logo.clearbit.com/jaguar.com' }
    ],
    it: [
        { name: '삼성전자', image: 'https://logo.clearbit.com/samsung.com' },
        { name: '애플', image: 'https://logo.clearbit.com/apple.com' },
        { name: '구글', image: 'https://logo.clearbit.com/google.com' },
        { name: '마이크로소프트', image: 'https://logo.clearbit.com/microsoft.com' },
        { name: '네이버', image: 'https://logo.clearbit.com/naver.com' },
        { name: '카카오', image: 'https://logo.clearbit.com/kakao.com' },
        { name: '아마존', image: 'https://logo.clearbit.com/amazon.com' },
        { name: '메타', image: 'https://logo.clearbit.com/meta.com' },
        { name: '테슬라', image: 'https://logo.clearbit.com/tesla.com' },
        { name: 'SK하이닉스', image: 'https://logo.clearbit.com/skhynix.com' },
        { name: 'LG전자', image: 'https://logo.clearbit.com/lge.com' },
        { name: '엔비디아', image: 'https://logo.clearbit.com/nvidia.com' },
        { name: 'AMD', image: 'https://logo.clearbit.com/amd.com' },
        { name: '인텔', image: 'https://logo.clearbit.com/intel.com' },
        { name: '오라클', image: 'https://logo.clearbit.com/oracle.com' }
    ],
    estate: [
        { name: '강남구', image: '' },
        { name: '서초구', image: '' },
        { name: '송파구', image: '' },
        { name: '용산구', image: '' },
        { name: '마포구', image: '' },
        { name: '성동구', image: '' },
        { name: '광진구', image: '' },
        { name: '강동구', image: '' },
        { name: '양천구', image: '' },
        { name: '영등포구', image: '' },
        { name: '동작구', image: '' },
        { name: '관악구', image: '' },
        { name: '강서구', image: '' },
        { name: '구로구', image: '' },
        { name: '금천구', image: '' }
    ]
};


let currentCategory = 'lck';
let draggedElement = null;

// 페이지 로드 시 초기화
document.addEventListener('DOMContentLoaded', () => {
    initializePage();
});

function initializePage() {
    // 카테고리 탭 이벤트
    document.querySelectorAll('.tab-btn').forEach(btn => {
        btn.addEventListener('click', (e) => {
            document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
            e.target.classList.add('active');
            currentCategory = e.target.dataset.category;

            if (document.getElementById('itemsPool')) {
                loadCreatePage();
            }
        });
    });



    // 등급표 작성 페이지
    if (document.getElementById('itemsPool')) {
        loadCreatePage();
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

        const target = btn.dataset.target;
        document.querySelectorAll(".tier-pyramid").forEach(tp => tp.classList.remove("active"));
        document.getElementById(target).classList.add("active");
    });
});

// 등급표 작성 페이지 로드
function loadCreatePage() {
    const pool = document.getElementById('itemsPool');
    pool.innerHTML = '';

    data[currentCategory].forEach(item => {
        const itemEl = document.createElement('div');
        itemEl.className = 'tier-item';
        itemEl.draggable = true;
        itemEl.textContent = item.name;
        itemEl.dataset.item = item.name;

        const imgEl = document.createElement('img');
        imgEl.className = 'tier-item-image'
        imgEl.src = item.image;

        itemEl.appendChild(imgEl);
        pool.appendChild(itemEl);
    });

    // 모든 드롭존 초기화
    document.querySelectorAll('.drop-zone').forEach(zone => {
        zone.innerHTML = '';
    });
}

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
        loadCreatePage();
    }
}

// 제출
function submitRanking() {
    const ranking = {};
    let totalItems = 0;

    document.querySelectorAll('.drop-zone').forEach(zone => {
        const tier = zone.dataset.tier;
        const items = Array.from(zone.querySelectorAll('.tier-item')).map(el => el.textContent);
        ranking[tier] = items;
        totalItems += items.length;
    });

    if (totalItems === 0) {
        alert('최소 1개 이상의 항목을 배치해주세요!');
        return;
    }

    console.log('제출된 등급표:', ranking);

    // 모달 표시
    const modal = document.getElementById('successModal');
    modal.classList.add('show');

    // 2초 후 실시간 등급표로 이동
    setTimeout(() => {
        window.location.href = 'index.html';
    }, 2000);
}

function closeModal() {
    const modal = document.getElementById('successModal');
    modal.classList.remove('show');
}
