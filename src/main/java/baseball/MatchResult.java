package baseball;

public class MatchResult {

  private static final int NUMBER_SIZE = 3;
  private int strike;
  private int ball;

  public MatchResult() {
    this.strike = 0;
    this.ball = 0;
  }

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }

  public boolean endGame() {
    return this.strike == NUMBER_SIZE;
  }

  public void report(BallStatus ballStatus) {
    if (ballStatus.isStrike()) {
      this.strike += 1;
    }
    if (ballStatus.isBall()) {
      this.ball += 1;
    }
  }

  public String printResult() {
    StringBuilder sb = new StringBuilder();
    if (this.strike == 3) {
      return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }
    if (this.strike == 0 && this.ball == 0) {
      return "낫띵";
    }
    if (this.strike > 0) {
      sb.append(strike).append("스트라이크 ");
    }
    if (this.ball > 0) {
      sb.append(ball).append("볼");
    }

    return String.valueOf(sb);
  }
}
