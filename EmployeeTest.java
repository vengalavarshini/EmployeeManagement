package demo;

import java.util.Scanner;
public class EmployeeTest {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		Attendance attendance = new Attendance();
		Salary salary = new Salary();
		int choice;
		do {
			System.out.println("\n=========================");
			System.out.println("EMPLOYEE ATTENDANCE & PAYROLL SYSTEM");
			System.out.println("\n=========================");
			System.out.println("1.Enter Employee Details");
			System.out.println("2. Calculate Attendance");
			System.out.println("3. Calculate Salary");
			System.out.println("4. Display Employee Deatils");
			System.out.println("5. Exist");
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("\n---Enter Employee Details----");
				System.out.println("Enter Employee ID: ");
				employee.employeeId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter employee Name: ");
				employee.employeeName = sc.nextLine();
				System.out.println("\nSelect Departement:");
				System.out.println("1. IT");
				System.out.println("2. HR");
				System.out.println("3. Finance");
				System.out.println("/4. Marketing");
				System.out.println("Enter Department Choice: ");
				employee.departmentChoice = sc.nextInt();
				switch(employee.departmentChoice)
				{
				case 1:
					employee.department = "IT";
					break;
				case 2:
					employee.department = "HR";
					break;
				case 3:
					employee.department = "Finance";
					break;
				case 4:
					employee.department = "Marketing";
					break;
				default:
					employee.department = "Unknown";
					System.out.println("Invaild department choice.");
					
					
				}
				System.out.println("Enter Basic Salary: ");
				employee.basicSalary = sc.nextDouble();
				if(employee.basicSalary > 0)
				{
					System.out.println("Employee Details entered successfully.");
				}
				else {
					System.out.println("Invaild salary . Salary must be greater than Zero . ");
				}
				break;	
			case 2:
				System.out.println("\n--- ATTENDANCE CALACUATION---");
				System.out.println("Enter Total Working days:");
				attendance.totalWorkingDays = sc.nextInt();
				if (attendance.totalWorkingDays >0)
				{
					attendance.presentDays = 0;
					attendance.absentDays = 0;
					for(int day = 1; day<=attendance.totalWorkingDays;day++)
					{
						System.out.println("Day " + day + "- Enter 1 for Present , 0 for absent: ");
						attendance.attendance = sc.nextInt();
						if(attendance.attendance == 1)
						{
							attendance.presentDays++;
						}else if (attendance.attendance == 0) {
							attendance.absentDays++;
						}else {
							System.out.println("Invaild input . Enter only 1 or 0.");
						}
					}
					attendance.attendancePercentage = ((double)attendance.presentDays / attendance.totalWorkingDays)*100;
					System.out.println("\nPresnt Days : " + attendance.presentDays);
					System.out.println("Absent Days : " + attendance.absentDays);
					System.out.println("Attendance % : " + attendance.attendancePercentage + "%");
					if(attendance.attendancePercentage >= 75)
					{
					   System.out.println("Attendance Status : Eligible");
					}else {
						System.out.println("Attendance Status :  Not Eligible");
					}
				}else {
					System.out.println("Working Days must be greater than zero");
				}
				break;
			case 3:
				System.out.println("\n--SALARY CALACUATION---");
				if(employee.basicSalary >0) {
					if(attendance.totalWorkingDays >0) {
						if(attendance.attendancePercentage >=90)
						{
							salary.incentive = employee.basicSalary * 0.10;
							salary.finalSalary = employee.basicSalary + salary.incentive;
							System.out.println("Attendance Category : Execellent");
							System.out.println("Attendance Incentive : 10%");
						}else if(attendance.attendancePercentage >=75) {
							salary.incentive = 0;
							salary.deduction = 0 ;
							salary.finalSalary = employee.basicSalary;
							System.out.println("Attendance Category : Good");
							System.out.println("Attendance Incentive : 0%");
						}else {
							salary.deduction=employee.basicSalary * 0.10;
							salary.finalSalary = employee.basicSalary - salary.deduction;
						
						}
						System.out.println("Basic Salary : Rs." + employee.basicSalary);
						System.out.println("Final Salary : Rs." + salary.finalSalary);
					}else {
							System.out.println("Please calcuate attendance first.");
						}
					}else {
						System.out.println("Please enter valid employee details first.");
					}
				break;
			case 4:
				System.out.println("\n--EMPLOYEE DETAILS---");
				if(employee.employeeId !=0) {
					System.out.println("Employee ID : " + employee.employeeId);
					System.out.println("Employee Name : " + employee.employeeName);
					System.out.println("Department : " + employee.department);
					System.out.println("Basic Salary : " + employee.basicSalary);
					System.out.println("Present Days : " + attendance.presentDays);
					System.out.println("Absent Days : " + attendance.absentDays);
					System.out.println("Attendance % : " + attendance.attendancePercentage + "%");
					System.out.println("Final Salary : " + salary.finalSalary);
				}else {
					System.out.println("No employee deatils availble.");
				}
				break;
			case 5:
				System.out.println("\nThankYou for Using the system *-*.");
				break;
				
				
			default:
				System.out.println("Invaild");
	
		}
	
		}while(choice !=5);
		sc.close();
		
	}

}