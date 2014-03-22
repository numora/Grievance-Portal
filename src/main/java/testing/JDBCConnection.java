package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://11.16.8.124/anil";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "db2acce5s";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
  
      
   /*   String sql="create table address(address_id Integer NOT NULL,"+
			"address_line_1 varchar(255),"+
			"address_line_2 varchar(255),"+
			"state varchar(2),"+
			"city varchar(100),"+
			"zip varchar(10),"+
			"po_box varchar(10),"+
			"primary key(address_id));";
			
			*/
     
  String str="create table newuser (user_id Integer NOT NULL,"+ 
	"password varchar(255),"+
	"email_id varchar(255),"+
	"last_modified_date DATE,"+ 
	"login_name varchar(255), "+
	"created_date DATE,"+
	"verified integer,"+
	"role_id integer,"+
	"dob DATE,"+
	"language varchar(50),"+
	"address_id Integer,"+
	"primary key (user_id),"+
  	"FOREIGN KEY (address_id) REFERENCES address(address_id));";
      
      
      /* String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 
*/
      stmt.executeUpdate(str);
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
