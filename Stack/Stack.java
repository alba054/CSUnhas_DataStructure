package DataStructure.Stack;

import java.util.EmptyStackException;

/*
    stack implemented using array 
    code by YoYo101
 */

public class Stack<T>
{
    /* 
        initial state : make array with 10 length
    */
    protected Object[] nodes = new Object[10];
    protected int size = 0;

    // number of elements in stack
    public int getSize()
    {
        return this.size;
    }

    // remove the last element and return the value O(1)
    public T remove()
    {
        if(this.size == 0)
        {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        final T node = (T) this.nodes[this.size - 1];
        // remove the from the element form last index in the array
        this.nodes[this.size - 1] = null;
        this.size--;
        return node;
    }

    // add new element to stack O(1) and O(n) when old array is full
    public boolean add(T node)
    {
        // extend the array by 2 times : currentSize = 10 --> currentSize = 20
        if(size == this.nodes.length)
        {
            Object[] nodes = new Object[this.nodes.length*2];
            // coppying all elements from old array to new extended array : O(n)
            for(int i = 0; i < this.nodes.length; i++)
            {
                nodes[i] = this.nodes[i];
            }
            this.nodes = nodes;
        }
        
        // add to the last index of array
        this.nodes[size] = node;
        this.size++;
        return true;
    }

    // return the value of the last element in stack O(1)
    public T peek()
    {
        if(this.size == 0)
        {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        final T node = (T) this.nodes[this.size - 1];
        // this.nodes[this.size - 1] = null;
        // this.size--;
        return node;
    }

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 100; i++)
        {
            stack.add(i);
        }

        while(stack.getSize() > 0)
        {
            System.out.println(stack.remove());
        }
    }
}