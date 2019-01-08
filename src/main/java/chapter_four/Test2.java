package chapter_four;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    @Test
    public void test(){
        MyTree t = new MyTree();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        MyTree.TreeNode node = t.createTreeFromArray(arr);
        System.out.println(node);
    }

    @Test
    public void testTask3(){
        MyTree t = new MyTree();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        MyTree.TreeNode node = t.createTreeFromArray(arr);
        t.setRoot(node);

        List<LinkedList<MyTree.TreeNode>> l = t.createListsNodes();
        for(LinkedList<MyTree.TreeNode> list : l){
            for(MyTree.TreeNode n : list){
                System.out.print(n.key);
            }
            System.out.println();
        }
    }

    @Test
    public void testTask4(){
        MyTree myTree = new MyTree();
        myTree.add(35,"1");
        myTree.add(15,"1");
        myTree.add(7,"1");
        myTree.add(6,"1");
        myTree.add(5,"1");
        myTree.add(4,"1");
        myTree.add(3,"1");
        myTree.add(2,"1");
        myTree.add(1,"1");

        System.out.println(myTree.isBalancedTree());
        List<LinkedList<MyTree.TreeNode>> l = myTree.createListsNodes();
        for(LinkedList<MyTree.TreeNode> list : l){
            for(MyTree.TreeNode n : list){
                System.out.print(n.key);
            }
            System.out.println();
        }

        MyTree myTree2 = new MyTree();
        myTree.add(33,"1");
        myTree.add(35,"1");
        myTree.add(5,"1");
        myTree.add(1,"1");
        myTree.add(20,"1");
        myTree.add(99,"1");
        myTree.add(4,"1");
        myTree.add(17,"1");
        myTree.add(31,"1");

        System.out.println(myTree2.isBalancedTree());

    }

    @Test
    public void task5(){
        MyTree myTree = new MyTree();
        MyTree.TreeNode node = new MyTree.TreeNode("20",20);

        MyTree.TreeNode node2 = new MyTree.TreeNode("10",10);
        node.left = node2;
        MyTree.TreeNode node3 = new MyTree.TreeNode("30",30);
        node.right = node3;
        MyTree.TreeNode node4 = new MyTree.TreeNode("25",25);
        node2.right = node4;

        boolean res = myTree.isSearchTree(node);
        System.out.println(res);
    }

    @Test
    public void task5Valid(){
        MyTree myTree = new MyTree();
        MyTree.TreeNode node = new MyTree.TreeNode("20",20);

        MyTree.TreeNode node2 = new MyTree.TreeNode("10",10);
        node.left = node2;
        MyTree.TreeNode node3 = new MyTree.TreeNode("30",30);
        node.right = node3;
        MyTree.TreeNode node4 = new MyTree.TreeNode("15",15);
        node2.right = node4;

        boolean res = myTree.isSearchTree(node);
        System.out.println(res);
    }



    @Test
    public void testTask8(){
        MyTree myTree = new MyTree();
        MyTree.TreeNode root = new MyTree.TreeNode("20",20);

        MyTree.TreeNode node2 = new MyTree.TreeNode("10",10);
        root.left = node2;
        MyTree.TreeNode node3 = new MyTree.TreeNode("30",30);
        root.right = node3;
        MyTree.TreeNode node4 = new MyTree.TreeNode("25",25);
        node2.right = node4;
        MyTree.TreeNode node5 = new MyTree.TreeNode("9",9);
        node2.left = node5;

        MyTree.TreeNode res = myTree.commonAncestor(root,node5,node4);
        System.out.println(res.data);

    }

    @Test
    public void testTask9(){
        MyTree myTree = new MyTree();
        LinkedList<Integer> first = new LinkedList<>(Arrays.asList(1,2,3));
        LinkedList<Integer> second = new LinkedList<>(Arrays.asList(4,5,6));
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        myTree.weaveList(first,second, res, new LinkedList<>());

        int counter = 0;
        for(LinkedList<Integer> l : res){
            counter++;
            System.out.print(counter+". ");
            for (Integer i : l) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    @Test
    public void test9(){
        MyTree.TreeNode root = new MyTree.TreeNode("4",4);
        MyTree.TreeNode node2 = new MyTree.TreeNode( "2",2);
        root.left = node2;
        MyTree.TreeNode node3 = new MyTree.TreeNode("6",6);
        root.right = node3;
        MyTree.TreeNode node4 = new MyTree.TreeNode("3",3);
        node2.right = node4;
        MyTree.TreeNode node5 = new MyTree.TreeNode("1",1);
        node2.left = node5;
        MyTree.TreeNode node6 = new MyTree.TreeNode("5",5);
        node3.left = node6;

        MyTree myTree = new MyTree();
        ArrayList<LinkedList<Integer>> res = myTree.allSeq(root);

        int counter = 0;
        for(LinkedList<Integer> l : res){
            counter++;
            System.out.print(counter+". ");
            for (Integer i : l) {
                System.out.print(i);
            }
            System.out.println("");
        }

    }

    @Test
    public void test001(){
        System.out.println(2%60);
    }
}
