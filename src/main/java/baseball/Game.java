package baseball;

public class Game {

  static final String RESTART = "1";

  public void play(BallNumbers random_numbers) {
    User user = new User();
    BallNumbers userNumbers;
    boolean keepGoing = false;

    while (!keepGoing) {
      System.out.print("서로 다른 3자리 숫자를 입력해주세요. ");
      userNumbers = user.createNumbers();
      MatchResult result = random_numbers.count(userNumbers);
      System.out.println(result.printResult());
      keepGoing = result.endGame();
    }
  }

  public boolean restartOrExit() {
    User user = new User();
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    return user.inputRestartOrExit().equals(RESTART);
  }
}