package pairmatching.view;

public class OutputViewer {

    private static final String ERROR_SIGN = "[ERROR] ";

    public void printError(IllegalArgumentException e) {
        System.out.println(ERROR_SIGN + e.getMessage());
    }

    public void reset() {
        System.out.println("초기화 되었습니다.");
    }

    public void resultPair(String pairMessage) {
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(pairMessage);
    }
}
