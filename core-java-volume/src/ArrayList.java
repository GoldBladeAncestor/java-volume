//
//import java.util.*;
//
///**
// * @Description:
// * @Author:Antonio
// * @Date:Created in 20:32 2019/5/6
// */
//
//
//
//public class ArrayList<E> extends AbstractList<E>
//        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//{
//    private static final long serialVersionUID = 8683452581122892189L;
//
//    /**
//     * Default initial capacity.
//     * 默认初始容量大小
//     */
//    private static final int DEFAULT_CAPACITY = 10;
//
//    /**
//     * Shared empty array instance used for empty instances.
//     * 空数组（用于空实例）
//     */
//    private static final Object[] EMPTY_ELEMENTDATA = {};
//
//    /**
//     * 用于默认大小空实例的共享空数组实例
//     * 我们把它从EMPTY_ELEMENTDATA数组中区分出来，以知道在添加第一个元素时容量需要增加多少
//     */
//    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//
//    /**
//     * 保存ArrayList数据的数组
//     */
//    transient Object[] elementData; // non-private to simplify nested class access
//
//    /**
//     * ArrayList 所包含的元素个数
//     * @serial
//     */
//    private int size;
//
//    /**
//     * 带初始容量参数的构造函数。（用户自己指定容量）
//     */
//    public ArrayList(int initialCapacity) {
//        if (initialCapacity > 0) {
//            this.elementData = new Object[initialCapacity];
//        } else if (initialCapacity == 0) {
//            this.elementData = EMPTY_ELEMENTDATA;
//        } else {
//            throw new IllegalArgumentException("Illegal Capacity: "+
//                    initialCapacity);
//        }
//    }
//
//    /**
//     * Constructs an empty list with an initial capacity of ten.
//     * 默认构造函数， DEFAULTCAPACITY_EMPTY_ELEMENTDATA为0.初始值为10
//     * 也就是说初始其实是空数组，当添加一个元素的时候数组容量变为10
//     */
//    public ArrayList() {
//        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//    }
//
//    /**
//     * 构造一个包含指定集合的元素的列表
//     */
//    public ArrayList(Collection<? extends E> c) {
//        elementData = c.toArray();
//        if ((size = elementData.length) != 0) {
//            // c.toArray might (incorrectly) not return Object[] (see 6260652)
//            if (elementData.getClass() != Object[].class)
//                elementData = Arrays.copyOf(elementData, size, Object[].class);
//        } else {
//            // replace with empty array.
//            this.elementData = EMPTY_ELEMENTDATA;
//        }
//    }
//
//    /**
//     * 修改这个ArrayList实例的容量是列表的当前大小
//     * 可以使用此操作来最小化ArrayList实例的存储
//     */
//    public void trimToSize() {
//        modCount++;
//        if (size < elementData.length) {
//            elementData = (size == 0)
//                    ? EMPTY_ELEMENTDATA
//                    : Arrays.copyOf(elementData, size);
//        }
//    }
//
//    //下面是ArrayList的扩容机制
//    //ArrayList的扩容机制提高了性能，如果每次只扩充一个
//    //那么频繁的插入会导致频繁的拷贝，降低性能，而ArrayList的扩容机制避免了这种情况
//
//    /**
//     * 如有必要，增加此ArrayList实例的容量，以确保它至少能容纳元素的数量
//     * @param minCapacity 所需的最小容量
//     */
//    public void ensureCapacity(int minCapacity) {
//        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
//                // any size if not default element table
//                ? 0
//                // larger than default for default empty table. It's already
//                // supposed to be at default size.
//                : DEFAULT_CAPACITY;
//
//        if (minCapacity > minExpand) {
//            ensureExplicitCapacity(minCapacity);
//        }
//    }
//
//    //得到最小扩容量
//    private void ensureCapacityInternal(int minCapacity) {
//        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
//        }
//
//        ensureExplicitCapacity(minCapacity);
//    }
//
//    //判断是否需要扩容
//    private void ensureExplicitCapacity(int minCapacity) {
//        modCount++;
//
//        // overflow-conscious code
//        if (minCapacity - elementData.length > 0)
//            //调用grow方法进行扩容，调用此方法代表已经开始扩容了
//            grow(minCapacity);
//    }
//
//    /**
//     * 要分配的最大数组大小
//     */
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//    /**
//     * ArrayList扩容的核心方法
//     * @param minCapacity the desired minimum capacity
//     */
//    private void grow(int minCapacity) {
//        // oldCapacity为旧容量，newCapacity为新容量
//        int oldCapacity = elementData.length;
//        //将oldCapacity 右移一位，其效果相当于oldCapacity /2，
//        //我们知道位运算的速度远远快于整除运算，整句运算式的结果就是将新容量更新为旧容量的1.5倍
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        //然后检查新容量是否大于最小需要容量，若还是小于最小需要容量，那么就把最小需要容量当作数组的新容量，
//        if (newCapacity - minCapacity < 0)
//            newCapacity = minCapacity;
//        //再检查新容量是否超出了ArrayList所定义的最大容量，
//        //若超出了，则调用hugeCapacity()来比较minCapacity和 MAX_ARRAY_SIZE，
//        //如果minCapacity大于最大容量，则新容量则为ArrayList定义的最大容量，否则，新容量大小则为 minCapacity。
//
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);
//        // minCapacity is usually close to size, so this is a win:
//        elementData = Arrays.copyOf(elementData, newCapacity);
//    }
//
//    //比较minCapacity和MAX_ARRAY_SIZE
//    private static int hugeCapacity(int minCapacity) {
//        if (minCapacity < 0) // overflow
//            throw new OutOfMemoryError();
//        return (minCapacity > MAX_ARRAY_SIZE) ?
//                Integer.MAX_VALUE :
//                MAX_ARRAY_SIZE;
//    }
//
//    /**
//     * 返回此列表中的元素数
//     */
//    public int size() {
//        return size;
//    }
//
//    /**
//     * 如果此列表不包含元素，则返回 true
//     */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    /**
//     * 如果此列表包含指定的元素，则返回 true
//     */
//    public boolean contains(Object o) {
//        return indexOf(o) >= 0;
//    }
//
//    /**
//     * 返回此列表中指定元素的首次出现的索引，如果此列表不包含此元素，则为-1
//     */
//    public int indexOf(Object o) {
//        if (o == null) {
//            for (int i = 0; i < size; i++)
//                if (elementData[i]==null)
//                    return i;
//        } else {
//            for (int i = 0; i < size; i++)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    /**
//     * 返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1
//     */
//    public int lastIndexOf(Object o) {
//        if (o == null) {
//            for (int i = size-1; i >= 0; i--)
//                if (elementData[i]==null)
//                    return i;
//        } else {
//            for (int i = size-1; i >= 0; i--)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    /**
//     * 返回此ArrayList实例的拷贝
//     *
//     * @return a clone of this <tt>ArrayList</tt> instance
//     */
//    public Object clone() {
//        try {
//            ArrayList<?> v = (ArrayList<?>) super.clone();
//            v.elementData = Arrays.copyOf(elementData, size);
//            v.modCount = 0;
//            return v;
//        } catch (CloneNotSupportedException e) {
//            // this shouldn't happen, since we are Cloneable
//            throw new InternalError(e);
//        }
//    }
//
//    /**
//     * List转数组
//     * 以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组。
//     */
//    public Object[] toArray() {
//        return Arrays.copyOf(elementData, size);
//    }
//
//    /**
//     * 以正确的顺序返回一个包含此列表中所有元素的数组（从第一个到最后一个元素）;
//     * 返回的数组的运行时类型是指定数组的运行时类型。 如果列表适合指定的数组，则返回其中。
//     * 否则，将为指定数组的运行时类型和此列表的大小分配一个新数组。
//     * 如果列表适用于指定的数组，其余空间（即数组的列表数量多于此元素），则紧跟在集合结束后的数组中的元素设置为null 。
//     *（这仅在调用者知道列表不包含任何空元素的情况下才能确定列表的长度。）
//     */
//    @SuppressWarnings("unchecked")
//    public <T> T[] toArray(T[] a) {
//        if (a.length < size)
//            // Make a new array of a's runtime type, but my contents:
//            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//        System.arraycopy(elementData, 0, a, 0, size);
//        if (a.length > size)
//            a[size] = null;
//        return a;
//    }
//
//    // Positional Access Operations
//
//    @SuppressWarnings("unchecked")
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//
//    /**
//     * 返回此列表中指定位置的元素。
//     */
//    public E get(int index) {
//        rangeCheck(index);
//
//        return elementData(index);
//    }
//
//    /**
//     * 用指定的元素替换此列表中指定位置的元素。
//     */
//    public E set(int index, E element) {
//        //对index进行界限检查
//        rangeCheck(index);
//
//        E oldValue = elementData(index);
//        elementData[index] = element;
//        //返回原来在这个位置的元素
//        return oldValue;
//    }
//
//    /**
//     * 将特定的元素追加到此列表的末尾
//     */
//    public boolean add(E e) {
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
//        //这里看到ArrayList添加元素的实质就相当于为数组赋值
//        elementData[size++] = e;
//        return true;
//    }
//
//    /**
//     * 在此列表中的指定位置插入指定的元素。
//     * 先调用 rangeCheckForAdd 对index进行界限检查；然后调用 ensureCapacityInternal 方法保证capacity足够大；
//     * 再将从index开始之后的所有成员后移一个位置；将element插入index位置；最后size加1。
//     */
//    public void add(int index, E element) {
//        rangeCheckForAdd(index);
//
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
//        System.arraycopy(elementData, index, elementData, index + 1,
//                size - index);
//        elementData[index] = element;
//        size++;
//    }
//
//    /**
//     * 删除该列表中指定位置的元素。 将任何后续元素移动到左侧（从其索引中减去一个元素）。
//     */
//    public E remove(int index) {
//        rangeCheck(index);
//
//        modCount++;
//        E oldValue = elementData(index);
//
//        int numMoved = size - index - 1;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index+1, elementData, index,
//                    numMoved);
//        elementData[--size] = null; // clear to let GC do its work
//
//        //返回从列表中删除的元素
//        return oldValue;
//    }
//
//    /**
//     * 从列表中删除指定元素的第一个出现位置的元素（如果存在）。 如果列表不包含该元素，则它不会更改。
//     */
//    public boolean remove(Object o) {
//        if (o == null) {
//            for (int index = 0; index < size; index++)
//                if (elementData[index] == null) {
//                    fastRemove(index);
//                    return true;
//                }
//        } else {
//            for (int index = 0; index < size; index++)
//                if (o.equals(elementData[index])) {
//                    fastRemove(index);
//                    return true;
//                }
//        }
//        return false;
//    }
//
//    /*
//     * 快速删除，用的较少，用时再深究
//     */
//    private void fastRemove(int index) {
//        modCount++;
//        int numMoved = size - index - 1;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index+1, elementData, index,
//                    numMoved);
//        elementData[--size] = null; // clear to let GC do its work
//    }
//
//    /**
//     * 从列表中删除所有元素
//     */
//    public void clear() {
//        modCount++;
//
//        // 把数组中所有元素的值设为null（？不是释放 应该是后面用垃圾回收机制回收内存）
//        for (int i = 0; i < size; i++)
//            elementData[i] = null;
//
//        size = 0;
//    }
//
//    /**
//     * 按指定集合的Iterator返回的顺序将指定集合中的所有元素追加到此列表的末尾。
//     */
//    public boolean addAll(Collection<? extends E> c) {
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        ensureCapacityInternal(size + numNew);  // Increments modCount
//        System.arraycopy(a, 0, elementData, size, numNew);
//        size += numNew;
//        return numNew != 0;
//    }
//
//    /**
//     * 将指定集合中的所有元素插入到此列表中，从指定的位置开始。
//     */
//    public boolean addAll(int index, Collection<? extends E> c) {
//        rangeCheckForAdd(index);
//
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        ensureCapacityInternal(size + numNew);  // Increments modCount
//
//        int numMoved = size - index;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index, elementData, index + numNew,
//                    numMoved);
//
//        System.arraycopy(a, 0, elementData, index, numNew);
//        size += numNew;
//        return numNew != 0;
//    }
//
//    /**
//     * 从此列表中删除所有索引为fromIndex （含）和toIndex之间的元素。
//     * 将任何后续元素移动到左侧（减少其索引）。
//     */
//    protected void removeRange(int fromIndex, int toIndex) {
//        modCount++;
//        int numMoved = size - toIndex;
//        System.arraycopy(elementData, toIndex, elementData, fromIndex,
//                numMoved);
//
//        // clear to let GC do its work
//        int newSize = size - (toIndex-fromIndex);
//        for (int i = newSize; i < size; i++) {
//            elementData[i] = null;
//        }
//        size = newSize;
//    }
//
//    /**
//     * 检查给定的索引是否在范围内。
//     */
//    private void rangeCheck(int index) {
//        if (index >= size)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    /**
//     * A version of rangeCheck used by add and addAll.
//     * add和addAll使用的rangeCheck的一个版本
//     */
//    private void rangeCheckForAdd(int index) {
//        if (index > size || index < 0)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    /**
//     * 返回IndexOutOfBoundsException细节信息
//     */
//    private String outOfBoundsMsg(int index) {
//        return "Index: "+index+", Size: "+size;
//    }
//
//    /**
//     * 从此列表中删除指定集合中包含的所有元素。
//     */
//    public boolean removeAll(Collection<?> c) {
//        Objects.requireNonNull(c);
//        return batchRemove(c, false);
//    }
//
//    /**
//     * 仅保留此列表中包含在指定集合中的元素。 （取交集）
//     * 即 从此列表中删除其中不包含在指定集合中的所有元素。
//     * @see Collection#contains(Object)
//     */
//    public boolean retainAll(Collection<?> c) {
//        Objects.requireNonNull(c);
//        return batchRemove(c, true);
//    }
//
//    private boolean batchRemove(Collection<?> c, boolean complement) {
//        final Object[] elementData = this.elementData;
//        int r = 0, w = 0;
//        boolean modified = false;
//        try {
//            for (; r < size; r++)
//                if (c.contains(elementData[r]) == complement)
//                    elementData[w++] = elementData[r];
//        } finally {
//            // Preserve behavioral compatibility with AbstractCollection,
//            // even if c.contains() throws.
//            if (r != size) {
//                System.arraycopy(elementData, r,
//                        elementData, w,
//                        size - r);
//                w += size - r;
//            }
//            if (w != size) {
//                // clear to let GC do its work
//                for (int i = w; i < size; i++)
//                    elementData[i] = null;
//                modCount += size - w;
//                size = w;
//                modified = true;
//            }
//        }
//        return modified;
//    }
//
//    /**
//     * Save the state of the <tt>ArrayList</tt> instance to a stream (that
//     * is, serialize it).
//     *
//     * @serialData The length of the array backing the <tt>ArrayList</tt>
//     *             instance is emitted (int), followed by all of its elements
//     *             (each an <tt>Object</tt>) in the proper order.
//     */
//    private void writeObject(java.io.ObjectOutputStream s)
//            throws java.io.IOException{
//        // Write out element count, and any hidden stuff
//        int expectedModCount = modCount;
//        s.defaultWriteObject();
//
//        // Write out size as capacity for behavioural compatibility with clone()
//        s.writeInt(size);
//
//        // Write out all elements in the proper order.
//        for (int i=0; i<size; i++) {
//            s.writeObject(elementData[i]);
//        }
//
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//    }
//
//    /**
//     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
//     * deserialize it).
//     */
//    private void readObject(java.io.ObjectInputStream s)
//            throws java.io.IOException, ClassNotFoundException {
//        elementData = EMPTY_ELEMENTDATA;
//
//        // Read in size, and any hidden stuff
//        s.defaultReadObject();
//
//        // Read in capacity
//        s.readInt(); // ignored
//
//        if (size > 0) {
//            // be like clone(), allocate array based upon size not capacity
//            ensureCapacityInternal(size);
//
//            Object[] a = elementData;
//            // Read in all elements in the proper order.
//            for (int i=0; i<size; i++) {
//                a[i] = s.readObject();
//            }
//        }
//    }
//
//    /**
//     * 从列表中的指定位置开始，返回列表中的元素（按正确顺序）的列表迭代器。
//     */
//    public ListIterator<E> listIterator(int index) {
//        if (index < 0 || index > size)
//            throw new IndexOutOfBoundsException("Index: "+index);
//        return new ListItr(index);
//    }
//
//    /**
//     * 返回列表中的列表迭代器（按适当的顺序）。
//     *
//     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
//     *
//     * @see #listIterator(int)
//     */
//    public ListIterator<E> listIterator() {
//        return new ListItr(0);
//    }
//
//    /**
//     * 以正确的顺序返回该列表中的元素的迭代器。
//     *
//     */
//    public Iterator<E> iterator() {
//        return new Itr();
//    }
//
//    /**
//     * An optimized version of AbstractList.Itr
//     */
//    private class Itr implements Iterator<E> {
//        int cursor;       // index of next element to return
//        int lastRet = -1; // index of last element returned; -1 if no such
//        int expectedModCount = modCount;
//
//        public boolean hasNext() {
//            return cursor != size;
//        }
//
//        @SuppressWarnings("unchecked")
//        public E next() {
//            checkForComodification();
//            int i = cursor;
//            if (i >= size)
//                throw new NoSuchElementException();
//            Object[] elementData = ArrayList.this.elementData;
//            if (i >= elementData.length)
//                throw new ConcurrentModificationException();
//            cursor = i + 1;
//            return (E) elementData[lastRet = i];
//        }
//
//        public void remove() {
//            if (lastRet < 0)
//                throw new IllegalStateException();
//            checkForComodification();
//
//            try {
//                ArrayList.this.remove(lastRet);
//                cursor = lastRet;
//                lastRet = -1;
//                expectedModCount = modCount;
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//
//        @Override
//        @SuppressWarnings("unchecked")
//        public void forEachRemaining(Consumer<? super E> consumer) {
//            Objects.requireNonNull(consumer);
//            final int size = ArrayList.this.size;
//            int i = cursor;
//            if (i >= size) {
//                return;
//            }
//            final Object[] elementData = ArrayList.this.elementData;
//            if (i >= elementData.length) {
//                throw new ConcurrentModificationException();
//            }
//            while (i != size && modCount == expectedModCount) {
//                consumer.accept((E) elementData[i++]);
//            }
//            // update once at end of iteration to reduce heap write traffic
//            cursor = i;
//            lastRet = i - 1;
//            checkForComodification();
//        }
//
//        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
//    }
//
//    /**
//     * An optimized version of AbstractList.ListItr
//     */
//    private class ListItr extends Itr implements ListIterator<E> {
//        ListItr(int index) {
//            super();
//            cursor = index;
//        }
//
//        public boolean hasPrevious() {
//            return cursor != 0;
//        }
//
//        public int nextIndex() {
//            return cursor;
//        }
//
//        public int previousIndex() {
//            return cursor - 1;
//        }
//
//        @SuppressWarnings("unchecked")
//        public E previous() {
//            checkForComodification();
//            int i = cursor - 1;
//            if (i < 0)
//                throw new NoSuchElementException();
//            Object[] elementData = ArrayList.this.elementData;
//            if (i >= elementData.length)
//                throw new ConcurrentModificationException();
//            cursor = i;
//            return (E) elementData[lastRet = i];
//        }
//
//        public void set(E e) {
//            if (lastRet < 0)
//                throw new IllegalStateException();
//            checkForComodification();
//
//            try {
//                ArrayList.this.set(lastRet, e);
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//
//        public void add(E e) {
//            checkForComodification();
//
//            try {
//                int i = cursor;
//                ArrayList.this.add(i, e);
//                cursor = i + 1;
//                lastRet = -1;
//                expectedModCount = modCount;
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//    }
//
//    /**
//     * Returns a view of the portion of this list between the specified
//     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
//     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
//     * empty.)  The returned list is backed by this list, so non-structural
//     * changes in the returned list are reflected in this list, and vice-versa.
//     * The returned list supports all of the optional list operations.
//     *
//     * <p>This method eliminates the need for explicit range operations (of
//     * the sort that commonly exist for arrays).  Any operation that expects
//     * a list can be used as a range operation by passing a subList view
//     * instead of a whole list.  For example, the following idiom
//     * removes a range of elements from a list:
//     * <pre>
//     *      list.subList(from, to).clear();
//     * </pre>
//     * Similar idioms may be constructed for {@link #indexOf(Object)} and
//     * {@link #lastIndexOf(Object)}, and all of the algorithms in the
//     * {@link Collections} class can be applied to a subList.
//     *
//     * <p>The semantics of the list returned by this method become undefined if
//     * the backing list (i.e., this list) is <i>structurally modified</i> in
//     * any way other than via the returned list.  (Structural modifications are
//     * those that change the size of this list, or otherwise perturb it in such
//     * a fashion that iterations in progress may yield incorrect results.)
//     *
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     * @throws IllegalArgumentException {@inheritDoc}
//     */
//    public List<E> subList(int fromIndex, int toIndex) {
//        subListRangeCheck(fromIndex, toIndex, size);
//        return new SubList(this, 0, fromIndex, toIndex);
//    }
//
//    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
//        if (fromIndex < 0)
//            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
//        if (toIndex > size)
//            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
//        if (fromIndex > toIndex)
//            throw new IllegalArgumentException("fromIndex(" + fromIndex +
//                    ") > toIndex(" + toIndex + ")");
//    }
//
//    private class SubList extends AbstractList<E> implements RandomAccess {
//        private final AbstractList<E> parent;
//        private final int parentOffset;
//        private final int offset;
//        int size;
//
//        SubList(AbstractList<E> parent,
//                int offset, int fromIndex, int toIndex) {
//            this.parent = parent;
//            this.parentOffset = fromIndex;
//            this.offset = offset + fromIndex;
//            this.size = toIndex - fromIndex;
//            this.modCount = ArrayList.this.modCount;
//        }
//
//        public E set(int index, E e) {
//            rangeCheck(index);
//            checkForComodification();
//            E oldValue = ArrayList.this.elementData(offset + index);
//            ArrayList.this.elementData[offset + index] = e;
//            return oldValue;
//        }
//
//        public E get(int index) {
//            rangeCheck(index);
//            checkForComodification();
//            return ArrayList.this.elementData(offset + index);
//        }
//
//        public int size() {
//            checkForComodification();
//            return this.size;
//        }
//
//        public void add(int index, E e) {
//            rangeCheckForAdd(index);
//            checkForComodification();
//            parent.add(parentOffset + index, e);
//            this.modCount = parent.modCount;
//            this.size++;
//        }
//
//        public E remove(int index) {
//            rangeCheck(index);
//            checkForComodification();
//            E result = parent.remove(parentOffset + index);
//            this.modCount = parent.modCount;
//            this.size--;
//            return result;
//        }
//
//        protected void removeRange(int fromIndex, int toIndex) {
//            checkForComodification();
//            parent.removeRange(parentOffset + fromIndex,
//                    parentOffset + toIndex);
//            this.modCount = parent.modCount;
//            this.size -= toIndex - fromIndex;
//        }
//
//        public boolean addAll(Collection<? extends E> c) {
//            return addAll(this.size, c);
//        }
//
//        public boolean addAll(int index, Collection<? extends E> c) {
//            rangeCheckForAdd(index);
//            int cSize = c.size();
//            if (cSize==0)
//                return false;
//
//            checkForComodification();
//            parent.addAll(parentOffset + index, c);
//            this.modCount = parent.modCount;
//            this.size += cSize;
//            return true;
//        }
//
//        public Iterator<E> iterator() {
//            return listIterator();
//        }
//
//        public ListIterator<E> listIterator(final int index) {
//            checkForComodification();
//            rangeCheckForAdd(index);
//            final int offset = this.offset;
//
//            return new ListIterator<E>() {
//                int cursor = index;
//                int lastRet = -1;
//                int expectedModCount = ArrayList.this.modCount;
//
//                public boolean hasNext() {
//                    return cursor != SubList.this.size;
//                }
//
//                @SuppressWarnings("unchecked")
//                public E next() {
//                    checkForComodification();
//                    int i = cursor;
//                    if (i >= SubList.this.size)
//                        throw new NoSuchElementException();
//                    Object[] elementData = ArrayList.this.elementData;
//                    if (offset + i >= elementData.length)
//                        throw new ConcurrentModificationException();
//                    cursor = i + 1;
//                    return (E) elementData[offset + (lastRet = i)];
//                }
//
//                public boolean hasPrevious() {
//                    return cursor != 0;
//                }
//
//                @SuppressWarnings("unchecked")
//                public E previous() {
//                    checkForComodification();
//                    int i = cursor - 1;
//                    if (i < 0)
//                        throw new NoSuchElementException();
//                    Object[] elementData = ArrayList.this.elementData;
//                    if (offset + i >= elementData.length)
//                        throw new ConcurrentModificationException();
//                    cursor = i;
//                    return (E) elementData[offset + (lastRet = i)];
//                }
//
//                @SuppressWarnings("unchecked")
//                public void forEachRemaining(Consumer<? super E> consumer) {
//                    Objects.requireNonNull(consumer);
//                    final int size = SubList.this.size;
//                    int i = cursor;
//                    if (i >= size) {
//                        return;
//                    }
//                    final Object[] elementData = ArrayList.this.elementData;
//                    if (offset + i >= elementData.length) {
//                        throw new ConcurrentModificationException();
//                    }
//                    while (i != size && modCount == expectedModCount) {
//                        consumer.accept((E) elementData[offset + (i++)]);
//                    }
//                    // update once at end of iteration to reduce heap write traffic
//                    lastRet = cursor = i;
//                    checkForComodification();
//                }
//
//                public int nextIndex() {
//                    return cursor;
//                }
//
//                public int previousIndex() {
//                    return cursor - 1;
//                }
//
//                public void remove() {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        SubList.this.remove(lastRet);
//                        cursor = lastRet;
//                        lastRet = -1;
//                        expectedModCount = ArrayList.this.modCount;
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                public void set(E e) {
//                    if (lastRet < 0)
//                        throw new IllegalStateException();
//                    checkForComodification();
//
//                    try {
//                        ArrayList.this.set(offset + lastRet, e);
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                public void add(E e) {
//                    checkForComodification();
//
//                    try {
//                        int i = cursor;
//                        SubList.this.add(i, e);
//                        cursor = i + 1;
//                        lastRet = -1;
//                        expectedModCount = ArrayList.this.modCount;
//                    } catch (IndexOutOfBoundsException ex) {
//                        throw new ConcurrentModificationException();
//                    }
//                }
//
//                final void checkForComodification() {
//                    if (expectedModCount != ArrayList.this.modCount)
//                        throw new ConcurrentModificationException();
//                }
//            };
//        }
//
//        public List<E> subList(int fromIndex, int toIndex) {
//            subListRangeCheck(fromIndex, toIndex, size);
//            return new SubList(this, offset, fromIndex, toIndex);
//        }
//
//        private void rangeCheck(int index) {
//            if (index < 0 || index >= this.size)
//                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//        }
//
//        private void rangeCheckForAdd(int index) {
//            if (index < 0 || index > this.size)
//                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//        }
//
//        private String outOfBoundsMsg(int index) {
//            return "Index: "+index+", Size: "+this.size;
//        }
//
//        private void checkForComodification() {
//            if (ArrayList.this.modCount != this.modCount)
//                throw new ConcurrentModificationException();
//        }
//
//        public Spliterator<E> spliterator() {
//            checkForComodification();
//            return new ArrayListSpliterator<E>(ArrayList.this, offset,
//                    offset + this.size, this.modCount);
//        }
//    }
//
//    @Override
//    public void forEach(Consumer<? super E> action) {
//        Objects.requireNonNull(action);
//        final int expectedModCount = modCount;
//        @SuppressWarnings("unchecked")
//        final E[] elementData = (E[]) this.elementData;
//        final int size = this.size;
//        for (int i=0; modCount == expectedModCount && i < size; i++) {
//            action.accept(elementData[i]);
//        }
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//    }
//
//    /**
//     * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
//     * and <em>fail-fast</em> {@link Spliterator} over the elements in this
//     * list.
//     *
//     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
//     * {@link Spliterator#SUBSIZED}, and {@link Spliterator#ORDERED}.
//     * Overriding implementations should document the reporting of additional
//     * characteristic values.
//     *
//     * @return a {@code Spliterator} over the elements in this list
//     * @since 1.8
//     */
//    @Override
//    public Spliterator<E> spliterator() {
//        return new ArrayListSpliterator<>(this, 0, -1, 0);
//    }
//
//    /** Index-based split-by-two, lazily initialized Spliterator */
//    static final class ArrayListSpliterator<E> implements Spliterator<E> {
//
//        private final ArrayList<E> list;
//        private int index; // current index, modified on advance/split
//        private int fence; // -1 until used; then one past last index
//        private int expectedModCount; // initialized when fence set
//
//        /** Create new spliterator covering the given  range */
//        ArrayListSpliterator(ArrayList<E> list, int origin, int fence,
//                             int expectedModCount) {
//            this.list = list; // OK if null unless traversed
//            this.index = origin;
//            this.fence = fence;
//            this.expectedModCount = expectedModCount;
//        }
//
//        private int getFence() { // initialize fence to size on first use
//            int hi; // (a specialized variant appears in method forEach)
//            ArrayList<E> lst;
//            if ((hi = fence) < 0) {
//                if ((lst = list) == null)
//                    hi = fence = 0;
//                else {
//                    expectedModCount = lst.modCount;
//                    hi = fence = lst.size;
//                }
//            }
//            return hi;
//        }
//
//        public ArrayListSpliterator<E> trySplit() {
//            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//            return (lo >= mid) ? null : // divide range in half unless too small
//                    new ArrayListSpliterator<E>(list, lo, index = mid,
//                            expectedModCount);
//        }
//
//        public boolean tryAdvance(Consumer<? super E> action) {
//            if (action == null)
//                throw new NullPointerException();
//            int hi = getFence(), i = index;
//            if (i < hi) {
//                index = i + 1;
//                @SuppressWarnings("unchecked") E e = (E)list.elementData[i];
//                action.accept(e);
//                if (list.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                return true;
//            }
//            return false;
//        }
//
//        public void forEachRemaining(Consumer<? super E> action) {
//            int i, hi, mc; // hoist accesses and checks from loop
//            ArrayList<E> lst; Object[] a;
//            if (action == null)
//                throw new NullPointerException();
//            if ((lst = list) != null && (a = lst.elementData) != null) {
//                if ((hi = fence) < 0) {
//                    mc = lst.modCount;
//                    hi = lst.size;
//                }
//                else
//                    mc = expectedModCount;
//                if ((i = index) >= 0 && (index = hi) <= a.length) {
//                    for (; i < hi; ++i) {
//                        @SuppressWarnings("unchecked") E e = (E) a[i];
//                        action.accept(e);
//                    }
//                    if (lst.modCount == mc)
//                        return;
//                }
//            }
//            throw new ConcurrentModificationException();
//        }
//
//        public long estimateSize() {
//            return (long) (getFence() - index);
//        }
//
//        public int characteristics() {
//            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
//        }
//    }
//
//    @Override
//    public boolean removeIf(Predicate<? super E> filter) {
//        Objects.requireNonNull(filter);
//        // figure out which elements are to be removed
//        // any exception thrown from the filter predicate at this stage
//        // will leave the collection unmodified
//        int removeCount = 0;
//        final BitSet removeSet = new BitSet(size);
//        final int expectedModCount = modCount;
//        final int size = this.size;
//        for (int i=0; modCount == expectedModCount && i < size; i++) {
//            @SuppressWarnings("unchecked")
//            final E element = (E) elementData[i];
//            if (filter.test(element)) {
//                removeSet.set(i);
//                removeCount++;
//            }
//        }
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//
//        // shift surviving elements left over the spaces left by removed elements
//        final boolean anyToRemove = removeCount > 0;
//        if (anyToRemove) {
//            final int newSize = size - removeCount;
//            for (int i=0, j=0; (i < size) && (j < newSize); i++, j++) {
//                i = removeSet.nextClearBit(i);
//                elementData[j] = elementData[i];
//            }
//            for (int k=newSize; k < size; k++) {
//                elementData[k] = null;  // Let gc do its work
//            }
//            this.size = newSize;
//            if (modCount != expectedModCount) {
//                throw new ConcurrentModificationException();
//            }
//            modCount++;
//        }
//
//        return anyToRemove;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void replaceAll(UnaryOperator<E> operator) {
//        Objects.requireNonNull(operator);
//        final int expectedModCount = modCount;
//        final int size = this.size;
//        for (int i=0; modCount == expectedModCount && i < size; i++) {
//            elementData[i] = operator.apply((E) elementData[i]);
//        }
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//        modCount++;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void sort(Comparator<? super E> c) {
//        final int expectedModCount = modCount;
//        Arrays.sort((E[]) elementData, 0, size, c);
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//        modCount++;
//    }
//}
//
