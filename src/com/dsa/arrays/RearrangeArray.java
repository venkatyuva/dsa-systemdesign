package com.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(4, 0, 2, 1, 3));
        new RearrangeArray().arrange(list);
        System.out.println(list);
    }
    public void arrange(ArrayList<Integer> a) {
        int index = 0;
        while (index < a.size()) {
            int element = a.get(index);
            int current = index;
            while (current != element) {
                int temp = a.get(current);
                a.set(current, a.get(element));
                a.set(element, temp);
                element = a.get(current);
            }
            index++;
        }
    }
}
