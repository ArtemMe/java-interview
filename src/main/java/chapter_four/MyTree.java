package chapter_four;

public class MyTree {

    private TreeNode root;

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
}
