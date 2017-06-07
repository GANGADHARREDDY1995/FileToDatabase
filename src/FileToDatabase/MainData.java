package FileToDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainData {
	public static void main(String[] args) throws IOException {
		String path="F:/GANGA Workspace/Files/OUT";
		String errorPath ="F:/GANGA Workspace/Files/ErrorList/ErrorEmployeList.txt";
		
		List<String> listOfFileData=readDataFormFile(path);
		
		System.out.println(listOfFileData.size());
		
		Map<String, List<String>> map=dataVarification(listOfFileData);
		List<String> successRecordList=map.get("success");
		List<String> failure=map.get("failue");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(errorPath));
		for(String recordsFailure : failure){
			writer.write(recordsFailure);
		}
		writer.flush();
		writer.close();
		
			List<Employe> listOfSuccessEployeList=convertToEmploye(successRecordList);
			EmployeSevice sevice = new EmployeSevice();
			sevice.serviceMethod(listOfSuccessEployeList);
			
	}

	public static List<Employe> convertToEmploye(List<String> success) {
		// TODO Auto-generated method stub
		List<Employe> listOfEmploye = new ArrayList<>();
		for(String data:success){
			String [] convertData=data.split(",");
			Employe employe = new Employe(convertData[0], convertData[1], convertData[2], convertData[3], convertData[4]);
			listOfEmploye.add(employe);
		}
		return listOfEmploye;
	}

	public static Map<String, List<String>> dataVarification(List<String> listOfFileData) {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new  TreeMap<>();
		List<String> successList = new ArrayList<>();
		List<String> failureList = new ArrayList<>();
		
		for(String listOfData : listOfFileData){
			String [] splitListOfData= listOfData.split(",");
			if(splitListOfData[0].equals("") || splitListOfData[1].equals("")){
				failureList.add(listOfData);
			}else{
				successList.add(listOfData);
			}
		}
		map.put("success", successList);
		map.put("failue", failureList);
		return map;
	}

	public static List<String> readDataFormFile(String path) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File(path);
		
		List<String> listOfData = new ArrayList<>();
		File[] listOfFiles = file.listFiles();
		List<String> listOfRecord = new ArrayList<>();
		
		for (int i = 0; i <= listOfFiles.length - 1; i++) {
		
			File filePath=listOfFiles[i].getAbsoluteFile();
			Scanner scanner = new Scanner(filePath);
			
			while (scanner.hasNextLine()) {
				listOfData.add(scanner.nextLine());

			}
			scanner.close();
		}
		return listOfData;
	}
}
