package com.kr.grade.model;

import com.kr.grade.constants.Category;
import com.kr.grade.constants.Grade;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@ToString
public class GradeDto {

    private String grade;
    private List<ItemDto> items;


    public GradeDto(Category category, Grade grade) {
        this.grade = grade.getValue();

        switch (category) {
            case LCK -> setLck(grade);
            case IT -> setIt(grade);
            case CAR -> setCar(grade);
            case REAL_ESTATE -> setRealEstate(grade);
        }

    }

    private void setLck(Grade grade) {
        this.items = new ArrayList<>();
        switch (grade) {

            case S -> {
                items.add(new ItemDto("Faker", "/img/lck/t1.png"));
                items.add(new ItemDto("Gumayusi", "/img/lck/t1.png"));
                items.add(new ItemDto("Oner", "/img/lck/t1.png"));
                items.add(new ItemDto("BDD", "/img/lck/kt.png"));
                items.add(new ItemDto("Kiin", "/img/lck/geng.png"));
            }

            case A -> {
                items.add(new ItemDto("Chovy", "/img/lck/geng.png"));
                items.add(new ItemDto("Keria", "/img/lck/t1.png"));
                items.add(new ItemDto("Ruler", "/img/lck/geng.png"));
                items.add(new ItemDto("Duro", "/img/lck/geng.png"));
            }

            case B -> {
                items.add(new ItemDto("Doran", "/img/lck/t1.png"));
                items.add(new ItemDto("Canyon", "/img/lck/geng.png"));
                items.add(new ItemDto("Cuzz", "/img/lck/kt.png"));
                items.add(new ItemDto("Viper", "/img/lck/hanwha.png"));
                items.add(new ItemDto("Zeus", "/img/lck/hanwha.png"));
            }

            case C -> {
                items.add(new ItemDto("Peanut", "/img/lck/hanwha.png"));
                items.add(new ItemDto("Delight", "/img/lck/hanwha.png"));
                items.add(new ItemDto("Diabol", "/img/lck/bfx.png"));
                items.add(new ItemDto("Duckdam", "/img/lck/kt.png"));
            }

            case D -> {
                items.add(new ItemDto("Zeka", "/img/lck/hanwha.png"));
                items.add(new ItemDto("Perfect", "/img/lck/kt.png"));
                items.add(new ItemDto("Peter", "/img/lck/kt.png"));
            }

            case F -> {
                items.add(new ItemDto("DK", "/img/lck/dk.png"));
                items.add(new ItemDto("BFX", "/img/lck/bfx.png"));
                items.add(new ItemDto("NS", "/img/lck/ns.png"));
                items.add(new ItemDto("BRION", "/img/lck/brion.png"));
                items.add(new ItemDto("DRX", "/img/lck/drx.png"));
                items.add(new ItemDto("DNF", "/img/lck/dnf.png"));
            }

        }


    }

