package algorithms.reversedlinkedlistsolution;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (next != null) {
            return value + " → " + next.toString();
        } else {
            return value + " → null";
        }
    }

}
