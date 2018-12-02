package chapter_four;

public class TreeNode {
    private String data;
    private int key;
    private TreeNode left, right, parent;
    private int size;

    public TreeNode(int key, String data){
        this.key = key;
        this.data = data;
        size = 1;
    }

    public void insertInOrder(int k, String d){
        if(k<= key){
            if(left == null)
                setLeftChild(new TreeNode(k, d));
            else
                left.insertInOrder(k, d);
        }else if(right == null){
            setRightChild(new TreeNode(k, d));
        }else{
            right.insertInOrder(k, d);
        }
        size++;
    }

    public void remove(int k){
        TreeNode cur = this;
        TreeNode prevNode = null;

        while (cur != null){
            if(cur.key == k)
                break;
            else{
                prevNode = cur;
                if(cur.key<k)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
        }

        if(cur == null)
            return;

        if (cur.right == null) {
            if (prevNode == null) {
                //this = cur.left;
            } else {
                if (cur == prevNode.left) {
                    prevNode.left = cur.left;
                } else {
                    prevNode.right = cur.left;
                }
            }
        } else {
            TreeNode leftMost = cur.right;
            prevNode = null;
            while (leftMost.left != null) {
                prevNode = leftMost;
                leftMost = leftMost.left;
            }
            if (prevNode != null) {
                prevNode.left = leftMost.right;
            } else {
                cur.right = leftMost.right;
            }
            cur.key = leftMost.key;
            cur.data = leftMost.data;
        }
    }


    public TreeNode find(int d){
        if(d == key)
            return this;
        if(d<= key)
            return left !=null ? left.find(d) : null;
        else return right != null ? right.find(d) : null;
    }

    public int getSize(){
        return size;
    }

    public void setLeftChild(TreeNode node){
        this.left = node;
        if(node!=null)
            node.parent = this;
    }
    public void setRightChild(TreeNode node){
        this.right = node;
        if(node!=null)
            node.parent = this;
    }
}
