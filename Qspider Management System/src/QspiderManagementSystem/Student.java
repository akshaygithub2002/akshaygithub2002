package QspiderManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class Student {
    private Connection connection;
    private Scanner scanner;

    public Student(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addStudent(){
        System.out.print("Enter Student Name: ");
        String name = scanner.next();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Student Gender: ");
        String gender = scanner.next();

        try{
            String query = "INSERT INTO students(name, age, gender) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("Student Added Successfully!!");
            }else{
                System.out.println("Failed to add Student!!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewStudent(){
        String query = "select * from Students";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Students: ");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("| Student Id | Name               | Age      | Gender     |");
            System.out.println("+------------+--------------------+----------+------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", id, name, age, gender);
                System.out.println("+------------+--------------------+----------+------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getStudentById(int id){
        String query = "SELECT * FROM students WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}