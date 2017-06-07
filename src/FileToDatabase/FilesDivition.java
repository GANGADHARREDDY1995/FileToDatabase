package FileToDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilesDivition {
	static int i = 1;

	public static void main(String[] args) throws IOException {

		Scanner reader = new Scanner(new FileReader("F:/GANGA Workspace/Files/IN/ListOfEmployeData.txt"));

		List<String> empList = new ArrayList<>();
		int count = 0;
		System.out.println("reading");
		while (reader.hasNext()) {
			count++;
			String record = reader.nextLine();
			if (count %100000==0) {
				
				//System.out.println("temp data   :"+record);
				
				empList.add(record);
				
				int a=writeData(empList);
				
				empList.clear();
				System.out.println("how many times we are sendinng the data  :"+a);
			} 
			else{
				empList.add(record);
			}
		}
		
		
		System.out.println("sending data");
		reader.close();
		
		
		
	}

	public static int  writeData(List<String> list) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("F:/GANGA Workspace/Files/OUT/text" + i + ".txt")));
		for (String data : list) {
			writer.write(data);
			writer.write("\n");
			
		}
		
		i++;
		writer.flush();
		writer.close();
		
		return i;
	}

}
