package collproj;


	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;

	public class objdev {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter Student ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Tuition Fee: ");
	            double tuition = sc.nextDouble();

	            System.out.print("Enter Hostel Fee: ");
	            double hostel = sc.nextDouble();

	            Collegestudent student = new Collegestudent(id, name, tuition, hostel);
	            student.displayDetails();

	            double totalFee = student.calculateFee();

	            System.out.print("Enter Amount Paid: ");
	            double paid = sc.nextDouble();

	            if (paid < totalFee) {
	                throw new InvalidPaymentException("Payment is less than total fee!");
	            }

	            saveToFile(student, paid);
	            System.out.println("Payment successful. Receipt saved.");

	        } catch (InvalidPaymentException e) {
	            System.out.println("Error: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("File error occurred.");
	        } catch (Exception e) {
	            System.out.println("Invalid input!");
	        } finally {
	            sc.close();
	        }
	    }

	    // FILE HANDLING
	    public static void saveToFile(Collegestudent student, double paid) throws IOException {
	        FileWriter fw = new FileWriter("receipt.txt", true);
	        fw.write("----- Fee Receipt -----\n");
	        fw.write("Student ID: " + student.studentId + "\n");
	        fw.write("Name: " + student.name + "\n");
	        fw.write("Paid Amount: ₹" + paid + "\n");
	        fw.write("-----------------------\n\n");
	        fw.close();
	    }
	}


