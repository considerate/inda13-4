import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Before;
import org.junit.After;

import org.junit.rules.ExpectedException;

@RunWith(JUnit4.class)
public class TestHashSet {
	private HashSet hashSet;

	@Before
	public void setUp() {
		hashSet = new HashSet(10);
	}

	@After
	public void tearDown() {
		hashSet = null;
	}

	@Test
	public void testAdd() {
		boolean added;
		added = hashSet.add("Test");
		assertEquals(true, added);
		added = hashSet.add("Test");
		assertEquals(false, added);
		added = hashSet.add("Some data here");
		assertEquals(true, added);
		added = hashSet.add(null);
		assertEquals(false, added);
	}

	@Test
	public void testRemove() {
		boolean added;
		boolean removed;
		removed = hashSet.remove("Test");
		assertEquals(false, removed);
		added = hashSet.add("Test");
		assertEquals(true, added);
		removed = hashSet.remove("Test");
		assertEquals(true, removed);
		removed = hashSet.remove(null);
		assertEquals(false, removed);
	}

	@Test
	public void testContains() {
		boolean contains;
		contains = hashSet.contains("Hello");
		assertEquals(false, contains);
		hashSet.add(null);
		contains = hashSet.contains(null);
		assertEquals(false, contains);
		hashSet.add("Hello");
		contains = hashSet.contains("Hello");
		assertEquals(true, contains);
	}
}