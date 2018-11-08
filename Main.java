import dependencies.*;

class Main {
    public static void main(String[] args) {
        // HitungWaktu btPush = new HitungWaktu("BinaryTree push");
        // HitungWaktu btPop = new HitungWaktu("BinaryTree pop");
        // HitungWaktu btGet = new HitungWaktu("BinaryTree get");
        // HitungWaktu llPush = new HitungWaktu("Linked List push");
        // HitungWaktu llPop = new HitungWaktu("Linked List pop");
        // HitungWaktu llGet = new HitungWaktu("Linked List get");

        // int size = 100000;

        // // Binary Tree Push
        // btPush.startTimeM();
        // BinaryTree a = new BinaryTree();
        // for (int i = 1; i <= size; i++) {
        // a.push(i);
        // }
        // btPush.endTimeM();

        // // Binary Tree Get
        // btGet.startTimeM();
        // // System.out.println(a.get(a.size / 2));
        // for (int i2 = 0; i2 < a.size; i2++) {
        // a.get(i2);
        // }
        // btGet.endTimeM();

        // // Binary Tree Pop
        // btPop.startTimeM();
        // for (int i3 = 0; i3 < size; i3++) {
        // a.pop();
        // }
        // btPop.endTimeM();

        // // Linked List Push
        // llPush.startTimeM();
        // MyLinkedList b = new MyLinkedList();
        // for (int j = 1; j <= size; j++) {
        // b.add(j);
        // }
        // llPush.endTimeM();

        // // Linked List Get
        // llGet.startTimeM();
        // // System.out.println(b.get(b.size() / 2));
        // for (int j2 = 0; j2 < b.size(); j2++) {
        // b.get(j2);
        // }
        // llGet.endTimeM();

        // // Linked List Pop
        // llPop.startTimeM();
        // for (int j3 = 0; j3 < size; j3++) {
        // b.removeLast();
        // }
        // llPop.endTimeM();

        // btPush.runTimeM();
        // btGet.runTimeM();
        // btPop.runTimeM();

        // llPush.runTimeM();
        // llGet.runTimeM();
        // llPop.runTimeM();

        MyArray random = new MyArray();
        int[] arr = random.randomArray(10);
        int[] arr2 = random.randomArray(10);
        random.printArray(arr);
        random.printArray(arr2);

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(arr);
        bst.printInOrder();
        bst.insert(arr2);
        bst.printInOrder();
        System.out.println(bst.isBST());
    }
}