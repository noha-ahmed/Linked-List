package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SLinkedListTest {
	SLinkedList list1= new SLinkedList();
	SLinkedList list2= new SLinkedList();
	SLinkedList list3 = new SLinkedList();
	SLinkedListTest(){
		list1.add(1);
		list1.add(4);
		list1.add('a');
		list1.add(5);
		list1.add(26);
	}
	
	@Test 
	void addTest() {
		//add to a specific index
		list1.add(1,'h');
		assertEquals( 'h' , list1.get(1));
		assertThrows(IndexOutOfBoundsException.class,()->{list1.add(8, 'g');});
	    //add to the end 
		list1.add('f');
		assertEquals( 'f' , list1.get(list1.size()-1));
	}
	@Test
	void containTest() {
	assertEquals(true,list1.contains(1));
	assertEquals(false,list1.contains(6));
   }
	@Test 
   void sublistTest() {
	   list2=(SLinkedList) list1.sublist(1, 4);
	   assertEquals(4,list2.size());
	   assertEquals(list1.get(1),list2.get(0));
	   assertEquals(list1.get(2),list2.get(1));
	   assertEquals(list1.get(3),list2.get(2));
	   assertEquals(list1.get(4),list2.get(3));
	   Exception thrown = assertThrows(IndexOutOfBoundsException.class,() ->list1.sublist(1,5));
	   assertEquals( "invalid index" , thrown.getMessage());
	   thrown = assertThrows(IndexOutOfBoundsException.class,() ->list1.sublist(5,3));
	   assertEquals( "invalid index" , thrown.getMessage());
	   thrown = assertThrows(NullPointerException.class,() ->list3.sublist(0,1));
	   assertEquals( "empty list" , thrown.getMessage());
	   
	   
   }
   @Test
   void sizeTest() {
       assertEquals(5,list1.size());
       assertEquals(0,list3.size());
       
   }
   @Test
   void removeTest() {
      list1.remove(2);
      assertEquals(4,list1.size());
      assertEquals(false,list1.contains('a'));
      assertEquals(5,list1.get(2));
      Exception thrown = assertThrows(IndexOutOfBoundsException.class,() ->list1.remove(7));
	   assertEquals( "invalid index" , thrown.getMessage());
	   thrown = assertThrows(NullPointerException.class,() ->list3.remove(1));
	   assertEquals( "empty list" , thrown.getMessage());
      
   }
   @Test
   void emptyTest() {
	  assertEquals(false,list1.isEmpty());
	  assertEquals( true,list3.isEmpty());

   }
  @Test
   void clearTest() {
	  assertFalse(list1.isEmpty());
	  list1.clear();
	  assertEquals(0,list1.size());
	  assertTrue(list1.isEmpty());
  }
  @Test
  void seTest() {
	list1.set(2, 13);
	assertEquals(false,list1.contains('a'));
	assertEquals(true,list1.contains(13));
     assertEquals(13,list1.get(2));
     Exception thrown = assertThrows(IndexOutOfBoundsException.class,() ->list1.set(7,9));
     assertEquals( "invalid index" , thrown.getMessage());

  }
@Test
void getTest() {
	assertEquals(1,list1.get(0));
	assertEquals(4,list1.get(1));
	assertEquals('a',list1.get(2));
	assertEquals(5,list1.get(3));
	list1.add(2, 88);
	assertEquals(88,list1.get(2));
	assertEquals('a',list1.get(3));
	Exception thrown = assertThrows(IndexOutOfBoundsException.class,() ->list1.get(9));
    assertEquals( "invalid index" , thrown.getMessage());
    thrown = assertThrows(NullPointerException.class,() ->list3.get(1));
    assertEquals( "empty list" , thrown.getMessage());
}
}
