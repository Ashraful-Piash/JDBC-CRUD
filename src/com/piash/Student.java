package com.piash;

import java.sql.*;

public class Student {
    //load driver
    //connection establish
    //statement create
    //execute query
    //connection close
    public void createDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String passWord = "Piash328911*#*";

            Connection con = DriverManager.getConnection(url, userName, passWord);
            Statement statement = con.createStatement();
            String query ="create database codingwalah";
            statement.execute(query);
            System.out.println("established");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not created");
        }

    }

    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/codingwalah";
            String userName = "root";
            String passWord = "Piash328911*#*";

            Connection con = DriverManager.getConnection(url, userName, passWord);
            Statement statement = con.createStatement();
            String query ="create table student (sid int(3),sname varchar(200),semail varchar(200))";
            statement.execute(query);
            System.out.println("established");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not created");
        }

    }

    public void createData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "codingwalah";
            String userName = "root";
            String passWord = "Piash328911*#*";

            Connection con = DriverManager.getConnection(url+db, userName, passWord);
//            Statement statement = con.createStatement();
            String query ="INSERT into student (sid, sname, semail) VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,11);
            preparedStatement.setString(2,"piash");
            preparedStatement.setString(3,"piash@gmail.com");
            preparedStatement.execute();
            System.out.println("created data");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not created");
        }

    }

    public void readData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "codingwalah";
            String userName = "root";
            String passWord = "Piash328911*#*";

            Connection con = DriverManager.getConnection(url+db, userName, passWord);

            String query ="select * from student";
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setInt(1,11);
//            preparedStatement.setString(2,"ashraful");
//            preparedStatement.setString(3,"ashrafulpiash@gmail.com");
            Statement statement = con.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println("id: " +resultSet.getInt(1));
                System.out.println("Name : "+resultSet.getString(2));
                System.out.println("email: "+resultSet.getString(3));

            }
            System.out.println("Got the data");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not created");
        }
    }

    public void updateData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "codingwalah";
            String userName = "root";
            String passWord = "Piash328911*#*";

            Connection con = DriverManager.getConnection(url+db, userName, passWord);
//            Statement statement = con.createStatement();
            String query = "UPDATE student SET sid = ? WHERE sname = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1,12);
            preparedStatement.setString(2,"piash");

            preparedStatement.executeUpdate();
            System.out.println("updated");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not created");
        }
    }

    public void deleteData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "codingwalah";
            String userName = "root";
            String passWord = "Piash328911*#*";

            Connection con = DriverManager.getConnection(url+db, userName, passWord);
//            Statement statement = con.createStatement();
            String query ="DELETE FROM student  where sid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,12);
            preparedStatement.executeUpdate();
            System.out.println("Deleted");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not created");
        }
    }
}

