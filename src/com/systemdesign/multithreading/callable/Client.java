package com.systemdesign.multithreading.callable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> list = List.of(4, 6, 2, 8, 5, 3, 1, 7);
        MergeSorter mergeSorter = new MergeSorter(list, executorService);
        Future<List<Integer>> future = executorService.submit(mergeSorter);
        List<Integer> sortedArray = future.get();
        System.out.println(sortedArray);
        executorService.shutdown();
    }
}
