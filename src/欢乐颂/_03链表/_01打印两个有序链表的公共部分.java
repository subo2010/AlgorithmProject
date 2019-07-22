package ������._03����;

import org.junit.Test;


/*
 * ��ӡ������������Ĺ�������
	����Ŀ�� �����������������ͷָ��head1��head2��(**��������--Ĭ�ϴ�С����)
	               ��ӡ��������Ĺ������֡�
	˼·:������������ 
 */
public class _01��ӡ������������Ĺ������� {
	
	@Test
	public void main() {
		MySingleLinkList my1 = new MySingleLinkList();
		MySingleLinkList my2 = new MySingleLinkList();
		my1.addLast(1);
		my1.addLast(2);
		my1.addLast(3);
		my1.addLast(4);
		my2.addLast(1);
		my2.addLast(3);
		my2.addLast(4);
		my2.addLast(5);
		my2.addLast(6);
		MyNode head1 = my1.head;
		MyNode head2 = my2.head;
		printLinklist(head1,head2);
	}
	
	public void printLinklist(MyNode head1,MyNode head2){
		while(head1!=null && head2!=null){
			if (head1.elem>head2.elem) {
				head2=head2.next;
			} else if(head1.elem<head2.elem) {
				head1=head1.next;
			} else {
				System.out.print(head1.elem+" ");
				head1=head1.next;
			}
		}
	}
}



//������-----������-------������------������------������---------������------------������-------------������-------������---
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