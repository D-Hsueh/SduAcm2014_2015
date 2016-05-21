package FirstDay;

import java.util.Scanner;

public class MissionA{
	
	private class Node{
		Node node;
		char ch;
	}
	
	private Node top;
	private int size;
	public MissionA(){
		top=null;
		size=0;
	}
	
	public void push(char c){
		Node node = new Node();
		node.ch=c;
		node.node=top;
		top=node;
		size++;
	}
	
	public void pop(){
		if (top!=null){
			top=top.node;
			size--;
		}
	}
	public boolean isEmpty(){
		if(size==0)
			return true;
		else
			return false;
	}
	
	public int getSize(){
		return size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String op= scan.nextLine();
		for (int i = 0;i<n;i++){
			String s = scan.nextLine();
			MissionA m = new MissionA();
			for (int j = 0;j<s.length();j++){
				char ch = s.charAt(j);
				if (m.getSize()>0){
					char temp = m.top.ch;
					if (temp=='['&&ch==']'){
						m.pop();
					}
					else if (temp=='('&&ch==')'){
						m.pop();
					}
					else
						m.push(ch);
				}
				else{
					m.push(ch);
				}
			}
			if (m.isEmpty())
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
