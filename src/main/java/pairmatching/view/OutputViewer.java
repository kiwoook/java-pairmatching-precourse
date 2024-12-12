package pairmatching.view;

public class OutputViewer {

    private static final String ERROR_SIGN = "[ERROR] ";

    public void printError(Exception e) {
        System.out.println(ERROR_SIGN + e.getMessage());
    }

    public void printClear() {
        System.out.println();
        System.out.println("초기화 되었습니다.");
        System.out.println();
    }

    public void printResult(String result) {
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(result);
    }


}
