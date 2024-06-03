Day-6;

import Day-6.linkedlist_middleElement.Node;

public class MergeTwoSortedList {
	public static linkedlist_middleElement mergeLists(linkedlist_middleElement list1,linkedlist_middleElement list2) {
        if (list1.getHead() == null) return list2;
        if (list2.getHead() == null) return list1;

        Node dummy =new Node(0); 
        Node tail = dummy;

        Node l1 = list1.getHead();
        Node l2 = list2.getHead();

       
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

       
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        while(tail.next!=null) {
        	tail=tail.next;
        }
        list1.setTail(tail);

        
        list1.setHead(dummy.next);
        list1.setLength(list1.getLength()+list2.getLength());
        return list1;
    }
	public static void main(String[] args) {
		linkedlist_middleElement ll1=new linkedlist_middleElement(10);
		ll1.append(20);
		ll1.append(40);
		ll1.append(70);
		ll1.append(80);
		linkedlist_middleElement ll2=new linkedlist_middleElement(30);
		ll2.append(50);
		ll2.append(60);
		ll2.append(90);
		ll2.append(100);
		System.out.println("lists befor merging : ");
		ll1.printList();
		ll2.printList();
		linkedlist_middleElement ll=mergeLists(ll1, ll2);
		System.out.println("lists after getting merged : ");
		ll.printList();
	}


}

