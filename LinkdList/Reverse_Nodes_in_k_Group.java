package LinkdList;

class Solution {

    public ListNode reverse(ListNode head, int k, int reverseNTimes) {
        if (head == null || reverseNTimes <= 0)
            return head;

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
        headOfTail.next = reverse(head, k, reverseNTimes - 1);
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
 
        int reverseNTimes = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            reverseNTimes++;
        }
        reverseNTimes /= k;

        return reverse(head, k, reverseNTimes);
    }
}

public class Reverse_Nodes_in_k_Group {

}
