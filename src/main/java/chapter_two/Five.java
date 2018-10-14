package chapter_two;

public class Five {

    public MyLinkedList addTwoList(MyLinkedList first, MyLinkedList second){
        MyLinkedList.Node firstNode = first.getHead();
        MyLinkedList.Node secondNode = second.getHead();
        MyLinkedList list = new MyLinkedList();

        int mod = 0;
        int trans =0;
        while(firstNode!=null && secondNode!=null){

            int sum = firstNode.data + secondNode.data + trans;

            if(sum>10){
                mod = sum%10;
                trans = 1;
            }else{
                trans = 0;
                mod = sum;
            }
            list.add(mod);

            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        while(firstNode !=null){
            list.add(firstNode.data);
            firstNode = firstNode.next;
        }

        while(secondNode !=null){
            list.add(secondNode.data);
            secondNode = secondNode.next;
        }

        return list;

    }
}
