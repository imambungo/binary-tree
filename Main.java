import dependencies.MyLinkedList;
import dependencies.HitungWaktu;

class Main {
    public static void main(String[] args) {
        HitungWaktu btPush = new HitungWaktu("BinaryTree push");
        HitungWaktu btPop = new HitungWaktu("BinaryTree pop");
        HitungWaktu btGet = new HitungWaktu("BinaryTree get");
        HitungWaktu llPush = new HitungWaktu("Linked List push");
        HitungWaktu llPop = new HitungWaktu("Linked List pop");
        HitungWaktu llGet = new HitungWaktu("Linked List get");

        int size = 10000000;

        // Binary Tree Push
        btPush.startTimeM();
        BinaryTree a = new BinaryTree();
        for (int i = 1; i <= size; i++) {
            a.push(i);
        }
        btPush.endTimeM();

        // Binary Tree Pop
        btPop.startTimeM();
        for (int i2 = 1; i2 < size / 2; i2++) {
            a.pop();
        }
        btPop.endTimeM();

        // Binary Tree Get
        btGet.startTimeM();
        a.get(a.size / 2);
        btGet.endTimeM();

        // Linked List Push
        llPush.startTimeM();
        MyLinkedList b = new MyLinkedList();
        for (int j = 1; j <= size; j++) {
            b.add(j);
        }
        llPush.endTimeM();

        // Linked List Pop
        llPop.startTimeM();
        for (int j2 = 1; j2 < size / 2; j2++) {
            b.removeLast();
        }
        llPop.endTimeM();

        // Linked List Get
        llGet.startTimeM();
        b.get(b.size() / 2);
        llGet.endTimeM();

        btPush.runTimeM();
        btPop.runTimeM();
        btGet.runTimeM();
        llPush.runTimeM();
        llPop.runTimeM();
        llGet.runTimeM();
    }
}