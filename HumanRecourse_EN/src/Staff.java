import java.util.Scanner;

public abstract class Staff implements ICalculator {
	private int employeeID;
	private String employeeName;
	private int age;
	private double salaryCoefficient;
	private String department;
	private String enterDate;
	private double annualLeave;
	Scanner cs = new Scanner(System.in);

	public Staff(int employeeID, String employeeName, int age, String department, String enterDate, double annualLeave,
			double salaryCoefficient) {
		this.employeeName = employeeName;
		this.employeeID = employeeID;
		this.age = age;
		this.salaryCoefficient = salaryCoefficient;
		this.department = department;
		this.enterDate = enterDate;
		this.annualLeave = annualLeave;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}

	public double getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(double annualLeave) {
		this.annualLeave = annualLeave;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalaryCoefficient() {
		return salaryCoefficient;
	}

	public void setSalaryCoefficient(double salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}

	public abstract void displayInformation();
	public void payroll() {
		System.out.println(String.format("|%03d|%20s|%18s|%11s|%13s VND|", getEmployeeID(),
				getEmployeeName(), getDepartment(),getSalaryCoefficient(),(int)calculateSalary()));
	}
	
}
