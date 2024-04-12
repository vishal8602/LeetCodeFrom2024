package LinkdList;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public List<ListNode> reverseIfEven(ListNode head, int k) {

        ListNode prev = null, headOfTail = null;
        int count = 0;
        while (head != null && count < k) {
            if (headOfTail == null)
                headOfTail = head;
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            count++;
            head = temp;
        }
        List<ListNode> result = new ArrayList<>();
        result.add(prev);
        result.add(headOfTail);
        result.add(head);
        return result;

    }

    public List<ListNode> skipIfOdd(ListNode head, int k) {

        ListNode prev = null, headOfTail = null;
        int count = 0;
        while (head != null && count < k) {
            if (headOfTail == null)
                headOfTail = head;
            ListNode temp = head.next;
            prev = head;
            count++;
            head = temp;
        }
        List<ListNode> result = new ArrayList<>();
        result.add(headOfTail);
        result.add(prev);
        result.add(head);
        return result;

    }

    public ListNode reverse(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode temp = head;
        int count = 0;
        while (temp != null && k > count) {
            temp = temp.next;
            count++;
        }
        boolean flag = (k % 2 == 0) ? true : false;
        if (flag && count % 2 != 0) {
            flag = false;
        }
        if (!flag && count % 2 == 0) {
            flag = true;
        }
        List<ListNode> headTail;
        if (flag) {
            headTail = reverseIfEven(head, k);
        } else {
            headTail = skipIfOdd(head, k);
        }
        headTail.get(1).next = reverse(headTail.get(2), k + 1);
        return headTail.get(0);
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        return reverse(head, 1);
    }
}