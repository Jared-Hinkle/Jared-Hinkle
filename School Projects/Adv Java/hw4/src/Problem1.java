import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Problem1 {
    //create a sumIt object
    private static SumIt sum = new SumIt();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 1000 threads
        for (int i = 0; i < 1000; i++) {
            executor.execute(new SumTask());
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println(sum.print());
    }

    private static class SumTask implements Runnable {
        public void run() {
            sum.add(1);
        }
    }

    private static class SumIt{
        private int sum1 = 0;
        public SumIt(){}
        //add one to the sum synchronized
        public synchronized void add(int i){
            sum1 += i;
        }
        //print sum
        public String print(){
            return "Sum is: " + sum1;
        }
    }
}
