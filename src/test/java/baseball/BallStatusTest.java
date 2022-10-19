package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallStatusTest {

  BallStatus ballStatusStrike;
  BallStatus ballStatusBall;
  BallStatus ballStatusNothing;

  @BeforeEach
  public void init() {
    ballStatusStrike = BallStatus.STRIKE;
    ballStatusBall = BallStatus.BALL;
    ballStatusNothing = BallStatus.NOTHING;
  }

  @Test
  void 낫띵_체크() {

    // when
    boolean strikeIsNotNothing = ballStatusStrike.isNotNothing();
    boolean ballIsNotNothing = ballStatusBall.isNotNothing();
    boolean nothingIsNotNothing = ballStatusNothing.isNotNothing();

    //then
    Assertions.assertThat(strikeIsNotNothing).isTrue();
    Assertions.assertThat(ballIsNotNothing).isTrue();
    Assertions.assertThat(nothingIsNotNothing).isFalse();
  }

  @Test
  void 스트라이크_체크() {

    //when
    boolean strikeIsStrike = ballStatusStrike.isStrike();
    boolean ballIsStrike = ballStatusBall.isStrike();
    boolean nothingIsStrike = ballStatusNothing.isStrike();

    //then
    Assertions.assertThat(strikeIsStrike).isTrue();
    Assertions.assertThat(ballIsStrike).isFalse();
    Assertions.assertThat(nothingIsStrike).isFalse();
  }

  @Test
  void 볼_체크() {

    //when
    boolean strikeIsBall = ballStatusStrike.isBall();
    boolean ballIsBall = ballStatusBall.isBall();
    boolean nothingIsBall = ballStatusNothing.isBall();

    //then
    Assertions.assertThat(strikeIsBall).isFalse();
    Assertions.assertThat(ballIsBall).isTrue();
    Assertions.assertThat(nothingIsBall).isFalse();
  }
}
