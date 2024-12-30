package ListDataStructure;

import ListDataStructure.ListException.ListErrorCode;

public class SinglyLinkedList<T> {
	private ListElement<T> head = null;

	public boolean isEmpty() {
		return (head == null);
	}

	public void add(int position, T o) throws ListException {
		ListElement<T> e = new ListElement<T>(o);
		if (position == 0) {
			e.next = head;
			head = e;
		} else {
			ListElement<T> cursor = head;
			for (int pos = 1; pos < position; pos++) {
				if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
				cursor = cursor.next;
			} 
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			e.next = cursor.next;
			cursor.next = e;
		}
	}

	public T get(int position) throws ListException {
		if (position < 0) throw new ListException(ListErrorCode.PositionTooSmall);
		ListElement<T> cursor = head;
		for (int pos = 0; pos < position; pos++) {
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			cursor = cursor.next;
		}
		if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
		return cursor.getData();
	}

	public T remove(int position) throws ListException {
		// Validieren der Position
		if (position < 0){
			throw new ListException(ListErrorCode.PositionTooSmall);
		}
		if(head == null) {
			throw new ListException(ListErrorCode.PositionTooLarge);
		}
		//Spezialfall entfernt Kopf, head-Zeiger wird einfach auf das nächste Element gesetzt
		if (position == 0) {
			T data = head.getData();
			head = head.next;
			return data;
		}
		//Allgemeiner Fall
		ListElement<T> cursor = head;
		for (int i = 0; i < position - 1; i++) {
			if (cursor.next == null) {
				throw new ListException(ListErrorCode.PositionTooLarge);
			}
			cursor = cursor.next;
		}
		//Prüfen ob das Element existiert
		if (cursor.next == null) {
			throw new ListException(ListErrorCode.PositionTooLarge);
		}
		//Element entfernen
		T data = cursor.next.getData();
		cursor.next = cursor.next.next;
		return data;
	}
	
	public int size() {
		int count = 0; // Zähler initialisieren
	    ListElement<T> current = head; // Start beim Kopf der Liste
	    
		while (current != null) { // Solange ein Element vorhanden ist
			count++; // Zähler erhöhen
			current = current.next; // Nächstes Element betrachten
		}
        return count; // Zähler zurückgeben
	}
	
	public boolean contains(T elt) {
		ListElement<T> current = head; // Start beim Kopf der Liste
		
		while (current != null) { // Solange Elemente in der Liste vorhanden sind
	        if (current.getData() == null && elt == null) {
	            return true; // Null-Element gefunden
	        }
	        if (current.getData() != null && current.getData().equals(elt)) {
	            return true; // Übereinstimmendes Element gefunden
	        }
	        current = current.next; // Zum nächsten Knoten wechseln
		}
	    return false; // Element nicht gefunden
	}
}
