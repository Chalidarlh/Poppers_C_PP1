package KlinikPasien.src.Util;

import KlinikPasien.src.Entity.Pasien;

public class Node {
    private Pasien data;
	private Node next;

	public Node(Pasien data) {
		this.data = data;
	}

	public void setData(Pasien data) {
		this.data = data;
	}

	public Pasien getData() {
		return data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}

}