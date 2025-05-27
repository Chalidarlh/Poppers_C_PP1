package KlinikPasien;

public class ListPasien {
    Node HEAD;

    public boolean isEmpty() {
        if (HEAD != null) {
            return false;
        } else {
            return true;
        }
    }

    public void addHead(Pasien data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            HEAD = newNode;
        } else {
            newNode.setNext(HEAD);
            HEAD = newNode;
        }
    }

    public void addMid(Pasien data, int position) {
        Node posNode = null, curNode = null;
        int i;

        Node newNode = new Node(data);
        if (isEmpty()) {
            HEAD = newNode;
        } else {
            curNode = HEAD;
            if (position == 1) {
                newNode.setNext(curNode);
                HEAD = newNode;
            } else {
                i = 1;
                while (curNode != null && i < position) {
                    posNode = curNode;
                    curNode = curNode.getNext();
                    i++;
                }
                posNode.setNext(newNode);
                newNode.setNext(curNode);
            }
        }
    }

    public void addTail(Pasien data) {
        Node posNode = null, curNode = null;

        Node newNode = new Node(data);
        if (isEmpty()) {
            HEAD = newNode;
        } else {
            curNode = HEAD;
            while (curNode != null) {
                posNode = curNode;
                curNode = curNode.getNext();

            }
            posNode.setNext(newNode);
        }
    }

    private void dispose(Node node) {
        node.setNext(null);
        node = null;
    }
}
