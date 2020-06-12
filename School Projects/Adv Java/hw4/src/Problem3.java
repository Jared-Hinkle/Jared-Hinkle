import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Problem3 {
    public static void main(String[] args)
    {
        ForkJoinPool fjp = new ForkJoinPool();
        //create and initilize array of doubles
        double[] nums = new double[9000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double)(((i % 2) == 0) ? i : -1);
        }
        //create a recursive task
        SumRecursive task = new SumRecursive(nums, 0, nums.length);
        //invoke start of recursive task
        double sum = fjp.invoke(task);
        //print the final sum
        System.out.println("Sum: " + sum);
    }
}

class SumRecursive extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start, end;
    //recursive task constructor
    SumRecursive(double[] data, int start, int end)
    {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute()
    {
        double sum = 0;
        //sum data if end minus start is less than the threshold
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++)
                sum += data[i];
        }
        else {
            int middle = (start + end) / 2;
            //split data into two recursive tasks
            SumRecursive subtaskA = new SumRecursive(data, start, middle);
            SumRecursive subtaskB = new SumRecursive(data, middle, end);

            subtaskA.fork();
            subtaskB.fork();
            //join tasks to the sum
            sum += subtaskA.join() + subtaskB.join();
        }
        return sum;
    }
}
