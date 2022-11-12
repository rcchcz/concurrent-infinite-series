import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Class Utils
 * This class is used as an auxiliary for the other classes in the project, providing methods
 * for reading arguments and calculating the sum of the series.
 */
public class Utils {

    /**
     * Gets the argument passed by user in command line that represents the quantity of terms
     * that will be used to approach the Euler's number
     * @param args String Array with all arguments passed by user
     * @return Integer that will be the number of terms
     */
    public static int getNumOfTerms(String[] args) {
        int numOfTerms = -1;
        try {
            int index = 0;
            for (String arg : args) {
                index++;
                if (arg.equals("-nterms")) {
                    numOfTerms = Integer.parseInt(args[index]);
                    System.out.println("Number of Terms -> " + numOfTerms);
                }
            }
            if(numOfTerms == -1){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException error) {
            if(error instanceof NumberFormatException){
                System.out.println("The argument must be a integer");
                System.exit(-1);
            }else{
                System.out.println("You have to pass the amount of terms as argument using (-nterms)");
                System.exit(-1);
            }
        }
        return numOfTerms;
    }

    /**
     * Gets the argument passed by user in command line that represents the quantity of threads
     * that will be used (Fixed Threads Implementation)
     * @param args String Array with all arguments passed by user
     * @return Integer that will be the number of threads
     */
    public static int getNumOfThreads(String[] args){
        int numOfThreads = 0;
        try {
            int index = 0;
            for (String arg : args) {
                index++;
                if (arg.equals("-nthreads")) {
                    numOfThreads = Integer.parseInt(args[index]);
                    System.out.println("Number of Threads -> " + numOfThreads);
                }
            }
        } catch (IllegalArgumentException error) {
            if(error instanceof NumberFormatException){
                System.out.println("The argument must be a integer");
                System.exit(-1);
            }else{
                System.out.println("You have to pass the amount of terms as argument using (-nterms)");
                System.exit(-1);
            }
        }
        return numOfThreads;
    }

    /**
     * Calculates the sum of the terms of the series
     * @param args A list with the terms that will be added
     * @return Double that represents the result of the sum
     */
    public static Double seriesSum(List<Future<Double>> terms) {
        try{
            Double seriesSum = 0.0;
            for (Future<Double> term: terms){
                seriesSum += term.get();
            }
            return seriesSum;
        }catch(ExecutionException | InterruptedException error){
            throw new RuntimeException(error);
        }
    }
}
