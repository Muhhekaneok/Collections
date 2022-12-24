package justforfun.collections.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test5 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] nums3 = {1, 2, 2, 1};
        int[] nums4 = {2, 2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        System.out.println(Arrays.toString(intersect(nums3, nums4)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums1)
            set.add(i);

        Set<Integer> intersectionSet = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i))
                intersectionSet.add(i);
        }

        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int i : intersectionSet)
            result[index++] = i;
        return result;
    }
}