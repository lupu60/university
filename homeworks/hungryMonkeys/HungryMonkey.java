import java.util.Scanner;
import java.util.stream.*;
public class HungryMonkey {

	static int hungryLevel[]=new int[50];
	static int banana[]=new int[50];
	static int n;

	public static void readHungyLevel(){
		Scanner sc= new Scanner(System.in);

		System.out.print("Number of monkey= ");
		n=sc.nextInt();

		// System.out.println(n);

		for(int i=0;i<n;i++){
			System.out.print("Monkey number "+i+" HungryLevel= ");hungryLevel[i]=sc.nextInt();
		}
	}

	public static void calculate(){
		for(int i=0;i<n;i++){
			banana[i]=1;
		}
		for(int i=0;i<n;i++){
			if( i>=0 && i<n-1){
				if(hungryLevel[i]>hungryLevel[i+1] && banana[i]<=banana[i+1]){
					banana[i]=banana[i+1]+1;
				}
				else if(hungryLevel[i]<hungryLevel[i+1] && banana[i]>=banana[i+1]){
					banana[i+1]=banana[i]+1;
				}

			}

		}

		for(int i=n-1;i>=0;i--){
			if(i>0 && i<n){
				if(hungryLevel[i-1]>hungryLevel[i] && banana[i-1]<=banana[i]){
					banana[i-1]=banana[i]+1;
				}
				else if(hungryLevel[i-1]<hungryLevel[i] && banana[i-1]>=banana[i]){
					banana[i]=banana[i-1]+1;
				}
			}

		}
	}

	public static void show(){
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(hungryLevel[i]+" ");
		}
		System.out.println();

		for(int i=0;i<n;i++){
			System.out.print(banana[i]+" ");
		}
		System.out.println();
		int sum = IntStream.of(banana).sum();
		System.out.println("The sum is " + sum);
	}

	public static void main(String[] args) {
		readHungyLevel();
		calculate();
		show();

	}

}
