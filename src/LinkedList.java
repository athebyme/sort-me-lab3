import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>{

    private Node<E>  firstNode;
    private Node<E>  lastNode;
    private int size = 0;
    public LinkedList(){
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null,null, lastNode);
    }




    public void addLast(E e){
        Node<E> prev = lastNode;
        prev.setCurItem(e);
        lastNode = new Node<E>(null, prev, null);
        prev.setNextNode(lastNode);
        size++;
    }

    public void removeLast(){
        lastNode = lastNode.getPrevNode();
        if (lastNode != null){
            lastNode.setNextNode(null);
        }else{
            lastNode = null;
        }
        size--;
    }


    public void addFirst(E e){
        Node<E> next = firstNode;
        next.setCurItem(e);
        firstNode = new Node<E>(null, null, next);
        next.setPrevNode(firstNode);
        size++;
    }

    public void removeFirst(){
        Node<E> next = firstNode.getNextNode();
        firstNode.curItem = null;
        firstNode.setNextNode(null);
        firstNode = next;
        if (next == null)
            lastNode = null;
        else
            next.setPrevNode(null);
        size--;
    }


    public int size(){
        return size;
    }

    public E getItemByIndex(int counter){
        Node<E> target = firstNode.getNextNode();
        for (int i = 0; i < counter; i++){
            target = getNextItem(target);
        }
        return target.getCurItem();
    }

    private Node<E> getNextItem(Node<E> curItem){
        return curItem.getNextNode();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getItemByIndex(counter++);
            }
        };
    }

    public Iterator<E> descandingIterator(){
        return new Iterator<E>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getItemByIndex(counter--);
            }
        };
    }

    private static class Node<E>{
        private E curItem;
        private Node<E> nextNode;
        private Node<E> prevNode;

        private Node(E curItem, Node<E> prevItem, Node<E> nextItem){
            this.curItem = curItem;
            this.nextNode = nextItem;
            this.prevNode = prevItem;
        }

        public void setCurItem(E curItem){this.curItem = curItem;}
        public E getCurItem(){return curItem;}

        public void setNextNode(Node<E> nextNode){this.nextNode = nextNode;}
        public Node<E> getNextNode(){return nextNode;}

        public void setPrevNode(Node<E> prevNode){this.prevNode = prevNode;}
        public Node<E> getPrevNode(){return prevNode;}

    }
}
