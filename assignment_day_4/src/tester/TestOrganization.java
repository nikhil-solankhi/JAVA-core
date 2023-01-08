package tester;

import java.util.Scanner;

import com.app.org.Emp;
import com.app.org.Mgr;
import com.app.org.Worker;

import custom_exception.EmpNotFoundExc;
import validation.ValidateEmpId;

public class TestOrganization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many employees you want to hire");
		Emp[] emp = new Emp[sc.nextInt()];
		int counter = 0, choice = 0, index = 0;
		String fname, lname;
		int deptno, id;
		double perfBonus, basic, hourlyRate;
		float hoursWorked;
		boolean flagName = false, exit = false;
		int size = emp.length;
		System.out.println("Select from below menu");

		do {
			System.out.println("========================================================================"
					+ "\n1.Hire Manager" + "\n2.Hire Worker" + "\n3.Display all employees details" + "\n4.Update Salary"
					+ "\n5.Compute Net Salary" + "\n6.Validate Name" + "\n10.Exit Console Application"
					+ "\n========================================================================");
			try {
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter manager details");
					System.out.println("First Name");
					fname = sc.next();
					System.out.println("Last Name");
					lname = sc.next();
//					if (Emp.getCount()>1000) {
//						if (ValidateEmpId.nameValidate(fname, lname, emp)) {
//						}
//					}
					System.out.println("Dept No");
					deptno = sc.nextInt();
					System.out.println("Basic Salary");
					basic = sc.nextDouble();
					System.out.println("Performance Bonus");
					perfBonus = sc.nextDouble();
					emp[counter] = new Mgr(fname, lname, deptno, basic, perfBonus);
					System.out.println("Manager Hired");
					counter++;
					System.out.println("========================================================================");
					break;
				case 2:
					System.out.println("Enter manager details");
					System.out.println("First Name");
					fname = sc.next();
					System.out.println("Last Name");
					lname = sc.next();
//					if (Emp.getCount()>1000) {
//						if (ValidateEmpId.nameValidate(fname, lname, emp)) {
//						}
//					}
					System.out.println("Dept No");
					deptno = sc.nextInt();
					System.out.println("Basic Salary");
					basic = sc.nextDouble();
					System.out.println("Hours Worked");
					hoursWorked = sc.nextFloat();
					System.out.println("Hourly Rate");
					hourlyRate = sc.nextDouble();
					emp[counter] = new Worker(fname, lname, deptno, basic, hoursWorked, hourlyRate);
					System.out.println("Worker Hired");
					counter++;
					System.out.println("========================================================================");
					break;
				case 3:
					System.out.println("Displaying all employes details");
					for (int i = 0; i < counter; i++) {
						System.out.println(emp[i].toString());
					}
					System.out.println("========================================================================");
					break;
				case 4:
					System.out.println("Update employee basic salary");

					System.out.println("Enter Employee ID");
					id = sc.nextInt();
					index = ValidateEmpId.EmpIdValidate(id, emp);
					System.out.println("Enter amount by which you want to calculate salary");
					double incsal = sc.nextDouble();
					emp[index].setBasic(emp[index].getBasic() + incsal);
					System.out.println("Salary of " + emp[index].getFirstname() + " has been updated by " + incsal
							+ ", Net Salary: " + emp[index].getBasic());
					System.out.println("========================================================================");

					break;
				case 5:
					System.out.println("Compute Net Salary");

					System.out.println("Enter Employee ID");
					id = sc.nextInt();
					index = ValidateEmpId.EmpIdValidate(id, emp);
					System.out.println(emp[index].getFirstname() + "'s net salary is " + emp[index].computeNetSal());
					System.out.println("========================================================================");
					break;
				case 6:
					System.out.println("First Name");
					fname = sc.next();
					System.out.println("Last Name");
					lname = sc.next();
					if (ValidateEmpId.nameValidate(fname, lname, emp)) {
					}
					break;
				case 10:
					exit = true;
					break;
				default:
					System.out.println("Invalid Choice");
					System.out.println("========================================================================");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("========================================================================");
			}

		} while (!exit);
		System.out.println("========================================================================");
	}
}
