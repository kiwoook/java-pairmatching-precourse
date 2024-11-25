package pairmatching.controller;

import java.util.List;
import pairmatching.enums.Confirmation;
import pairmatching.enums.Option;
import pairmatching.model.CourseMission;
import pairmatching.model.Crew;
import pairmatching.model.Crews;
import pairmatching.model.MissionPairs;
import pairmatching.utils.FileHandler;
import pairmatching.utils.RecoveryUtils;
import pairmatching.view.InputViewer;
import pairmatching.view.OutputViewer;

public class MatchingController {

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;
    private final FileHandler fileHandler;

    private final Crews crews = Crews.create();
    private final MissionPairs missionPairs = MissionPairs.create();

    public MatchingController(InputViewer inputViewer, OutputViewer outputViewer, FileHandler fileHandler) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
        this.fileHandler = fileHandler;
    }

    public void saveCrews() {
        List<Crew> backendCrews = fileHandler.getBackendCrews();
        crews.addCrews(backendCrews);

        List<Crew> frontendCrews = fileHandler.getFrontendCrews();
        crews.addCrews(frontendCrews);

    }

    public void run() {
        Option option;
        do {
            option = RecoveryUtils.executeWithRetry(() -> Option.from(inputViewer.chooseOption()));
            executeFunction(option);

        } while (!option.equals(Option.QUIT));
    }

    public void executeFunction(Option option) {
        if (option.equals(Option.ONE)) {
            matching();
        }
        if (option.equals(Option.TWO)) {
            check();
        }
        if (option.equals(Option.THREE)) {
            reset();
        }
    }

    public void matching() {
        CourseMission courseMission = RecoveryUtils.executeWithRetry(
                () -> CourseMission.parseInput(inputViewer.chooseMatching()));

        if (missionPairs.existCourseMission(courseMission)) {
            Confirmation confirmation = RecoveryUtils.executeWithRetry(
                    () -> Confirmation.from(inputViewer.alreadyPairs()));

            reMatch(confirmation);
        }

        shuffle(missionPairs, courseMission);
    }

    private void shuffle(MissionPairs missionPairs, CourseMission courseMission) {
        try {
            missionPairs.shufflePair(0, crews, courseMission);
            String pairMessage = missionPairs.toMessage(courseMission);
            outputViewer.resultPair(pairMessage);
        } catch (IllegalArgumentException e) {
            outputViewer.printError(e);
            // 섞는게 실패하면 다시 페어 매칭으로 돌아가서 다시 확인받는다.
            matching();
        }
    }

    public void reMatch(Confirmation confirmation) {
        if (confirmation.equals(Confirmation.NO)) {
            matching();
        }
    }

    public void check() {
        CourseMission courseMission = RecoveryUtils.executeWithRetry(
                () -> CourseMission.parseInput(inputViewer.chooseMatching()));

        try {
            String pairMessage = missionPairs.toMessage(courseMission);
            outputViewer.resultPair(pairMessage);
        } catch (IllegalArgumentException e) {
            outputViewer.printError(e);
            check();
        }
    }

    public void reset() {
        missionPairs.reset();
        outputViewer.reset();
    }
}
