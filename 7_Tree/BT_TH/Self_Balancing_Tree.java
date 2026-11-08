package BT_TH;

class Node {
    int val;    //Value
    int ht;        //Height
    Node left;    //Left child
    Node right;    //Right child

    public Node(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }

    public Node() {
    }
}

public class Self_Balancing_Tree {
    static int h(Node node){
        return (node != null) ? node.ht : -1;
    }

    static int upd(Node node){

        return 1 + Math.max(h(node.left), h(node.right));
    }

    static Node left_Rotate(Node X){     // Gia su node dang bi mat can bang
        Node Y = X.right;

        // Chuyen giao con trai
        X.right = Y.left;

        // Chuyen giao vi tri
        Y.left = X;

        X.ht = upd(X); Y.ht = upd(Y);

        return Y;
    }

    static Node right_Rotate(Node X){
        Node Y = X.left;

        // Chuyen giao con phai
        X.left = Y.right;

        // Chuyen giao vi tri
        Y.right = X;

        X.ht = upd(X); Y.ht = upd(Y);

        return Y;
    }

    static int bf(Node node){
        return h(node.left) - h(node.right);
    }

    static Node rebalance(Node node){
        node.ht = upd(node);
        int balanceFactor = bf(node);

        if (balanceFactor > 1) {    // lech trai
            if (bf(node.left) < 0){ // lech trai phai
                node.left = left_Rotate(node.left);
            }
            return right_Rotate(node);
        } else if (balanceFactor < -1){     // lech phai
            if (bf(node.right) > 0){ // lech phai trai
                node.right = right_Rotate(node.right);
            }
            return left_Rotate(node);
        }

        return node;

    }

    static Node insert(Node root,int val) {
        if (root == null){
            Node n = new Node();
            n.val = val;
            n.left = null;
            n.right = null;
            n.ht = 0;
            return n;
        }
        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);
        else return root;

        return rebalance(root);
    }
}
