/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagement;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Student {

    private String nameStudent;
    private String addressStudent;
    private int yearStudent;
    private String idStudent;
    private float scoreStudent;

    public void InsertStudent() {
        Scanner insert = new Scanner(System.in);
        System.out.print("1. Enter your name student: ");
        nameStudent = insert.nextLine();
        System.out.print("2. Enter your number id of student: ");
        idStudent = insert.nextLine();
        System.out.print("3. Enter your year of student: ");
        yearStudent = insert.nextInt();
        insert.nextLine();
        System.out.print("4. Enter your address of student: ");
        addressStudent = insert.nextLine();
        System.out.print("5. Enter your score of student: ");
        scoreStudent = insert.nextFloat();
        System.out.println();

    }

    public void DisplayStudent() {
        System.out.println(">>>>>     Student List     <<<<<");
        System.out.println("Full Name: " + nameStudent);
        System.out.println("Student ID: " + idStudent);
        System.out.println("Address: " + addressStudent);
        System.out.println("Year of Birth: " + yearStudent);
        System.out.println("Score: " + scoreStudent);
        System.out.println();
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getAddressStudent() {
        return addressStudent;
    }

    public void setAddressStudent(String addressStudent) {
        this.addressStudent = addressStudent;
    }

    public int getYearStudent() {
        return yearStudent;
    }

    public void setYearStudent(int yearStudent) {
        this.yearStudent = yearStudent;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public float getScoreStudent() {
        return scoreStudent;
    }

    public void setScoreStudent(float scoreStudent) {
        if (scoreStudent >= 0 && scoreStudent <= 10) {
            this.scoreStudent = scoreStudent;
        } else {
            System.out.println("Invalid score!!!! Please re-enter score in the range 0-10.");
        }
    }

}
