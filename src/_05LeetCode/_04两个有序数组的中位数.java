package _05LeetCode;

import org.junit.Test;

/*
����������СΪ m �� n �����򣨴�С��������?nums1 ��?nums2��
�����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ?O(log(m + n))��
����Լ���?nums1?��?nums2?����ͬʱΪ�ա�

����:
1.����������ϲ���һ������,������ȡ��λ��  O((m+n)log(m+n))

2.merge:�鲢�����е�merge

3.ͨ�����ֲ�����ʵ��

*/
public class _04���������������λ�� {

    @Test
    public void main( ) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double ret = findMedianSortedArrays(nums1,nums2);
        double ret1 = SortedArrays(nums1,nums2);
        System.out.println(ret);
        System.out.println(ret1);
    }

    // ���ֲ���
    public double SortedArrays(int[] nums1, int[] nums2) {
        //��num1��Ϊ�Ƚ϶̵�����
        if (nums1.length > nums2.length) {
            int[] tem = nums1;
            nums1 = nums2;
            nums2 = tem;
        }
        int m = nums1.length;
        int n = nums2.length;
        //��ȥ��λ�����Ԫ�صĸ���
        int totallLeft = m + (n - m + 1) / 2;   //  (m+n+1)/2  1.����ż������ȡֵ��ͬ���   2.��ֹ��ֵ���

        // ��nums1��Ѱ��nums1��λ�߷ָ��ߵ�λ��[0 m]��
        // ʹ��nums1[i - 1] <= nums2[j]  && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totallLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // ��һ������[left i-1]
                right = i - 1;
            } else {
                // ��һ������[i right]
                left = i;
            }
        }

        int i = left;
        int j = totallLeft - i;
        int nums1LeftMax = i == 0? Integer.MIN_VALUE : nums1[i-1];
        int nums1RightMin = i == m? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0? Integer.MIN_VALUE : nums2[j-1];
        int nums2RightMin = j == n? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        } else {
            return (double) (Math.max(nums1LeftMax,nums2LeftMax) + Math.min(nums1RightMin,nums2RightMin))/2;
        }
    }

    // merge   (ʱ��ռ䶼�� O(m+n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tem = new int[nums1.length + nums2.length];
        int index = 0;
        int d1 = 0;
        int d2 = 0;
        while (d1 < nums1.length && d2 < nums2.length) {        // �߽�����
            tem[index++] = (nums1[d1] <= nums2[d2]) ? nums1[d1++] : nums2[d2++];
        }
        while(d1 < nums1.length) {
            tem[index++] = nums1[d1++];
        }
        while(d2 < nums2.length) {
            tem[index++] = nums2[d2++];
        }
        if (tem.length % 2 == 0) {
            return (double)(tem[tem.length/2] + tem[tem.length/2 -1]) / 2;      // �᲻��Խ��
        } else {
            return tem[tem.length/2];
        }
    }
}
