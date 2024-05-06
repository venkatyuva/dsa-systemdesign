package com.dsa.linkedlist;

public class ReverseListInGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode reverse = new ReverseListInGroup().reverseKGroup(head, 3);
        temp = reverse;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        int index = k;
        while (current != null && index > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            index--;
        }
        head.next = reverseKGroup(current, k);
        return prev;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}