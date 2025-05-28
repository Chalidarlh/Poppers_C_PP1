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

    public void removeHead() {
        if(isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node temp = HEAD;
            HEAD = HEAD.getNext();
            dispose(temp);
        }
    }

    public void removeMid(String nama, int usia, String alamat) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
    
        Node tempNode = HEAD;
        Node preNode = null;
    
        while (tempNode != null) {
            if (tempNode.getData().getNama().equals(nama) && tempNode.getData().getUsia()== usia && tempNode.getData().getAlamat().equals(alamat)) {
                if (preNode == null) {
                    // Data berada di head
                    HEAD = tempNode.getNext();
                } else {
                    // Data berada di tengah/akhir
                    preNode.setNext(tempNode.getNext());
                }
                dispose(tempNode);
                System.out.println("Pasien dengan nama: " + nama + " berhasil dihapus.");
                return;
            }
            preNode = tempNode;
            tempNode = tempNode.getNext();
        }
    
        System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
    }

    public void removeTail() {
        if(isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node lastNode = HEAD;
            Node preNode = null;

            while (lastNode.getNext() != null) {
                preNode = lastNode;
                lastNode = lastNode.getNext();
            }

            preNode.setNext(null);
            dispose(lastNode);
        }
    }

    public int count() {
        Node curNode = HEAD;
        int jumlah = 0;

        while (curNode != null) {
            jumlah = jumlah + 1;
            curNode = curNode.getNext();
        }
        return jumlah;
    }

    public boolean find(String nama) {
        Node curNode = HEAD;
        while (curNode != null) {
            if (curNode.getData().getNama().equals(nama)) {
                return true;
            }
            curNode = curNode.getNext();
        }
        return false;
    }

    public void displayElement() {
        if (isEmpty()) {
            System.out.println("List Kosong");
        } else {
            Node curNode = HEAD;
            while (curNode != null) {
                System.out.println(curNode.getData().getId()+
                 " " +curNode.getData().getNama()+ 
                 " " +curNode.getData().getJenisKelamin()+ 
                 " " +curNode.getData().getUsia()+ 
                 " " +curNode.getData().getAlamat()+ 
                 " " +curNode.getData().getKeluhan()+ 
                 " " +curNode.getData().getStatusPasien());
                curNode = curNode.getNext();
            }
        }
        System.out.println();
    }
}
