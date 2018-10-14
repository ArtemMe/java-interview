package chapter_two;

import java.util.Stack;

public class MyLinkedList {
    Node head; // first element
    Node tail; // last element

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

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
    public void printData(){
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

    public boolean insertFirst(Node current){
        Node copyHead = new Node();
        copyHead.next = head.next;
        copyHead.data = head.data;

        head.data = current.data;
        head.next = copyHead;

        return true;
    }
    public boolean deleteNodeWithLast(Node penult, Node n){
        if(n == null)
            return false;

        if(n.next == null){
            tail = penult;
            penult.next = null;
            return true;
        }

        Node next = n.next;
        n.data= next.data;
        n.next = next.next;
        return true;
    }

    public void sort(int n){
        Node node = head;
        Node rHead = head;
        Node rTail = head;

        while(node != null){
            Node next = node.next;
            if(node.data < n){
                node.next = rHead;
                rHead = node;
            }else{
                rTail.next = node;
                rTail = node;
            }
            node = next;
        }
        rTail.next = null;
        head = rHead;
        tail = rTail;
    }

    //2.4
    public void sortAround(int n){
        Node next = head;
        Node before = null;
        boolean first = true;
        while(next != null){
            if(n>next.data && !first){
                Node current = next;
                next = next.next;
                insertFirst(current);
                deleteNodeWithLast(before, current);
            }else {
                first = false;
                next = next.next;
            }
        }
    }

    //2.6
    public boolean isPolidrom(){
        Node fast = head;
        Node slow = head;
        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null){
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            int fromStack = stack.pop();
            if(slow.data != fromStack){
                return false;
            }
            slow = slow.next;
        }

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
