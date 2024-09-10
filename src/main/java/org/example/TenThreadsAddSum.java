package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TenThreadsAddSum {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        List<Future<Integer>> futures = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            Callable<Integer> callable = () -> {
//                int isum = 0;
//                for (int j = 1; j < 10000001; j++) {
//                    isum = isum + 10* finalI +j;
//                }
//                return isum;
//            };
//            Future<Integer> submit = executorService.submit(callable);
//            futures.add(submit);
//        }
//        for (Future<Integer> future : futures) {
//            try {
//                sum += future.get();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        executorService.shutdown();

        for (int i = 1; i < 100000001; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("get ruselt multi version:" + sum+ " consumer ticks:"+ (endTime - startTime));
    }
}
