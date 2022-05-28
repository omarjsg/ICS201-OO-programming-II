//************************  SLLNode.java  *******************************
//           node in a generic singly linked list class 

public class MSLLNode<T> {
    public T info;
    public MSLLNode<T> next;
    public SLL<T> list;

    public MSLLNode() {
        this(null, null, null);
    }

    public MSLLNode(T el) {
        this(el, null, null);
    }

    public MSLLNode(T el, MSLLNode<T> ptr) {
        this(el, ptr, null);
    }

    public MSLLNode(T el, MSLLNode<T> ptr, SLL<T> lst) {
        info = el;
        next = ptr;
        list = lst;
    }
}
