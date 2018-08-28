package chapter_two;

public class MyLinkedList {
    Node head; // first element
    Node tail; // last element

    protected class Node{
        Node next;
        int data; //leave it that
    }

    public void add(int newData){
        if(head==null){
            head = new Node();
            head.data=newData;
            tail = head;
            head.next = tail;
        }else{
            Node temp = new Node();
            temp.data = newData;
            tail.next = temp;
            tail = temp;
        }
    }
    void printData(){
        Node current = head;
        while(current !=null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    //2.3
    public boolean deleteNode(Node n){
        if(n == null || n.next == null)
            return false;
        Node next = n.next;
        n.data= next.data;
        n.next = next.next;
        return true;
    }
}
class ForTest{
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printData();
        System.out.println("===");
        list.deleteNode(list.head.next.next);
        list.printData();
    }
}
