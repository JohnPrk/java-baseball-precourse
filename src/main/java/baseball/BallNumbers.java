package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumbers {

  private static final int NUMBER_SIZE = 3;
  private final List<BallNumber> numbers;

  public BallNumbers(List<BallNumber> numbers) {

    // 사이즈 체크 및 인덱스, 값 중복 체크
    sizeCheck(numbers);
    numberDuplicationCheck(numbers);
    indexDuplicationCheck(numbers);

    this.numbers = numbers;
  }

  private void sizeCheck(List<BallNumber> numbers) {
    if (numbers.size() != NUMBER_SIZE) {
      throw new IllegalArgumentException();
    }
  }

  private void indexDuplicationCheck(List<BallNumber> numbers) {
    Set<Integer> duplicationIndexCheckHash = new HashSet<>();
    for (BallNumber number : numbers) {
      duplicationIndexCheckHash.add(number.getIndex());
    }
    if (duplicationIndexCheckHash.size() != NUMBER_SIZE) {
      throw new IllegalArgumentException();
    }
  }

  private void numberDuplicationCheck(List<BallNumber> numbers) {
    Set<String> duplicationNumberCheckHash = new HashSet<>();

    for (BallNumber number : numbers) {
      duplicationNumberCheckHash.add(number.getNumber());
    }
    if (duplicationNumberCheckHash.size() != NUMBER_SIZE) {
      throw new IllegalArgumentException("중복되지 않는 값 3개를 입력해주세요.");
    }
  }

  public List<BallNumber> getNumbers() {
    return numbers;
  }

  public MatchResult count(BallNumbers ballNumbers) {

    MatchResult matchResult = new MatchResult();
    for (BallNumber ballNumber : numbers) {
      BallStatus ballStatus = ballNumbers.count(ballNumber);

      matchResult.report(ballStatus);
    }

    return matchResult;
  }

  public BallStatus count(BallNumber ballNumber) {

    return numbers.stream()
        .map(randomBall -> randomBall.check(ballNumber))
        .filter(BallStatus::isNotNothing)
        .findFirst()
        .orElse(BallStatus.NOTHING);
  }
}
