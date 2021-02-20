package Stack;

import java.util.EmptyStackException;

// Stack implemented using java array
// code by YoYo101

public class Stack<T>
{
    protected Object[] nodes = new Object[10];
    protected int size = 0;

    public int getSize()
    {
        return this.size;
    }

    public T remove()
    {
        if(this.size == 0)
        {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        final T node = (T) this.nodes[this.size - 1];
        this.nodes[this.size - 1] = null;
        this.size--;
        return node;
    }

    public boolean add(T node)
    {
        if(size == this.nodes.length)
        {
            Object[] nodes = new Object[this.nodes.length*2];
            for(int i = 0; i < this.nodes.length; i++)
            {
                nodes[i] = this.nodes[i];
            }
            this.nodes = nodes;
        }
        
        this.nodes[size] = node;
        this.size++;
        return true;
    }

    public T peek() throws Exception
    {
        if(this.size == 0)
        {
            throw new Exception("Empty Stack");
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