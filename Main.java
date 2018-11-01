class Main {
    public static void main(String[] args) {
        // BinaryTree a = new BinaryTree();
        // a.plant(1);
        // a.root.setLeftChild(2);
        // a.root.setRightChild(3);
        // a.root.getLeftChild().setLeftChild(4);
        // a.root.getLeftChild().setRightChild(5);
        // a.root.getRightChild().setLeftChild(6);
        // a.root.getRightChild().setRightChild(7);
        // a.root.getLeftChild().getLeftChild().setLeftChild(8);
        // a.root.getLeftChild().getLeftChild().setRightChild(9);
        // a.printPreOrder();
        // a.printInOrder();
        // a.printPostOrder();
        // a.printLeaf();
        // a.jumlahDaun();
        // a.depth();

        // BinaryTree b = new BinaryTree();
        // // b.plant(1);
        // b.printPreOrder();
        // b.printInOrder();
        // b.printPostOrder();
        // b.printLeaf();
        // b.jumlahDaun();
        // b.depth();

        SkewedLeft a = new SkewedLeft();
        a.insertAsLeaf('A');
        a.insertAsLeaf('B');
        a.insertAsLeaf('C');
        a.insertAsLeaf('D');
        a.insertAsRoot('E');
        a.insertAsRoot('F');
        a.insertAsRoot('G');
        a.insertAsRoot('H');
        a.delLeaf();
        a.delRoot();
        System.out.println("depth : " + a.depth());
        a.printTree();
    }
}