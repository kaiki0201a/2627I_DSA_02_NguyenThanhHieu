package BT_TH;

import java.util.*;
import java.io.*;
class BSTs_Insert {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root,int data) {
        if (root == null){
            return new Node(data);
        }

        if (root.val > data){
            root.left = insert(root.left, data);
        } else
            root.right = insert(root.right, data);

        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
