package pairmatching.view;

import static pairmatching.utils.Constants.ENTER;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringJoiner;

public class InputViewer {

    public String chooseOption() {
        System.out.println(new StringJoiner(ENTER)
                .add("기능을 선택하세요.")
                .add("1. 페어 매칭")
                .add("2. 페어 조회")
                .add("3. 페어 초기화")
                .add("Q. 종료"));

        return Console.readLine();
    }

    public String chooseMatching() {
        printInfo();
        System.out.println(new StringJoiner(ENTER)
                .add("과정, 레벨, 미션을 선택하세요.")
                .add("ex) 백엔드, 레벨1, 자동차경주"));

        return Console.readLine();
    }

    public String alreadyPairs() {
        System.out.println(new StringJoiner(ENTER)
                .add("매칭 정보가 있습니다. 다시 매칭하시겠습니까?")
                .add("네 | 아니오"));

        return Console.readLine();
    }


    public void printInfo() {
        System.out.println(new StringJoiner(ENTER)
                .add("#############################################")
                .add("과정: 백엔드 | 프론트엔드")
                .add("미션:")
                .add("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임")
                .add("  - 레벨2: 장바구니 | 결제 | 지하철노선도")
                .add("  - 레벨3: ")
                .add("  - 레벨4: 성능개선 | 배포")
                .add("  - 레벨5:")
                .add("#############################################"));
    }


}
