package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName, lastName, courses, studentId;
	private int tuitionBalance, year;
	private final static int courseCost = 600;
	private static int[] id = { 0, 0, 0, 0 };

	public Student() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		firstName = in.nextLine();

		System.out.print("Enter student's last name: ");
		lastName = in.nextLine();

		System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter number correspoding to grade:");
		year = in.nextInt();
		setStudentId();

		System.out.println(firstName + " " + lastName + ", year " + year + "\nID: " + studentId);
	}

	public void enroll() {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Enter course to enroll (Q to quit): ");
			String course = in.nextLine();
			if (!course.equalsIgnoreCase("q")) {

				if (courses == null) {
					courses = course;
				} else {
					courses = courses + "\n" + course;
				}

				tuitionBalance += courseCost;
			} else {
				break;
			}

		} while (true);
		System.out.println("Enrolled in:\n" + courses);
		viewTuitionBalance();
	}

	public String getCourses() {
		return courses;
	}

	public void viewTuitionBalance() {
		System.out.println("Current Balance is $" + tuitionBalance);
	}

	public void payTuition() {
		viewTuitionBalance();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter payment amount: ");
		int payment = in.nextInt();
		tuitionBalance -= payment;

		if (tuitionBalance > 0) {
			System.out.println("Your payment of $" + payment + " has been proccesed.");
			viewTuitionBalance();
		} else if (tuitionBalance == 0) {
			System.out.println("Your payment of $" + payment + " has been proccesed.");
			System.out.println("\nYou have paid off entire balance. Enjoy your semester!");
			viewTuitionBalance();
		} else {
			System.out.println("Your payment of $" + payment + " has been proccesed.");
			System.out.println("\nYou have paid off entire balance. Enjoy your semester!");
			System.out.println("Refund Avaliable : $" + Math.abs(tuitionBalance));
			tuitionBalance = 0;
		}

	}
	
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nYear " + year +  
				"\nStudent ID: " + studentId +"\nEnrolled Courses:\n" + courses + "\nTuition Balance: $"+
				tuitionBalance;
	}

	public String getStudentId() {
		return studentId;
	}

	private void setStudentId() {
		id[year]++;
		this.studentId = ((year * 1000) + id[year]) + "";
	}

}
