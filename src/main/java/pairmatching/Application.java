package pairmatching;

import pairmatching.config.PairMatchingConfig;
import pairmatching.controller.MatchingController;

public class Application {

    private static final MatchingController matchingController = PairMatchingConfig.getMatchingController();

    public static void main(String[] args) {
        matchingController.saveCrews();
        matchingController.run();
    }
}
