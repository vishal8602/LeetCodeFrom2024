package LinkdList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        ListNode end = head;
        while (end != null && end.next != null) {
            end = end.next;
        }
        return to_BST(head, end);
    }

    public TreeNode to_BST(ListNode start, ListNode End) {
        if (start == null || End == null)
            return null;
        // if(start==End) return End;
        ListNode slow = start, fast = start, prev = null;
        while (slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is our mid
        if (prev != null)
            prev.next = null;
        if (End != null)
            End.next = null;
        TreeNode mid = new TreeNode(slow.val);
        mid.left = to_BST(start, prev);
        mid.right = to_BST(slow.next, End);
        return mid;
    }
}

public class Convert_Sorted_List_to_Binary_Search_Tree {
    public static void main(String[] args) {
        Solution_Convert_Sorted_List_to_Binary_Search_Tree solution = new Solution_Convert_Sorted_List_to_Binary_Search_Tree();

        // Test Case 1: Empty List
        System.out.println("Test Case 1: Empty List");
        ListNode head1 = null;
        TreeNode result1 = solution.sortedListToBST(head1);
        if (result1 == null) {
          System.out.println("Passed");
        } else {
          System.out.println("Failed");
        }
    
        // Test Case 2: Single Node List
        System.out.println("\nTest Case 2: Single Node List");
        ListNode head2 = new ListNode(1);
        TreeNode result2 = solution.sortedListToBST(head2);
        if (result2 != null && result2.val == 1 && result2.left == null && result2.right == null) {
          System.out.println("Passed");
        } else {
          System.out.println("Failed");
        }
    
      
      
    }
}
