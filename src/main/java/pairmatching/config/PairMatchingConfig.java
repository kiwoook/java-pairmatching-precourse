package pairmatching.config;

import pairmatching.controller.MatchingController;
import pairmatching.utils.FileHandler;
import pairmatching.view.InputViewer;
import pairmatching.view.OutputViewer;

public class PairMatchingConfig {

    private static final OutputViewer outputViewer = new OutputViewer();
    private static final InputViewer inputViewer = new InputViewer();
    private static final FileHandler fileHandler = new FileHandler();

    private static final MatchingController matchingController = new MatchingController(inputViewer, outputViewer,
            fileHandler);

    private PairMatchingConfig() {
    }

    public static OutputViewer getOutputViewer() {
        return outputViewer;
    }

    public static MatchingController getMatchingController() {
        return matchingController;
    }
}
