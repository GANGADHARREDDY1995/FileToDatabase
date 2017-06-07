import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainData {
	

	public static void main(String[] args) throws IOException {
		String path = "F:/GANGA Workspace/Files/ListOfData.txt";
		String errorPath = "F:/GANGA Workspace/Files/FGANGA WorkspaceFiles.txt";
		List<String> fileOutPutData = fileOparation(path);
		System.out.println("total records loaded  "+fileOutPutData.size());
		
		Map<String, List<String>> dataMap = validationData(fileOutPutData);
		
		List<String> sucList = dataMap.get("SUCCESS_RECORDS");
		System.out.println("suclist records loaded   :"+sucList.size());
		List<String> failureList = dataMap.get("FAILURE_RECORDS");
		System.out.println("failure records loaded   :"+failureList.size());

		
		List<Employe> list = convertEmployees(sucList);
		EmployeSevice employeSevice = new EmployeSevice();
		System.out.println("sending employedata count "+list.size());
		int count=employeSevice.serviceMethod(list);
		System.out.println("total succuessfully records  ="+count);
		
		//List<Employe> list2=sendToFile(failureList);
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(errorPath));
		System.out.println("inserting");
		
		for(String failedreRecord:failureList){
			
			bufferedWriter.write(failedreRecord);
			
		}bufferedWriter.flush();
		System.out.println("inserting complieted");
		bufferedWriter.close();
	}

	static List<Employe> convertEmployees(List<String> empData) {

		String[] splitData = null;
		List<Employe> list = new ArrayList<>();

		for (String data : empData) {
			splitData = data.split(",");
			Employe employe = new Employe(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4]);

			list.add(employe);

		}

		return list;
	}

	static List<Employe> sendToFile(List<String> failureList) throws IOException {

		List<Employe> list = new ArrayList<>();
		String[] failureOutput = null;
		
		for (String failureData : failureList) {
			failureOutput = failureData.split(",");
			Employe employe = new Employe(failureOutput[0], failureOutput[1], failureOutput[2], failureOutput[3],
					failureOutput[4]);
			list.add(employe);
			
		}
		return list;
	}

	static List<String> fileOparation(String path) throws IOException {

		Scanner scanner = new Scanner(new FileReader(path));

		ArrayList<String> list = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String fileData = scanner.nextLine();
			list.add(fileData);
		}
		scanner.close();
		return list;
	}

	static Map<String, List<String>> validationData(List<String> ValidationList) throws IOException {

		Map<String, List<String>> data = new HashMap<String, List<String>>();

		List<String> successList = new ArrayList<String>();
		List<String> errrorList = new ArrayList<String>();

		for (String line : ValidationList) {

			String[] array = line.split(",");

			if (array[0].trim().equals("") || array[1].equals("")) {
				errrorList.add(line);

			} else {
				successList.add(line);

			}
		}

		data.put("SUCCESS_RECORDS", successList);
		data.put("FAILURE_RECORDS", errrorList);

		return data;
	}
}
