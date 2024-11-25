package pairmatching.utils;

import java.util.function.Supplier;
import pairmatching.view.OutputViewer;

public class RecoveryUtils {

    private static final OutputViewer VIEWER = new OutputViewer();

    private RecoveryUtils() {
    }

    public static <T> T executeWithRetry(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                VIEWER.printError(e);
            }
        }
    }


}