package DataStructure.Stack;

public class StackLinkedList 
{
    Node base, top;
    int size;

    static public class Node 
    {
        int data;
        Node next;
    
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    StackLinkedList()
    {
        size = 0;
    }

    boolean isEmpty()
    {
        return size == 0;
    }

    void push(int data)
    {
        Node newNode = new Node(data);
        if(isEmpty())
        {
            base = newNode;
            top = newNode;
        }
        else
        {
            top.next = newNode;
            top = newNode;
        }

        size++;
    }

    int pop()
    {
        size--;
        Node current = base;
        while(current.next.next != null)
        {
            current = current.next;
        }

        top = current;
        // System.out.println(top.data);
        int value = top.next.data;
        top.next = null;
        return value;
    }

    void display()
    {
        Node current = base;
        while(current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    
    public static void main(String args [])
    {
        StackLinkedList sLinkedList = new StackLinkedList();
        sLinkedList.push(1);
        sLinkedList.push(2);
        sLinkedList.push(3);
        System.out.println(sLinkedList.pop());
        System.out.println(sLinkedList.pop());
        System.out.println(sLinkedList.pop());
        System.out.println(sLinkedList.pop());
        sLinkedList.display();
    }
}
