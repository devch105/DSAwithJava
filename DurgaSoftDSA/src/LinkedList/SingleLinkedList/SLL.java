package LinkedList.SingleLinkedList;

public class SLL {
    ListNode head;
    int len;
    private ListNode fast;

    public void AddLastNode(int i) {
    }

    // ***** Single ListNode ********
    class ListNode {
        int val;
        ListNode next;


        ListNode(int val) {
            this.val = val;
            this.next = null;
            len++;
        }

        ListNode(int val, ListNode temp) {
            this.val = val;
            this.next = temp;
            len++;
        }
    }
    // ************************

    // . PrintList
    void printlist() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        } else {
            System.out.print("head  ");
            ListNode temp = head;
            while (temp != null) {
                System.out.print("" + temp.val + "=>");
                temp = temp.next;
            }
        }
        System.out.println("null");
    }

    //  get size of List
    int getLen() {
        return this.len;
    }

    // 1. Add at Begining
    void AddListNodefirst(int data) {
        ListNode newListNode = new ListNode(data);
        if (head == null) {
            head = newListNode;
            return;
        }
        newListNode.next = head;
        head = newListNode;
    }

    // 2. Add at Last
    void AddLastListNode(int data) {
        ListNode newListNode = new ListNode(data);
        if (head == null) {
            head = newListNode;
            return;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newListNode;
        }
    }

    // 3. delete first ListNode
    int deleteFirst() {
        if (head == null) {
            System.out.println("Empty list");
            return -1;
        }
        ListNode temp = head;
        head = head.next;
        len--;
        return temp.val;

    }

    //4.  delete last ListNode
    int deleteLast() {
        if (head == null) {
            System.out.println("Empty list");
            return -1;
        }
        ListNode temp1 = head, temp2 = head.next;
        while (temp2.next != null) {
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        temp1.next = null;
        len--;
        return temp2.val;
    }

    // 5. Searching in List Linear:
    int searching(int data) {
        if (head == null) {
            System.out.println("Empty");
            return -1;
        }
        ListNode currListNode = head;
        int index = 0;
        while (currListNode != null) {
            index++;
            if (currListNode.val == data) {
                return index;
            }
            currListNode = currListNode.next;
        }
        if (index != 0) {
            return index;
        } else return -1;
    }

    // 6. Insert at position
    void Addatposition(int data, int pos) {
        int index = 0;
        ListNode newListNode = new ListNode(data);
        if (pos != 0) {
            ListNode currListNode = head;
            ListNode prevListNode = null;
            while (currListNode.next != null && index < pos) {
                prevListNode = currListNode;
                currListNode = currListNode.next;
                index++;
            }
            prevListNode.next = newListNode;
            newListNode.next = currListNode;
        } else {
            newListNode.next = head;
            head = newListNode;
        }
    }

    // 7. Insertion in order
    void SortedInsert(int data) {
        ListNode newListNode = new ListNode(data);
        ListNode currListNode = head;
        if (currListNode == null || currListNode.val > data) {
            newListNode.next = head;
            head = newListNode;
            return;
        }
        while (currListNode.next != null && currListNode.next.val < data) {
            currListNode = currListNode.next;
        }
        newListNode.next = currListNode.next;
        currListNode.next = newListNode;
    }

    int deleteatIndex(int pos) {
        int index = 0;
        if (head == null) {
            System.out.println("Empty list");
            return -1;
        }
        if (pos == 0) {
            ListNode temp = head;
            head = head.next;
            len--;
            return temp.val;
        }
        ListNode currListNode = head;
        ListNode prev = null;
        while (currListNode.next != null && index < pos) {
            prev = currListNode;
            currListNode = currListNode.next;
            index++;
        }
        prev.next = currListNode.next;
        len--;
        return currListNode.val;
    }

    // Delete by Element
    ListNode deletebyElement(int data) {
        if (head == null) {
            System.out.println("Empty list");
            return null; // Indicates the list is empty
        }

        ListNode temp = head;
        // Case: The head ListNode contains the target data
        if (temp.val == data) {
            head = head.next; // Update head to the next ListNode
            len--;
            return temp; // Return the deleted ListNode
        }

        // Traverse the list to find the ListNode to delete
        while (temp.next != null) {
            if (temp.next.val == data) {
                ListNode toDelete = temp.next;
                temp.next = temp.next.next; // Remove the target ListNode
                len--;
                return toDelete; // Return the deleted ListNode
            }
            temp = temp.next; // Move to the next ListNode
        }

        // If we reach here, the element was not found
        System.out.println("Element not found");
        return null; // Indicates the element was not found
    }

    // ReverseList
    void ReverseList() {
        ListNode currListNode = head, prev = null, nextListNode = null;
        while (currListNode != null) {
            nextListNode = currListNode.next;
            currListNode.next = prev;
            prev = currListNode;
            currListNode = nextListNode;
        }
        head = prev;
    }

    // remove duplicates
    void removeadjacentDuplicates() {
        ListNode currListNode = head;
        while (currListNode != null) {
            if (currListNode.next != null && currListNode.val == currListNode.next.val) {
                len--;
                currListNode.next = currListNode.next.next;

            }
            currListNode = currListNode.next;
        }

    }

    // copyof ReverseList
    SLL copyofReverseList() {
        ListNode temp1 = null, temp2 = null, currListNode = head;
        while (currListNode != null) {
            temp2 = new ListNode(currListNode.val, temp1);
            currListNode = currListNode.next;
            temp1 = temp2;
        }
        SLL obj = new SLL();
        obj.head = temp1;
        return obj;
    }

    // copy of original list
    SLL copyList() {
        ListNode headListNode = null, tail = null, temp = null, currListNode = head;
        if (currListNode == null) {
            return null;
        }
        headListNode = new ListNode(currListNode.val, null);
        tail = headListNode;
        currListNode = currListNode.next;
        while (currListNode != null) {
            temp = new ListNode(currListNode.val, null);
            tail.next = temp;
            tail = temp;
            currListNode = currListNode.next;
        }
        SLL obj = new SLL();
        obj.head = headListNode;
        return obj;
    }

    // compare list
    boolean compareList(SLL l1, SLL l2) {
        ListNode head1 = l2.head, head2 = l1.head;
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;

        }
        if (head1 == null && head2 == null) return true;
        return false;
    }

    // Find nth ListNode begin
    int findNthListNodefrombegin(int index) {
        if (index > len || index < 1) return -1;
        int count = 0;
        ListNode currListNode = head;
        while (currListNode != null && count < index - 1) {
            count++;
            currListNode = currListNode.next;
        }
        return currListNode.val;
    }

    // find Nth ListNode from last
    int findnthformLast(int index) {
        int size = getLen();
        int sindex;
        if (size != 0 && size < index) return -1;
        sindex = size - index + 1;
        return findNthListNodefrombegin(sindex);
    }

    // leetcode 876
    public int find_middle_ofLinkedList() {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;

    }

    // Leetcode 21  merge two sorted List

    public void mergeofTwosortedList(SLL l1, SLL l2) {

        ListNode l1ListNode = l1.head;
        ListNode l2ListNode = l2.head;
        ListNode obj = new ListNode(-1);
        ListNode prev = obj;
        while (l1ListNode != null && l2ListNode != null) {
            if (l1ListNode.val <= l2ListNode.val) {
                prev.next = l1ListNode;
                l1ListNode = l1ListNode.next;
            } else {
                prev.next = l2ListNode;
                l2ListNode = l2ListNode.next;
            }
            prev = prev.next;
        }
        prev.next = l1ListNode == null ? l2ListNode : l1ListNode;


        ListNode temp=obj.next;
        while (temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
    }

    // leetcode  160  Intersection of Two LinkedList

    public void IntersectionofTwoList(SLL l1 , SLL l2){
         int x=-1;
          int l1length=l1.len;
          int l2length=l2.len;
          int diff;
          ListNode l2ListNode=l2.head;
          ListNode l1ListNode=l1.head;

          if(l1length>l2length){
              diff=l1length-l2length;
              int i=0;
              while (i<diff){
                  l1ListNode=l1ListNode.next;
                  i++;
              }
          }
             diff=l2length-l1length;
            int i=0;
             while (i<diff){
            l2ListNode=l2ListNode.next;
            i++;
        }

             while (l1ListNode !=null && l2ListNode!=null ){
                 System.out.println("l1 val: "+l1ListNode.val+"  l2 val : "+l2ListNode.val);
                 if (l1ListNode.val==l2ListNode.val){
                     x= l1ListNode.val;
                     System.out.println(" Answer : "+x);

                     break;
                 }
                 l1ListNode=l1ListNode.next;
                 l2ListNode=l2ListNode.next;
             }

    }

    //  leetcode 141  Cycle in SLL
     public boolean  HasaCycle( ListNode head){
        ListNode slow=head;
        ListNode fast =head.next;

        if (head==null){
            return false;
        }
        while (slow!=fast){
            if (fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
      return  true;
     }
     
     // leetcode 234  palindrome
    
    public boolean ispalindrome(ListNode head){
        ListNode f=head;
        ListNode s=head;
        // Find Middle Node
        while (f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        if(f!=null){
            s=s.next;
        }
        // Reverse After Mid
        s=reverse(s);
        f=head;

        // Check Values of Palindrome
        while (s!=null){
            if(f.val!=s.val){
                return false;
            }
            f=f.next;
            s=s.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head){
        ListNode p=null;
        ListNode n=null;
        while (head!=null){
            n=head.next;
            head.next=p;
            p=head;
            head=n;
        }
        return p;
    }


    // leetcode 25 Reverse k Groups

    public ListNode reverseKGroup(ListNode head,int k){
        if(k==1){
            return head;
        }
        ListNode temp=head;
        int len=0;
        while (temp!=null){
            temp=temp.next;
            len++;
        }
        ListNode dummy =new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy,curr=null,next=null;
        while (len>=k){
            curr=prev.next;
            next=curr.next;
            for(int i=1; i<k; ++i){
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next=curr.next;
            }
            prev=curr;
            len-=k;

        }
        return dummy.next;
    }



 // leetcode 19  Remove nth node From end

    public ListNode Removenth(ListNode head,int n){
        int len=0;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            len++;
        }
        int sindex;
        if(len!=0&& len<n) return head;
          sindex=len-n+1;
          return RemoventhfromStart(head, sindex);

    }

    private ListNode RemoventhfromStart(ListNode head,int index) {
        ListNode currnode=head;
        int i=0;
        ListNode prev=head;
        while (currnode!=null && i<index-1){
            i++;
            currnode=currnode.next;
            prev=prev.next;
        }

        ListNode nextnode=currnode.next;
        prev.next=nextnode;
        currnode=null;
        return head;
    }


}
