package patterns;

import sun.jvm.hotspot.debugger.windbg.DLL;

class Node {
    int data;
    Node prev;
    Node next;
    Node(int d) {data =d;}
}

public class DoublyLL {
    //general rules:
    // create relationship using new node before breaking/changing existing ones
    //as soon as new node is created, create relationship first
    Node head;
    void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        if (head !=null) head.prev = new_node;
        head = new_node;
    }

    void append(int data) {
       Node new_node = new Node(data);
       Node last = head; //tmp node, not to loose head
       if(head == null) {
            head = new_node;
            return;
        }
       while(last.next !=null) { //remember last.next, need last not null node and not last
        last = last.next;
       }
       last.next = new_node;
       new_node.prev = last;
    }

    void insertBefore(Node next_node, int new_data) {
       if(next_node == null) return;

       Node new_node = new Node(new_data);
       //create reln with new node first
       new_node.next = next_node;
       new_node.prev = next_node.prev;

      //change existing reln
       next_node.prev = new_node;
       if(new_node !=null)
            new_node.prev.next = new_node;
       else head=new_node;
    }

    void insertAfter(Node prev_node, int data) {
       if(prev_node == null) return;

       Node new_node = new Node(data);

       new_node.next = prev_node.next;
       new_node.prev = prev_node;

       prev_node.next = new_node;
       if(new_node.next != null)
           new_node.next.prev = new_node;
    }
    void printList(Node node) {
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp =  tmp.next;
        }
    }

    public Node reverseList(Node head) {
        //not to loose head
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            //don't loose existing reln before changing !!
            Node next = curr.next;
            curr.next =prev; //switch the direction (reverse)

           //increment
            prev = curr;
            curr = next;
        }
        //return head
        return prev;
    }

    public static void main(String[] args)
    {
        /* Start with the empty list */
       DoublyLL  dll = new DoublyLL();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        dll.push(7);

        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        dll.append(4);

        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        dll.insertAfter(dll.head.next, 8);

        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        dll.insertBefore(dll.head.next.next, 5);

        System.out.println("Created DLL is: ");
        dll.printList(dll.head);
    }
}

