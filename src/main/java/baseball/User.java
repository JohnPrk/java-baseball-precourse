package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

  public String inputRestartOrExit() {
    String input = readLine();
    if (!(input.equals("1") || input.equals("2"))) {
      throw new IllegalArgumentException("게임을 다시 시작하려면 1의 값을, 게임을 완전히 종료하려면 2를 입력해주세요");
    }
    return input;

  }

  public BallNumbers createNumbers() {
    List<BallNumber> number = new ArrayList<>();
    String[] split = readLine().split("");
    if (split.length != 3) {
      throw new IllegalArgumentException("3자리의 숫자를 넣어주세요.");
    }
    for (int i = 0; i < 3; i++) {
      number.add(new BallNumber(i, split[i]));
    }

    return new BallNumbers(number);
  }
}
