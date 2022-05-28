import java.util.NoSuchElementException;

public class MSLL<T> extends SLL<T> {
    protected MSLLNode<T> head, tail;

    public MSLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToMSLLHead(T el) {
        head = new MSLLNode<T>(el, head, new SLL<>());
        head.list.addToTail(el);
        if (tail == null)
            tail = head;
    }

    public void addToMSLLTail(T el) {
        if (!isEmpty()) {
            tail.next = new MSLLNode<T>(el, null, new SLL<>());
            tail = tail.next;
        } else {
            head = tail = new MSLLNode<T>(el, null, new SLL<>());
        }
    }

    public void deleteFromMSLL(T el) {
        if (!isEmpty())
            if (head == tail && el.equals(head.info))
                head = tail = null;
            else if (el.equals(head.info))
                head = head.next;
            else {
                MSLLNode<T> pred, tmp;
                for (pred = head, tmp = head.next; tmp != null && !tmp.info.equals(el); pred = pred.next){
                    tmp = tmp.next;
                }
                if (tmp != null) {
                    pred.next = tmp.next;
                    if (tmp == tail)
                        tail = pred;
                }
            }
    }

    public boolean isInMSLList(T el) {
        MSLLNode<T> tmp;
        for (tmp = head; tmp != null && tmp.info != el; tmp = tmp.next){
        }
        return tmp != null;
    }

    public SLLNode<T> findCity(String city) {
        Character fl = city.toUpperCase().charAt(0);
        City temp = new City(city);
        MSLLNode<T> finder = findMSLLNodeWithCity(temp);
        if (finder.info == fl) {
            return finder.list.findCity(temp);
        }
        throw new NoSuchElementException(city + " city does not exist in the list.");
    }

    public void addCityToSublistAtRear(T e1) {
        if (cityIsInSubList(e1)) {
            throw new IllegalArgumentException(
                    "Error: cannot add " + ((City) e1).getName() + " because it is already in the list.");
        }
        Character fl = ((City) e1).getName().toUpperCase().charAt(0);
        if (!isInMSLList((T) fl)) {
            addToMSLLTail((T) fl);
            tail.list.addToHead(e1);
            return;
        }
        for (MSLLNode<T> pointer = head; pointer != null; pointer = pointer.next) {
            if (pointer.info.equals(fl)) {
                if (pointer.list != null) {
                    pointer.list.addToTail(e1);
                } else {
                    pointer.list = new SLL<>();
                    pointer.list.addToTail(e1);
                }

            }
        }
    }

    public void addToCitySublistList(T e1, int position) {
        if (cityIsInSubList(e1)) {
            throw new IllegalArgumentException(
                    "Error: cannot add " + ((City) e1).getName() + " because it is already in the list.");
        }
        Character fl = ((City) e1).getName().toUpperCase().charAt(0);
        if (!isInMSLList((T) fl) && position != 0) {
            throw new NoSuchElementException("Error: main list " + fl + " does not exist");
        } else if (!isInMSLList((T) fl) && position == 0) {
            addToMSLLTail((T) fl);
            tail.list.addToHead(e1);
            return;
        }
        MSLLNode<T> finder = head;
        while (finder != null) {
            if (finder.info == fl) {
                if (finder.list != null) {
                    finder.list.insertNth(e1, position);
                } else {
                    finder.list = new SLL<>();
                    finder.list.insertNth(e1, position);
                }
            }
            finder = finder.next;
        }
    }

    public void deleteCityFromSublist(T e1) {
        MSLLNode<T> finder = findMSLLNodeWithCity((City) e1);
        finder.list.delete(e1);
    }

    public void deleteCitySublist(String str) {
        str = str.toUpperCase();
        MSLLNode<T> finder = findMSLLNodeWithCity(new City(str));
        deleteFromMSLL(finder.info);
    }

    public boolean cityIsInSubList(T e1) {
        MSLLNode<T> finder = head;
        Character fl = ((City) e1).getName().toUpperCase().charAt(0);
        boolean found = false;
        while (finder != null) {
            if (finder.info == fl) {
                    found = finder.list.isInList(e1);
            }
            finder = finder.next;
        }
        return found;
    }

    public void makeCitySublistEmpty(String str) {
        MSLLNode<T> finder = findMSLLNodeWithCity(new City(str));
        finder.list = null;
    }

    public void displayCitySublist(T e1) {
        if(isEmpty()){
            throw new NoSuchElementException("Error: The sublist of " + e1+ " has been emptied or does not exist.");
        }
        for (MSLLNode<T> pointer = head; pointer != null; pointer = pointer.next) {
            if (pointer.info.equals(e1)) {
                System.out.println("_____________________________________________________________________________________");
                System.out.printf("|%-27s|%-27s|%-27s|%n", "City", "Latitude", "Longitude");
                pointer.list.printAll();
                System.out.println("|___________________________|___________________________|___________________________|");
                return;
            }
        }
        throw new NoSuchElementException("Element entered does not exist in the list.");
    }

    public double getDistance(String city1, String city2) {
        City city1N = (City) findCity(city1).info;
        City city2N = (City) findCity(city2).info;
        double radLat1 = Math.toRadians(city1N.getLatitude());
        double radLat2 = Math.toRadians(city2N.getLatitude());
        double radLong1 = Math.toRadians(city1N.getLongitude());
        double radLong2 = Math.toRadians(city2N.getLongitude());
        return 2 * 6372.8 * Math.asin(Math.sqrt(Math.pow(Math.sin((radLat2 - radLat1) / 2.0), 2) + Math.cos(radLat1) *  Math.cos(radLat2) * Math.pow(Math.sin((radLong2 - radLong1) / 2.0), 2)));
    }

    private MSLLNode<T> findMSLLNodeWithCity(City city) {
        Character fl = city.getName().toUpperCase().charAt(0);
        for (MSLLNode<T> finder = head; finder != null; finder = finder.next) {
            if (finder.info == fl) {
                return finder;
            }
        }
        throw new NoSuchElementException(city.getName() + " city does not exist in the list.");

    }

    public void printAll() {

        System.out.print("MSLLNodes available: ");
        for (MSLLNode<T> tmp = head; tmp != tail; tmp = tmp.next) {
            System.out.print(tmp.info + ", ");
        }
        System.out.print(tail.info + ".\n");
    }
    public void displayAll(){
        System.out.println("_____________________________________________________________________________________");
        System.out.printf("|%-27s|%-27s|%-27s|%n", "City", "Latitude", "Longitude");
        for (MSLLNode<T> pointer = head; pointer != null; pointer = pointer.next) {
            if (!pointer.list.isEmpty()) {
                pointer.list.printAll();
            }
        }
        System.out.println("|___________________________|___________________________|___________________________|");
    }
}
