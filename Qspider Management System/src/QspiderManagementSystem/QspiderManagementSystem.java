package QspiderManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class QspiderManagementSystem {
    private static final String url = "jdbc:mysql://localhost:3306/qspider";
    private static final String username = "root";
    private static final String password = "root";
	


    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Student student = new Student(connection, scanner);
            Trainer trainer = new Trainer(connection);
            while(true){
                System.out.println("Qspider MANAGEMENT SYSTEM ");
                System.out.println("1. Add student");
                System.out.println("2. View student");
                System.out.println("3. View Trainer");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        // Add Patient
                        student.addStudent();
                        System.out.println();
                        break;
                    case 2:
                        // View Patient
                    	 student.viewStudent();
                        System.out.println();
                        break;
                    case 3:
                        // View Doctors
                        trainer.viewTrainer();
                        System.out.println();
                        break;
                    case 4:
                        // Book Appointment
                        bookAppointment(student, trainer, connection, scanner);
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("THANK YOU! FOR USING Qspider MANAGEMENT SYSTEM!!");
                        return;
                    default:
                        System.out.println("Enter valid choice!!!");
                        break;
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static void bookAppointment(Student student, Trainer trainer, Connection connection, Scanner scanner){
        System.out.print("Enter Student Id: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Trainer Id: ");
        int trainerId = scanner.nextInt();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();
        if(student.getStudentById(studentId) && trainer.getTrainerById(trainerId)){
            if(checkTrainerAvailability(trainerId, appointmentDate, connection)){
                String appointmentQuery = "INSERT INTO appointments(student_id, trainer_id, appointment_date) VALUES(?, ?, ?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1, studentId);
                    preparedStatement.setInt(2, trainerId);
                    preparedStatement.setString(3, appointmentDate);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected>0){
                        System.out.println("Appointment Booked!");
                    }else{
                        System.out.println("Failed to Book Appointment!");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("trainer not available on this date!!");
            }
        }else{
            System.out.println("Either trainer or student doesn't exist!!!");
        }
    }
   

//    private static boolean checkTrainerAvailability(int trainerId2, String appointmentDate, Connection connection) {
//		// TODO Auto-generated method stub
//		return false;
//	}


	public static boolean checkTrainerAvailability(int trainerId, String appointmentDate, Connection connection){
        String query = "SELECT COUNT(*) FROM appointments WHERE trainer_id = ? AND appointment_date = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, trainerId);
            preparedStatement.setString(2, appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                if(count==0){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}