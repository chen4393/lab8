import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chen4393 on 3/21/17.
 */
public class MergesortTest {
    @org.junit.Test
    public void merge1() throws Exception {
        /* Test case 1: Integer array with different length */
        Integer[] L = {1, 3};
        Integer[] R = {2, 4, 5};
        Object[] actual = Mergesort.merge(L, R);
        Integer[] expected = {1, 2, 3, 4, 5};
        boolean result = true;
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    public void merge2() throws Exception {
        /* Test case 2: String array with different length */
        String[] L = {"a", "c"};
        String[] R = {"b", "d", "e"};
        Object[] actual = Mergesort.merge(L, R);
        String[] expected = {"a", "b", "c", "d", "e"};
        boolean result = true;
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    public void merge3() throws Exception {
        /* Test case 3: String array with same length and duplicated element */
        String[] L = {"a", "c", "d"};
        String[] R = {"b", "d", "e"};
        Object[] actual = Mergesort.merge(L, R);
        String[] expected = {"a", "b", "c", "d", "d", "e"};
        boolean result = true;
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    public void mergesort1() throws Exception {
        /* Test case 1: Integer array with odd length */
        Integer[] a = {2, 1, 4, 3, 5};
        Object[] actual = Mergesort.mergesort(a);
        Integer[] expected = {1, 2, 3, 4, 5};
        boolean result = true;
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    public void mergesort2() throws Exception {
        /* Test case 2: Integer array with even length */
        Integer[] a = {2, 1, 4, 3, 5, 0};
        Object[] actual = Mergesort.mergesort(a);
        Integer[] expected = {0, 1, 2, 3, 4, 5};
        boolean result = true;
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    public void mergesort3() throws Exception {
        /* Test case 3: String array with odd length and duplicated element*/
        String[] a = {"b", "a", "f", "e", "c", "d", "b"};
        Object[] actual = Mergesort.mergesort(a);
        String[] expected = {"a", "b", "b", "c", "d", "e", "f"};
        boolean result = true;
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }
}