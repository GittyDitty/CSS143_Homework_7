import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        ArrayDictionary empty = new ArrayDictionary(0);
        empty.remove(1);
        assertFalse(empty.remove(200));

        ArrayDictionary test1 = new ArrayDictionary(2);
        test1.add(0, 100);
        test1.add(1, 200);
        assertTrue(test1.remove(1));

        ArrayDictionary test2 = new ArrayDictionary(2);
        test2.add(0, 100);
        test2.add(1, 200);
        assertFalse(test2.remove(2));

        ArrayDictionary test3 = new ArrayDictionary(2);
        test3.add(0, 100);
        test3.add(0, 200);
        test3.add(1, 100);
        assertTrue(test3.remove(0));
        assertTrue(test3.remove(1));
        assertFalse(test3.remove(2));
    }

    @Test
    public void get() {
        assertTrue(true);  // place holder
    }

    @Test
    public void contains() {
        ArrayDictionary set1 = new ArrayDictionary(1);
        //these should all return false
        assertFalse(set1.contains(-1));
        assertFalse(set1.contains(0));
        assertFalse(set1.contains(1));

        ArrayDictionary set2 = new ArrayDictionary(1);
        set2.add(0, 103);
        assertFalse(set2.contains(2));
        assertTrue(set2.contains(0));

        ArrayDictionary set3 = new ArrayDictionary(2);
        set3.add(0, 103);
        set3.add(1, 105);
        assertTrue(set3.contains(0));
        assertTrue(set3.contains(1));
        assertFalse(set3.contains(2));
        assertFalse(set3.contains(3));

        ArrayDictionary set4 = new ArrayDictionary(3);
        set4.add(0, 105);
        set4.add(1, 105);
        assertFalse(set4.contains(3));
        set4.add(2, 206);
        assertTrue(set4.contains(1));

        ArrayDictionary set5 = new ArrayDictionary(3);
        set5.add(0, 103);
        set5.add(1, 105);
        set5.add(2, 206);
        set5.add(4, 407);

        assertTrue(set5.contains(1));
        assertTrue(set5.contains(4));  //this is added onto another key causing collision for some reason
        assertFalse(set5.contains(7)); //this isn't added
        assertFalse(set5.contains(8)); //this isn't added
    }
}