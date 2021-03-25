package DataStructure.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T>
{
    protected Node head;
    protected Node tail;
    protected int size;

    public SinglyLinkedList()
    {
        this.head = new Node();
        this.tail = this.head;
        this.size = 0;
    }

    protected class Node 
    {
        public T node;
        public Node next;
    }

    public int getSize()
    {
        return this.size;
    }

    protected void insertEmpty(T node)
    {
        this.head.node = node;
        this.size++;
    }

    public void insertHead(T node)
    {
        if(this.size == 0)
        {
            insertEmpty(node);
            return;
        }

        Node newNode = new Node();
        newNode.node = node;
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public void insertTail(T node)
    {
        if(this.size == 0)
        {
            insertEmpty(node);
            return;
        }
        
        Node newTail = new Node();
        newTail.node = node;
        this.tail.next = newTail;
        this.tail = newTail;
        this.size++;
    }

    public boolean insertAfter(T data, T newData)
    {
        if(this.size == 1 && this.head.node == data)
        {
            insertTail(newData);
            return true;
        }

        Node curNode = this.head;
        while(curNode != null)
        {
            if(curNode.node == data)
            {
                if(curNode == this.tail) insertTail(newData);
                else
                {
                    Node newNode = new Node();
                    newNode.node = newData;
                    newNode.next = curNode.next;
                    // System.out.println(newNode.next);
                    curNode.next = newNode;
                    // System.out.println(curNode.next.node);
                    this.size++;
                }
                return true;
            }
            curNode = curNode.next;
        }
        
        return false;
    }

    public boolean contains(T node)
    {
        Node curNode = this.head;

        while(curNode != null)
        {
            if(curNode.node == node) return true;

            curNode = curNode.next;
        }
        

        return false;
    }

    public boolean removeHead()
    {
        // if(this.head == this.tail)
        // {
        //     this.head = this.tail = null;
        //     this.size--;
        //     return true;
        // }
        if(this.size != 0)
        {
            Node nextHead = this.head.next;
            this.head = nextHead;
            // this.head = null;
            this.size--;

            return true;
        }

        return false;
    }

    public boolean removeTail()
    {
        Node curNode = this.head;
        // if(curNode == this.tail)
        // {
        //     removeHead();
        //     return true;
        // }
        if(curNode == null) return false;
        if(this.head == this.tail) 
        {
            removeHead();
            return true;
            // this.size--;
            // return true;
        }

        while(curNode.next != null)
        {
            if(curNode.next == this.tail)
            {
                this.tail = curNode;
                this.tail.next = null;
                this.size--;
                // return true;
            }
            curNode = curNode.next;
        }
        // curNode = this.tail = null;

        return true;
    }
    
    public boolean removeNode(T node)
    {
        if(this.head.node == node) 
        {
            removeHead();
            return true;
        }
        else
        {
            Node curNode = this.head;
            while(curNode.next != null)
            {
                if(curNode.next.node == node)
                {
                    Node temp = curNode.next;
                    curNode.next = curNode.next.next;
                    temp.next = null;
                    temp = null;
                    return true;
                }
                curNode = curNode.next;
            }
        }

        return false;
    }

    public T getHeadValue()
    {
        return this.head.node;
    }

    public T getTailValue()
    {
        return this.tail.node;
    }


    @Override
    public Iterator<T> iterator() 
    {
        return new Iterator<T>()
        {
            Node curNode = head;
            @Override
            public boolean hasNext() 
            {
                return this.curNode != null;
            }

            @Override
            public T next() 
            {
                T data = curNode.node;
                this.curNode = this.curNode.next;
                return data;
            }
        };
    }

    

    public static void main(String[] args) 
    {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertHead(1);
        list.insertAfter(1, 2);
        list.insertAfter(2, 3);
        list.insertTail(3);
        list.insertAfter(2, 5);
        list.insertTail(4);
        

        System.out.println("before...");
        for(Integer i : list)
        {
            System.out.print(i + "-->");
        }
        // list.removeNode(4);
        // list.removeHead();
        list.removeNode(4);
        // list.removeNode(3);
        // list.removeNode(3);
        // list.removeNode(1);
        // System.out.println(list.contains(4));
        System.out.println("\nafter...");

        // System.out.println(list.getHeadValue());
        for(Integer i : list)
        {
            System.out.print(i + "-->");
        }
    }

}
