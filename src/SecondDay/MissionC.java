package SecondDay;

import java.util.Scanner;

public class MissionC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a[] = new boolean[1000001];
		for (int i = 2; i <=1000000; i++) {
			a[i] = true;
		}
		int i, j;
		for (i = 2; i <= 1000000; i++) {
			if (a[i] == true) {
				for (j = 2; j * i <=1000000; j++) {
					a[j * i] = false;
				}
			}
		}

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int i1 = scan.nextInt();
			if (i1 == 0)
				break;
			else {
				int c=2;
				while(true){
					if (a[i1-c])
						break;
					else
					{
						while (true){
							c++;
							if (a[c])
								break;
						}
					}
				}
				System.out.println(i1+" = "+c+" + "+(i1-c));
			}
		}
	}

}