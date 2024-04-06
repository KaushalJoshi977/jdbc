package dao;

import config.JDBCconfig;
import models.Student;

import java.sql.*;

public class studentDao {
    public static boolean insertStudentDB(Student st) {

        boolean f=false;

        try {

            Connection connection = JDBCconfig.create();





            String qString = "insert into students(sname,sphone,scity) values(?,?,?)";



            PreparedStatement pstmt = connection.prepareStatement(qString);



            pstmt.setString(1, st.getStudentName());

            pstmt.setString(2, st.getStudentPhone());

            pstmt.setString(3, st.getStudentCity());



            pstmt.executeUpdate();



            f=true;

        } catch (SQLException e) {

            // TODO: handle exception

            e.printStackTrace();

        }

        return f;

    }



    //Delete Student

    public static boolean deleteStudent(int userId) {

        boolean f=false;

        try {

            Connection connection = JDBCconfig.create();





            String qString = "delete from student where sid = ?";



            PreparedStatement pstmt = connection.prepareStatement(qString);



            pstmt.setInt(1, userId);



            pstmt.executeUpdate();



            f=true;

        } catch (SQLException e) {

            // TODO: handle exception

            e.printStackTrace();

        }

        return f;



    }



    //Get Student

    public static boolean showAllStudent() {

        boolean f=false;

        try {

            Connection connection = JDBCconfig.create();





            String qString = "select * from students;";



            Statement stmt=connection.createStatement();

            ResultSet set = stmt.executeQuery(qString);

            while(set.next()) {

                int id = set.getInt(1);

                String nameString = set.getString(2);

                String phoneString = set.getString(3);

                String cityString = set.getString("scity");



                System.out.println("ID is" + id);

                System.out.println("Name is " + nameString);

                System.out.println();

            }



            f=true;

        } catch (SQLException e) {

            // TODO: handle exception

            e.printStackTrace();

        }

        return f;



    }





    //Update Student

    public static boolean updateStudentCity(int userId, String newCity) {

        boolean f = false;

        try {

            Connection connection = JDBCconfig.create();



            String qString = "update students set scity = ? where sid = ?";



            PreparedStatement pstmt = connection.prepareStatement(qString);



            pstmt.setString(1, newCity);

            pstmt.setInt(2, userId);



            int rowsAffected = pstmt.executeUpdate();



            if (rowsAffected > 0) {

                f = true;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return f;

    }


}


