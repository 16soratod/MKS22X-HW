import java.util.*;
public class MyQueue<T>{

    public MyLinkedList<T> current;
     /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item){
        current.add(current.size()-1, item);
    }

    /*
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
        if(size() == 0){
            throw new NoSuchElementException("index out of bounds");
        }else{
            return current.remove(0);
        }
    }

    /*
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
        return current.get(0);
    }

    /*
     * Returns the number of items currently in the queue.
     */
    public int size(){
        return current.size();
    }

    /*
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty(){
        if(current == null){
            return true;
        }else{
            return false;
        }
    }

    }