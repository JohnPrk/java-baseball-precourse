package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class BallNumberTest {

  private BallNumber ballNumber;

  @BeforeEach
  public void init() {
    ballNumber = new BallNumber(1, "4");
  }

  /**
   * index와 number값을 기준으로 BallStatus(STRIKE, BALL, NOTHING) 체크
   */

  @Test
  public void 낫띵_체크() {

    //when
    BallStatus ballStatus = ballNumber.check(new BallNumber(2, "5"));

    //then
    Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
  }

  @Test
  public void 볼_체크() {

    //when
    BallStatus ballStatus = ballNumber.check(new BallNumber(2, "4"));

    //then
    Assertions.assertThat(ballStatus).isEqualTo(BallStatus.BALL);
  }

  @Test
  public void 스트라이크_체크() {

    //when
    BallStatus ballStatus = ballNumber.check(new BallNumber(1, "4"));

    //then
    Assertions.assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
  }

  /**
   * 생성자 생성시 유효성 검사 체크(문자 체크, index 길이 체크)
   */

  @ParameterizedTest
  @ValueSource(strings = {"1", "9"})
  @DisplayName("1~9인 문자인 경우 정상(경계값 테스트)")
  public void 숫자_범위_정상_경계값_테스트(String ballNumber) {

    //then
    Assertions.assertThatCode(() -> {
      new BallNumber(1, ballNumber);
    }).doesNotThrowAnyException();
  }

  @ParameterizedTest
  @ValueSource(strings = {"0", "10"})
  @DisplayName("1~9의 범위를 넘는 문자인 경우 IllegalArgumentException 발생(경계값 테스트)")
  public void 숫자_범위_초과_경계값_테스트(String ballNumber) {

    //then
    Assertions.assertThatThrownBy(() -> {
      new BallNumber(1, ballNumber);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"a", "A", "ㄱ", "ㅏ", "-", "!"})
  @DisplayName("문자가 정수가 아닌 문자인 경우 IllegalArgumentException 발생")
  public void 문자가_정수가_아닌_문자(String ballNumber) {

    //then
    Assertions.assertThatThrownBy(() -> {
      new BallNumber(1, ballNumber);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 2})
  public void 인덱스_범위_정상_경계값_테스트(int index) {

    //then
    Assertions.assertThatCode(() -> {
      new BallNumber(index, "1");
    }).doesNotThrowAnyException();
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 4})
  @DisplayName("인덱스가 0~2의 값을 넘을 경우 IllegalArgumentException 발생")
  public void 인덱스_범위_초과_경계값_테스트(int index) {

    //then
    Assertions.assertThatCode(() -> {
      new BallNumber(index, "1");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
