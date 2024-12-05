/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class studentManagements {

    public static void main(String[] args) {
        StudentManagement.studentManagements list = new studentManagements();
        Scanner sc = new Scanner(System.in);
        int menu, i = 0;

        while (i == 0) {
            System.out.println(">>>>>     Selectable Menu     <<<<<");
            System.out.println("1. Enter Student List Information");
            System.out.println("2. Display Student List Information");
            System.out.println("3. Sort Student List by Grades");
            System.out.println("4. Search for Student Information");
            System.out.println("5. Edit Student Information");
            System.out.println("6. Delete Student Information");
            System.out.println("7. Exit Program");
            System.out.print("Please enter your choice: ");

            menu = sc.nextInt();    
            System.out.println("");

            switch (menu) {
                case 1:
                    System.out.print("Please enter the number of students to add to the list: ");
                    int n = sc.nextInt();
                    list.InsertListStudent(n);
                    System.out.println("Students added successfully.");
                    break;
                case 2:
                    if (list.dataStudents.isEmpty()) {
                        System.out.println(">>  !!!!!!!!!The list is empty!!!!!!  <<");
                    } else {
                        sc.nextLine(); // Clear the buffer
                        list.DisplayListStudent(list.dataStudents);
                    }
                    break;
                case 3:
                    list.SortingCore(list.dataStudents);
                    System.out.println("The list has been sorted.");
                    break;
               
                case 4:
                    sc.nextLine(); 
                    System.out.println("Please enter the name of the student to search for: ");
                    String a = sc.nextLine();
                    list.SearchListStudent(list.dataStudents, a);
                    break;
                case 5:
                    sc.nextLine(); 
                    System.out.println("Enter the name of the student to edit: ");
                    String editName = sc.nextLine();
                    list.EditListStudent(editName);
                    break;
                case 6:
                    sc.nextLine(); 
                    System.out.println("Enter the name of the student to delete: ");
                    String deleteName = sc.nextLine();
                    list.DeleteListStudent(deleteName);
                    break;
                case 7:
                    i = 1;
                    System.out.println("You have exited the program.");
                    break;
                default:
                    System.out.println("!!!!!!!!!!Your choice is not valid!!!!!!!!!!!");
            }
        }
        sc.close(); 
    }

    ArrayList<Student> dataStudents = new ArrayList<>(); 

    public void InsertListStudent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Enter information for students " + (i + 1));
            Student students = new Student();
            students.InsertStudent();
            dataStudents.add(students);
        }
    }

    public void DisplayListStudent(ArrayList<Student> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).DisplayStudent();
        }
    }

    public void SortingCore(ArrayList<Student> arrStudent) {
        for (int i = 0; i < arrStudent.size(); i++) {
            for (int j = 0; j < arrStudent.size(); j++) {
                if (arrStudent.get(i).getScoreStudent() 
                        < arrStudent.get(j).getScoreStudent()) {
                    Student students = new Student();
                    students = arrStudent.get(i);
                    arrStudent.set(i, arrStudent.get(j));
                    arrStudent.set(j, students);
                }
            }
        }
    }
    
    public void EditListStudent(String name) {
        for (Student student : dataStudents) {
            if (student.getNameStudent().equalsIgnoreCase(name)) {
                System.out.println("Enter information new for students " + name);
                student.InsertStudent();
                System.out.println("Edit student information name: " + name);
                return;
            }
        }
        System.out.println("Can't find student name: " + name);
    }

    public void DeleteListStudent(String name) {
        boolean removed = dataStudents.removeIf(student -> student.getNameStudent().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Student name deleted: " + name);
        } else {
            System.out.println("Can't find student name: " + name);
        }
    }

    public void SearchListStudent(ArrayList<Student> arr, String name) {
        int j = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getNameStudent().lastIndexOf(name) >= 0) {
                arr.get(i).DisplayStudent();
                j = 1;
            }
        }
        if (j == 0) {
            System.out.println("!!!!!1No information of "
                    + "the student you are looking for!!!!!!!!!!!");
        }
    }
}
