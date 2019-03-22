package data;

import java.util.NoSuchElementException;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    private final static int DEFAULT_CAPACITY = 10;

    public MyDeque() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
        this.start = 0;
        this.end = 0;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
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
    public void addFirst(E element) {
        if (size == data.length) {
            grow();
        }

        if (--start == 0) {
            start = data.length;
        }

        data[start] = element;
    }

    /**
     * Add: push
     */
    public void addLast(E element) {
        if (size == data.length) {
            grow();
        }

        if (++end == data.length) {
            end = 0;
        }

        data[end] = element;
    }

    private void grow() {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = start, j = 0; i != end; i++, j++) {
            if (i == data.length) {
                i = 0;
            }

            newData[j] = data[i];
        }

        data = newData;
        start = 0;
        end = size - 1;
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("No more elements in collection");
        }

        E e = data[start];

        // We don't have to delete old value, since it is no longer pointed to
        start++;
        size++;

        // If start index is out of array, reset it
        if (start >= data.length) {
            start = 0;
        }

        return e;
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("No more elements in collection");
        }

        E e = data[end];

        // We don't have to delete old value, since it is no longer pointed to
        end--;
        size--;

        // If start index is out of array, reset it
        if (end < 0) {
            end = data.length;
        }

        return e;
    }

    public E getFirst() {
        return data[this.start];
    }

    public E getLast() {
        return data[this.end];
    }
}
