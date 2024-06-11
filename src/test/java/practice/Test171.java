package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test171 {

	public static void main(String[] args)throws Exception {
		// 1.Connect to DB as per DB Technology used by dev team
		Class.forName("com.mysql.jdbc.Driver"); //My SQL Server
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch264","root","admin");
		//2. Insert data to a Table
		Statement st1=con.createStatement();
		st1.executeUpdate("insert into search_words(word) values(magnitia)");
		//update data in a table
		Statement st2=con.createStatement();
		st2.executeUpdate("update search_words set word='magnitiait' where word='magnitia';");
		//Get data from DB table using sql query
		Statement st3=con.createStatement();
		ResultSet res=st3.executeQuery("select * from search_words;");
		while(res.next())  //goto each row in result set sequentially
		{
			String value=res.getString(2); //take 2nd column(word) value in that row
			System.out.println(value);
		}
		//5. delete data from a table
		Statement st4=con.createStatement(); 
		st4.executeUpdate("delete from search_words where word='magnitiait';");
		//disconnect from DB
		con.close();
		

	}

}
