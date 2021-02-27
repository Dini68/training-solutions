package simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class EmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not read data source", se);
        }
//        try (
//                Connection conn = dataSource.getConnection();
//                PreparedStatement stmt =
//                        conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)")) {
//            stmt.setString(1,"John Doe");
//            stmt.executeUpdate();
//        } catch (SQLException se) {
//            throw new IllegalStateException("Can not insert", se);
//        }
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select id, emp_name from employees")
        ){
            while (rs.next()) {
                long id = rs.getLong("id");
                System.out.println(id);
                String name = rs.getString("emp_name");
                System.out.println(name);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }

    }
}
