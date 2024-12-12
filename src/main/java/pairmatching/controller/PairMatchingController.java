package pairmatching.controller;

import java.util.List;
import pairmatching.model.Crew;
import pairmatching.model.Crews;
import pairmatching.utils.FileHandler;
import pairmatching.view.InputViewer;
import pairmatching.view.OutputViewer;

public class PairMatchingController {

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;
    private final FileHandler fileHandler;
    private Crews crews;

    public PairMatchingController(InputViewer inputViewer, OutputViewer outputViewer, FileHandler fileHandler) {
        this.inputViewer = inputViewer;
        this.outputViewer = outputViewer;
        this.fileHandler = fileHandler;
    }

    public void execute() {
        init();
        System.out.println(crews);
    }

    public void init() {
        List<Crew> backendCrews = fileHandler.getBackendCrews();
        List<Crew> frontendCrews = fileHandler.getFrontendCrews();

        crews = Crews.of(backendCrews, frontendCrews);
    }
}
