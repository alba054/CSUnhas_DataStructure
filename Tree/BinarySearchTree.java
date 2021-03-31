package DataStructure.Tree;


// implementasi binary search tree
/* fungsi - fungsi :
    1. inserting
    2. deleting
    3. searching
    4. traversing (inorder, preorder, postorder)
    5. getMaxDepth

*/
public class BinarySearchTree {

    Node root;

    // membuat binary tree dengan inisial root
    public BinarySearchTree(int data) {
        root = new Node(data, null, null);
    }
    public BinarySearchTree() {}
    
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public boolean search(int data) {
        return search(data, root);
    }

    public boolean search(int data, Node curNode) {
        // curNode akan null jika data tidak ditemukan
        if(curNode == null) {
            return false;
        }
        
        // aturan standar binary tree
        if(data < curNode.data) {
            return search(data, curNode.left);
        }
        else if(data > curNode.data) {
            return search(data, curNode.right);
        }
        else {
            return true;
        }

    }


    public boolean insert(int data) {
        // mencegah nilai duplikat
        if(search(data)) {
            return false;
        }
        
        root = insert(data, root);
        return true;
    }

    public Node insert(int data, Node curNode) {
        if(curNode == null) {
            curNode = new Node(data, null, null);
        }

        if(data < curNode.data) {
            curNode.left = insert(data, curNode.left);
        }
        else if(data > curNode.data) {
            curNode.right = insert(data, curNode.right);
        }
        
        return curNode;
    }

    public void preorder(Node curNode) {
        if(curNode == null) return;
        System.out.print(curNode.data + " ");
        preorder(curNode.left);
        preorder(curNode.right);
    }

    public void inorder(Node curNode) {
        if(curNode == null) return;
        inorder(curNode.left);
        System.out.print(curNode.data + " ");
        inorder(curNode.right);
    }

    public void postorder(Node curNode) {
        if(curNode == null) return;
        postorder(curNode.left);
        postorder(curNode.right);
        System.out.print(curNode.data + " ");
    }

    public boolean delete(int data) {
        // nilai yang dicari tidak ada
        if(!search(data)) return false;
        
        root = delete(data, root);
        return true;
    }

    public Node delete(int data, Node curNode) {

        if(data < curNode.data) {
            curNode.left = delete(data, curNode.left);
        }
        else if(data > curNode.data) {
            curNode.right = delete(data, curNode.right);
        }
        else {
            // menghapus daun pada pohon
            if(curNode.left == null && curNode.right == null) {
                return null;
            }
            // menghapus node yang tidak memiliki subtree kiri
            else if(curNode.left == null) {
                Node temp = curNode.right;
                curNode = null;
                return temp;
            }
            // menghapus node yang tidak memiliki subtree kanan
            else if(curNode.right == null) {
                Node temp = curNode.left;
                curNode = null;
                return temp;
                
            }
            // menghapus node yang memiliki subtree kiri dan kanan
            else {
                // mencari nilai terkecil di subtree kanan relatif thd curNode
                Node temp = minRightSubTree(curNode.right);
                curNode.data = temp.data;
                curNode.right = delete(temp.data, curNode.right);
            }
        }
        
        return curNode;
    }

    public Node minRightSubTree(Node node) {
        while(node.left != null) {
            node = node.left;
        }

        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree bts = new BinarySearchTree(10);
        bts.insert(20);
        bts.insert(21);
        bts.insert(30);
        bts.insert(11);
        bts.insert(21);
        bts.insert(9);
        bts.insert(12);
        bts.insert(12);
        bts.insert(30);
        bts.preorder(bts.root);
        System.out.println();
        bts.inorder(bts.root);
        System.out.println();
        bts.postorder(bts.root);
        System.out.println(bts.search(9));
        
        bts.delete(10);
        bts.inorder(bts.root);
    }
    
}
