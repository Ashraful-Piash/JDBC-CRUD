package com.piash;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
//        student.createDatabase();
//        student.createTable();
//        student.createData();
//        student.readData();
//        student.updateData();
        student.deleteData();

    }
}
