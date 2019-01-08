package chapter_four;

import org.omg.PortableInterceptor.INACTIVE;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyTree {

    private TreeNode root;

    //task 9
    public void customWeaveList(LinkedList<Integer> first, LinkedList<Integer> second,
                                ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        for(Integer i : first){
            //todo сделать это дерьмо!!!!
        }
    }

    public ArrayList<LinkedList<Integer>> allSeq(TreeNode node){
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if(node == null){
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(Integer.valueOf(node.data));

        ArrayList<LinkedList<Integer>> leftSeq = allSeq(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSeq(node.right);

        for(LinkedList<Integer> left : leftSeq){
            for (LinkedList<Integer> right : rightSeq){
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveList(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public void weaveList(LinkedList<Integer> first, LinkedList<Integer> second,
                          ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){

        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveList(first,second,results,prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveList(first,second,results,prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    //task 8
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(!covers(root,p) || !covers(root,q)) return null;
        return heplerAncestor(root,p,q);
    }

    private TreeNode heplerAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root == p || root==q) return root;

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);

        if(pIsOnLeft != qIsOnLeft) return root;

        TreeNode common = pIsOnLeft ? root.left : root.right;
        return heplerAncestor(common, p, q);
    }

    private boolean covers(TreeNode root, TreeNode p){
        if(root == null) return false;
        if(root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    //task 5
    boolean isSearchTree(TreeNode root){
        return 0 == isSearchTree(root, null, null);
    }

    Integer isSearchTree(TreeNode root, Integer min, Integer max){
        if(root == null)
            return 0;

        Integer left = isSearchTree(root.left, min, root.key);
        if(left == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        Integer right = isSearchTree(root.right, root.key, max);
        if(right == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;


        if(max != null){
            if(root.key > max)
                return Integer.MIN_VALUE;
        }

        if(min != null){
            if(root.key < min)
                return Integer.MIN_VALUE;
        }

        return 0;
    }

    //task 4
    boolean isBalancedTree(){
        return countHeight(root) != Integer.MIN_VALUE;
    }

    Integer countHeight(TreeNode node){
        if(node == null)
            return 0;

        Integer leftTreeHeight = countHeight(node.left);
        if(leftTreeHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        Integer rightTreeHeight = countHeight(node.right);
        if(rightTreeHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if(Math.abs(leftTreeHeight - rightTreeHeight) > 1)
            return Integer.MIN_VALUE;
//            throw new RuntimeException("it is not balanced");
        else if(leftTreeHeight > rightTreeHeight)
            return leftTreeHeight+1;
        else
            return rightTreeHeight+1;
    }

    public void setRoot(TreeNode root){
        this.root = root;
    }
    //3 task
    public List<LinkedList<TreeNode>> createListsNodes(){
        List<LinkedList<TreeNode>> result = new LinkedList<>();

        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);

        while(!current.isEmpty()){
            result.add(current);
            LinkedList<TreeNode> tmp = current;
            current = new LinkedList<>();

            for(TreeNode n : tmp){
                if(n.left != null)
                    current.add(n.left);
                if(n.right != null)
                    current.add(n.right);
            }
        }
        return result;
    }

    //2 task
    public TreeNode createTreeFromArray(int[] arr){
        return createTreeFromArray(arr,0, arr.length -1);
    }

    private TreeNode createTreeFromArray(int[] arr, int start, int end){
        if(end < start)
            return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(String.valueOf(arr[mid]), arr[mid]);
        node.left = createTreeFromArray(arr, start, mid - 1);
        node.right = createTreeFromArray(arr, mid+1,end);

        return node;
    }

    public void add(int key, String data){
        if(root == null)
            root = new TreeNode(data,key);
        else{
            TreeNode cN = root;
            TreeNode pN = null;
            while (true){
                if(key == cN.key)
                    {cN.data = data; break;}

                if(key < cN.key)
                    if(cN.left == null)
                        {cN.left = new TreeNode(data, key);break;}
                    else
                        cN = cN.left;
                else
                    if(cN.right == null)
                        {cN.right = new TreeNode(data, key);break;}
                    else
                        cN = cN.right;
            }
        }
    }

    public void delete(int key){
        TreeNode cN = root;
        TreeNode prevN = null;
        TreeNode deleting = null;
        while (true){
            if(key == cN.key){ deleting = cN; break; }
            if(key < cN.key) {
                if (cN.left == null) break;
                prevN = cN;
                cN = cN.left;
            }else if (cN.right == null) {
                break;
            }else {
                prevN = cN;
                cN = cN.right;
            }
        }


        if(deleting == null) return;

        //Если у удаляемого узла нет правого сына
        if(deleting.right == null){
            if(prevN.left.key == deleting.key)
                prevN.left = deleting.left;
            else
                prevN.right = deleting.left;

        }else{
            TreeNode leftMost = deleting.right;
            prevN = null;
            while(leftMost.left != null){
                prevN = leftMost;
                leftMost = leftMost.left;
            }

            if(prevN != null){
                prevN.left = leftMost.right;
            }else{
                deleting.right = leftMost.right;
            }

            deleting.key = leftMost.key;
            deleting.data = leftMost.data;
        }

    }

    static class TreeNode{
        String data;
        TreeNode left, right;
        int key;
        public TreeNode(String data, int key) {
            this.data = data;
            this.key = key;
        }

    }


    public TreeNode getRoot() {
        return root;
    }
}
