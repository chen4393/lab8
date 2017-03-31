import java.util.Comparator;

/**
 * Created by chaoranchen on 3/21/17.
 */

public class Mergesort {
    public static <T extends Comparable<T>> T[] merge(T[] arr1, T[] arr2) {
        //T[] res = (T[])new Object[arr1.length + arr2.length]; // This does not work!
        T[] res = (T[]) new Comparable[arr1.length + arr2.length];

        int i = 0, j = 0;
        for (int k = 0; k < res.length; k++) {
            /* if arr2 is finished going through OR the element in arr1 is less than arr2,
             * use the element in arr1 */
            if (j >= arr2.length || (i < arr1.length && arr1[i].compareTo(arr2[j]) <= 0)) {
                res[k] = arr1[i];
                i++;
            }
            /* if arr1 is finished going through OR the element in arr1 is greater than arr2,
             * use the element in arr2 */
            else if (i >= arr1.length || (j < arr2.length && arr1[i].compareTo(arr2[j]) > 0)){
                res[k] = arr2[j];
                j++;
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> T[] mergesort(T[] arr) {
        /* Base case: single element array */
        if (arr.length <= 1)
            return arr;
        /* Split the original array into two sub-arrays
        * and copy the contents into them*/
        T[] L = (T[]) new Comparable[ arr.length / 2];
        T[] R = (T[]) new Comparable[arr.length - arr.length / 2];
        /* Copy the contents */
        for (int i = 0; i < L.length; i++)
            L[i] = arr[i];
        for (int i = 0; i < R.length; i++)
            R[i] = arr[L.length + i];   // copy the remaining part of arr

        /* Sort these two sub-array separately */
        T[] msL = mergesort(L);
        T[] msR = mergesort(R);

        /* Merge the two sorted sub-array */
        return merge(msL, msR);
    }

    public static <T> T[] merge(T[] arr1, T[] arr2, Comparator<T> comp) {
        T[] res = (T[]) new Comparable[arr1.length + arr2.length];

        int i = 0, j = 0;
        for (int k = 0; k < res.length; k++) {
            /* if arr2 is finished going through OR the element in arr1 is less than arr2,
             * use the element in arr1 */
            if (j >= arr2.length || (i < arr1.length && comp.compare(arr1[i], arr2[j]) <= 0)) {
                res[k] = arr1[i];
                i++;
            }
            /* if arr1 is finished going through OR the element in arr1 is greater than arr2,
             * use the element in arr2 */
            else if (i >= arr1.length || (j < arr2.length && comp.compare(arr1[i], arr2[j]) > 0)) {
                res[k] = arr2[j];
                j++;
            }
        }
        return res;
    }

    public static <T> T[] mergesort(T[] arr, Comparator<T> comp) {
        /* Base case: single element array */
        if (arr.length <= 1)
            return arr;
        /* Split the original array into two sub-arrays
        * and copy the contents into them*/
        T[] L = (T[]) new Comparable[arr.length / 2];
        T[] R = (T[]) new Comparable[arr.length - arr.length / 2];
        /* Copy the contents */
        for (int i = 0; i < L.length; i++)
            L[i] = arr[i];
        for (int i = 0; i < R.length; i++)
            R[i] = arr[L.length + i];   // copy the remaining part of arr

        /* Sort these two sub-array separately */
        T[] msL = mergesort(L, comp);
        T[] msR = mergesort(R, comp);

        /* Merge the two sorted sub-array */
        return merge(msL, msR, comp);
    }

    public static void main(String[] args) {
        ReverseStringComparator rscomp = new ReverseStringComparator();
        /* Test merge() */
        System.out.println("Test merge():");
        String[] L = {"ca", "bc", "ae"};
        String[] R = {"cca", "cd", "e"};
        Object[] res = merge(L, R, rscomp);
        for (Object i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        /* Test mergesort() */
        System.out.println("Test mergesort():");
        String[] a = {"ca", "bc", "ae", "cca", "cd", "e"};
        Object[] ans = mergesort(a, rscomp);

        for (Object i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class ReverseStringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() == 0) {
            return -1;
        } else if (s2.length() == 0) {
            return 1;
        }
        int i = s1.length() - 1, j = s2.length() - 1;
        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) < s2.charAt(j)) {
                return -1;
            } else if (s1.charAt(i) > s2.charAt(j)) {
                return 1;
            }
            i--;
            j--;
        }
        return s1.length() - s2.length();
    }
    // "" vs. "a"  "abc" vs. "bc"
}
