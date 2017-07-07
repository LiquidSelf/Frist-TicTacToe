package mainapp;

import java.sql.*;

public class SqlEXMP {



    public static void main(String[] args) throws Exception {

        Connection connection = null;

        String url = "jdbc:sqlserver://mssql2.gear.host";

        String name = "luldb";

        String pass = "Cd0zjV6__g65";

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(url, name, pass);

            System.out.println("Connected.");

            Statement statement = connection.createStatement();
            Statement statement2 = connection.createStatement();

//            statement.executeUpdate("DROP TABLE IF EXISTS vp");
//
//            System.out.println("Old table: dropped.");
//
//            statement.executeUpdate("CREATE TABLE vp (id int NOT NULL IDENTITY, FirstName VARCHAR (15), Role VARCHAR(15), PRIMARY KEY (id))");
//
//            System.out.println("New table: created.");
//
//            statement.executeUpdate("Insert into vp values('Alexey','Support'),('Vovan', 'Midlane'),('Papasha', 'Hardlane'),('LIL','Support'),('Ramzes!','Carry')");
//
//            statement.executeUpdate("DELETE from vp where id = 4");
//
//            statement.executeUpdate("UPDATE vp SET FirstName = 'Leha' where FirstName = 'Alexey'");
//
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into vp (FirstName, Role) VALUES (?,?)");
//            preparedStatement.setString(1,"mag");
//            preparedStatement.setString(2,"hard");
//            preparedStatement.executeUpdate();
//            preparedStatement.setString(1,"sema");
//            preparedStatement.setString(2,"sup");
//            preparedStatement.executeUpdate();
//
//            ResultSet result1 = statement.executeQuery("SELECT * FROM vp where id >2 and id <10");
//
//            while (result1.next()) {
//
//                System.out.println("Номер в выборке #" + result1.getRow() + "\t Имя: " + result1.getString("FirstName") + "\t Роль: " + result1.getString("Role"));
//            }
//
//            result1.close();





            statement.executeUpdate("UPDATE xoxo SET figure = '" + 'O' + "' where field =  9 or field = 10");


            boolean yo = false;










            statement.close();
            statement2.close();
            connection.close();
            System.out.println("connection closed.");


        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("yopta!");

        } finally {

            connection.close();
        }

    }

}