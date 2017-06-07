package FileToDatabase;


public class Employe implements Comparable<Employe>{
private String EmployeId;
private String name;
private String Address;
private String salary;
private String phoneNumber;

public String getEmployeId() {
	return EmployeId;
}
public void setEmployeId(String employeId) {
	EmployeId = employeId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Employe(String employeId, String name, String address, String salary, String phoneNumber) {
	super();
	EmployeId = employeId;
	this.name = name;
	Address = address;
	this.salary = salary;
	this.phoneNumber = phoneNumber;
}
@Override
public String toString() {
	return "Employe [EmployeId=" + EmployeId + ", name=" + name + ", Address=" + Address + ", salary=" + salary
			+ ", phoneNumber=" + phoneNumber + "]";
}
@Override
public int compareTo(Employe o) {
	
	
	return this.EmployeId.compareTo(o.EmployeId);
}

}
