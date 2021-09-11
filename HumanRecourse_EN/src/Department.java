
public class Department {
	int departmentID;
	int numberOfEmployee;
	String departmentName;

	public Department(int departmentID, String departmentName, int numberOfEmployee) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.numberOfEmployee = numberOfEmployee;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String toString() {
		return String.format("|%5s|%16s|%18s|", departmentID, departmentName, numberOfEmployee);
	}

}
