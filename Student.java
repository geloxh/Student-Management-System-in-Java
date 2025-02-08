package PBL5;

import java.util.Scanner;

public class Student {
    float[] m;
    float t;
    long idNum;
    String name;
    DOB date;

    public Student(float[] ma, long idNum, String name, int d, int mo, int y) {
        this.m = ma.clone();  // Ensuring array immutability
        this.idNum = idNum;
        this.name = name;
        this.date = new DOB(d, mo, y);  // Initializing DOB object
        this.t = calcTotal();  // Calculating initial total
    }

    public float calcTotal() {
        t = 0;
        for (float mark : m) {
            t += mark;  // Summing up marks
        }
        t /= m.length; // Calculating average
        return t;
    }

    public void display() {
        System.out.println("\nName: " + name + "\nID No.: " + idNum + "\nAverage Marks: " + t);
        System.out.println("DOB: " + date.d + "/" + date.mo + "/" + date.y);
    }

    public void update() {
        Scanner input = new Scanner(System.in);

        System.out.print("Do you want to update Name? (y/n): ");
        String a = input.next();
        if (a.equalsIgnoreCase("y")) {
            System.out.print("Enter the new name: ");
            input.nextLine(); // Clear buffer
            name = input.nextLine();  // Updating name
            System.out.println("Student name has been successfully updated.");
        }

        System.out.print("Do you want to update Marks? (y/n): ");
        a = input.next();
        if (a.equalsIgnoreCase("y")) {
            System.out.println("Enter the new set of Marks:");
            for (int i = 0; i < m.length; i++) {
                m[i] = input.nextFloat();  // Updating marks
            }
            System.out.println("Student marks updated.");
            t = calcTotal();  // Recalculating total
        }
    }
}

// Separate class for DOB
class DOB {
    int d, mo, y;

    public DOB(int d, int mo, int y) {
        this.d = d;
        this.mo = mo;
        this.y = y;
    }
}
