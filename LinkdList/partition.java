package LinkdList;

class Solution_partation {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller_value_node = new ListNode(-1), higher_equal_value_node = new ListNode(-1), ans = null,
                head_of_higher_values = null;
        // Break the list in two parts small and big and attach them latter
        while (head != null) {
            if (head.val < x) {
                if (ans == null)
                    ans = head;
                smaller_value_node.next = head;
                smaller_value_node = head;
            } else {
                if (head_of_higher_values == null)
                    head_of_higher_values = head;
                higher_equal_value_node.next = head;
                higher_equal_value_node = head;
            }
            head = head.next;
        }
        if (ans == null)
            ans = head_of_higher_values;
        smaller_value_node.next = head_of_higher_values;
        higher_equal_value_node.next = null;
        return ans;
    }
}

public class partition {
    public static void main(String[] args) {
        ListNode head = new ListNode(0), temp;
        temp = head;
        for (int i = 5; i >=0; i--) {
            temp.next = new ListNode(i + 1);
            temp = temp.next;
        }
        head = new Solution_partation().partition(head,3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
