import static org.junit.jupiter.api.Assertions.*;

class MinPriorityQueueTest {

    @org.junit.jupiter.api.Test
    void add() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(3);
        pq.add(3);
        pq.add(23);
        pq.add(9);

        //Order 3, 9, 23
        int first = pq.remove(); //3 As first
        assertEquals(first,3); //Test passed.
    }

    @org.junit.jupiter.api.Test
    void remove() {

        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(3);
        pq.add(4);
        pq.add(5);
        pq.add(1);

        //Order 1, 4, 5
        int first = pq.remove(); //1 As first
        int secondRemoved = pq.remove();
        assertEquals(secondRemoved,4); //Test passed.
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(3);

        //Nothing added, then empty
        boolean status = pq.isEmpty();
        assertTrue(status); //Test passed.
    }
}