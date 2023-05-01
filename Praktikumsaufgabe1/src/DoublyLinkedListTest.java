import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList list = new DoublyLinkedList();

    @org.junit.jupiter.api.Test
    void remove() {
        list.add(0,"1");
        list.remove(0);
        Assertions.assertEquals(0 , list.size());
    }
    @org.junit.jupiter.api.Test
    void removeFirst() {
        list.add(0,"1");
        list.add(1,"2");
        list.remove(0);
        Assertions.assertEquals("2" , list.get(0));
    }
    @org.junit.jupiter.api.Test
    void removeLast() {
        list.add(0,"1");
        list.add(1,"2");
        list.remove(1);
        Assertions.assertEquals("1" , list.get(0));
    }
    @org.junit.jupiter.api.Test
    void removeMiddle() {
        list.add(0,"1");
        list.add(1,"2");
        list.add(2,"3");
        list.remove(1);
        Assertions.assertEquals("1" , list.get(0));
        Assertions.assertEquals("3" , list.get(1));
    }

    @org.junit.jupiter.api.Test
    void set() {
        list.add(0,"1");
        list.add(1,"2");
        list.add(2,"3");
        list.set(1,"4");
        Assertions.assertEquals("4", list.get(1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        list.add(0,"1");
        Assertions.assertEquals("1",list.get(0));
    }
    @org.junit.jupiter.api.Test
    void addLast() {
        list.add(0,"1");
        list.add(1,"2");
        Assertions.assertEquals("2",list.get(1));
    }
    @org.junit.jupiter.api.Test
    void addFirst() {
        list.add(0,"1");
        list.add(1,"2");
        list.add(0,"3");
        Assertions.assertEquals("3",list.get(0));
    }
    @org.junit.jupiter.api.Test
    void addMiddle() {
        list.add(0,"1");
        list.add(1,"2");
        list.add(0,"3");
        list.add(1,"4");
        Assertions.assertEquals("4",list.get(1));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.clear();
        Assertions.assertEquals(0,list.size());
    }
}