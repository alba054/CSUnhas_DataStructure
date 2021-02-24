package DataStructure.Queue;

import java.util.EmptyStackException;
import DataStructure.Stack.Stack;
/*
    queue implemented using stack 
    code by YoYo101
 */

public class Queue<T> extends Stack<T>
{
    private int head = 0;

    @Override
    public T remove()
    {
        if(this.size == 0)
        {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        final T node = (T) this.nodes[head];
        this.nodes[head] = null;
        this.size--;
        this.head++;
        return node;
    }

    @Override
    public T peek()
    {
        if(this.size == 0)
        {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        final T node = (T) this.nodes[0];
        // this.nodes[this.size - 1] = null;
        // this.size--;
        return node;
    }

    public static void main(String[] args) 
    {
        Queue<Integer> queue = new Queue<>();
        
        for(int i = 0; i < 100; i++)
        {
            queue.add(i);
        }

        while(queue.getSize() > 0)
        {
            System.out.println(queue.remove());
        }
    }
}
