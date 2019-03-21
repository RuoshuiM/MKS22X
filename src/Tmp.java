import java.util.Arrays;

public class Tmp {
    public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

    public MyDeque() {
      MyDeque(10);
    }

    public MyDeque(int initialCapacity) {
      this.data = new E[initialCapacity];
      this.start = 0;
      this.end = 0;
      this.size = 0;
    }

    public int size() {
      return this.size;
    }

    public String toString() {
      boolean wraps = this.end < this.start;
      StringBuilder str = new StringBuilder();
      str.append("{");
      for (int i = this.start; i < size; i++) {
        if (i > data.length) {
          i = 0;
        }
        str.append(data[i]);
        str.append(" ");
      }
      str.append("}");
      return str.toString();
    }

    /**
      * Add: en-queue
      */
    public void addFirst(E element){

    }

    /**
      * Add: dequeue
      */
    public void addLast(E element){

    }


    public E removeFirst() {

    }

    public E removeLast() {
      
    }

    public E getFirst() {
      return data[this.start];
    }
    public E getLast() {
      return data[this.end];
    }
  }
}
