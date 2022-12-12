import java.sql.*;

public class ExecuteQuery01 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Step: Registration to the driver
        Class.forName("org.postgresql.Driver");

        //2. Step: Create connection with dataBase
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Arcilla2016");

        //3. Ste : Create statement
        Statement st = con.createStatement();
        System.out.println("Connection Success");

        //1.Example: Select the country names whose region id's are 1

        String sql1 = "SELECT country_name from countries WHERE region_id=1;";
        // If you use this execute() method, you will get True or False as return. But I want to see the records
        boolean result1 = st.execute(sql1);
        System.out.println(result1);
        // to see the records we have another method, which is "executeQuery()".

        ResultSet resultSet1 = st.executeQuery(sql1);

        while (resultSet1.next()) {

            System.out.println(resultSet1.getString("country_name"));
        }
        //2.Example: Select the country_id and country_name whose region_id's are greater than 2

        String sql2 = "SELECT  country_id,country_name FROM countries WHERE region_id >2";
        ResultSet resultSet2 = st.executeQuery(sql2);

        while (resultSet2.next()) {
            System.out.println(resultSet2.getString("country_id") + " -> " + resultSet2.getString("country_name"));
        }
        //3.Example: Select the company whose number_of_employees is the lowest from companies table

        String sql3 = "SELECT company FROM companies WHERE number_of_employees=(SELECT MIN( number_of_employees) FROM companies)";
        ResultSet resultSet3 = st.executeQuery(sql3);

        resultSet3.next();
        System.out.println(resultSet3.getString("company"));

        //4.Example: Select all columns whose number_of_employees is the lowest from companies table

        String sql4 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet resultSet4 = st.executeQuery(sql4);

        while (resultSet4.next()) {

            System.out.println(resultSet4.getInt(1) + " " + resultSet4.getString(2) + " " + resultSet4.getInt(3));
        }
        con.close();
        st.close();
    }
}
