import java.util.Scanner;

public class Student_Grade_Calculator{
    public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("How many subjects do you have?");
		int numOfSubjects = sc.nextInt();
		
		if(numOfSubjects <=0) {
			System.err.println("Invalid number of subjects.");
			return;
		}
		String[] subjects = new String[numOfSubjects];
		double []marks = new double[numOfSubjects];
		double totalMarks =0.0;
		
		sc.nextLine();
		for(int i=0; i< numOfSubjects; i++) {
			
		System.out.println("Enter the subject name"+(i+1)+":");
		subjects[i]= sc.nextLine();
			
			
		System.out.println("Enter marks for subject"+(i+1)+"(out of 100)");
		marks[i]=sc.nextDouble();
		sc.nextLine();
		
		
		if(marks[i]<0 || marks [i]>100 ) {
			System.err.println("Marks must be between 0 and 100.");
			return;
		}
		totalMarks+=marks[i];
		}
		
		double averagePercentage=totalMarks/numOfSubjects;
		
		String grade;
		if(averagePercentage>=90) {
			grade="A+";
		}
		else if (averagePercentage>=80) {
			grade="A";
		}
		else if(averagePercentage>=70) {
			grade="B";
		}
		else if(averagePercentage>=60) {
			grade="C";
		}
		else if(averagePercentage>=50) {
			grade="D";
		}
		else {
			grade="F";//fail
		}
		System.out.println("\nThe Result Is:");
		System.out.println("Totyal Marks Obtained:"+totalMarks);
		System.out.println("Average Percentage:"+averagePercentage);
		System.out.println("Grade:"+grade);
		sc.close();
	}
}