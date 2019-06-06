package _1���������㷨;

public class _01������ {
	public static void main(String[] args) {
		
//		Node node = new Node(1);
		MySingleLinkList sl = new MySingleLinkList();
		sl.addLast(1);
		sl.addLast(2);
		sl.addLast(3);
		sl.addLast(4);
		sl.addLast(5);
		sl.addIndex(3, 100);
		sl.removeFirst();
		sl.removeLast();
		sl.removeIndex(3);

		System.out.println(sl.Isempty());
		System.out.println(sl.Length());
		sl.travel();	
	}
	
	public static MySingleLinkList getLinked(){
		return new MySingleLinkList();
	}
}


/**����һ���ڵ�
*/
class MyNode{
	public int elem;	//Ԫ�ص�ֵ
	public MyNode next;	//Ԫ�ص�ָ��
	public MyNode(int elem){
		this.elem = elem;
	}
}

/**������������ */
class MySingleLinkList{
	 
	 public MyNode head = null;
	 public MySingleLinkList(){};
	 public MySingleLinkList(MyNode node){
		 this.head = node;
	 };
	 
	 //�ж��Ƿ�Ϊ��
	 public boolean Isempty(){
		 if(head == null){
			 return true;
		 } 
		 return false;
	 }
	
	 //������
	 public int Length(){
		 MyNode cur = head;
		 int count = 0;
		 while(cur != null){
			 count += 1;
			 cur = cur.next;
		 }
		 return count;
	 }
	 
	 //������������
	 public void travel(){
		MyNode cur = head;
        while (cur != null){
        	System.out.print(cur.elem +" ");
        	cur = cur.next;
        }
        System.out.println();
	 }
	 
	 //ͷ�����
	 public void add(int item){
		 MyNode node = new MyNode(item);
		 node.next = head;
		 head = node;
	 }
	 
	 //β�����
	 public void addLast(int item){
		 MyNode node = new MyNode(item);
		 MyNode cur = head;
		 if(cur == null){		//���ж�ͷ���ڵ��Ƿ�Ϊnull
			 head = node;
			 return;
		 }
         while (cur.next != null){//���������һ���ڵ�
        	cur = cur.next;
         }
         cur.next = node;
	 }
	 
	 //ָ������λ�����
	 public void addIndex(int index,int item){
		 MyNode node = new MyNode(item);
		 MyNode cur = head;
		 int i = 0;
		 if(index <= 0){		
			 add(item);
			 return;
		 }
		 if(index >= Length()-1){		
			 addLast(item);
			 return;
		 }
		 while(i < index-1){
			 cur = cur.next;
			 i++;
		 }
		 node.next = cur.next;
		 cur.next = node;
	 }
	 
	 //ͷ��ɾ��
	 public void removeFirst(){
		 if(head==null){
			 return;
		 }
		 head= head.next;
	 }
	 
	 //β��ɾ��
	 public void removeLast(){
		 MyNode cur = head;
		 if(head==null){
			 return;
		 }
		 if(cur.next==null){
			 head = null;
			 return;
		 }
		 while(cur.next.next!=null){
			 cur = cur.next;
		 }
		 cur.next = null;
	 }
	 
	//ָ������λ��ɾ��
	 public void removeIndex(int index){
		 
		 MyNode cur = head;
		 int i = 0;
		 if(index <= 0){		
			 removeFirst();
			 return;
		 }
		 if(index >= Length()-1){		
			 removeLast();
			 return;
		 }
		 while(i < index-1){
			 cur = cur.next;
			 i++;
		 }
		 
		 cur.next = cur.next.next;
	 }	 
 }