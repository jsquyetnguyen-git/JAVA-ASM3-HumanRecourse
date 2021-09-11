public class Employee extends Staff implements ICalculator {
	private int overTime;

	public Employee(int employeeID, String employeeName, int age, String department, int overTime,
			String enterDate, double annualLeave,double salaryCoefficient) {
		super(employeeID, employeeName, age, department, enterDate, annualLeave, salaryCoefficient);
		this.overTime = overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public int getOverTime() {
		return overTime;
	}

	@Override
	public void displayInformation() {
		System.out.println(String.format("|%03d|%20s|%5s|%18s|%17s|%13s|%13s|%13s|%11s|%13s VND|", super.getEmployeeID(),
				super.getEmployeeName(), super.getAge(), super.getDepartment(), "EMPLOYEE", super.getEnterDate(), super.getAnnualLeave(), getOverTime(),
				super.getSalaryCoefficient(),(int)calculateSalary()));
	}

	@Override
	public double calculateSalary() {
		return getSalaryCoefficient() * 3000000 + this.getOverTime() * 200000;
	}
	
}
