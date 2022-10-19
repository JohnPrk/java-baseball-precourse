package baseball;

public class Application {

  public static void main(String[] args) {
    Game game = new Game();
    RandomBallNumberGenerator randomBallNumberGenerator = new RandomBallNumberGenerator();

    //TODO: 숫자 야구 게임 구현
    do {
      BallNumbers random_numbers = randomBallNumberGenerator.createRandomNumbers();
      System.out.print("숫자 야구 게임을 시작합니다. ");
      game.play(random_numbers);
    } while (game.restartOrExit());
  }
}