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


    private static class Pair {
        Node root;
        int status;

        Pair(Node r, int s) {
            this.root = r;
            this.status = s;
        }
    }


    private static void printInOrder(Node root) {

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));


        while(!st.isEmpty()) {
            Pair rem = st.pop();

            if(rem.status == 0) {

                rem.status = 1;
                st.push(rem);

                if(rem.root.left != null)
                    st.push(new Pair(rem.root.left, 0));
            }
            else if(rem.status == 1) {
                System.out.print(rem.root.data + " ");

                rem.status = 2;
                st.push(rem);

                if(rem.root.right != null)
                    st.push(new Pair(rem.root.right, 0));
            }
            else if(rem.status == 2) {

                //do nothing.
            }
        }


    }


    


    
    private static ArrayList<Node> getInOrder(Node root) {

        ArrayList<Node> list = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));


        while(!st.isEmpty()) {
            Pair rem = st.pop();

            if(rem.status == 0) {

                rem.status = 1;
                st.push(rem);

                if(rem.root.left != null)
                    st.push(new Pair(rem.root.left, 0));
            }
            else if(rem.status == 1) {
                list.add(rem.root);

                rem.status = 2;
                st.push(rem);

                if(rem.root.right != null)
                    st.push(new Pair(rem.root.right, 0));
            }
            else if(rem.status == 2) {
                //do nothing.
            }
        }


        return list;

    }




    private static void correctBST(Node root) {
        ArrayList<Node> list = getInOrder(root);

        //first defaulter
        int idx1 = 0;
        while(idx1 < list.size() - 1) {

            if(list.get(idx1).data > list.get(idx1 + 1).data) {
                break;
            }

            idx1++;
        }

        //second defaulter
        int idx2 = list.size() - 1;
        while(idx2 >= 1) {

            if(list.get(idx2).data < list.get(idx2 - 1).data) {
                break;
            }

            idx2--;
        }



        //swap the node data;
        int temp = list.get(idx1).data;
        list.get(idx1).data = list.get(idx2).data;
        list.get(idx2).data = temp;

    }




   

    public static void main(String[] args) {
        
        // Node root = new Node(5);
        // root.left = new Node(1);
        // root.right = new Node(6);
        // root.right.left = new Node(7);
        // root.right.left.left = new Node(9);
        // root.right.right = new Node(8);

        Node root = new Node(10);
        root.left = new Node(13);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.right = new Node(11);
        root.right.right = new Node(8);

        printInOrder(root);


        correctBST(root);

        System.out.println();
        printInOrder(root);


    }

}