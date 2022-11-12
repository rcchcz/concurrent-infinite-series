import java.util.concurrent.Callable;

/**
 * This class represents the task that will be performed by the threads, which in this
 * case will be the calculation of each term of the series using the factorial auxiliary function
 */
public class Task implements Callable<Double>{

    private int term;

    /**
     * Simple constructor that initializes the term variable of a task
     * @param term Term that will be calculated the factorial
     */
    public Task(int term) {
        this.term = term;
    }

    /**
     * Call the function that will calculate the series term
     * @return The Term's value
     * @throws Exception
     */
    @Override
    public Double call() throws Exception {
        return this.termCalculator(this.term);
    }

    /**
     * Function that calculates the value of the term
     * @param term Term that will be calculated the factorial
     * @return The Term's value
     */
    private Double termCalculator(int term){
        return 1.0/factorial(term);
    }

    /**
     * Helper function that calculates the factorial of a number
     * @param num Number that will be calculated the factorial
     * @return The Factorial's result
     */
    private int factorial(int num){
        if(num <= 1){
            return 1;
        }else{
            return num * factorial(num-1);
        }
    }
}
