```
miniProject
└── src
    ├── restaurantDTO
    │   └── RestaurantDTO.java
    ├── restaurantController
    │   └── RestaurantController.java
    ├── restaurantService
    │   └── RestaurantService.java
    └── restaurantView
        └── RestaurantView.java
```
프로젝트 레스토랑 음식종류를 고르면 식당과 메뉴 2개를 알려주는 프로그램입니다.

MVC 패턴으로 제작하였으며 데이터 값은 View에 있으며 음식 종류(한식, 중식)등을 입력하면 음식과 식당을 출력합니다.

원하는 옵션을 선택하세요 부분에서 숫자 이외의 값을 입력시 NullPointerException 에러 발생 해결 하였습니다.
