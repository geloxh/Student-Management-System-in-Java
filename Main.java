package PBL5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int ch, d, mo, y, i;
        long p;
        float[] m = new float[5];
        String n;

        Scanner input = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        System.out.println("Choose the Number to Perform an Action: ");
        System.out.println("1. Add Student \n2. Display List \n3. Search by ID No. \n4. Search by Name \n5. Search by Position \n6. Update/Edit List \n7. Delete \n8. Display Sorted List \n9. Display Count by Mark Range \n10. Exit");

        boolean quit = false;
        while (!quit) {
            System.out.print("Enter your choice: ");
            ch = input.nextInt();
            input.nextLine(); // Consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    n = input.nextLine();

                    System.out.print("ID No.: ");
                    p = input.nextLong();

                    boolean exists = false;
                    for (Student student : list) {
                        if (student.idNum == p) {
                            System.out.println("ID No. Already Exists...");
                            exists = true;
                            break;
                        }
                    }
                    if (exists) break;

                    System.out.print("Enter 5 Subject Grades (out of 100): ");
                    for (i = 0; i < 5; i++) {
                        m[i] = input.nextFloat();
                    }

                    System.out.print("Enter DOB (Day, Month, Year): ");
                    d = input.nextInt();
                    mo = input.nextInt();
                    y = input.nextInt();

                    Student ob = new Student(m, p, n, d, mo, y);
                    ob.calcTotal();
                    list.add(ob);
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No students in the list.");
                    } else {
                        System.out.println("Student List:");
                        for (Student student : list) {
                            student.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID No. to Search: ");
                    long s = input.nextLong();
                    boolean found = false;

                    for (Student student : list) {
                        if (student.idNum == s) {
                            System.out.println("Student Found:");
                            student.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter Student Name to Search: ");
                    String searchName = input.nextLine();
                    boolean nameFound = false;

                    for (Student student : list) {
                        if (student.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Student Found:");
                            student.display();
                            nameFound = true;
                        }
                    }
                    if (!nameFound) System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.print("Enter Position (starting from 1): ");
                    int pos = input.nextInt() - 1;

                    if (pos >= 0 && pos < list.size()) {
                        System.out.println("Student at Position " + (pos + 1) + ":");
                        list.get(pos).display();
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;

                case 6:
                    System.out.print("Enter ID No. to Update: ");
                    long updateId = input.nextLong();
                    boolean updated = false;

                    for (Student student : list) {
                        if (student.idNum == updateId) {
                            student.update();
                            System.out.println("Updated Student Info:");
                            student.display();
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) System.out.println("Student not found.");
                    break;

                case 7:
                    System.out.print("Enter ID No. to Delete: ");
                    long deleteId = input.nextLong();
                    boolean deleted = false;

                    for (i = 0; i < list.size(); i++) {
                        if (list.get(i).idNum == deleteId) {
                            list.remove(i);
                            System.out.println("Student deleted successfully.");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) System.out.println("Student not found.");
                    break;

                case 8:
                    if (list.isEmpty()) {
                        System.out.println("No students to sort.");
                    } else {
                        list.sort(Comparator.comparingDouble(s1 -> -s1.t));
                        System.out.println("Sorted List (Descending Order by Total Marks):");
                        for (Student stu : list) {
                            System.out.println(stu.name + " :\t" + stu.t);
                        }
                    }
                    break;

                case 9:
                    int[] count = new int[4];
                    for (Student student : list) {
                        if (student.t > 80) count[0]++;
                        else if (student.t > 60) count[1]++;
                        else if (student.t > 40) count[2]++;
                        else count[3]++;
                    }
                    System.out.println("Students Count by Marks Range:");
                    System.out.println("A (81-100): " + count[0]);
                    System.out.println("B (61-80) : " + count[1]);
                    System.out.println("C (41-60) : " + count[2]);
                    System.out.println("F (Failed): " + count[3]);
                    break;

                case 10:
                    quit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1-10.");
            }
        }
        input.close();
    }
}
