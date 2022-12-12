public class Runner {

    public static void main(String[] args) {

        //1. Step: Registration to the driver
        //2. Step: Create connection with dataBase

        JDBCUtils.connectToDatabase("localhost","postgres","postgres","1234"); // call the method we created in JDBCUtils

        //3. Ste : Create statement
        JDBCUtils.createStatement();

        //4. Step: Execute the query

        JDBCUtils.createTable("Students","name 'Mark'","id 123","tel 1234567890","address 'Ankara'");

        JDBCUtils.createTable("Students","name 'John'");
        JDBCUtils.dropTable("workers");
        JDBCUtils.insertDataToTable("Students","name 'Mark'","id 123","tel 1234567890","address 'Ankara'");

        //5. Step: Close the connection and statement
        JDBCUtils.closeConnectionAndStatement();
    }


}
