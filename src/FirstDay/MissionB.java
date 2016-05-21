package FirstDay;

import java.util.Scanner;

public class MissionB {
	private class Node{
		Node node;
		String s;
	}
	
	private Node top;
	private int size;
	public MissionB(){
		top=null;
		size=0;
	}
	public void clear() {  
        top = null;  
        size = 0;  
    }  
	
	public void push(String c){
		Node node = new Node();
		node.s=c;
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
		MissionB m = new MissionB();
		m.push("http://www.acm.org/");
		MissionB n = new MissionB();
		while (scan.hasNext()){
			String temp = scan.nextLine();
			String[] ss = temp.split(" ");
			if (ss[0].equals("QUIT")){
				break;
			}
			else if (ss[0].equals("VISIT")){
				m.push(ss[1]);
				n.clear();
				System.out.println(m.top.s);
			}
			else if (ss[0].equals("BACK")){
				if (m.size==1)
					System.out.println("Ignored");
				else{
					n.push(m.top.s);
					m.pop();
					System.out.println(m.top.s);
				}
			}
			else if (ss[0].equals("FORWARD")){
				if (n.size==0)
					System.out.println("Ignored");
				else{
					m.push(n.top.s);
					n.pop();
					System.out.println(m.top.s);
				}
			}
		}
	}

}
