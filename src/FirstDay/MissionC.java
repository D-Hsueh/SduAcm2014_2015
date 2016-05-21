package FirstDay;

import java.util.Scanner;

public class MissionC {
	public class Node {
		Node node;
		int data;
	}

	Node first;
	Node last;
	int size;

	public MissionC() {
		first = null;
		last = null;
	}

	public Node add(int data) {
		Node temp = new Node();
		temp.data = data;
		if (size == 0) {
			first = temp;
			last = temp;
		} else {
			last.node = temp;
			last = temp;
		}
		size++;
		return temp;
	}

	public Node insert(Node temp, int data) {
		Node now = new Node();
		now.data = data;
		now.node = temp.node;
		temp.node = now;
		return now;
	}

	public void del(Node[] b) {
		for (int i =0;i<b.length;i++){
			if (b[i]==first){
				b[i]=null;
				break;
			}
		}
		System.out.println(first.data);
		first = first.node;
		size--;
	}

	public int find(int data,int[][] a){
		for (int i =0;i<a.length;i++){
			for (int j =0;j<a[i].length;j++){
				if (data==a[i][j])
					return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] a=null;
		Node[] b=null;
		MissionC m=null;
		int count=1;
		while (scan.hasNext()){
			String s =scan.nextLine();
			String[] s1=s.split(" ");
			if (s.equals("0")){
				break;
			}else if (s.equals("STOP")){
				System.out.println();
				a=null;
				b=null;
				m=null;
			}else if (s.equals("DEQUEUE")){
				m.del(b);
			}else if (s1[0].equals("ENQUEUE")){
				int data=Integer.valueOf(s1[1]);
				int num = m.find(data, a);
				if (num==-1){
					m.add(data);
				}
				else if (b[num]==null){
					b[num]=m.add(data);
				}else{
					b[num]=m.insert(b[num], data);
				}
			}else if (s1.length==1){
				int n = Integer.valueOf(s);
				a=new int[n][];
				b=new Node[n];
				for (int i = 0;i<n;i++){
					String s12 = scan.nextLine();
					String[] s2 = s12.split(" ");
					int n2=Integer.valueOf(s2[0]);
					a[i]=new int[n2];
					b[i]=null;
					for (int j=0;j<n2;j++){
						a[i][j]=Integer.valueOf(s2[j+1]);
					}
				}
				m= new MissionC();
				System.out.println("Scenario #" + count++);
			}
		
		}
		}
}
