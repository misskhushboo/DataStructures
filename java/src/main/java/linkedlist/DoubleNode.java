package linkedlist;

public class DoubleNode {

    int key;
    int value;
    DoubleNode prev;
    DoubleNode next;
    public DoubleNode(int key, int value){
        this.key = key;
        this.value = value;
    }
    public DoubleNode(){}

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }


}
