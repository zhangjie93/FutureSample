package org.example;

import java.util.concurrent.*;

/**
 * @author xyzha
 * @date 2022/10/22 19:02
 */
public class FutureSample {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                try {
                    Thread.sleep(100);//sleep
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 5;
            }
        });

        try {
            future.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
