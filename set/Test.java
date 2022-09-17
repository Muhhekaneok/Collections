package justforfun.collections.set;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays, and you may return the result in any order.
 * <p>
 * Даны два целочисленных массива nums1 и nums2, верните массив с их пересечением.
 * Каждый элемент в результате должен появляться столько раз, сколько он показывает в обоих массивах,
 * и вы можете вернуть результат в любом порядкеУчитывая два целочисленных массива nums1 и nums2, верните массив их пересечения.
 * Каждый элемент в результате должен появляться столько раз, сколько он показывает в обоих массивах,
 * и вы можете вернуть результат в любом порядке
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 */
public class Test {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] numsResult;

        Set<Integer> hashSet1 = new HashSet<>();
        Set<Integer> hashSet2 = new HashSet<>();

        for (int i : nums1) {
            hashSet1.add(i);
        }

        for (int i : nums2) {
            hashSet2.add(i);
        }

        nums1 = new int[hashSet1.toArray().length];
        nums2 = new int[hashSet2.toArray().length];
//        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
//            nums1[i] = (int) hashSet1.toArray()[i];
//            nums2[j] = (int) hashSet2.toArray()[j];
//        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = (int) hashSet1.toArray()[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = (int) hashSet2.toArray()[i];
        }
        System.out.println("nums1 modified = " + Arrays.toString(nums1));
        System.out.println("nums2 modified = " + Arrays.toString(nums2));

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        // TODO: 16-Sep-22  nums1 = [4,9,5], nums2 = [9,4,9,8,4] - it works,
        // TODO: 16-Sep-22 nums1 = [1,2,2,1], nums2 = [2,2] - doesn't works :( ...
        if (nums1.length >= nums2.length) {
            numsResult = new int[nums1.length];
            for (int i = 0, j = 0; i < numsResult.length && j < numsResult.length; i++, j++) {
                numsResult[i] = nums1[i];
                list1.add(numsResult[i]);
                list2.add(nums2[j]);
            }
        } else {
            numsResult = new int[nums2.length];
            for (int i = 0; i < numsResult.length; i++) {
                numsResult[i] = nums2[i];
                list2.add(numsResult[i]);
                list1.add(nums1[i]);
            }
        }
        System.out.println(list1);
        System.out.println(list2);

        if (list1.size() >= list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) == list2.get(i))
                    list3.add(list1.get(i));
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {
                if (list1.get(i) == list2.get(i))
                    list3.add(list2.get(i));
            }
        }
        System.out.println(list3);
    }
}