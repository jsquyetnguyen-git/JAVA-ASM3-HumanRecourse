import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResoucres {
	static Scanner cs = new Scanner(System.in);
	static ArrayList<Staff> arrEmployee = new ArrayList<Staff>();
	static ArrayList<Department> arrDepartment = new ArrayList<Department>();

	public static void main(String[] args) {
		int menuId = 0, temp;
		boolean tiepTuc = false;
		testData();
		departments();

		// Loop menu
		do {
			showMenu();
			menuId = cs.nextInt();
			switch (menuId) {
			case 1: {
				// Add new staff
				addNewStaff();
				break;
			}
			case 2: {
				// List of employees
				displayAllEmployees();
				break;
			}
			case 3: {
				// List of departments in the company
				displayAllDepartments();
				break;
			}
			case 4: {
				// Employees by department
				employeesByDepartment();
				break;
			}
			case 5: {
				// Search for employees
				searchForEmployees();
				break;
			}
			case 6: {
				// Payroll of all employees
				showPayroll();
				break;
			}
			case 7: {
				// Payroll in ascending order
				payrollAsc();
				break;
			}
			case 8: {
				// Payroll in descending order
				payrollDesc();
				break;
			}
			case 9: {
				// Delete employee
				deleteEmployee();
				break;
			}
			case 10: {
				System.out.println("GOODBYE!");
				System.exit(0);
			}
			default:
				System.out.println("THE NUMBER YOU ENTERED IS INVALID. PLEASE TRY AGAIN!");
			}
			System.out.print("\nENTER [1] TO DISPLAY THE FUNCTION MENU, ENTER [2] TO EXIT.");
			temp = cs.nextInt();
			if (temp == 1) {
				tiepTuc = true;
			} else {
				tiepTuc = false;
			}
		} while (tiepTuc);
		System.out.println("GOODBYE!");
	}

	// data to test
	public static void testData() {
		arrEmployee.add(new Employee(248, "NGUYEN VAN QUYET", 27, "HUMAN RESOUCES", 12, "12/08/2019", 15.5, 2));
		arrEmployee.add(new Employee(200, "NGUYEN VAN THANH", 25, "HUMAN RESOUCES", 12, "12/05/2017", 10, 1));
		arrEmployee.add(new Employee(223, "TRAN THI HUE", 27, "BUSINESS", 14, "12/08/2018", 12, 3));
		arrEmployee.add(new Employee(169, "TRAN THANH AN", 27, "BUSINESS", 5, "12/08/2014", 5.5, 5));
		arrEmployee.add(new Employee(242, "NGUYEN THI HIEN", 25, "MARKETING", 10, "12/08/2020", 15, 1));
		arrEmployee.add(new Manager(357, "NGUYEN ANH PHUONG", 35, "MARKETING", "BUSINESS LEADER", "12/08/2015", 18, 4));
		arrEmployee.add(new Manager(157, "TRAN VAN MAN", 27, "BUSINESS", "PROJECT LEADER", "12/08/2014", 15, 5));

	}

	// show menu
	static void showMenu() {

		System.out.println(
				"\n|--------------------------------------------------------------------------------------------------------|");
		System.out.println(
				"|************************************ HUMAN RESOURCE MANAGEMENT *****************************************|");
		System.out.println(
				"|--------------------------------------------------------------------------------------------------------|");
		System.out.println(
				"| MENU:                                                                                                  |");
		System.out.println(
				"|       [1] ADD NEW EMPLOYEES                              [6] DISPLAY PAYROLL                           |");
		System.out.println(
				"|       [2] DISPLAY LIST OF EMPLOYEES                      [7] DISPLAY PAYROLL IN ASCENDING ORDER        |");
		System.out.println(
				"|       [3] DISPLAY LIST OF DEPARTMENTS                    [8] DISPLAY PAYROLL IN DESCENDING ORDER       |");
		System.out.println(
				"|       [4] DISPLAY EMPLOYEES BY DEPARTMENT                [9] DELETE EMPLOYEE                           |");
		System.out.println(
				"|       [5] SEARCH EMPLOYEE                                [10]EXIT                                      |");
		System.out.println(
				"|________________________________________________________________________________________________________|");
		System.out.print("\n>> ENTER FUNCTION NUMBER: ");
	}

	// Display list of employees
	public static void displayAllEmployees() {
		System.out.println("\n\n                                           **********   EMPLOYEES LIST   **********");
		showTable();
		for (Staff nv : arrEmployee) {
			nv.displayInformation();
		}
		System.out.println(
				"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");
	}

	// Display list of departments in the company
	public static void displayAllDepartments() {
		System.out.println("\n  ********* LIST OF DEPARTMENTS *********");
		System.out.println("|_________________________________________|");
		System.out.println(String.format("|%5s|%16s|%18s|", "ID", "DEPARTMENT", "NUMBER OF EMPLOYEE"));
		System.out.println("|-----------------------------------------|");
		for (Department pb : arrDepartment)
			System.out.println(pb.toString());
		System.out.println("|_________________________________________|");
	}

	// Add new staff
	public static void addNewStaff() {
		int temp = 0;
		System.out.print("ENTER THE NUMBER OF EMPLOYEES TO ADD: ");
		temp = cs.nextInt();
		for (int i = 0; i < temp; i++) {

			int Etype;
			System.out.print("ENTER 1 TO ADD EMPLOYEE, 2 TO ADD MANAGER: ");
			Etype = cs.nextInt();

			switch (Etype) {
			case 1: {

				System.out.print("EMPLOYEE ID (000-999): ");
				int employeeID = idCheck();

				System.out.print("NAME: ");
				cs.nextLine();
				String employeeName = cs.nextLine().toUpperCase();

				System.out.print("AGE: ");
				int age = intValidCheck();

				// choose department
				boolean dvalid;
				String department = "";
				do {
					System.out.print("CHOOSE DEPARMENT (1 = HUMAN RESOUCES | 2 = BUSINESS | 3 = MARKETING): ");
					int temp0 = cs.nextInt();
					dvalid = false;
					switch (temp0) {
					case 1: {
						department = "HUMAN RESOUCES";
						arrDepartment.get(0).setNumberOfEmployee(arrDepartment.get(0).getNumberOfEmployee() + 1);
						break;
					}
					case 2: {
						department = "BUSINESS";
						arrDepartment.get(1).setNumberOfEmployee(arrDepartment.get(1).getNumberOfEmployee() + 1);
						break;
					}
					case 3: {
						department = "MARKETING";
						arrDepartment.get(2).setNumberOfEmployee(arrDepartment.get(2).getNumberOfEmployee() + 1);
						break;
					}
					default:
						System.out.println("THE NUMBER YOU ENTERED IS INVALID. PLEASE TRY AGAIN!");
						dvalid = true;
					}
				} while (dvalid);

				System.out.print("OVERTIME HOURS: ");
				int overTime = intValidCheck();

				System.out.print("DATE OF ENTERING (dd/mm/yyy): ");
				String enterDate = cs.next();

				System.out.print("ANNUAL LEAVE: ");
				double annualLeave = positiveValueCheck();

				System.out.print("SALARY COEFFICIENT: ");
				double salaryCoefficient = positiveValueCheck();

				arrEmployee.add(new Employee(employeeID, employeeName, age, department, overTime, enterDate,
						annualLeave, salaryCoefficient));
				System.out.println("SUCCESSFULLY ADDED NEW EMPLOYEE " + employeeName + "\n");

				break;
			}

			case 2: {
				System.out.print("EMPLOYEE ID (000-999): ");
				int employeeID = idCheck();

				System.out.print("NAME: ");
				cs.nextLine();
				String employeeName = cs.nextLine().toUpperCase();

				System.out.print("AGE: ");
				int age = intValidCheck();

				String department = "";
				boolean departmentValid;

				do {
					System.out.print("CHOOSE DEPARMENT (1 = HUMAN RESOUCES | 2 = BUSINESS | 3 = MARKETING): ");
					int temp0 = cs.nextInt();
					departmentValid = false;
					switch (temp0) {
					case 1: {
						department = "HUMAN RESOUCES";
						arrDepartment.get(0).setNumberOfEmployee(arrDepartment.get(0).getNumberOfEmployee() + 1);
						break;
					}
					case 2: {
						department = "BUSINESS";
						arrDepartment.get(1).setNumberOfEmployee(arrDepartment.get(1).getNumberOfEmployee() + 1);
						break;
					}
					case 3: {
						department = "MARKETING";
						arrDepartment.get(2).setNumberOfEmployee(arrDepartment.get(2).getNumberOfEmployee() + 1);
						break;
					}
					default:
						System.out.println("THE NUMBER YOU ENTERED IS INVALID. PLEASE TRY AGAIN!");
						departmentValid = true;
					}
				} while (departmentValid);

				boolean positionValid;
				String position = "";

				do {
					positionValid = false;
					System.out.print(
							"CHOOSE POSITION (1 = BUSINESS LEADER | 2 = PROJECT LEADER | 3 = TECHNICAL LEADER): ");
					int temp1 = cs.nextInt();
					switch (temp1) {
					case 1: {
						position = "BUSINESS LEADER";
						break;
					}
					case 2: {
						position = "PROJECT LEADER";
						break;
					}
					case 3: {
						position = "TECHNICAL LEADER";
						break;
					}
					default:
						System.out.println("THE NUMBER YOU ENTERED IS INVALID. PLEASE TRY AGAIN!");
						positionValid = true;
					}
				} while (positionValid);

				System.out.print("DATE OF ENTERING (dd/mm/yyy): ");
				String enterDate = cs.next();

				System.out.print("ANNUAL LEAVE: ");
				double annualLeave = positiveValueCheck();

				System.out.print("SALARY COEFFICIENT: ");
				double salaryCoefficient = positiveValueCheck();

				arrEmployee.add(
						new Manager(employeeID, employeeName, age, department, position, enterDate, annualLeave, salaryCoefficient));
				System.out.println("SUCCESSFULLY ADDED NEW MANAGER " + employeeName + "\n");
				break;
			}
			}
		}
	}

	// List of department
	public static void departments() {
		int numberEmployeeOfHR = 0;
		for (int i = 0; i < arrEmployee.size(); i++) {
			if (arrEmployee.get(i).getDepartment().equals("HUMAN RESOUCES"))
				numberEmployeeOfHR += 1;
		}

		int numberEmployeeOfBS = 0;
		for (int i = 0; i < arrEmployee.size(); i++) {
			if (arrEmployee.get(i).getDepartment().equals("BUSINESS"))
				numberEmployeeOfBS += 1;
		}

		int numberEmployeeOfMK = 0;
		for (int i = 0; i < arrEmployee.size(); i++) {
			if (arrEmployee.get(i).getDepartment().equals("MARKETING"))
				numberEmployeeOfMK += 1;
		}

		Department pB1 = new Department(001, "HUMAN RESOUCES", numberEmployeeOfHR);
		Department pB2 = new Department(002, "BUSINESS", numberEmployeeOfBS);
		Department pB3 = new Department(003, "MARKETING", numberEmployeeOfMK);

		arrDepartment.add(pB1);
		arrDepartment.add(pB2);
		arrDepartment.add(pB3);
	}

	// Display employee by department
	public static void employeesByDepartment() {

		for (Department bp : arrDepartment) {
			String department = bp.getDepartmentName();
			System.out.println(
					"\n\n                                        **** EMPLOYEE LIST OF " + department + " DEPARTMENT ****");
			showTable();
			for (Staff nv : arrEmployee) {
				if (nv.getDepartment().equals(department)) {
					nv.displayInformation();
				}
			}
			System.out.println(
					"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");

		}
	}
	

	// search employee by name or id
	public static void searchForEmployees() {
		System.out.print("SEARCH BY ( 1 - EMPLOYEE NAME | 2 - EMPLOYEE ID): ");
		int searchMethod = cs.nextInt();
		switch (searchMethod) {
		case 1: {
			// search by name
			boolean exist = true;
			System.out.print("ENTER NAME: ");
			cs.nextLine();
			String input = cs.nextLine().toUpperCase();
			System.out.println("\n\n                                                      *** SEARCH RESULT ***");
			showTable();
			for (int i = 0; i < arrEmployee.size(); i++) {
				if (input.equals(arrEmployee.get(i).getEmployeeName())) {
					exist = false;
					arrEmployee.get(i).displayInformation();
				}
			}

			if (exist == true)
				System.out.println(" NOT FOUND EMPLOYEE " + input);
			System.out.println(
					"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");
			break;
		}
		case 2: {
			// search by EMPLOYEE ID
			boolean khongTonTai = true;
			System.out.print("ENTER EMPLOYEE ID: ");
			int input = cs.nextInt();
			System.out.println("\n\n                                                      *** SEARCH RESULT ***");
			showTable();
			for (int i = 0; i < arrEmployee.size(); i++) {
				if (input == arrEmployee.get(i).getEmployeeID()) {
					khongTonTai = false;
					arrEmployee.get(i).displayInformation();
				}
			}
			if (khongTonTai == true)
				System.out.println(" NOT FOUND EMPLOYEE WITH ID " + input);
			System.out.println(
					"|___|____________________|_____|__________________|_________________|_____________|_____________|_____________|___________|_________________|");
			break;
		}
		default:
			System.out.println("THE NUMBER YOU ENTERED IS INVALID. PLEASE TRY AGAIN!");
		}
	}

	// delete employee
	public static void deleteEmployee() {
		System.out.print(" 1 - DELETE ONE EMPLOYEE | 2 - DELETE ALL EMPLOYEES");
		int deleteMethod = cs.nextInt();

		switch (deleteMethod) {
		case 1: {
			// delete one employee by id
			System.out.print("ENTER EMPLOYEE ID TO DELETE: ");
			int input = cs.nextInt();
			boolean notExist = true;
			for (int i = 0; i < arrEmployee.size(); i++) {
				if (input == arrEmployee.get(i).getEmployeeID()) {
					notExist = false;
					System.out.println("  |-EMPLOYEE WITH ID " + input + " IS: [" + arrEmployee.get(i).getEmployeeName()
							+ "] BELONG TO " + arrEmployee.get(i).getDepartment()+" DEPARTMENT.");
					System.out.print("  |-ARE YOU SURE YOU WANT TO DELETE? (1 - DELETE | 2 - CANCEL)");
					int tem = cs.nextInt();
					if (tem == 1) {
						System.out.print("  DELETE SUCCESSFUL " + arrEmployee.get(i).getEmployeeName());
						arrEmployee.remove(i);

						// Reduce the number of employees of each department
						for (Department pb : arrDepartment) {
							pb.setNumberOfEmployee(pb.getNumberOfEmployee() - 1);
						}
						i = arrEmployee.size();
					}

				}
			}
			if (notExist == true)
				System.out.println("[!] UNSUCCESSFUL! EMPLOYEE ID DOESN'T EXIST.");
			break;
		}
		case 2: {
			// Delete all employees
			System.out.print("  |-ARE YOU SURE YOU WANT TO DELETE? (1 - DELETE | 2 - CANCEL)");
			int tem = cs.nextInt();
			if (tem == 1)
				arrEmployee.clear();
			System.out.print("  DELETE SUCCESSFUL!");
			break;
		}

		}

	}

	// Payroll of all employees
	public static void showPayroll() {
		System.out.println("\n\n              ******* PAYROLL OF ALL EMPLOYEES  *******");
		System.out.println("|-------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%18s|%11s|%13s VND|", "ID", "NAME", "DEPARTMENT",
				"COEFFICIENT", "SALARY"));
		System.out.println("|-------------------------------------------------------------------------|");
		for (Staff nv : arrEmployee) {
			nv.payroll();
		}
		System.out.println("|___|____________________|__________________|___________|_________________|");
	}

	// Payroll in ascending order
	public static void payrollAsc() {
		System.out.println("\n\n               **** PAYROLL IN ASCENDING ORDER****");
		System.out.println("|-------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%18s|%11s|%13s VND|", "ID", "NAME", "DEPARTMENT",
				"COEFFICIENT", "SALARY"));
		System.out.println("|-------------------------------------------------------------------------|");

		@SuppressWarnings("unchecked")
		ArrayList<Staff> cloneArr = (ArrayList<Staff>) arrEmployee.clone();
		Collections.sort(cloneArr, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				if (o1.calculateSalary() > o2.calculateSalary()) {
					return 1;
				}
				if (o1.calculateSalary() < o2.calculateSalary()) {
					return -1;
				} else {
					return 0;
				}
			}

		});

		for (Staff nv : cloneArr) {
			nv.payroll();
		}
		System.out.println("|___|____________________|__________________|___________|_________________|");
	}

	// Payroll in descending order
	public static void payrollDesc() {
		System.out.println("\n\n               **** PAYROLL IN DESCENDING ORDER****");
		System.out.println("|-------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%18s|%11s|%13s VND|", "ID", "NAME", "DEPARTMENT",
				"COEFFICIENT", "SALARY"));
		System.out.println("|-------------------------------------------------------------------------|");

		@SuppressWarnings("unchecked")
		ArrayList<Staff> cloneArr = (ArrayList<Staff>) arrEmployee.clone();
		Collections.sort(cloneArr, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				if (o1.calculateSalary() > o2.calculateSalary()) {
					return -1;
				}
				if (o1.calculateSalary() < o2.calculateSalary()) {
					return 1;
				} else {
					return 0;
				}
			}

		});

		for (Staff nv : cloneArr) {
			nv.payroll();
		}
		System.out.println("|___|____________________|__________________|___________|_________________|");
	}

	// Form table
	static // show table
	void showTable() {
		System.out.println(
				"|-------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println(String.format("|%3s|%20s|%5s|%18s|%17s|%13s|%13s|%13s|%11s|%13s VND|", "ID", "NAME",
				"AGE", "DEPARTMENT", "POSITION", "ENTER DATE", "ANNUAL LEAVE", "OT HOURS", "COEFFICIENT",
				"SALARY"));
		System.out.println(
				"|-------------------------------------------------------------------------------------------------------------------------------------------|");
	}

	// int value check
	public static int intValidCheck() {
		boolean temp = false;
		int num = 0;
		do {
			num = cs.nextInt();
			if (num <= 0) {
				temp = true;
				System.out.println("NUMBER MUST BE POSITIVE INTEGER! TRY AGAIN!");
			} else {
				temp = false;
			}
		} while (temp);

		return num;
	}

	// positive value check
	public static double positiveValueCheck() {
		boolean temp = false;
		double num = 0;
		do {
			num = cs.nextDouble();
			if (num <= 0) {
				System.out.println("NUMBER MUST BE GREATER THAN 0! TRY AGAIN!");
				temp = true;
			} else {
				temp = false;
			}
		} while (temp);
		return num;
	}

	// check if employee id already exists
	public static int idCheck() {
		boolean temp = false;
		int input = 0;
		do {
			input = cs.nextInt();
			for (int i = 0; i < arrEmployee.size(); i++) {
				if (input == arrEmployee.get(i).getEmployeeID()) {
					temp = true;
					System.out.println("EMPLOYEE ID ALREADY EXISTS! TRY GAIN");
					i = arrEmployee.size();
				} else {
					temp = false;
				}
			}
		} while (temp);

		return input;
	}

}
