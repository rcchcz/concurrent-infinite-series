import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * This class implements a fixed threaded pool to calculate the Euler's number
 */
public class FixedThreads {
    public static void main(String[] args) {

        //Get Number of Terms That Will Be Calculated
        int numOfTerms = Utils.getNumOfTerms(args);

        //Get Number of Threads That Will Be Used
        int numOfThreads = Utils.getNumOfThreads(args);

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

        List<Future<Double>> terms = new ArrayList<>();

        for (int i = 0; i < numOfTerms; i++) {
            Callable<Double> calculatorFactorial = new Task(i);
            Future<Double> term = executorService.submit(calculatorFactorial);
            terms.add(term);
        }

        System.out.println("The Euler's number is -> " + Utils.seriesSum(terms));

        executorService.shutdown();
    }
}
