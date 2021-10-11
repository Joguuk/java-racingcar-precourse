# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
   - 각 자동차 이름 부여(Car 객체)
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
   - 자동차 이름 조건
   1. 5자 이하만 입력 가능
   2. ,로 자동차 이름 구분
   3. 자동차 개수 이상으로 입력할 경우 ERROR 출력
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
   - 몇 변의 이동할지에 대한 racingCount 입력
5. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
   - Random 함수를 호출하여 전진하는 조건 기능
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
   - racingCount 만큼 이동 후 결과 출력(RacingCarConsoleView)
7. 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
   - RacingCarConsoleView를 통해 우승자 ,로 구분하여 출력
8. 사용자가 잘못된 값을 입력할 경우 “[ERROR]”로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.
   - RacingCarConsoleView를 통해 ERROR 출력
   
## 입력 케이스
car      /  moveRandomNumber /   moveCount
1 2 3       4 5 6                1 1 1
1 2 3       3 2 6                1 1 2
1 2 3       4 3 3                2 1 2

car      /  moveRandomNumber /   moveCount
1 2 3       4 5 6                1 1 1

car      /  moveRandomNumber /   moveCount
1           4                    1

