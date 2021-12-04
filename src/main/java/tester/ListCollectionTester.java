package tester;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Class that provides method for getting execution time of a method
 */
public class ListCollectionTester {

    /**
     * Gets the execution time of a given number of method calls
     *
     * @param methodToCall-       called method
     * @param collection          - collection for which the method is called
     * @param numberOfMethodCalls - number of calls
     * @param <T>                 - type of elements stored in the list
     * @return execution time in ms
     */
    public <T> double getExecutionTime(BiConsumer<List<T>, Integer> methodToCall, List<T> collection, int numberOfMethodCalls) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < numberOfMethodCalls; i++) {
            methodToCall.accept(collection, i);
        }
        stopWatch.stop();
        return stopWatch.getNanoTime() / 1000000.0;
    }
}
