package _05LeetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*����һ���ַ����õ�����û�����ظ��ַ�����ַ�������
 * ˼·:���û������ڷ�˼·������
 * 1.��¼��ǰ�ĳ���Ϊlen=0,forward,behind��Ϊǰ��ָ��
 * 2.ǰ��ָ�����û��Խ���������,�ж�hashset���Ƿ��е�ǰԪ��,������о����,
 * */
public class _03���ظ��ַ�����Ӵ�<lengthOfLongestSubstring1> {

    @Test
    public void test() {
        String str = "pwwkew";
        int len = lengthOfLongestSubstring1(str);
        System.out.println(len);    // 3
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //����hashset
        Set charSet = new HashSet();
        //����ǰ��ָ��ͳ���
        int len = 0;
        int forward = 0;
        int behind = 0;
        while (behind <= forward && forward < s.length()) {
            if (len >= (s.length() - behind)) break;
            if (!charSet.contains(s.charAt(forward))) {
                charSet.add(s.charAt(forward));
                len = Math.max(len, forward - behind + 1);
                forward++;
            } else {
                charSet.remove(s.charAt(behind++));
            }
        }
        return len;
    }

    public int lengthOfLongestSubstring(String s) {
        // ��¼�ַ���һ�γ��ֵ�λ��
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // ���ڿ�ʼλ��
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
