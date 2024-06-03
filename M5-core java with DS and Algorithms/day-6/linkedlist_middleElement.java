Day-6;

public class linkedlist_middleElement {
	private Node head;
	private Node tail;
	private int length;
	
	static class Node{
		int value;
		Node next;
		
		public Node(int value) {
			super();
			this.value=value;
		}
	}
	public linkedlist_middleElement(int value) {
		super();
		Node newNode=new Node(value);
		//System.out.println("Node:" + newNode);
		head=newNode;
		tail=newNode;
		length=1;
	}
	public Node getHead() {
	  //System.out.println("Head:"+head.value);
	  return head;
	}
	public void setHead(Node n) {
		this.head=n;
	}
	public Node getTail() {
		  //System.out.println("Tail:"+tail.value);
		return tail;
		}
	public void setTail(Node n) {
		this.tail=n;
	}
	public int getLength() {
		//  System.out.println("Length:"+length);
		  return length;
		}
	public void setLength(int length) {
		this.length=length;
	}
	public void printList() {
		Node temp=head;
		if(length>0) {
		//getHead();
			 System.out.println("Head:"+head.value);
		//getTail();
			 System.out.println("Tail:"+tail.value);
		//getLength();
			 System.out.println("Length:"+length);
		}
		System.out.print("HEAD");
		while(temp!=null) {
			System.out.print("--->"+temp.value);
			temp=temp.next;
		}
		System.out.println("--->NULL");
	}
	public  void append(int value) {
		Node newNode=new Node(value);
		if(length==0) {
			head=newNode;
			tail=newNode;
		}
		else {
			tail.next=newNode;
			tail=newNode;
		}
		length++;
	}
	public Node removeLast() {
		if(length==0) {
			return null;
		}
		Node temp=head;
		Node pre=head;
		while(temp.next!=null) {
			pre=temp;
			temp=temp.next;
		}
		tail=pre;
		tail.next=null;
		length--;
		if(length==0) {
			head=null;
			tail=null;
		}
		return temp;
		
	}
	public void prepend(int value) {
		Node newNode=new Node(value);
		if(length==0) {
			head=newNode;
			tail=newNode;
		}
		else {
			newNode.next=head;
			head=newNode;
		}
		length++;
	}
	public Node removeFirst() {
		if(head==null) {
			return null;
		}
		
		else {
			Node temp=head;
			head=head.next;
			temp.next=null;
			length--;
			return temp;
		}
	}
	public Node get(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node temp=head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp;
	}
	public boolean set(int index,int value) {
		Node temp=get(index);
		if(temp!=null) {
			temp.value=value;
			return true;
		}
		return false;
	}
	public void addAtIndex(int index,int value) {
		Node newNode=new Node(value);
		if(index>length || head==null) {
			this.append(value);
		}
		else {
			Node temp=head;
			
			int count=0;
			while(count!=index-2) {
				temp=temp.next;	
				count++;
			}
			Node next=temp.next;
			temp.next=newNode;
			newNode.next=next;
			
		}
		length++;
		
	}
	public Node deleteAtIndex(int index) {
		if(index>length ||head==null) {
			return null;
		}
		else if(index==length) {
			this.removeLast();
		}
		else if(index==1) {
			this.removeFirst();
		}
		else {
			Node temp=head;
			Node node=this.get(index-1);
			Node prev=this.get(index-2);
			prev.next=node.next;
			node.next=null;
			length--;
			return temp;
			
		}
		return null;
	}
	public Node middleElement() {
		if(head==null) {
			return null;
		}
		int index=(int)(length/2);
		Node node=this.get(index);
		if(length%2==0) {
			node=this.get(index-1);
		}
		return node;
	}
	 public static void main(String[] args) {
		linkedlist_middleElement ll=new linkedlist_middleElement(33);
		ll.append(44);
		ll.append(55);
		ll.append(66);
		ll.prepend(22);
		ll.prepend(11);
		ll.prepend(0);
		ll.printList();
		//System.out.println(ll.removeLast().value);
		//System.out.println(ll.removeLast().value);
		//ll.printList();
		System.out.println(ll.removeFirst().value);
		ll.printList();
		ll.addAtIndex(3, 43);
		ll.printList();
		System.out.println(ll.deleteAtIndex(3).value);
		ll.printList();
		System.out.println(ll.middleElement().value);
	}

}

