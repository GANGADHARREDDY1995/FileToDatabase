package FileToDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter some range");
		int range=scanner.nextInt();
		int i =0;
		List<Integer> integerValues=oddNUmber(i,range);
		System.out.println(integerValues);
		List<Integer> integerlist=evenNumber(i,range);
		System.out.println(integerlist);
		scanner.close();

	}

	public static List<Integer> evenNumber(int i,int range) {
		// TODO Auto-generated method stub
		i=1;
		List<Integer> list = new ArrayList<>();
		while(i<=range){
			i=i+2;
			list.add(i);
		}
		return list;
		
	}

	public static List<Integer> oddNUmber(int i,int range) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		while (i <= range) {
			list.add(i);
			i = i + 2;
		}
		return list;

	}
}
