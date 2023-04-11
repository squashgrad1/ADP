import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class DoublyLinkedList extends AbstractList {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(0,"a");
        System.out.println("done");
        list.add(0,"b");
        System.out.println("done");
        list.add(0,"c");
        System.out.println("done");
        System.out.println(list.get(0).getValue());
        System.out.println(list.get(1).getValue());
        System.out.println(list.get(2).getValue());
        list.set(1,"d");
        System.out.println("done");
        System.out.println(list.get(0).getValue());
        System.out.println(list.get(1).getValue());
        System.out.println(list.get(2).getValue());
        list.remove(1);
        System.out.println("done");
        System.out.println(list.get(0).getValue());
        System.out.println(list.get(1).getValue());
        list.add(1,"c");
        list.remove(0);
        System.out.println("done");
        System.out.println(list.get(0).getValue());
        System.out.println(list.get(1).getValue());
        list.add(0,"b");
        list.remove(2);
        System.out.println("done");
        System.out.println(list.get(0).getValue());
        System.out.println(list.get(1).getValue());
        list.clear();
        System.out.println("done");
        System.out.println(list.size());

        list.add(0,"c");
        System.out.println("done");
        list.add(0,"b");
        System.out.println("done");
        list.add(0,"a");
        Iterator itr = list.iterator();
        System.out.println("Iterator test");
        int i = 0;
        while (itr.hasNext()){
            System.out.println(list.get(i).getValue());
            i++;
            itr.next();
        }
        System.out.println("Iterator test done");
        System.out.println("Stream test");
        Stream.of(list).forEach(n -> System.out.println(n) );
        System.out.println("Stream test done");
        System.out.println("list to array");
        Object[] arrayList = list.toArray();
        for (int j = 0; j < arrayList.length; j++) {
            System.out.println(arrayList[j]);
        }
        System.out.println("list to array done");
    }



    private Node firstNode;
    private Node lastNode;

    DoublyLinkedList(){
        firstNode = new Node(null,null,"first Node");
        lastNode = new Node(firstNode, null,"last Node");
        firstNode.changeNextNode(lastNode);
    }
    //TODO test this
    DoublyLinkedList(List listToCopy){
        Object[] a = listToCopy.toArray();
        for (int i = 0; i < a.length; i++) {
            add(i,a[i]);
        }
    }

    private class Node{

        private Node prevNode;
        private Node nextNode;
        private Object value;

        Node(Node prevNode, Node nextNode, Object value){
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public Object changeValue(Object newValue) {
            Object oldValue = value;
            value = newValue;
            return oldValue;
        }

        public Node changePrevNode(Node newPrevNode) {
            Node oldPrevNode = prevNode;
            prevNode = newPrevNode;
            return oldPrevNode;
        }

        public Node changeNextNode(Node newNextNode) {
            Node oldPrevNode = prevNode;
            nextNode = newNextNode;
            return oldPrevNode;
        }
    }
    /**
     * {@inheritDoc}
     *
     * @param index
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     * @implSpec This implementation always throws an
     * {@code UnsupportedOperationException}.
     */
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException{

        Node nodeToRemove = get(index);
        Node prevNode = nodeToRemove.getPrevNode();
        Node nextNode = nodeToRemove.getNextNode();

        prevNode.changeNextNode(nextNode);
        nextNode.changePrevNode(prevNode);

        return nodeToRemove.getValue();
    }

    /**
     * {@inheritDoc}
     *
     * @param index
     * @param element
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     * @implSpec This implementation always throws an
     * {@code UnsupportedOperationException}.
     */
    @Override
    public Object set(int index, Object element) {
        Node nodeToReplace = get(index);
        Object oldValue = nodeToReplace.getValue();
        nodeToReplace.changeValue(element);
        return oldValue;
    }
    /**
     * {@inheritDoc}
     *
     * @param index
     * @param value
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     * @implSpec This implementation always throws an
     * {@code UnsupportedOperationException}.
     */
    @Override
    public void add(int index, Object value) {
        Node nextNode;
        Node prevNode;
        if(size() == index){
            nextNode = lastNode;
            prevNode = lastNode.getPrevNode();
        }
        else{
            nextNode = get(index);
            prevNode = nextNode.getPrevNode();
        }
        Node newNode = new Node(prevNode, nextNode, value);
        nextNode.changePrevNode(newNode);
        prevNode.changeNextNode(newNode);
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this list
     * @implSpec This implementation calls {@code removeRange(0, size())}.
     *
     * <p>Note that this implementation throws an
     * {@code UnsupportedOperationException} unless {@code remove(int
     * index)} or {@code removeRange(int fromIndex, int toIndex)} is
     * overridden.
     */
    @Override
    public void clear() {
        firstNode.changeNextNode(lastNode);
        lastNode.changePrevNode(firstNode);
    }
    /**
     * {@inheritDoc}
     *
     * @param index
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public Node get(int index) throws IndexOutOfBoundsException{
        if(size() <= index) throw new IndexOutOfBoundsException("Index ist größer gleich der Liste");

        Node indexNode = firstNode.nextNode;
        for(int i = 0; i < index;indexNode = indexNode.nextNode){i++;}

        return indexNode;
    }
    @Override
    /**
     * Gibt die Anzahl an Elementen in der Liste zurück
     * @return ein int-Wert
     */
    public int size() {
        int i = 0;
        Node indexNode = firstNode;
        while(indexNode.getNextNode() != null){
            indexNode = indexNode.getNextNode();
            i++;
        }
        return i - 1;
    }
}
