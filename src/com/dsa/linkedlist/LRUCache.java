package com.dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        String[] inputs = "S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8".split(" ");
        LRUCache lruCache = new LRUCache(7);
        for (int i = 0; i < inputs.length; i++) {
            if ("S".equals(inputs[i])) {
                lruCache.set(Integer.parseInt(inputs[i + 1]), Integer.parseInt(inputs[i + 2]));
                i += 2;
            } else if ("G".equals(inputs[i])) {
                int value = lruCache.get(Integer.parseInt(inputs[i + 1]));
                System.out.println(value);
                i++;
            }
        }
    }

    private Map<Integer, Integer> valueMap;

    private Map<Integer, Node> referenceMap;

    private int capacity;

    private int size;

    private Node tail;

    private Node head;

    public LRUCache(int capacity) {
        valueMap = new HashMap<>();
        referenceMap = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        tail = null;
        head = null;
    }

    public int get(int key) {
        int value = -1;
        if (valueMap.containsKey(key)) {
            insertDLL(key);
            if (referenceMap.containsKey(key)) {
                Node existing = referenceMap.get(key);
                deleteDLL(existing);
            }
            referenceMap.put(key, tail);
            value = valueMap.get(key);
        }
        return value;
    }

    public void set(int key, int value) {
        valueMap.put(key, value);
        insertDLL(key);
        if (referenceMap.containsKey(key)) {
            Node existing = referenceMap.get(key);
            deleteDLL(existing);
        } else if (size > capacity) {
            valueMap.remove(head.data);
            referenceMap.remove(head.data);
            deleteDLL(head);
        }
        referenceMap.put(key, tail);
    }

    private void insertDLL(int key) {
        if (tail == null) {
            tail = new Node(key);
            head = tail;
        } else {
            Node newNode = new Node(key);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    private void deleteDLL(Node node) {
        if (node == head) {
            head = head.next;
            if (head == null) {
                tail = null;
                return;
            }
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        size--;
    }
}
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}