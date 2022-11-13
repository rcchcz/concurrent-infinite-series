import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * This class implements a cached thread pool to calculate the Euler's number
 */
public class CachedThreads {
    public static void main(String[] args) {

    // Get number of terms that will be calculated
    int numOfTerms = Utils.getNumOfTerms(args);

    ExecutorService executorService = Executors.newCachedThreadPool();

    List<Future<Double>> terms = new ArrayList<>();

        for(int i = 0; i < numOfTerms; i++) {
            Callable<Double> calculatorFactorial = new Task(i);
            Future<Double> term = executorService.submit(calculatorFactorial);
            terms.add(term);
        }

        System.out.println(Thread.activeCount() + " threads are being used");
        System.out.println("The Euler's number is -> " + Utils.seriesSum(terms));

        executorService.shutdown();

    }
}
