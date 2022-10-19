package baseball;

public class BallNumber {

  private final int index;
  private final String number;

  public BallNumber(int index, String number) {

    // 사용자 입력 값으로 문자가 아닌 숫자 여부 체크, 숫자 범위 및 인덱스 범위 체크
    stringValidationCheck(number);
    numberScopeCheck(number);
    indexScopeCheck(index);

    this.index = index;
    this.number = number;
  }

  private void indexScopeCheck(int index) {
    if (index < 0 || index > 2) {
      throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
    }
  }

  private void numberScopeCheck(String number) {
    int num = Integer.parseInt(number);

    if (num < 1 || num > 9) {
      throw new IllegalArgumentException("입력값으로 1-9까지의 숫자를 입력해주세요.");
    }
  }

  private void stringValidationCheck(String number) {
    if (!number.chars().allMatch(Character::isDigit)) {
      throw new IllegalArgumentException("입력값에 문자가 아닌 숫자를 입력해주세요.");
    }
  }

  public BallNumber(int index, int number) {
    this(index, String.valueOf(number));
  }

  public int getIndex() {
    return index;
  }

  public String getNumber() {
    return number;
  }

  public BallStatus check(BallNumber ballNumber) {

    if (ballNumber.equals(this)) {
      return BallStatus.STRIKE;
    }
    if (ballNumber.ballCheck(number)) {
      return BallStatus.BALL;
    }
    return BallStatus.NOTHING;
  }

  private boolean ballCheck(String number) {
    return this.number.equals(number);
  }

  @Override
  public boolean equals(Object obj) {
    BallNumber ballNumber = (BallNumber) obj;

    return this.number.equals(ballNumber.number) && this.index == ballNumber.index;
  }
}
