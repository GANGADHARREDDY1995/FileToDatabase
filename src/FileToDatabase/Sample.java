package FileToDatabase;

public class Sample {

	public static void main(String[] args) {
		for (int i = 0; i <= 1000000; i++) {
			int j = 0;
			int count=1;
			j = j + i;
			if (j % 100000 == 0) {
				for (int k = 0; k <= j; k++) {
					count++;
				}System.out.println(count);
			} else {
				for (int k = 0; k <= j; k++) {
					count++;
				}
				System.out.println(count);
			}
		}

	}
}
