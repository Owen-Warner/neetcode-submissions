class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int half = (total + 1) / 2;
        int lo = 0, hi = m;

        while (lo <= hi) {
            int cut1 = (lo + hi) / 2;
            int cut2 = half - cut1;
            int left1;
            int right1; 
            int left2;
            int right2;

            if (cut1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[cut1 - 1];
            }
            if (cut1 == m) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[cut1];
            }
            if (cut2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[cut2 - 1];
            }
            if (cut2 == n) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[cut2];
            }
            if (left1 <= right2 && left2 <= right1) {
                int maxLeft;
                if (left1 > left2) {
                    maxLeft = left1;
                } else {
                    maxLeft = left2;
                }
                if (total % 2 != 0) {
                    return maxLeft;
                }
                int minRight;
                if (right1 < right2) {
                    minRight = right1;
                } else {
                    minRight = right2;
                }
                return (maxLeft + minRight) / 2.0;
            } else if (left1 > right2) {
                hi = cut1 - 1;
            } else {
                lo = cut1 + 1;
            }
        }
        return -1.0;
    }
}
