import java.util.Arrays;

public class MinPriorityQueue <E extends Comparable<E>> {
    private E[] heap;
    private int size;

    public MinPriorityQueue(int capacity) {
        heap = (E[]) new Comparable[capacity + 1]; // Reservamos heap[0] como buffer
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        if (size >= heap.length - 1) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }

        heap[++size] = element;
        int currentIndex = size;
        while (heap[currentIndex].compareTo(heap[currentIndex/2]) < 0 && currentIndex != 1) {
            E tmp = heap[currentIndex];
            heap[currentIndex] = heap[currentIndex/2];
            heap[currentIndex/2] = tmp;
            currentIndex = currentIndex/2;
        }
    }

    public E remove() {
        E result = heap[1];
        heap[1] = heap[size];
        heap[size--] = null;

        int currentIndex = 1;
        while (2*currentIndex <= size) {
            int childIndex = 2*currentIndex;
            if (childIndex < size && heap[childIndex].compareTo(heap[childIndex+1]) > 0) {
                childIndex++;
            }
            if (heap[currentIndex].compareTo(heap[childIndex]) > 0) {
                E tmp = heap[currentIndex];
                heap[currentIndex] = heap[childIndex];
                heap[childIndex] = tmp;
                currentIndex = childIndex;
            } else {
                break;
            }
        }
        return result;
    }
}

