package eg.edu.alexu.csd.datastructure.linkedList.cs;

public class SLinkedList implements ILinkedList {
	private class SLNode {
		private Object data;
	    private SLNode next;
	    
	    public Object getData() {
	    	return this.data;
	    }
	    
	    public void setData(Object data) {
	    	this.data = data ;
	    }
	    
	    public SLNode getNext() {
	    	return this.next;
	    }
	    
	    public void setNext(SLNode next) {
	    	this.next = next;
	    }    
	}	
	private SLNode head;
	private SLNode tail;
	private int size=0;

	
	
	@Override
	public void add(int index, Object element) {
		SLNode node = new SLNode();
		node.data = element ;
		if( index == 0) {
			node.next = head;
			head = node ;
			size++ ;
		}
		else if ( index <= size) {
			SLNode pNode = new SLNode ();
			pNode = head;
			for( int i=0 ; i<index-1 ; i++) {
				pNode= pNode.next;
			}
			node.next = pNode.next;
			pNode.next = node;
			size++;
		}
		else {
			throw new IndexOutOfBoundsException("invalid index");
		}
	}

	@Override
	public void add(Object element) {
		SLNode node = new SLNode();
		node.data = element;	
		node.next = null;
		if( head == null ) {
			head = node;
		}
		else {
			if( tail == null ) {
				tail = node;
				head.next = tail ;
			}
			else {
				tail.next = node;
				tail = node;
			}
		}
		size++;
	}

	@Override
	public Object get(int index) {
		if(isEmpty()) {
			throw new NullPointerException ("empty list");
		}
		if( index >= 0 && index < size) {
			SLNode node = new SLNode();
			node = head;
			for( int i=0 ; i < index ; i++) {
				node = node.next;
			}
			return node.data;
		}
		else {
			throw new IndexOutOfBoundsException("invalid index");
		}
	
		
	}

	@Override
	public void set(int index, Object element) {
		if ( index < 0 || index >= size) {
			throw new IndexOutOfBoundsException ("invalid index");
		}
		
	    if( index >= 0 && index < size ) {
			SLNode currentNode = new SLNode();
			currentNode = head;
			for( int i=0 ; i<index ; i++ ) {
				currentNode = currentNode.next;
			}
			currentNode.data = element;
		}
		else {
			throw new IndexOutOfBoundsException("invalid index");
		}
		
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void remove(int index) {
		if(isEmpty()) {
			throw new NullPointerException ("empty list");
		}
		if( index >= size || index < 0) {
			throw new IndexOutOfBoundsException ("invalid index");
		}
		if( index == 0 ) {
			head = head.next;
		}
		else if( index > 0 && index < size ) {
		    SLNode n = new SLNode();
		    SLNode nTemp = new SLNode();
		    n=head;
		    for( int i=0 ; i < index-1 ; i++) {
		    	n = n.next;
		    }
		    nTemp = n.next;
		    n.next = nTemp.next;
		    nTemp = null;
		}
		size--;
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		if (this.isEmpty()) {
			throw new NullPointerException ("empty list");
		}
		
		if( fromIndex < 0 || fromIndex > this.size || toIndex <0 || toIndex >= this.size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException ("invalid index"); 
		}
		
		SLinkedList SubList = new SLinkedList();
		SLNode currentNode = head;
		for( int i=0 ; i < fromIndex ; i++) {
			currentNode = currentNode.next;
		}
		for( int i = fromIndex ; i <= toIndex ; i++) {
			SubList.add(currentNode.data);
			currentNode = currentNode.next;
		}
		
		return SubList;
	}

	@Override
	public boolean contains(Object o) {
		SLNode node = new SLNode();
		node = head;
		for( int i=0 ; i<size-1 ; i++) {
			if( node.data.equals(o)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	public void show () {
		SLNode node = head;
		while( node != null ) {
			System.out.print( node.data.toString() + "   "   );
			node = node.next;		   
		}
		System.out.println();
	}
	
	public void addAtHead (Object element) {
		SLNode newHead = new SLNode();
		newHead.setData(element);
		newHead.setNext(head);
		head =  newHead;
		size++ ;	
	}

}
