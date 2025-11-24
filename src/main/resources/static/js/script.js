const categoryMap = {
    lck: 0,
    car: 1,
    it: 2,
    estate: 3
};

// 데이터
const data = {
    lck: [
        { name: 'Doran', image: '/img/lck/t1.png' },
        { name: 'Oner', image: '/img/lck/t1.png' },
        { name: 'Faker', image: '/img/lck/t1.png' },
        { name: 'Peyz', image: '/img/lck/t1.png' },
        { name: 'Keria', image: '/img/lck/t1.png' },

        { name: 'Kiin', image: '/img/lck/geng.png' },
        { name: 'Canyon', image: '/img/lck/geng.png' },
        { name: 'Chovy', image: '/img/lck/geng.png' },
        { name: 'Ruler', image: '/img/lck/geng.png' },
        { name: 'Duro', image: '/img/lck/geng.png' },

        { name: 'Zeus', image: '/img/lck/hanwha.png' },
        { name: 'Kanavi', image: '/img/lck/hanwha.png' },
        { name: 'Zeka', image: '/img/lck/hanwha.png' },
        { name: 'Gumayusi', image: '/img/lck/hanwha.png' },
        { name: 'Delight', image: '/img/lck/hanwha.png' },

        { name: 'Siwoo', image: '/img/lck/dk.png' },
        { name: 'Lucid', image: '/img/lck/dk.png' },
        { name: 'ShowMaker', image: '/img/lck/dk.png' },
        { name: 'Smash', image: '/img/lck/dk.png' },
        { name: 'Career', image: '/img/lck/dk.png' },

        { name: 'Kingen', image: '/img/lck/ns.png' },
        { name: 'Sponge', image: '/img/lck/ns.png' },
        { name: 'Scout', image: '/img/lck/ns.png' },
        { name: 'Calix', image: '/img/lck/ns.png' },
        { name: 'Taeyoon', image: '/img/lck/ns.png' },
        { name: 'Lehends', image: '/img/lck/ns.png' },

        { name: 'PerfecT', image: '/img/lck/kt.png' },
        { name: 'Cuzz', image: '/img/lck/kt.png' },
        { name: 'Bdd', image: '/img/lck/kt.png' },
        { name: 'Aiming', image: '/img/lck/kt.png' },
        { name: 'Ghost', image: '/img/lck/kt.png' },
        { name: 'Pollu', image: '/img/lck/kt.png' },

        { name: 'Clear', image: '/img/lck/bfx.png' },
        { name: 'Raptor', image: '/img/lck/bfx.png' },
        { name: 'VicLa', image: '/img/lck/bfx.png' },
        { name: 'Daystar', image: '/img/lck/bfx.png' },
        { name: 'Diable', image: '/img/lck/bfx.png' },
        { name: 'Kellin', image: '/img/lck/bfx.png' },

        { name: 'Rich', image: '/img/lck/drx.png' },
        { name: 'Vincenzo', image: '/img/lck/drx.png' },
        { name: 'Willer', image: '/img/lck/drx.png' },
        { name: 'Jiwoo', image: '/img/lck/drx.png' },
        { name: 'Andil', image: '/img/lck/drx.png' },

        { name: 'Casting', image: '/img/lck/bro.png' },
        { name: 'GIDEON', image: '/img/lck/bro.png' },
        { name: 'Fisher', image: '/img/lck/bro.png' },
        { name: 'Teddy', image: '/img/lck/bro.png' },
        { name: 'Namgung', image: '/img/lck/bro.png' },

        { name: 'DuDu', image: '/img/lck/dnf.png' },
        { name: 'Pyosik', image: '/img/lck/dnf.png' },
        { name: 'Clozer', image: '/img/lck/dnf.png' },
        { name: 'deokdam', image: '/img/lck/dnf.png' },
        { name: 'Life', image: '/img/lck/dnf.png' },
        { name: 'Peter', image: '/img/lck/dnf.png' },

    ],
    car: [
        { name: "Bugatti", image: "/img/car/bugatti.png" },
        { name: "Koenigsegg", image: "/img/car/koenigsegg.png" },
        { name: "Pagani", image: "/img/car/pagani.png" },
        { name: "Lamborghini", image: "/img/car/lamborghini.jpg" },
        { name: "Ferrari", image: "/img/car/ferrari.jpg" },
        { name: "McLaren", image: "/img/car/mcLaren.png" },
        { name: "Rolls-Royce", image: "/img/car/rolls-royce.png" },
        { name: "Maserati", image: "/img/car/maserati.png" },
        { name: "Bentley", image: "/img/car/bentley.png" },
        { name: "Aston Martin", image: "/img/car/aston-martin.png" },
        { name: "Maybach", image: "/img/car/maybach.png" },
        { name: "Porsche", image: "/img/car/porsche.png" },
        { name: "Land Rover", image: "/img/car/land-rover.png" },
        { name: "Mercedes-Benz", image: "/img/car/benz.png" },
        { name: "Audi", image: "/img/car/audi.png" },
        { name: "BMW", image: "/img/car/bmw.png" },
        { name: "Lincoln", image: "/img/car/lincoln.png" },
        { name: "Jaguar", image: "/img/car/jaguar.png" },
        { name: "Cadillac", image: "/img/car/cadillac.png" },
        { name: "Lexus", image: "/img/car/lexus.png" },
        { name: "Volvo", image: "/img/car/volvo.png" },
        { name: "Genesis", image: "/img/car/genesis.png" },
        { name: "Tesla", image: "/img/car/tesla.png" },
        { name: "Acura", image: "/img/car/acura.png" },
        { name: "Polestar", image: "/img/car/polestar.png" },
        { name: "Honda", image: "/img/car/honda.png" },
        { name: "Hyundai", image: "/img/car/hyundai.png" },
        { name: "KG Mobility", image: "/img/car/kgm.png" },
        { name: "Renault", image: "/img/car/renault.png" },
        { name: "Kia", image: "/img/car/kia.png" },
        { name: "Volkswagen", image: "/img/car/volkswagen.png" },
        { name: "Peugeot", image: "/img/car/peugeot.png" },
        { name: "Toyota", image: "/img/car/toyota.png" },
        { name: "MINI", image: "/img/car/mini.png" },
        { name: "BYD", image: "/img/car/byd.png" },
        { name: "Chevrolet", image: "/img/car/chevrolet.png" },
        { name: "Citroën", image: "/img/car/citroën.png" },
        { name: "Ford", image: "/img/car/ford.png" },
        { name: "Jeep", image: "/img/car/jeep.png" },
        { name: "DS Automobiles", image: "/img/car/ds-automobiles.png" },
        { name: "Mazda", image: "/img/car/mazda.png" },
        { name: "Infiniti", image: "/img/car/infiniti.png" },
        { name: "Nissan", image: "/img/car/nissan.png" }
    ],
    it: [
        { name: "Nvidia", image: "/img/it/nvidia.png" },
        { name: "Google", image: "/img/it/google.png" },
        { name: "Moloco", image: "/img/it/moloco.png" },
        { name: "두나무", image: "/img/it/donamu.png" },
        { name: "Qualcomm", image: "/img/it/qualcomm.png" },
        { name: "AWS", image: "/img/it/aws.png" },
        { name: "Microsoft", image: "/img/it/ms.png" },
        { name: "SK Telecom", image: "/img/it/sk.jpg" },
        { name: "Naver", image: "/img/it/naver.png" },
        { name: "Kakao", image: "/img/it/kakao.png" },
        { name: "LINE", image: "/img/it/line.png" },
        { name: "Coupang", image: "/img/it/coupang.png" },
        { name: "배민", image: "/img/it/bamin.png" },
        { name: "삼성전자", image: "/img/it/samsung.png" },
        { name: "현대차", image: "/img/it/hyundai.png" },
        { name: "Toss", image: "/img/it/toss.png" },
        { name: "Nexon", image: "/img/it/nexon.png" },
        { name: "Tmap", image: "/img/it/tmap.png" },
        { name: "삼성 SDS", image: "/img/it/samsungsds.png" },
        { name: "현대오토에버", image: "/img/it/hyundaiautoever.png" },
        { name: "크래프톤", image: "/img/it/krafton.png" },
        { name: "당근마켓", image: "/img/it/carrot.png" },
        { name: "LG CNS", image: "/img/it/lgcns.png" },
        { name: "SSG", image: "/img/it/ssg.png" },
        { name: "무신사", image: "/img/it/musinsa.png" },
        { name: "야놀자", image: "/img/it/yanolja.png" },
        { name: "여기어때", image: "/img/it/howplace.jpg" },
        { name: "NHN", image: "/img/it/nhn.png" }
    ],
    estate: [
        { name: "강남구", image: "/img/realestate/gangnam.png" },
        { name: "서초구", image: "/img/realestate/seocho.jpg" },
        { name: "용산구", image: "/img/realestate/yongsan.png" },
        { name: "송파구", image: "/img/realestate/songpa.png" },
        { name: "마포구", image: "/img/realestate/mapo.png" },
        { name: "성동구", image: "/img/realestate/seongdong.png" },
        { name: "광진구", image: "/img/realestate/gwangjin.png" },
        { name: "양천구", image: "/img/realestate/yangcheon.png" },
        { name: "영등포구", image: "/img/realestate/yeongdeungpo.png" },
        { name: "동작구", image: "/img/realestate/dongjak.png" },
        { name: "중구", image: "/img/realestate/junggu.png" },
        { name: "강동구", image: "/img/realestate/ganado.png" },
        { name: "종로구", image: "/img/realestate/jongno.png" },
        { name: "서대문구", image: "/img/realestate/gangseo.png" }, // 주석: 이미지 경로 확인 필요
        { name: "강서구", image: "/img/realestate/gangseo.png" },
        { name: "동대문구", image: "/img/realestate/dongdaemun.png" },
        { name: "성북구", image: "/img/realestate/seongbuk.png" },
        { name: "은평구", image: "/img/realestate/eunpyeong.png" },
        { name: "관악구", image: "/img/realestate/gwanak.png" },
        { name: "노원구", image: "/img/realestate/nowon.png" },
        { name: "구로구", image: "/img/realestate/guro.png" },
        { name: "중랑구", image: "/img/realestate/jungnang.png" },
        { name: "금천구", image: "/img/realestate/geumcheon.png" },
        { name: "강북구", image: "/img/realestate/gangbuk.png" },
        { name: "도봉구", image: "/img/realestate/dobong.png" }
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
    const resultArray = [];
    let totalItems = 0;

    const categoryNumber = categoryMap[currentCategory]; // 현재 카테고리 번호 변환

    document.querySelectorAll('.drop-zone').forEach(zone => {
        const tier = zone.dataset.tier;  // S, A, B, C, D, F
        const items = Array.from(zone.querySelectorAll('.tier-item'));

        items.forEach(el => {
            resultArray.push({
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
