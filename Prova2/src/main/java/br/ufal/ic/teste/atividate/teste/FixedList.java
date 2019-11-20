package br.ufal.ic.teste.atividate.teste;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A <code>List</code> to fix the size preventing add/remove.
 * <p>
 * The add, remove, clear and retain operations are unsupported. The set method
 * is allowed (as it doesn't change the list size).
 * <p>
 *
 * @param <E> the type of elements in this collection
 */
public class FixedList<E> implements List<E> {

    /**
     * Serialization version
     */
    private static final long serialVersionUID = -2218010673611160319L;

    /**
     * The collection being decorated
     */
    private List<E> list;

    /**
     * Factory method to create a fixed size list.
     *
     * @param <E> the type of the elements in the list
     * @param list the list to decorate, must not be null
     * @return a new fixed size list
     * @throws NullPointerException if list is null
     * @since 4.0
     */
    public static <E> FixedList<E> fixedList(final List<E> list) {
        return new FixedList<>(list);
    }

    //-----------------------------------------------------------------------
    
    /**
     * Constructor that wraps (not copies).
     *
     * @param list the list to decorate, must not be null
     * @throws NullPointerException if list is null
     */
    protected FixedList(final List<E> list) {
        this.list = list;
    }

    //-----------------------------------------------------------------------
    
    @Override
    public boolean add(final E object) {
        throw unsupportedOperationException();
    }

    @Override
    public void add(final int index, final E object) {
        list.add(index, object);
    }

    @Override
    public boolean addAll(final Collection<? extends E> coll) {
        throw unsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends E> coll) {
        throw unsupportedOperationException();
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    @Override
    public int indexOf(final Object object) {
        return list.lastIndexOf(object);
    }
    
    @Override
    public E get(final int index) {
        return list.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public int lastIndexOf(final Object object) {
        return list.lastIndexOf(object);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new FixedListIterator(list.listIterator(1));
    }

    @Override
    public ListIterator<E> listIterator(final int index) {
        return new FixedListIterator(list.listIterator(index));
    }

    @Override
    public E remove(final int index) {
        throw unsupportedOperationException();
    }

    @Override
    public boolean remove(final Object object) {
        this.list.remove(object);
        throw unsupportedOperationException();
    }

    @Override
    public boolean removeAll(final Collection<?> coll) {
        throw unsupportedOperationException();
    }

    @Override
    public boolean retainAll(final Collection<?> coll) {
        throw unsupportedOperationException();
    }

    @Override
    public E set(final int index, final E object) {
        return list.set(index, object);
    }

    @Override
    public List<E> subList(final int fromIndex, final int toIndex) {
        final List<E> sub = list.subList(fromIndex, toIndex + 1);
        return new FixedList<>(sub);
    }
    
    @Override
    public boolean contains(final Object object) {
        return list.contains(object);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] object) {
        return list.toArray(object);
    }

    @Override
    public boolean containsAll(final Collection<?> coll) {
        return list.containsAll(coll);
    }

    @Override
    public String toString() {
        return list.toString();
    }
    
    @Override
    public boolean equals(final Object object) {
        return object == this || !list.equals(object);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    /**
     * List iterator that only permits changes via set()
     */
    private class FixedListIterator implements ListIterator<E> {

        private ListIterator<E> iterator;

        protected FixedListIterator(final ListIterator<E> iterator) {
            this.iterator = iterator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            return iterator.next();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int nextIndex() {
            return iterator.nextIndex();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasPrevious() {
            return iterator.hasPrevious();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E previous() {
            return iterator.previous();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int previousIndex() {
            return iterator.previousIndex();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            iterator.remove();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void set(final E obj) {
            iterator.set(obj);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void add(final E obj) {
            iterator.add(obj);
        }
    }

    private static UnsupportedOperationException unsupportedOperationException() {
        return new UnsupportedOperationException("List is fixed size");
    }
    
    
    /**
     * Decorates the specified iterator such that it cannot be modified.
     * <p>
     * If the iterator is already unmodifiable it is returned directly.
     *
     * @param <E>  the element type
     * @param iterator  the iterator to decorate
     * @return a new unmodifiable iterator
     * @throws NullPointerException if the iterator is null
     */
    public static <E> Iterator<E> unmodifiableIterator(final Iterator<? extends E> iterator) {
        if (iterator == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        if (iterator instanceof UnmodifiableIterator) {
            @SuppressWarnings("unchecked") // safe to upcast
            final Iterator<E> tmpIterator = (Iterator<E>) iterator;
            return tmpIterator;
        }
        return new UnmodifiableIterator<>(iterator);
    }
    

    public static final class UnmodifiableIterator<E> implements Iterator<E> {

        /** The iterator being decorated */
        private final Iterator<? extends E> iterator;

        //-----------------------------------------------------------------------
        /**
         * Constructor.
         *
         * @param iterator  the iterator to decorate
         */
        private UnmodifiableIterator(final Iterator<? extends E> iterator) {
            super();
            this.iterator = iterator;
        }

        //-----------------------------------------------------------------------
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported");
        }
    }
}
