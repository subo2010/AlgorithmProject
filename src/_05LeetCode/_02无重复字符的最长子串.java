package _05LeetCode;

import org.junit.Test;

/*����һ���ַ����õ�����û�����ظ��ַ�����ַ�������*/
public class _02���ظ��ַ�����Ӵ� {

    @Test
    public void test() {
        String str = "abcabcbb";
        int len = lengthOfLongestSubstring(str);
        System.out.println(len);    // 3
    }

    public int lengthOfLongestSubstring(String s) {
        // ��¼�ַ���һ�γ��ֵ�λ��
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // ���ڿ�ʼλ��
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
