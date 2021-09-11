
public class Manager extends Staff implements ICalculator {
	private String position;

	public Manager(int employeeID, String employeeName, int age, String department, String position,
			String enterDate, double annualLeave, double salaryCoefficient) {
		super(employeeID, employeeName, age, department, enterDate, annualLeave, salaryCoefficient);
		this.position = position;

	}

	public String getPosition() {
		return position;
	}

	@Override
	public void displayInformation() {
		System.out.println(String.format("|%03d|%20s|%5s|%18s|%17s|%13s|%13s|%13s|%11s|%13s VND|", super.getEmployeeID(),
				super.getEmployeeName(), super.getAge(), super.getDepartment(), getPosition(), super.getEnterDate(), super.getAnnualLeave(), "-",
				super.getSalaryCoefficient(),(int)calculateSalary()));
	}

	@Override
	public double calculateSalary() {
		int responsibleWages = 0;
		if (getPosition().equals("BUSINESS LEADER")) {
			responsibleWages = 8000000;
		} else if (getPosition().equals("PROJECT LEADER")) {
			responsibleWages = 5000000;
		} else if (getPosition().equals("TECHNICAL LEADER")) {
			responsibleWages = 6000000;
		}

		return super.getSalaryCoefficient() * 5000000 + responsibleWages;
	}


}
