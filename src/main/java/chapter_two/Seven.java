package chapter_two;

public class Seven {
    public Node findOverlap(Node list1, Node list2){

        if(list1 == null || list2 == null)
            return null;

        Node next1 = list1;
        Node next2 = list2;

        int length1 = 0;
        int length2 = 0;

        while(next1 != null && next1.next !=null){
            length1++;
            next1=next1.next;
        }

        while(next2 !=null && next2.next !=null){
            length2++;
            next2=next2.next;
        }

        if(next1 != next2)
            return null;

        Node shorter;
        Node longer;

        int bigCounter = 0;
        int smallCounter = 0;

        if(length1 > length2){
            longer = list1;
            shorter = list2;
            bigCounter = length1;
            smallCounter = length2;
        }else{
            longer = list2;
            shorter = list1;
            bigCounter = length2;
            smallCounter = length1;
        }

        while(longer != null){
            if(shorter == longer){
                return longer;
            }
            if(bigCounter == smallCounter){
                shorter = shorter.next;
            }else{
                bigCounter --;
            }
            longer = longer.next;
        }

        return null;
    }

    public static void main(String[] args){
        Node n11 = new Node();
        Node n21 = new Node();
        n11.next = n21;
        Node n3 = new Node();
        n3.data = 1;
        n21.next = n3;

        Node n12 = new Node();
        Node n22 = new Node();
        n12.next = n22;
        n22.next = n3;

        //общие
        Node n4 = new Node();
        Node n5 = new Node();

        n3.next = n4;
        n4.next = n5;

        Seven s = new Seven();
        Node res = s.findOverlap(n11,n22);
        System.out.print(res.data);
    }
}
class Node{
    Node next;
    int data;
}

