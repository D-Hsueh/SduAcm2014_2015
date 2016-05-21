package SecondDay;
import java.util.Arrays;
import java.util.Scanner;

public class MissionA {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()){
			long a = scan.nextLong();
			long b = scan.nextLong();
			if (a==0&&b==0){
				break;
			}
			else{
				long[][] ia = new long [2][(int) a];
				for (int i = 0;i<ia.length;i++){
					for (int j = 0;j<ia[i].length;j++){
						ia[i][j]=scan.nextLong();
					}
				}
				double ans1 = 0;
				double ans2 = 100;
				double ans=0;
				int time = 15;
				while (time-- > 0){
					double sum=0;
					ans = (ans1+ans2)/2;
					double[] c = new double[(int) a];
					for (int i=0;i<a;i++){
						c[i]=100*ia[0][i]-ia[1][i]*ans;
					}
					Arrays.sort(c);
					double resulta[] = new double[(int) (a-b)];
					for(int i = 0;i < a-b;i++){
			    		resulta[i] = c[(int) (i+b)];
			    	}
			    	for(int i = 0;i < a-b;i++)
			    		sum += resulta[i];
					if (sum>0){
						ans1=ans;
					}else{
						ans2=ans;
					}
				}
				System.out.printf("%.0f\n",ans);

			}
		}
	}

}