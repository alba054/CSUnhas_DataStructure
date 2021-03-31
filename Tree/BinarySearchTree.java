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

        // tanpa rekursif
        // Node temp = root;
        // while(temp != null) {
        //     if(temp.data < data) {
        //         temp = temp.right;
        //     }
        //     else if(temp.data > data) {
        //         temp = temp.left;
        //     }
        //     else {
        //         return true;
        //     }
        // }

        // return false;
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

        // Node temp = root;
        // Node trailTemp = null;
        // while(temp != null) {
        //     trailTemp = temp;
        //     if(temp.data < data) {
        //         temp = temp.right;
        //     }
        //     else if(temp.data > data) {
        //         temp = temp.left;
        //     }
        // }
        
        // if(trailTemp == null) {
        //     root = new Node(data, null, null);
        // }
        // else if(trailTemp.data < data) {
        //     trailTemp.right = new Node(data, null, null);
        // }
        // else if(trailTemp.data > data) {
        //     trailTemp.left = new Node(data, null, null);
        // }

        // return true;
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

        // Node temp = root;
        // Node trailTemp = null;

        // while(temp.data != data) {
        //     trailTemp = temp;
        //     if(temp.data < data) {
        //         temp = temp.right;
        //     }
        //     else if(temp.data > data) {
        //         temp = temp.left;
        //     }
            
        // }

        // if(temp.left == null && temp.right == null) {
        //     if(trailTemp.left == temp) {
        //         trailTemp.left = null;
        //     }
        //     else if(trailTemp.right == temp) {
        //         trailTemp.right = null;
        //     }
        // }

        // else if(temp.left == null) {
        //     Node rightTemp = temp.right;
        //     if(trailTemp.left == temp) {
        //         trailTemp.left = rightTemp;
        //     }
        //     else if(trailTemp.right == temp) {
        //         trailTemp.right = rightTemp;
        //     }
        //     temp = null;
        // }
        // else if(temp.right == null) {
        //     Node leftTemp = temp.left;
        //     if(trailTemp.left == temp) {
        //         trailTemp.left = leftTemp;
        //     }
        //     else if(trailTemp.right == temp) {
        //         trailTemp.right = leftTemp;
        //     }
        //     temp = null;
        // }
        // else {
        //     Node minTemp = minRightSubTree(temp.right);
        //     temp.data = minTemp.data;
        //     Node trailMinTemp = null;
        //     Node minTemp2 = temp.right;
        //     while(minTemp2.left != null) {
        //         trailMinTemp = minTemp2;
        //         minTemp2 = minTemp2.left;
        //     }
            
        //     if(minTemp2.left == null && minTemp2.right == null) {
        //         trailMinTemp.left = null;
        //     }
        //     else if(minTemp2.left == null) {
        //         Node rightTemp = minTemp2.right;
        //         trailMinTemp.left = rightTemp;
        //         minTemp2 = minTemp = null;
        //     }
        // }
        
        // return true;
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
        bts.insert(13);
        bts.insert(21);
        bts.insert(9);
        bts.insert(14);
        bts.insert(14);
        bts.insert(30);
        bts.preorder(bts.root);
        System.out.println();
        bts.inorder(bts.root);
        System.out.println();
        bts.postorder(bts.root);
        System.out.println(bts.search(941));
        System.out.println();
        bts.delete(20);
        // bts.delete(21);
        bts.inorder(bts.root);
        System.out.println();
        bts.postorder(bts.root);
        System.out.println();
        bts.preorder(bts.root);
    }
    
}
