/******************************************************************
 *
 *   KASS SEREK / COMP272 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        // create a set to store all elements of list1
        Set<Integer> set = new HashSet<>();

        // add each element from list1 to the set
        for (int num : list1) {
            set.add(num);
        }

        // check each element in list2 to see if it's in the set
        for (int num : list2) {
            // if any element in list2 is not in the set, return false
            if (!set.contains(num)) {
                return false;
            }
        }
        // if all elements in list2 are found in list 1, return true
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        // create a min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // iterate over each element in the array
        for (int num : array) {
            // add the current element to the min-heap
            minHeap.offer(num);

            // if the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // the root of the min-heap is the kth largest element
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        // create a new array to hold the merged result of both arrays
        int[] mergedArray = new int[array1.length + array2.length];

        // copy all elements from array 1 into the merged array
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);

        // copy all elements from array2 into the merged array, starting after array1
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);

        // sort the merged array in ascending order
        Arrays.sort(mergedArray);

        // return the sorted merged array
        return mergedArray;
    }

}
