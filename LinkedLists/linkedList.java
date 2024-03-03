import java.util.Scanner;
class Main
{
    static node head=null;
	 static class node{
	     int data;
	     node next;
	     node(int n){
	         data=n;
	         next=null;
	     }
	     
	 }
	 static void insert(int n){
	     node newNode=new node(n);
	     if(head==null){
	         head=newNode;
	     } else{
	         node cur=head;
	         while(cur.next!=null){
	             cur=cur.next;
	         }
	         cur.next=newNode;
	 }
	 }
	 static void display(){
	     node cur=head;
	     while(cur!=null){
	         System.out.print(cur.data+" ");
	         cur=cur.next;
	     }
	     //System.out.println("null");
	 }
	 
	 static node reverseLL(node first){
	     node cur=first;
	     node prev=null;
	     node next=null;
	     while(cur!=null){
	         next=cur.next;
	         cur.next=prev;
	         prev=cur;
	         cur=next;
	     }
	     first=prev;
	     return first;
	 }
	 
	 // rotate the linked list
	 static void rotate(int k){
	     node cur=head;
       int c=1;
       while(c!=k){
         cur=cur.next;
         c++;
       }
       node res=cur.next;
       node result=cur.next;
       cur.next=null;
       while(res.next!=null){
         res=res.next;
       }
       res.next=head;
       head=result;
	 }
	 // another method
	 static void rotatell(int k){
	     node cur=head;
      if(head==null) return;
      while(cur.next!=null) cur=cur.next;
      cur.next=head;
      node temp=head;
      for(int i=1;i<k;i++)
        temp=temp.next;
      head=temp.next;
      temp.next=null;
    }
	 
	 // for palindrome
	 static boolean palindrome(){
	     node fast=head;
	     node slow=head;
	     while(fast.next!=null&&fast.next.next!=null){
	         fast=fast.next.next;
	         slow=slow.next;
	     }
	     node temp=slow.next;
	     slow.next=null;
	     temp=reverseLL(temp);
	     node cur=head;
	     while(temp!=null){
	         if(cur.data!=temp.data){
	             return false;
	         }
	         cur=cur.next;
	         temp=temp.next;
	     }
	     return true;
	 }
	 public static void main(String[] args){
	     Scanner sc=new Scanner(System.in);
	     int n=sc.nextInt();
	     for(int i=0;i<n;i++){
           insert(sc.nextInt());
	     }
       int k=sc.nextInt();
       System.out.println("Given Linked list: ");
	     display();
	  
       System.out.println("Rotated Linked list: ");
       rotate(k); 
	     display();
	 }
}
