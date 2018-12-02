package chapter_four;

public class Client {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(33,"1");
        n1.insertInOrder(35,"1");
        n1.insertInOrder(5,"1");
        n1.insertInOrder(1,"1");
        n1.insertInOrder(20,"1");
        n1.insertInOrder(99,"1");
        n1.insertInOrder(4,"1");
        n1.insertInOrder(17,"1");
        n1.insertInOrder(31,"1");

        n1.remove(5);


        MyTree myTree = new MyTree();
        myTree.add(33,"1");
        myTree.add(35,"1");
        myTree.add(5,"1");
        myTree.add(1,"1");
        myTree.add(20,"1");
        myTree.add(99,"1");
        myTree.add(4,"1");
        myTree.add(17,"1");
        myTree.add(31,"1");


        myTree.delete(5);
    }
}
