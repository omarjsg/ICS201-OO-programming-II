import java.util.NoSuchElementException;

//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
    protected SLLNode<T> head, tail;

    public SLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T el) {
        head = new SLLNode<T>(el, head);
        if (tail == null)
            tail = head;
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        } else
            head = tail = new SLLNode<T>(el);
    }

    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)
            head = tail = null;
        else
            head = head.next;
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)
            head = tail = null;
        else {
            SLLNode<T> tmp;
            for (tmp = head; tmp.next != tail; tmp = tmp.next)
                ;
            tail = tmp;
            tail.next = null;
        }
        return el;
    }

    public void delete(T el) {
        if (!isEmpty())
            if (head == tail && el.equals(head.info))
                head = tail = null;
            else if (el.equals(head.info))
                head = head.next;
            else {
                SLLNode<T> pred, tmp;
                for (pred = head, tmp = head.next; tmp != null
                        && !tmp.info.equals(el); pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == tail)
                        tail = pred;
                }
            }
    }

    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            if(tmp.info instanceof City) {
            System.out.println("|___________________________|___________________________|___________________________|");
                System.out.printf("|%-27s|%-27.4f|%-27.4f|%n", ((City) tmp.info).getName(),
                        ((City) tmp.info).getLatitude(), ((City) tmp.info).getLongitude());
            }
        }
    }

    public boolean isInList(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && tmp.info != null; tmp = tmp.next){
            if(tmp.info instanceof City){
                if(((City) tmp.info).getName().equals(((City) el).getName())) {
                    return true;
                }
            }
        }
        return tmp != null;
    }

    public SLLNode<T> findCity(City city) {
        SLLNode<T> finder = head;
        while (finder != null) {
            if(finder.info instanceof City) {
                if (((City) finder.info).compareTo(city) == 0) {
                    return finder;
                }
            }
            finder = finder.next;
        }
        throw new NoSuchElementException(city.getName() + " city does not exist in the list.");
    }

    public void insertNth(T el, int position) {
        if (length() < position) {
            throw new IllegalArgumentException("Invalid position entry, position entered \"" + position
                    + "\" is greater than the length of the list");
        } else {
            SLLNode<T> temp = new SLLNode<T>(el);
            if (isEmpty()) {
                if (position != 0) {
                    throw new IllegalArgumentException("Invalid position entry, position entered \"" + position
                            + "\" is greater than the length of the list");
                } else {
                    head = temp;
                }
            } else if (!isEmpty() && position == 0) {
                temp.next = head;
                head = temp;
                return;
            } else {
                SLLNode<T> pointer = head, prev = null;
                for (int i = 0; i < position; i++, prev = pointer, pointer = pointer.next) {
                    if (pointer == null) {
                        break;
                    }
                }
                temp.next = pointer;
                prev.next = temp;
            }
        }
    }

    public int length() {
        return isEmpty() ? 0 : length(0, head);
    }

    private int length(int n, SLLNode<T> counter) {
        return counter == tail && counter != null ? 1 : 1 + length(n, counter.next);
    }

}
