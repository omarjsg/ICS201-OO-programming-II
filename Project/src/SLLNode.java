//************************  SLLNode.java  *******************************
//           node in a generic singly linked list class 

public class SLLNode<City> {
    public City info;
    public SLLNode<City> next;
    public SLLNode() {
        this(null,null);
    }
    public SLLNode(City el) {
        this(el,null);
    }
    public SLLNode(City el, SLLNode<City> ptr) {
        info = el; next = ptr;
    }
}

