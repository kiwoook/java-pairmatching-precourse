package pairmatching.controller;

import java.util.List;
import pairmatching.exception.CustomIllegalArgumentException;
import pairmatching.model.Confirmation;
import pairmatching.model.CourseMission;
import pairmatching.model.Crew;
import pairmatching.model.Crews;
import pairmatching.model.Matching;
import pairmatching.model.Option;
import pairmatching.utils.FileHandler;
import pairmatching.utils.RecoveryUtils;
import pairmatching.view.InputViewer;
import pairmatching.view.OutputViewer;

public class PairMatchingController {

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;
    private final FileHandler fileHandler;
    private final Matching matching = Matching.create();
    private Crews crews;

    public PairMatchingController(InputViewer inputViewer, OutputViewer outputViewer, FileHandler fileHandler) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
        this.fileHandler = fileHandler;
    }

    public void execute() {
        init();
        Option option;
        do {
            option = RecoveryUtils.executeWithRetry(() -> Option.from(inputViewer.promptOption()));
            chooseOption(option);
        } while (!option.equals(Option.QUIT));
    }

    public void init() {
        List<Crew> backendCrews = fileHandler.getBackendCrews();
        List<Crew> frontendCrews = fileHandler.getFrontendCrews();

        crews = Crews.of(backendCrews, frontendCrews);
    }

    public void chooseOption(Option option) {
        if (option.equals(Option.ONE)) {
            inputViewer.printMatchingStatus();
            pairMatching();
        }

        if (option.equals(Option.TWO)) {
            find();
        }

        if (option.equals(Option.THREE)) {
            clear();
        }
    }

    public void find() {
        CourseMission courseMission = RecoveryUtils.executeWithRetry(
                () -> CourseMission.of(inputViewer.promptCourseLevelMission()));

        result(courseMission);
    }

    public void pairMatching() {
        CourseMission courseMission = RecoveryUtils.executeWithRetry(
                () -> CourseMission.of(inputViewer.promptCourseLevelMission()));

        if (matching.hasCourseMission(courseMission) && isNo()) {
            pairMatching();
            return;
        }

        try {
            matching.process(0, courseMission, crews);
        } catch (CustomIllegalArgumentException e) {
            pairMatching();
        }
        result(courseMission);
    }

    public void clear() {
        outputViewer.printClear();
        matching.clear();
    }

    private boolean isNo() {
        return RecoveryUtils.executeWithRetry(() -> Confirmation.of(inputViewer.promptConfirmMatching()))
                .equals(Confirmation.NO);
    }

    public void result(CourseMission courseMission) {
        try {
            outputViewer.printResult(matching.toResult(courseMission));
        } catch (CustomIllegalArgumentException e) {
            outputViewer.printError(e);
            find();
        }
    }

}
