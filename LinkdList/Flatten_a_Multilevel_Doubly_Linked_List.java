package LinkdList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution_Flatten_a_Multilevel_Doubly_Linked_List {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node head) {
        Node tail_node = head;

        while (head != null) {
            Node attached_child = null;

            if (head.child != null) {
                attached_child = dfs(head.child);
                attached_child.next = head.next;

                head.next = head.child;
                head.child.prev = head;
                head.child = null;

                if (attached_child.next != null)
                    attached_child.next.prev = attached_child;

                head = attached_child.next;
                tail_node = attached_child;

            } else {
                tail_node = head;
                head = head.next;
            }
        }

        return tail_node;
    }
}

public class Flatten_a_Multilevel_Doubly_Linked_List {
       public static void main(String[] args) {
         new Solution_Flatten_a_Multilevel_Doubly_Linked_List().flatten(null);
       }
}
