package collproj;

public class Collegestudent extends student implements paymen {


    private double tuitionFee;
    private double hostelFee;

    public Collegestudent(int id, String name, double tuitionFee, double hostelFee) {
        super(id, name);
        this.tuitionFee = tuitionFee;
        this.hostelFee = hostelFee;
    }

    @Override
    public double calculateFee() {
        return tuitionFee + hostelFee;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Total Fee: ₹" + calculateFee());
    }
}
