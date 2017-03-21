import java.lang.reflect.Array;

/**
 * Created by chaoranchen on 3/21/17.
 */

public class Mergesort {
    public static <T extends Comparable<T>> T[] merge(T[] arr1, T[] arr2) {
        //T[] res = (T[])new Object[arr1.length + arr2.length]; // This does not work!
        T[] res = (T[]) Array.newInstance(arr1.getClass().getComponentType(), arr1.length + arr2.length);

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
        T[] L = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length / 2);
        T[] R = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length - arr.length / 2);
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

    public static void main(String[] args) {
        /* Test merge() */
        System.out.println("Test merge():");
        String[] L = {"a", "c"};
        String[] R = {"b", "d", "e"};
        String[] res = merge(L, R);
        for (String i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        /* Test mergesort() */
        System.out.println("Test mergesort():");
        Integer[] a = {2, 1, 4, 3, 5};
        Integer[] ans = mergesort(a);

        for (Integer i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
