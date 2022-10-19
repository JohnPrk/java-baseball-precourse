package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BallNumbersTest {

  private BallNumbers ballNumbers;

  @BeforeEach
  public void init() {
    ballNumbers = new BallNumbers(
        Arrays.asList(new BallNumber(0, "4"), new BallNumber(1, "5"), new BallNumber(2, "6")));
  }

  @Test
  void 낫띵_체크() {

    //given
    BallNumbers userBallNumbers = new BallNumbers(
        Arrays.asList(new BallNumber(0, "1"), new BallNumber(1, "2"), new BallNumber(2, "3")));

    //when
    MatchResult matchResult = ballNumbers.count(userBallNumbers);

    Assertions.assertThat(matchResult.getStrike()).isEqualTo(0);
    Assertions.assertThat(matchResult.getBall()).isEqualTo(0);
  }

  @Test
  void 원_스트라이크_원_볼_체크() {

    //given
    BallNumbers userBallNumbers = new BallNumbers(
        Arrays.asList(new BallNumber(0, "4"), new BallNumber(1, "6"), new BallNumber(2, "2")));

    //when
    MatchResult matchResult = ballNumbers.count(userBallNumbers);

    Assertions.assertThat(matchResult.getStrike()).isEqualTo(1);
    Assertions.assertThat(matchResult.getBall()).isEqualTo(1);
  }

  @Test
  void 쓰리_스트라이크_체크() {

    //given
    BallNumbers userBallNumbers = new BallNumbers(
        Arrays.asList(new BallNumber(0, "4"), new BallNumber(1, "5"), new BallNumber(2, "6")));

    //when
    MatchResult matchResult = ballNumbers.count(userBallNumbers);

    Assertions.assertThat(matchResult.getStrike()).isEqualTo(3);
    Assertions.assertThat(matchResult.getBall()).isEqualTo(0);
    Assertions.assertThat(matchResult.endGame()).isTrue();
  }

  @Test
  void 낫띵_부분_체크() {

    //given
    BallNumber ballNumber = new BallNumber(0, "1");

    //when
    BallStatus ballStatus = this.ballNumbers.count(ballNumber);

    //then
    Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
  }

  @Test
  void 볼_부분_체크() {

    //given
    BallNumber ballNumber = new BallNumber(2, "4");

    //when
    BallStatus ballStatus = this.ballNumbers.count(ballNumber);

    //then
    Assertions.assertThat(ballStatus).isEqualTo(BallStatus.BALL);
  }

  @Test
  void 스트라이크_부분_체크() {

    //given
    BallNumber ballNumber = new BallNumber(0, "4");

    //when
    BallStatus ballStatus = this.ballNumbers.count(ballNumber);

    //then
    Assertions.assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
  }

  @Test
  @DisplayName("BallNumber 리스트 길이가 3인 경우,")
  public void 길이_범위_3_정상_테스트() {

    //then
    Assertions.assertThatCode(() -> {
      new BallNumbers(
          Arrays.asList(new BallNumber(0, "1"), new BallNumber(1, "2"), new BallNumber(2, "3")));
    }).doesNotThrowAnyException();
  }

  @Test
  @DisplayName("BallNumber 리스트 길이가 2,4인 경우 IllegalArgumentException 발생(경계값 테스트)")
  public void 길이_범위_초과_경계값_테스트() {

    //then

    // 리스트 길이 = 2인 경우
    Assertions.assertThatThrownBy(() -> {
      new BallNumbers(Arrays.asList(new BallNumber(0, "1"), new BallNumber(1, "2")));
    }).isInstanceOf(IllegalArgumentException.class);

    // 리스트 길이 = 4인 경우
    Assertions.assertThatThrownBy(() -> {
      new BallNumbers(
          Arrays.asList(new BallNumber(0, "1"), new BallNumber(1, "2"), new BallNumber(2, "3"),
              new BallNumber(3, "4")));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 입력값_중복_테스트() {

    //then
    Assertions.assertThatThrownBy(() -> {
      new BallNumbers(
          Arrays.asList(new BallNumber(0, "1"), new BallNumber(1, "1"), new BallNumber(1, "3")));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 인덱스_중복_테스트() {

    //then
    Assertions.assertThatThrownBy(() -> {
      new BallNumbers(
          Arrays.asList(new BallNumber(0, "1"), new BallNumber(1, "2"), new BallNumber(1, "3")));
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
