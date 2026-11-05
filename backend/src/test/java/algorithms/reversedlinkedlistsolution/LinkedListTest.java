package algorithms.reversedlinkedlistsolution;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void reverseEmptyList() {
        Node result = Main.reverseList(null);

        assertNull(result);
    }

    @Test
    void reverseListWithOneElement() {
        Node head = ListFactory.buildList(42);

        Node result = Main.reverseList(head);

        assertEquals(42, result.value);
        assertNull(result.next);
    }

    @Test
    void reverseListWithSeveralElements() {
        Node head = ListFactory.buildList(1, 2, 3, 4, 5);

        Node result = Main.reverseList(head);

        int[] expected = {5, 4, 3, 2, 1};

        for (int value : expected) {
            assertNotNull(result);
            assertEquals(value, result.value);
            result = result.next;
        }

        assertNull(result);
    }
}
