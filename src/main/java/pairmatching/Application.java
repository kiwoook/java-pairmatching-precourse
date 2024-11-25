package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.utils.FileHandler;
import pairmatching.view.InputViewer;
import pairmatching.view.OutputViewer;

public class Application {

    public static void main(String[] args) {
        InputViewer inputViewer = new InputViewer();
        OutputViewer outputViewer = new OutputViewer();
        FileHandler fileHandler = new FileHandler();

        MatchingController matchingController = new MatchingController(inputViewer, outputViewer, fileHandler);

        matchingController.saveCrews();
        matchingController.run();
    }
}
