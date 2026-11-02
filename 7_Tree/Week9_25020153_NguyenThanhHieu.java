import java.util.ArrayList;
import java.util.List;
class TreeNode{
    String name;
    TreeNode conTruong;
    TreeNode anhEm;

    public TreeNode(String name, TreeNode conTruong, TreeNode anhEm){
        this.name = name;
        this.conTruong = conTruong;
        this.anhEm = anhEm;
    }
}

public class Week9_25020153_NguyenThanhHieu {
    TreeNode root;

    public static TreeNode findParent(TreeNode current, TreeNode target){
        if (current == null || target == null || current == target){
            return null;
        }

        // Kiem tra current co phai cha khogn
        TreeNode child = current.conTruong;
        while (child != null) {
            if (child == target){
                return current;
            }
            child = child.anhEm;
        }

        // Neu khong nam trong danh sach con truc tiep, de quy vao nhanh con
        TreeNode p = findParent(current.conTruong, target);
        if (p != null){
            return p;
        }

        return findParent(current.anhEm, target);
    }
}
