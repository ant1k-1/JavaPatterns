package task3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SemList<E> implements List<E> {
    private final Semaphore semaphore;
    private final List<E> list;

    public SemList() {
        semaphore = new Semaphore(1);
        list = new ArrayList<>();
    }

    @Override
    public int size() {
        try {
            semaphore.acquire();
            return list.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            return list.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            return list.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        try {
            semaphore.acquire();
            return list.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            return list.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return new Object[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        try {
            semaphore.acquire();
            return (T[]) list.toArray((Object[])a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public boolean add(E e) {
        try {
            semaphore.acquire();
            return list.add(e);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            return list.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.containsAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire();
            return list.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            semaphore.acquire();
            return list.addAll(index, c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    @Override
    public E get(int index) {
        try {
            semaphore.acquire();
            return list.get(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        try {
            semaphore.acquire();
            return list.set(index, element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        try {
            semaphore.acquire();
            list.add(index, element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    @Override
    public E remove(int index) {
        try {
            semaphore.acquire();
            return list.remove(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        try {
            semaphore.acquire();
            return list.indexOf(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            semaphore.acquire();
            return list.lastIndexOf(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        try {
            semaphore.acquire();
            return list.listIterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        try {
            semaphore.acquire();
            return list.listIterator(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        try {
            semaphore.acquire();
            return list.subList(fromIndex, toIndex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return null;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
