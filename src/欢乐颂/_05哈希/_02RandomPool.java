package ������._05��ϣ;

import java.util.HashMap;

import org.junit.Test;

/**
 * ���RandomPool�ṹ
	����Ŀ�� ���һ�ֽṹ���ڸýṹ���������������ܣ�
		1.insert(key)����ĳ��key���뵽�ýṹ���������ظ����롣
		2.delete(key)����ԭ���ڽṹ�е�ĳ��key�Ƴ��� 
		3.getRandom()���ȸ���������ؽṹ�е��κ�һ��key��
	
	��Ҫ�� Insert��delete��getRandom������ʱ�临�Ӷȶ���O(1)
	
	˼·:��Ŀ��ʵ�ֵ���һ�����м��ϵĽṹ(������HashSet),���Ƕ���һ��getRandom()����,����Ҫ��ʱ�临�Ӷȶ�ΪO(1)
		��˿�����������˫�м���(HashMap)��ʵ��,
			map1-->HashMap<String,Integer>
			map2-->HashMap<Integer,String>
			ά��һ��size������Ϊ���ϵĴ�С
		insert(key)������Ԫ��
 * @author Administrator
 *
 */
public class _02RandomPool {
	
	@Test
	public void main() {
		RandomPool pool = new RandomPool();
		pool.insert("1");
		pool.insert("2");
		pool.delete("2");
		
		String str = pool.getRandom(); 
		System.out.println(str);
		
	}
	
	
	
	class RandomPool{
		HashMap<String,Integer> map1;
		HashMap<Integer,String> map2;
		int size = 0;
		public RandomPool(){
			map1 = new HashMap<String, Integer>();
			map2 = new HashMap<Integer,String>();
		}
		
		//���Ԫ��
		public void insert(String key) {
			if (map1.containsKey(key)) {
				throw new RuntimeException("�Ѱ�����Ԫ��-->"+key);
			}
			size++;
			map1.put(key, size);
			map2.put(size, key);
		}
		
		//ɾ��Ԫ��
		public void delete(String key) {
			if (!map1.containsKey(key)) {
				throw new RuntimeException("���ϲ����ڴ�Ԫ��-->"+key);
			}
			int deleteIndex = this.map1.get(key);
			int lastIndex = size--;
			String lastKey = map2.get(lastIndex);
			map1.put(lastKey, deleteIndex);
			map2.put(deleteIndex, lastKey);
			map1.remove(key);
			map2.remove(lastIndex);
			
		}
		
		//������Ԫ��
		public String getRandom() {
			if (this.size == 0) {
				return null;
			}
			int randomIndex = (int) (Math.random() * this.size+1); // 1 ~ size
			return map2.get(randomIndex);
		}
	}

}
