import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
public class WorkStealingThreads{
    public static void main(String[] args) {

        //Get Number of Terms That Will Be Calculated
        int numOfTerms = Utils.getNumOfTerms(args);

        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Future<Double>> terms = new ArrayList<>();

        for (int i = 0; i <= numOfTerms; i++) {
            Callable<Double> calculatorFactorial = new Task(i);
            Future<Double> term = executorService.submit(calculatorFactorial);
            terms.add(term);
        }

        System.out.println(Thread.activeCount() + " threads are being used");
        System.out.println("The Euler's number is -> " + Utils.seriesSum(terms));

        executorService.shutdown();
    }
}
