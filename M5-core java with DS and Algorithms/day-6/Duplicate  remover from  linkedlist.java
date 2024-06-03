Day-6;

import Day_6.linkedlist_middleElement.Node;

public class Duplicate_remover_from_linkedlist {
	public static void removeDuplicates(linkedlist_middleElement ll) {
        if (ll.getHead() == null) return;

        Node current = ll.getHead();
        int length=ll.getLength();
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
               length--;
               
            } else {
                current = current.next;
            }
        }
        ll.setLength(length);
    }
	
public static void main(String[] args) {
	linkedlist_middleElement ll=new linkedlist_middleElement(10);
	ll.append(20);
	ll.append(20);
	ll.append(30);
	ll.append(40);
	ll.append(40);
	ll.append(50);
	ll.append(60);
	ll.append(60);
	System.out.println("list with duplicates");
	ll.printList();
	removeDuplicates(ll);
	System.out.println("list without duplicates");
	ll.printList();
}

}

