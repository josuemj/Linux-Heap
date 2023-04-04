import java.util.ArrayList;

public class MinPriorityQueue <T extends Comparable<T>> {
    private ArrayList<T> heap;
    private int size;

    public MinPriorityQueue(int capacity) {
        heap = new ArrayList<>(capacity);
        size = 0;
    }

    public void add(T item) {
        heap.add(item);
        size++;
        siftUp(size - 1);
    }

    public T remove() {
        if (size == 0) {
            throw new IllegalStateException("La cola de prioridad está vacía.");
        }
        T minItem = heap.get(0);
        heap.set(0, heap.get(size - 1));
        heap.remove(size - 1);
        size--;
        siftDown(0);
        return minItem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        int minIndex = index;

        if (leftChildIndex < size && heap.get(leftChildIndex).compareTo(heap.get(minIndex)) < 0) {
            minIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(minIndex)) < 0) {
            minIndex = rightChildIndex;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            siftDown(minIndex);
        }
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}

