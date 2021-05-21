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


    private static void printInOrder(Node root) {
        if(root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }


    private static int updateTree(Node root) {
        //base
        if(root == null) {
            return 0;
        }


        //post order work
        int leftAns = updateTree(root.left);
        int rightAns = updateTree(root.right);

        root.data = root.data + leftAns + rightAns;

        return root.data;
    }



    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    static void findCeil(Node root, int target) {
        //base
        if(root == null) {
            return;
        }

        //logic
        if(root.data == target) {
            ceil = root.data;
            floor = root.data;
            return;
        }
        else if(root.data > target) {
            ceil = Math.min(ceil, root.data);
            findCeil(root.left, target);
        }
        else {
            floor = Math.max(floor, root.data);
            findCeil(root.right, target);
        }

    }

   

    private static void printLeftView(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Node rem = q.poll();

                if(i == size - 1)
                    System.out.print(rem.data + " ");

                //add children
                if(rem.left != null) {
                    q.add(rem.left);
                }
                
                if(rem.right != null) {
                    q.add(rem.right);
                }
            }

            System.out.println();
        }
    }




    public static void main(String[] args) {
        
        // Node root = new Node(5);
        // root.left = new Node(1);
        // root.right = new Node(6);
        // root.right.left = new Node(7);
        // root.right.left.left = new Node(9);
        // root.right.right = new Node(8);

        // Node root = new Node(10);
        // root.left = new Node(13);
        // root.left.left = new Node(6);
        // root.left.right = new Node(7);
        // root.right = new Node(11);
        // root.right.right = new Node(8);

        // printInOrder(root);

        // updateTree(root);

        // System.out.println();
        // printInOrder(root);


        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(9);
        root.right = new Node(15);
        root.right.left = new Node(14);
        root.right.left.right = new Node(19);

        // int target = 9;

        // findCeil(root, target);

        // System.out.println("ceil " + ceil);
        // System.out.println("floor " + floor);



        printLeftView(root);
    }

}