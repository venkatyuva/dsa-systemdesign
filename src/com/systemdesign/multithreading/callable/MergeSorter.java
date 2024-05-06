package com.systemdesign.multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    private final List<Integer> listToSort;

    private final ExecutorService executorService;

    public MergeSorter(List<Integer> listToSort, ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (listToSort.size() <= 1) {
            return listToSort;
        }
        int mid = listToSort.size() / 2;
        List<Integer> leftList = listToSort.subList(0, mid);
        List<Integer> rightList = listToSort.subList(mid, listToSort.size());
        MergeSorter leftMergeSorter = new MergeSorter(leftList, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightList, executorService);
        Future<List<Integer>> leftSortedFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedFuture = executorService.submit(rightMergeSorter);
        List<Integer> leftSortedList = leftSortedFuture.get();
        List<Integer> rightSortedList = rightSortedFuture.get();
        return mergeTwoSortedLists(leftSortedList, rightSortedList);
    }

    private List<Integer> mergeTwoSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < list1.size() && right < list2.size()) {
            if (list1.get(left) < list2.get(right)) {
                mergedList.add(list1.get(left++));
            } else {
                mergedList.add(list2.get(right++));
            }
        }
        while (left < list1.size()) {
            mergedList.add(list1.get(left++));
        }
        while (right < list2.size()) {
            mergedList.add(list2.get(right++));
        }
        return mergedList;
    }
}
