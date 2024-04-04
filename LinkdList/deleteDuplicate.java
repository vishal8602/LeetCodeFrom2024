package LinkdList;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
         
         ListNode temp=head,prev=new ListNode(-200),ans=null;
         while(temp!=null){
            boolean count=true;
            // Check for duplicates and move current pointer forward
            while(temp.next!=null && temp.next.val==temp.val ){
                count=false;
                temp=temp.next;
            }
            // if no duplicate attach current node in ans else skip
            if(count){
                if(ans==null)ans=temp;
                prev.next=temp;
                prev=temp;
            }

            temp=temp.next;
         }
         prev.next=null;
         return ans;
    }
}

public class deleteDuplicate {
    public static void main(String[] args) {
          ListNode head=new ListNode(0),temp;
          temp=head;
          for(int i=0;i<5;i++){
            temp.next=new ListNode(i+1);
            temp= temp.next;
          }
          head=new Solution1().deleteDuplicates(head);
          while(head!=null){
            System.out.println(head.val);
            head=head.next;
          }
        
    }
}
