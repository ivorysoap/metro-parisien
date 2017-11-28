public abstract class Node {

    private Object element;

    private Node next;

    private Node previous;

    public Node(){
        this.element=null;
        this.next =null;
        this.previous = null;
    }

    public Node(Object element){
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public Node(Object element, Node next, Node previous){
        this.element =element;
        this.next =next;
        this.previous = previous;
    }


    public Node getNext(){
        return next;
    }

    public Node getPrevious(){
        return previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}
