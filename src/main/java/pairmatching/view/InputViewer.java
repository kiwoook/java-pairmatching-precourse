package pairmatching.view;

import static pairmatching.utils.Constants.ENTER;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringJoiner;

public class InputViewer {

    public String chooseOption() {
        System.out.println();
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

        return Console.readLine();
    }

    public String alreadyPairs() {
        System.out.println();
        System.out.println(new StringJoiner(ENTER)
                .add("매칭 정보가 있습니다. 다시 매칭하시겠습니까?")
                .add("네 | 아니오"));

        return Console.readLine();
    }


    public void printInfo() {
        System.out.println();
        System.out.println("#############################################\n"
                + "과정: 백엔드 | 프론트엔드\n"
                + "미션:\n"
                + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "  - 레벨3: \n"
                + "  - 레벨4: 성능개선 | 배포\n"
                + "  - 레벨5: \n"
                + "############################################\n"
                + "과정, 레벨, 미션을 선택하세요.\n"
                + "ex) 백엔드, 레벨1, 자동차경주\n");
    }


}
