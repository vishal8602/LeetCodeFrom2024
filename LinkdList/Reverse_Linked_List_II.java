package LinkdList;


class Solution {

    public ListNode reverse(ListNode Node,int right){
           ListNode prev=null,headOfReverseEndNode=null;int count=0;
           while(Node!=null && count<=right){
               if(headOfReverseEndNode==null) headOfReverseEndNode=Node;
               ListNode temp=Node.next;
               Node.next=prev;
               prev=Node;
               Node=temp; 
               count++;
           }
           if(headOfReverseEndNode!=null)headOfReverseEndNode.next=Node;
           return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count=1;
        ListNode temp=head,prev=null;
        while(temp!=null && count<left){
             prev=temp;
             temp=temp.next;
             count++;
        }
        if(prev!=null) prev.next=reverse(temp,right-count);
        else head=reverse(temp,right-count);
        return head;

    }
}

public class Reverse_Linked_List_II {
    
}
