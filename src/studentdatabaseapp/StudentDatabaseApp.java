package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("How many student would you like to enroll?");
		Student[] students = new Student[in.nextInt()];
		
		for(int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();
		}
		for(Student i : students) {
			System.out.println(i.toString());
		}
	}

}
