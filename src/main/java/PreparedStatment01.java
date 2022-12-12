import java.sql.*;

public class PreparedStatment01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Arcilla2016");
        Statement st = con.createStatement();

        //1.Example: Update the number of employees to 9999 if the company name is IBM by using prepared statement

    // 1.Step : Create Prepared Statement Query

    String sql1 = "update companies SET  number_of_employees =? WHERE company =?";

    // 2. Step :  Create Prepared Statement Object
    PreparedStatement pst1 =  con.prepareStatement(sql1);

    //3.Step: Assign the values by using 'setInt() or setString(),....' methods.
    pst1.setInt(1,9999);
    pst1.setString(2,"IBM");

    // 4Step : Execute the QUERY
    int numOfRecordsUpdated = pst1.executeUpdate();
    System.out.println("numOfRecordsUpdated = " + numOfRecordsUpdated);

    String sql2 = "SELECT * FROM companies";
    ResultSet resultSet1 = st.executeQuery(sql2);

    while(resultSet1.next()){
        System.out.println(resultSet1.getInt(1)+"-- "+resultSet1.getString(2)+"-- "+resultSet1.getInt(3));
    }

    ///2.Example: Update the number of employees to 5555 if the company name is GOOGLE by using prepared statement
    pst1.setInt(1,5555);
    pst1.setString(2,"GOOGLE");

    int numOfRecordsUpdated2 = pst1.executeUpdate();
        System.out.println("numOfRecordsUpdated2 = " + numOfRecordsUpdated2);


    ResultSet resultSet2 = st.executeQuery(sql2);
    while (resultSet2.next()) {
        System.out.println(resultSet2.getInt("company_id") + "--" + resultSet2.getString("company") + "--" + resultSet2.getInt("number_of_employees"));
    }

    con.close();
    st.close();
    pst1.close();

    }
}
