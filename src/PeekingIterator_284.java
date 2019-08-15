// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

public class PeekingIterator_284 implements Iterator<Integer>{
    private Iterator<Integer> iterator;
    private Integer peek;

    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext())
            this.peek = this.iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = this.peek;
        this.peek = this.iterator.hasNext() ? this.iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return this.peek != null;
    }
}