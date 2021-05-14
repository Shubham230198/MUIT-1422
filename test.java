import java.util.*;

class test {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }


    private static int getSize(Node root) {
        if(root == null) {
            return 0;
        }


        int count = 1;       //root itself;

        count += getSize(root.left);
        count += getSize(root.right);

        return count;
    }



    private static boolean checkHalfBreaking(Node root, int totalSize) {

        //base case
        if(root == null) {
            return false;
        }


        int leftTreeSize = 0;
        int rightTreeSize = 0;

        //left Edge ko break karke check karna hai.
        leftTreeSize = getSize(root.left);
        rightTreeSize = totalSize - leftTreeSize;

        if(leftTreeSize == rightTreeSize) {
            return true;
        }


        //right edge ko break karke.
        rightTreeSize = getSize(root.right);
        leftTreeSize = totalSize - rightTreeSize;

        if(leftTreeSize == rightTreeSize) {
            return true;
        }



        //left edge and right edge are not our answer,
        boolean leftAns = checkHalfBreaking(root.left, totalSize);
        if(leftAns == true) {
            return true;
        }

        boolean rightAns = checkHalfBreaking(root.right, totalSize);
        if(rightAns == true) {
            return true;
        }


        return false;

    }






    private static boolean printAncestors(Node root, int val) {
        //base case
        if(root == null) {
            return false;
        }


        //check if val == root.data
        if(val == root.data) {
            return true;
        }


        boolean leftAns = printAncestors(root.left, val);
        if(leftAns == true) {
            System.out.println(root.data);
            return true;
        }

        boolean rightAns = printAncestors(root.right, val);
        if(rightAns == true) {
            System.out.println(root.data);
            return true;
        }

        return false;
    }








   

    public static void main(String[] args) {
        
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.left.left = new Node(9);
        root.right.right = new Node(8);


        // int totalSize = getSize(root);

        // boolean isPossible = checkHalfBreaking(root, totalSize);

        // System.out.println(isPossible);


        printAncestors(root, 8);


    }

}