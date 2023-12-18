import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private int size=0;
    private Node<T> head;
    SimpleLinkedList() {
        this.size=0;
        this.head=null;
    }




    SimpleLinkedList(T[] values) {
        this();
        for(T val:values){
            push(val);
        }
    }

    void push(T value) {
     Node<T> newNode =  new Node<T>(value);
     newNode.next=head;
             head = newNode;
     size++;

    }

    T pop() {

        if(head==null) {
            throw new NoSuchElementException("Can't pop when no items");
        }
        T res = head.data;
        head=head.next;
        size--;
        return res;

    }

    void reverse() {
       Node<T> next;
        Node<T> current =head;
        Node<T> prev=null;
        while(current != null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        head=prev;
    }

    T[] asArray(Class<T> clazz) {
        List<T> tList = new ArrayList<>();
        Node<T> start =head;
        while(start != null){
          tList.add(  start.data);
          start=start.next;
        }
        return tList.toArray((T[]) java.lang.reflect.Array.newInstance(clazz, tList.size()));
    }

    int size() {
       return this.size;
    }
}
