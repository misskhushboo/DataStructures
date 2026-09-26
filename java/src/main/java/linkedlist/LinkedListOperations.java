package linkedlist;

import java.util.LinkedList;

/**
 *
 */
public class LinkedListOperations {
    
    public static void main(String[] args){
        LinkedListOperations list = new LinkedListOperations();
        LinkedListNode node=list.createLinkedList();
        LinkedListNode updatedList1= list.addToFirst(node);
        list.addToLast(updatedList1);
    }

    private LinkedListNode createLinkedList() {

        LinkedListNode head = new LinkedListNode("1");
        LinkedListNode node1 = new LinkedListNode("2");
        head.next = node1;
        LinkedListNode node2 = new LinkedListNode("3");
        node1.next = node2;
        return head;
    }

    public void traverseLinkedList(LinkedListNode head) {

        LinkedListNode current=head;
        while(current!=null){
            System.out.println("Node value="+current.getValue());
            current=current.next;
        }
    }

    public LinkedListNode addToFirst(LinkedListNode head){
        LinkedListNode newNode=new LinkedListNode("0");
        newNode.next=head;

        System.out.println("Added to First");
        traverseLinkedList(newNode);

        return newNode;  //this step is important. this is new head.
    }

    public void addToLast(LinkedListNode head){
        LinkedListNode newNode=new LinkedListNode("4");

        LinkedListNode current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;

        System.out.println("Added to last");
        traverseLinkedList(head);           //No need to return new head, there's no change.
    }
}
