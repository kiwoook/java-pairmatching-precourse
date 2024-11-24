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


    // 함수형 인터페이스로 할 수 있는 부분 같은데 쩝
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

    // 매칭을 하는 로직
    public void matching() {
        CourseMission courseMission = RecoveryUtils.executeWithRetry(
                () -> CourseMission.parseInput(inputViewer.chooseMatching()));

        if (missionPairs.existMissionPairs(courseMission)) {
            Confirmation confirmation = RecoveryUtils.executeWithRetry(
                    () -> Confirmation.from(inputViewer.alreadyPairs()));

            reMatch(confirmation);
        }

        // 해당 페어에 대하여 매칭을 시작한다.
    }

    public void reMatch(Confirmation confirmation) {
        if (confirmation.equals(Confirmation.NO)) {
            matching();
        }
    }

    // 조회를 하는 로직
    public void check() {

    }

    public void reset() {
        missionPairs.reset();
        outputViewer.reset();
    }


}
