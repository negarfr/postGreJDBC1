import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. Step: Registration to the driver
        Class.forName("org.postgresql.Driver");

        //2. Step: Create connection with dataBase
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Arcilla2016");

        //3. Ste : Create statement
        Statement st = con.createStatement();
        System.out.println("Connection Success");

        //4.Step: Execute the query
        /*
        execute() method can be used in DDL(Table creation, DROP Table, ALTER Table) and DQL(Select)
        1)If you use execute() method in DDL you will get false everytime.
        2)If you use execute() method in DQL you will get false or true
        When you use execute() method in DQL, if you get ResultSet Object as return you will get true
        otherwise you will get false.
         */

        //1)Example: Create a workers table with the columns worker_id,worker_name, worker_salary
        String sql1 = "CREATE TABLE  workers (worker_id VARCHAR(50),worker_name VARCHAR(20), worker_salary INT)";
        boolean sqlResult = st.execute(sql1);
        System.out.println(sqlResult);

        //2.Example: Alter table by adding worker_address column into the workers table
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        //3.Ex : Drop the Table
        String sql3 = "DROP TABLE workers";
        st.execute(sql3);

        //5. Step: Close the connection and statement
        con.close();
        st.close();

    }
}
