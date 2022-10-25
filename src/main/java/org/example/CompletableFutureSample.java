package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xyzha
 * @date 2022/10/22 19:16
 */
public class CompletableFutureSample {
    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        System.out.println("future");
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1;
                }
        ).thenApply((res) -> {
            System.out.println(res + 1);
            return res + 1;
        })

                .thenAccept((res) -> {
            System.out.println(res+1);
        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future);
        try {
            voidCompletableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("xxxxx");


    }
}
