import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataToFile  {
public static void main(String[] args) throws IOException {
	int id=1;
	String name="siva";
	String address="banglorre";
	String salary ="2000";
	String phone ="8985502467";
	BufferedWriter writer = new  BufferedWriter(new FileWriter("F:/GANGA Workspace/Files/ListOfData.txt"));
	System.out.println("data inseting to file");
	for(int i=0;i<=100000;i++){
		String empnumber="";
		empnumber=empnumber+id;
		
		if(i%500==0){
			empnumber="";
		}
		writer.write(empnumber+","+name+i+","+address+","+salary+","+phone);
		writer.write("\n");
		id++;
		
	}
	writer.flush();
	writer.close();
}


}
