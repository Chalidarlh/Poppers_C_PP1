package KlinikPasien;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ListPasien {
    Node HEAD;

    public boolean isEmpty() {
        if (HEAD != null) {
            return false;
        } else {
            return true;
        }
    }

    public void simpanKeFile(Pasien p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pasien.txt", true))) {
            // format penulisan data pasien: dipisah koma
            String data = p.getId() + "," +
                    p.getNama() + "," +
                    p.getJenisKelamin() + "," +
                    p.getUsia() + "," +
                    p.getAlamat() + "," +
                    p.getKeluhan() + "," +
                    p.getStatusPasien();

            bw.write(data);
            bw.newLine(); // tambahkan baris baru
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke file: " + e.getMessage());
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
        simpanKeFile(data);
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
        simpanKeFile(data);
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
        simpanKeFile(data);
    }

    private void dispose(Node node) {
        node.setNext(null);
        node = null;
    }

}