    private void setIt(Grade grade) {
        this.items = new ArrayList<>();
        switch (grade) {

            // S+ 등급
            case S -> {
                items.add(new ItemDto("Nvidia", "/img/it/nvidia.png"));
                items.add(new ItemDto("Google", "/img/it/google.png"));
                items.add(new ItemDto("Moloco", "/img/it/moloco.png"));          // 몰로코 → Moloco
                items.add(new ItemDto("두나무", "/img/it/donamu.png"));           // 두나무 → Dunamu
                items.add(new ItemDto("Qualcomm", "/img/it/qualcomm.png"));       // 퀄컴 → Qualcomm
            }

            // S 등급
            case A -> {
                items.add(new ItemDto("AWS", "/img/it/aws.png"));
                items.add(new ItemDto("Microsoft", "/img/it/ms.png"));
                items.add(new ItemDto("SK Telecom", "/img/it/sk.jpg"));           // SKT → SK Telecom
            }

            // A+ 등급
            case B -> {
                items.add(new ItemDto("Naver", "/img/it/naver.png"));             // 네이버 → Naver
                items.add(new ItemDto("Kakao", "/img/it/kakao.png"));             // 카카오 → Kakao
                items.add(new ItemDto("LINE", "/img/it/line.png"));               // 라인 → LINE
                items.add(new ItemDto("Coupang", "/img/it/coupang.png"));         // 쿠팡 → Coupang
                items.add(new ItemDto("배민", "/img/it/bamin.png"));            // 배민 → Baemin (공식 BaeMin 브랜드)
            }

            // A 등급
            case C -> {
                items.add(new ItemDto("삼성전자", "/img/it/samsung.png")); // 삼성전자
                items.add(new ItemDto("현대차", "/img/it/hyundai.png"));        // 현대차
                items.add(new ItemDto("Toss", "/img/it/toss.png"));                    // 토스
                items.add(new ItemDto("Nexon", "/img/it/nexon.png"));                  // 넥슨
            }

            // B+ 등급
            case D -> {
                items.add(new ItemDto("Tmap", "/img/it/tmap.png"));           // 티맵모빌리티
                items.add(new ItemDto("삼성 SDS", "/img/it/samsungsds.png"));        // 삼성 SDS
                items.add(new ItemDto("현대오토에버", "/img/it/hyundaiautoever.png")); // 현대오토에버
                items.add(new ItemDto("크래프톤", "/img/it/krafton.png"));              // 크래프톤
                items.add(new ItemDto("당근마켓", "/img/it/carrot.png"));       // 당근마켓 → Danggeun Market
            }

            // B 등급
            case F -> {
                items.add(new ItemDto("LG CNS", "/img/it/lgcns.png"));
                items.add(new ItemDto("SSG", "/img/it/ssg.png"));                      // SSG (영문 그대로 사용)
                items.add(new ItemDto("무신사", "/img/it/musinsa.png"));              // 무신사 → Musinsa
                items.add(new ItemDto("야놀자", "/img/it/yanolja.png"));              // 야놀자 → Yanolja
                items.add(new ItemDto("여기어때", "/img/it/howplace.jpg"));  // 여기어때 → Howplace(영문 브랜드)
                items.add(new ItemDto("NHN", "/img/it/nhn.png"));
            }
        }

    }

    private void setCar(Grade grade) {
        this.items = new ArrayList<>();

        switch (grade) {

            case S -> {
                items.add(new ItemDto("Bugatti", "/img/car/bugatti.png"));
                items.add(new ItemDto("Koenigsegg", "/img/car/koenigsegg.png"));
                items.add(new ItemDto("Pagani", "/img/car/pagani.png"));
            }

            case A -> {
                items.add(new ItemDto("Lamborghini", "/img/car/lamborghini.jpg"));
                items.add(new ItemDto("Ferrari", "/img/car/ferrari.jpg"));
                items.add(new ItemDto("McLaren", "/img/car/mcLaren.png"));
                items.add(new ItemDto("Rolls-Royce", "/img/car/rolls-royce.png"));
            }

            case B -> {
                items.add(new ItemDto("Maserati", "/img/car/maserati.png"));
                items.add(new ItemDto("Bentley", "/img/car/bentley.png"));
                items.add(new ItemDto("Aston Martin", "/img/car/aston-martin.png"));
                items.add(new ItemDto("Maybach", "/img/car/maybach.png"));
                items.add(new ItemDto("Porsche", "/img/car/porsche.png"));
            }

            case C -> {
                items.add(new ItemDto("Land Rover", "/img/car/land-rover.png"));
                items.add(new ItemDto("Mercedes-Benz", "/img/car/benz.png"));
                items.add(new ItemDto("Audi", "/img/car/audi.png"));
                items.add(new ItemDto("BMW", "/img/car/bmw.png"));
            }

            case D -> {
                items.add(new ItemDto("Lincoln", "/img/car/lincoln.png"));
                items.add(new ItemDto("Jaguar", "/img/car/jaguar.png"));
                items.add(new ItemDto("Cadillac", "/img/car/cadillac.png"));
                items.add(new ItemDto("Lexus", "/img/car/lexus.png"));
                items.add(new ItemDto("Volvo", "/img/car/volvo.png"));
                items.add(new ItemDto("Genesis", "/img/car/genesis.png"));
                items.add(new ItemDto("Tesla", "/img/car/tesla.png"));
                items.add(new ItemDto("Acura", "/img/car/acura.png"));
                items.add(new ItemDto("Polestar", "/img/car/polestar.png"));
            }

            case F -> {
                items.add(new ItemDto("Honda", "/img/car/honda.png"));
                items.add(new ItemDto("Hyundai", "/img/car/hyundai.png"));
                items.add(new ItemDto("KG Mobility", "/img/car/kgm.png"));  // 구 쌍용
                items.add(new ItemDto("Renault", "/img/car/renault.png"));
                items.add(new ItemDto("Kia", "/img/car/kia.png"));
                items.add(new ItemDto("Volkswagen", "/img/car/volkswagen.png"));
                items.add(new ItemDto("Peugeot", "/img/car/peugeot.png"));
                items.add(new ItemDto("Toyota", "/img/car/toyota.png"));
                items.add(new ItemDto("MINI", "/img/car/mini.png"));
                items.add(new ItemDto("BYD", "/img/car/byd.png"));
                items.add(new ItemDto("Chevrolet", "/img/car/chevrolet.png"));
                items.add(new ItemDto("Citroën", "/img/car/citroën.png"));
                items.add(new ItemDto("Ford", "/img/car/ford.png"));
                items.add(new ItemDto("Jeep", "/img/car/jeep.png"));
                items.add(new ItemDto("DS Automobiles", "/img/car/ds-automobiles.png"));
                items.add(new ItemDto("Mazda", "/img/car/mazda.png"));
                items.add(new ItemDto("Infiniti", "/img/car/infiniti.png"));
                items.add(new ItemDto("Nissan", "/img/car/nissan.png"));
            }

        }


    }

