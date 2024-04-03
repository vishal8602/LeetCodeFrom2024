package LinkdList;

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

class Solution {
    public int getLength(ListNode temp) {
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public int getCutPoint(int k, int length) {
        k = k % length;
        int cut_point = length - k;
        return cut_point;
    }

    public ListNode breakTheNodeAtCutPoint(ListNode temp, int cut_point) {

        while (cut_point > 1) {
            temp = temp.next;
            cut_point--;
        }
        ListNode ans = temp.next;
        temp.next = null;
        return ans;
    }

    public void appendTheFrontCutToBackSide(ListNode temp, ListNode head) {
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head, ans = head;

        int length = getLength(temp);

        if (length <= 1 || k % length == 0)
            return head;

        ans = breakTheNodeAtCutPoint(head, getCutPoint(k, length));
        appendTheFrontCutToBackSide(ans, head);
        return ans;
    }
}

public class RotateList {
      public static void main(String[] args) {
          ListNode head=new ListNode(0),temp;
          temp=head;
          for(int i=0;i<5;i++){
            temp.next=new ListNode(i+1);
            temp= temp.next;
          }
          head=new Solution().rotateRight(head, 4);
          while(head!=null){
            System.out.println(head.val);
            head=head.next;
          }

      }
}
