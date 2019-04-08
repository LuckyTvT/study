package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *      在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *  如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *  我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *  只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * @author Karlo
 * @date 2019/2/22 10:11
 */
public class Q993 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(4);
        root.right.left = null;
        root.right.right = new TreeNode(5);
//        root.left.left.left = new TreeNode(4);
        boolean cousins = isCousins(root, 5, 4);
        System.out.println(cousins);
    }


    //重点：深度相同，父节点不同，但是treenode无法获取父节点。
    public static boolean isCousins(TreeNode root, int x, int y) {
        List<TreeNode> child = new ArrayList<>();
        child.add(root.left);
        child.add(root.right);
        return re(child,x,y);
    }

    private static boolean re(List<TreeNode> parent, int x, int y) {
        boolean result = false;
        List<TreeNode> childs = new ArrayList<>();
        boolean a = false;
        boolean b = false;
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < parent.size(); i++) {
            TreeNode tmpNode = parent.get(i);
            if(tmpNode==null){
                continue;
            }
            if(tmpNode.val == x){
                t1 = i;
                a = true;
            }
            if(tmpNode.val == y){
                t2 = i;
                b = true;
            }
            if(tmpNode.left == null && tmpNode.right == null){
                continue;
            }
            childs.add(tmpNode.left);
            childs.add(tmpNode.right);
            childs.add(new TreeNode(-1));
        }

        if(a && b){
            int p1 ,p2;
            if(t1 > t2){
                p1 = t1;
                p2 = t2;
            }else{
                p1 = t2;
                p2 = t1;
            }
            for (int i = p2+1; i < p1; i++) {
                if(parent.get(i) == null || parent.get(i).val == -1){
                    return true;
                }
            }
        }else if(childs.size() == 0){
            return false;
        }else {
            result = re(childs,x,y);
        }
        return result;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
