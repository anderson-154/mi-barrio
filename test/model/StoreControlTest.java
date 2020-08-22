package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customException.CurrentDayException;
import customException.NotGiveAccessException;
import customException.RepeatPersonException;

class StoreControlTest {
	
private StoreControl store;

	public void stage1()  {
		store  = new StoreControl();
	}

	@Test
	public void addPerson()  {
		stage1();
		String id="123456789";
		String type="CC";
		
		try {
			store.addPerson(id, type);
			assertEquals(store.getPeople().size(),1);
			assertEquals(store.getPeople().get(0).getId(),id);
			assertEquals(store.getPeople().get(0).getType(),type);
		} catch (RepeatPersonException e) {
			fail("Error");
		}
		
		String id2="12343";
		String type2="CC";
		int day=3;
		
		try {
			store.joinToStore(id2, type2, day);
			store.addPerson(id2, type2);
		}catch(NotGiveAccessException n){
			assertEquals(store.getPeople().size(),1);
			assertEquals(store.getPeople().get(0).getId(),id);
			assertEquals(store.getPeople().get(0).getType(),type);
		}catch(CurrentDayException c) {
			assertEquals(store.getPeople().size(),1);
			assertEquals(store.getPeople().get(0).getId(),id);
			assertEquals(store.getPeople().get(0).getType(),type);
		}catch (RepeatPersonException e) {
			fail("Error");
		}
		
		String id3="1234";
		String type3="TI";
		int day2=3;
		
		try {
			store.joinToStore(id3, type3, day2);
			store.addPerson(id3, type3);
		}catch(NotGiveAccessException n){
			assertEquals(store.getPeople().size(),1);
			assertEquals(store.getPeople().get(0).getId(),id);
			assertEquals(store.getPeople().get(0).getType(),type);
		}catch(CurrentDayException c) {
			assertEquals(store.getPeople().size(),1);
			assertEquals(store.getPeople().get(0).getId(),id);
			assertEquals(store.getPeople().get(0).getType(),type);
		}catch (RepeatPersonException e) {
			fail("Error");
		}
	}

}
