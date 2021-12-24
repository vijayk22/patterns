import java.util.LinkedList;

public class LinkList {

    Node head;
//add a new node to front
    Node push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        return new_node;
    }
    void append(int data) {
        Node new_node = new Node(data);
        if(head == null) {
            head = new_node;
        }
        Node last = head; //use temp pointer to leave head as-is
        while(last.next !=null)
            last=last.next;
        last.next=new_node;
    }
    void insertAfter(Node prev_node, int data) {
        if(prev_node == null)//error no previous node found
            return;
        //if node is provided, no need to find
        Node new_node = new Node(data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    void delete(int data) {
       Node tmp = head;
       Node prev = head; //need to adjust next pointer
       while(tmp != null) {
            if(data == tmp.data)
                break;
            prev = tmp;
            tmp = tmp.next;
       }
        prev.next = tmp.next;
        System.out.println("deleting:"+tmp.data);
        tmp = null;
    }

    void deleteByPosition(int position) {
        //checks
        if(head == null)
            return;
        Node prev = head;
        if(position == 0) {
            head = prev.next;
            return;
        }
        for(int i=0; i< position-1; i++) {
            prev = prev.next;
        }
        if(prev == null || prev.next == null)
            return;

        //now delete the next node
        prev.next = prev.next.next;
    }
    void print() {
        //use tmp node, not to loose head point
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }

    Node findNodeAtIndex(int index) {
        Node tmp = head;
        for(int i=0; i<index-1; i++) {
            if(tmp == null)
                return null;
            tmp = tmp.next;
        }
        return tmp;
    }
    Node findMiddleOfLL() {
        Node slow=head, fast = head;
        while(fast != null && fast.next != null) { //slow, fast pointer
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; //remember to return slower pointer
    }

    void deleteAlt(){
        if(head == null)
            return;
        //initialize
        Node curr=head;
        Node later=head.next;

        while(curr != null && later != null) {
            curr.next = later.next; //skip later node
            later = null; //free later node

            //increment
            curr = curr.next;
            if(curr !=null)
                later = curr.next;
        }
    }

    public static void main(String args[]) {
        LinkList ll = new LinkList();
        ll =  ll.createLL();
        ll.print();
        ll.deleteAlt();
        ll.print();

        ll =ll.createLL();

        System.out.println("\n2nd node: "+ll.findNodeAtIndex(2).data);
        System.out.println("Middle of LL: "+ ll.findMiddleOfLL().data);
        ll.delete(2);
        ll.deleteByPosition(1);
        ll.print();
    }
     LinkList createLL() {
        LinkList ll = new LinkList();
        ll.push(2);
        ll.push(1);
        //intentional gap
        ll.append(4);
        //append 3 after head.next which is 2 (head points to 1)
        ll.insertAfter(ll.head.next, 3);
        return ll;
    }

}

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
    }
}