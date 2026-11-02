import BT_TH.Queue;

public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree(){
        root = null;
    }

    // 1. Search
    public boolean contains(int key){
        return search(root, key) != null;
    }

    private Node search(Node node, int key){
        if (node == null){
            return null;
        } else if (node.key == key){
            return node;
        } else if (node.key < key){
            return search(node.right, key);
        } else {
            return search(node.left, key);
        }
    }

    // 2. Insert
    void insert(int key){
        root = insertKey(root, key);
    }

    Node insertKey(Node node, int key){
        if (node == null){
            return new Node(key);
        }

        if (key < node.key){
            node.left = insertKey(node.left, key);
        } else if (key > node.key){
            node.right = insertKey(node.right, key);
        }

        return node;
    }

    // 3. Delete
    void delete(int key){
        root = deleteNode(root, key);
    }

    Node deleteNode(Node node, int key) {
        if (node == null) {
            return node;
        }

        // Find the node to be deleted
        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // If the node has two children
            node.key = findMin(node.right).key;

            node.right = deleteNode(node.right, node.key);
        }

        return node;
    }

    Node findMin(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    // 4. Traversal
    // DFS
    // a. Pre-order _ Recur
    void pre_order(Node node){
        if (node == null){
            return ;
        }
        System.out.print(node.key + " ");
        pre_order(node.left);
        pre_order(node.right);
    }

    // a.2. Pre-order _ Stack
    void pre_order2(Node node){
        Stack<Node> st = new Stack<>();
        st.push(node);

        while (!st.isEmpty()){
            node = st.pop();
            System.out.print(node.key + " ");

            // Push right truoc vi luc lay ra se duoc lay ra sau
            if (node.right != null)
                st.push(node.right);
            if (node.left != null)
                st.push(node.left);
        }
    }

    // b. In-order
    void in_order(Node node){
        if (node == null){
            return ;
        }
        in_order(node.left);
        System.out.print(node.key+ " ");
        in_order(node.right);
    }

    // c. Post-order
    void post_order(Node node){
        if (node == null){
            return ;
        }
        post_order(node.left);
        post_order(node.right);
        System.out.print(node.key + " ");
    }

    // BFS
    void level_order(Node node){
        Queue<Node> queue = new Queue<>();
        queue.enqueue(node);

        while (!queue.isEmpty()){
            node = queue.dequeue();
            System.out.print(node.key + " ");
            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int v : new int[]{8, 3, 10, 1, 6, 14, 4, 7}) {
            tree.insert(v);
        }
        tree.pre_order(tree.root);    // 8 3 1 6 4 7 10 14
        System.out.println();
        tree.pre_order2(tree.root);   // giống hệt dòng trên
        System.out.println();
        tree.in_order(tree.root);     // 1 3 4 6 7 8 10 14
        System.out.println();
        tree.post_order(tree.root);   // 1 4 7 6 3 14 10 8
        System.out.println();
        tree.level_order(tree.root);  // 8 3 10 1 6 14 4 7
    }
}