    private void setRealEstate(Grade grade) {
        this.items = new ArrayList<>();
        switch (grade) {

            case S -> {
                items.add(new ItemDto("강남구", "/img/realestate/gangnam.png"));
                items.add(new ItemDto("서초구", "/img/realestate/seocho.jpg"));
            }
            case A -> {
                items.add(new ItemDto("용산구", "/img/realestate/yongsan.png"));
                items.add(new ItemDto("송파구", "/img/realestate/songpa.png"));
            }
            case B -> {
                items.add(new ItemDto("마포구", "/img/realestate/mapo.png"));
                items.add(new ItemDto("성동구", "/img/realestate/seongdong.png"));
                items.add(new ItemDto("광진구", "/img/realestate/gwangjin.png"));
                items.add(new ItemDto("양천구", "/img/realestate/yangcheon.png"));
            }
            case C -> {
                items.add(new ItemDto("영등포구", "/img/realestate/yeongdeungpo.png"));
                items.add(new ItemDto("동작구", "/img/realestate/dongjak.png"));
                items.add(new ItemDto("중구", "/img/realestate/junggu.png"));
                items.add(new ItemDto("강동구", "/img/realestate/ganado.png"));
                items.add(new ItemDto("종로구", "/img/realestate/jongno.png"));
            }
            case D -> {
                items.add(new ItemDto("서대문구", "/img/realestate/gangseo.png"));
                items.add(new ItemDto("강서구", "/img/realestate/gangseo.png"));
                items.add(new ItemDto("동대문구", "/img/realestate/dongdaemun.png"));
                items.add(new ItemDto("성북구", "/img/realestate/seongbuk.png"));
                items.add(new ItemDto("은평구", "/img/realestate/eunpyeong.png"));
                items.add(new ItemDto("관악구", "/img/realestate/gwanak.png"));
            }
            case F -> {
                items.add(new ItemDto("노원구", "/img/realestate/nowon.png"));
                items.add(new ItemDto("구로구", "/img/realestate/guro.png"));
                items.add(new ItemDto("중랑구", "/img/realestate/jungnang.png"));
                items.add(new ItemDto("금천구", "/img/realestate/geumcheon.png"));
                items.add(new ItemDto("강북구", "/img/realestate/gangbuk.png"));
                items.add(new ItemDto("도봉구", "/img/realestate/dobong.png"));
            }

        }
    }

}
