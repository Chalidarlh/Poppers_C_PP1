package KlinikPasien;

public class Node {
    private String nama;
    private String alamat;
    private String noTelp;
    private String keluhan;
    private Node next;
    private Node prev;
    private Node head;
    private Node tail;
    private int noAntrian;
    private int noAntrianAwal;
    private int noAntrianAkhir;
    private int noAntrianSementara;

    public Node(String nama, String alamat, String noTelp, String keluhan) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.keluhan = keluhan;
        this.next = null;
        this.prev = null;
    }
}