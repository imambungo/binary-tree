public class MyLinkedList {// Berperan sebagai Head
    private Node next;
    private Node tail;
    private int size;
    private int sum = 0;

    public void clear() {
        this.next = null;
        this.size = 0;
    }

    public int sum() {
        return this.sum;
    }

    public int getFirst() {
        return this.next.getIsiInt();
    }

    public int getLast() {
        return this.tail.getIsiInt();
    }

    public boolean contains(int nilai) {
        Node pointer = this.next;
        while (pointer != null) {
            if (pointer.getIsiInt() == nilai) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public boolean add(int ygDitambah) {
        if (this.next == null) {
            this.next = new Node(ygDitambah, null);
            tail = this.next;
        } else {
            tail.next = new Node(ygDitambah, tail);
            tail = tail.next;
        }
        this.size++;
        this.sum += ygDitambah;
        return true;
    }

    public void addFirst(int ygDitambah) {
        if (this.next == null) {
            next = new Node(ygDitambah, null);
            tail = next;
        } else {
            Node sisip = new Node(ygDitambah, null);
            sisip.next = this.next;
            this.next = sisip;
        }
        this.size++;
        this.sum += ygDitambah;
    }

    public Node removeFirst() {
        Node temp = next;
        if (this.next != null) {
            next = next.next;
            this.sum -= temp.getIsiInt();
            temp.next = null;// apakah harus pakai ini?
            this.size--;
        }
        return temp;
    }

    public void add(int index, int nilai) {
        if (index < 0 || index > size()) {
            System.out.println("Error: Index out of bound gan :v");
            if (index > size())
                System.out.println("\tvoid add(" + index + "," + nilai + ") -> Max index allowed: " + (size() - 1));
            if (index < 0)
                System.out.println("\tvoid add(" + index + "," + nilai + ") -> Minimum index is 0");
            System.exit(0);
        } else if (index == 0) {
            addFirst(nilai);
        } else if (index == size()) {
            add(nilai);
        } else {
            Node nodeBaru;
            Node pointer = next;
            while (index > 0) {
                pointer = pointer.next;
                index--;
            }
            nodeBaru = new Node(nilai, pointer.prev);
            pointer.prev.next = nodeBaru;
            pointer.prev = nodeBaru;
            nodeBaru.next = pointer;
            this.size++;
            this.sum += nilai;
        }
    }

    protected void tampilkan() {
        System.out.print("[");
        Node pointer = next;
        if (this.next != null) {
            System.out.print(next.getIsiInt());
            pointer = pointer.next;
        }
        while (pointer != null) {
            System.out.print("," + pointer.getIsiInt());
            pointer = pointer.next;
        }
        System.out.println("]");
    }

    public int get(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Error: Index out of bound gan :v");
            if (index >= size())
                System.out.println("\tint get(" + index + ") -> Maximum index is " + (size() - 1));
            if (index < 0)
                System.out.println("\tint get(" + index + ") -> Minimum index is 0");
            System.exit(0);
        } else {
            Node pointer = next;
            while (index > 0) {
                pointer = pointer.next;
                index--;
            }
            return pointer.getIsiInt();
        }
        return -1;
    }

    public int size() {
        return this.size;
    }

    public Node removeLast() {
        Node temp = null;
        if (next != null) {
            if (next.next == null) {
                temp = next;
                this.sum -= next.getIsiInt();
                next = null;
            } else {
                temp = tail;
                this.sum -= temp.getIsiInt();
                tail.prev.next = null;
                tail = tail.prev;
            }
            this.size--;
        }
        return temp;
    }

    public Node remove(int index) {
        Node temp = null;
        if (index < 0 || index >= size()) {
            System.out.println("Error: Index out of bound gan :v");
            if (index >= size())
                System.out.println("\tvoid remove(" + index + ") -> Maximum index is " + (size() - 1));
            if (index < 0)
                System.out.println("\tvoid remove(" + index + ") -> Minimum index is 0");
            System.exit(0);
        } else if (index == 0) {
            temp = removeFirst();
        } else if (index == size() - 1) {
            temp = removeLast();
        } else {
            Node pointer = next;
            while (index > 1) {
                pointer = pointer.next;
                index--;
            }
            temp = pointer.next;// !
            pointer.next.next.prev = pointer;
            pointer.next = pointer.next.next;
            this.sum -= temp.getIsiInt();
            this.size--;
        }
        return temp;
    }
}

class Node {
    private int isiInt;
    protected Node next;
    protected Node prev;

    public Node(int isiInt, Node prev) {
        this.isiInt = isiInt;
        this.prev = prev;
    }

    public int getIsiInt() {
        return this.isiInt;
    }
}