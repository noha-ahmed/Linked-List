package eg.edu.alexu.csd.datastructure.linkedList.cs;


public class DLinkedList implements ILinkedList{
int i=0;

	private class DNode{
		private Object data;
		private DNode next;
		private DNode prev;
		
		public Object getData() {
	    	return this.data;
	    }
	    
	    public void setData(Object data) {
	    	this.data = data ;
	    }
	    
	    public DNode getNext() {
	    	return this.next;
	    }
	    
	    public void setNext(DNode next) {
	    	this.next = next;
	    }   
	    public DNode getprev() {
	    	return this.prev;
	    }
	    
	    public void setPrev(DNode prev) {
	    	this.prev = prev;
	    }  
	}
	
	private DNode header;
	private DNode trailer;
	private int size;
	
	public DLinkedList () {
		size = 0;
		header = new DNode();
		trailer = new DNode();
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	@Override
	public void add(int index, Object element) {
		if( index < 0 || index > size ) {
			throw new IndexOutOfBoundsException("invalid index");
		}
		else {
			DNode node = new DNode();
			node.setData( element );
			DNode prevNode = new DNode();
			prevNode = header;
			for( int i=0 ; i< index ; i++) {
				prevNode = prevNode.getNext();
			}
			DNode nextNode = prevNode.getNext();
			node.setNext(nextNode);
			node.setPrev(prevNode);
		    prevNode.setNext(node);
		    nextNode.setPrev(node);
		}
		size++;		
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		DNode node = new DNode();
		node.setData(element);
		DNode prevNode = trailer.getprev();
		node.setNext( trailer );
		node.setPrev( prevNode );
		trailer.setPrev(node);
		prevNode.setNext(node);
		size++;
	}

	@Override
	public Object get(int index) {
		if(isEmpty()) {
			throw new NullPointerException ("empty list");
		}
		if ( index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("invalid index"); 
		}
		else {
			DNode currentNode = header;
			for(int i=0 ; i <= index ; i++ ) {
				currentNode = currentNode.next;
			}
			return currentNode.getData();
		}
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if ( index < 0 || index >= size) {
			throw new IndexOutOfBoundsException ("invalid index");
		}
		DNode node = header;
		for (int i=0 ; i <= index ; i++) {
			node = node.getNext();
		}
		node.setData( element );
	}

	@Override
	public void clear() {
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;		
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void remove(int index) {
		if(isEmpty()) {
			throw new NullPointerException ("empty list");
		}	
		if( index >= size || index < 0) {
			throw new IndexOutOfBoundsException ("invalid index");
		}
		
		else if( index >= 0 && index < size ) {
			DNode node = new DNode();
			DNode prevNode = new DNode();
			prevNode = header;
            for(int i=0 ; i<index ; i++ ) {
	            prevNode = prevNode.getNext();
            }
            node = prevNode.getNext();
            DNode nextNode = node.getNext();
            nextNode.setPrev(prevNode);
            prevNode.setNext(nextNode);
            size--;	
       }	
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		DLinkedList sublist= new DLinkedList();
		DNode prevNode = header;
		if (this.isEmpty()) {
			throw new NullPointerException ("empty list");
		}
		
		if( fromIndex < 0 || fromIndex > this.size || toIndex <0 || toIndex >= this.size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException ("invalid index"); 
		}
		else {
			 for ( i=0;i<fromIndex;i++) {
				prevNode = prevNode.getNext();
			 }
			 prevNode = prevNode.getNext();

	         for(int j=i-1;j<toIndex;j++) {
	        	 sublist.add(prevNode.getData());
			     prevNode = prevNode.getNext();
		     }
		}
		
		return sublist;
	}

	@Override
	public boolean contains(Object o) {
		DNode currentNode = header;
	    currentNode=currentNode.getNext();
		for (int k=0;k<size;k++) {
           if(currentNode.getData()==o) {
		   return true; 
	   	  }
	  	currentNode = currentNode.getNext();
	    }
			return false;	
		}
	
	public void show() {
		DNode currentNode = header;
		if( isEmpty()) {
			throw new NullPointerException (" empty list");
		}
		for(int i=0 ; i < size ; i++) {
			currentNode = currentNode.getNext();
			System.out.print(currentNode.getData().toString() +"  ");
		}
		System.out.println();
	}
	

}
