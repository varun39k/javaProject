import java.sql.*;
import java.util.*;
public class Movies {
		static Movies MoviesObj = new Movies();
		static Scanner ScannerObj = new Scanner(System.in);
	public void CreateDatabase(){
		try {
			String url = "jdbc:sqlite:C:/sqlite/database";
			Connection conn = DriverManager.getConnection(url);
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
		}
	}
	public static void CreateTable(){
		try{
			String url = "jdbc:sqlite:C:/sqlite/database";
			Connection conn = DriverManager.getConnection(url);
			if(conn != null){
				Statement ps = conn.createStatement();
				String query = "create table movies(moviename varchar, actor_actress char, dateOfRelease varchar, directorname char)";
				ps.executeUpdate(query);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static void Insert(){
		String mname, aname, dor, dname;
		System.out.println("Enter Movie name: ");
		mname = ScannerObj.nextLine();
		
		System.out.println("Enter Actor or Actress name: ");
		aname = ScannerObj.nextLine();
		
		System.out.println("Enter Date Of Release");
		dor = ScannerObj.nextLine();
		
		System.out.println("Enter Director name");
		dname = ScannerObj.nextLine();
		try{
			String url = "jdbc:sqlite:C:/sqlite/database";
			Connection conn = DriverManager.getConnection(url);
			if(conn != null){
				Statement ps = conn.createStatement();
				String query = "insert into movies values('"+mname+"', '"+aname+"', '"+dor+"', '"+dname+"')";
				ps.executeUpdate(query);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
	
	public static void Fetch(){
		 try {
			String url = "jdbc:sqlite:C:/sqlite/database";
			Connection conn = DriverManager.getConnection(url);
 
            // SQL command data stored in String datatype
            String sql = "select * from movies";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
 
            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("moviename\t\tActor/Actressname\t\tDate of Release\t\tDirector name");
 
            // Condiion check
            while (rs.next()) {
 
                String mname = rs.getString("moviename");
                String aname = rs.getString("actor_actress");
                String dor = rs.getString("dateOfRelease");
                String dname = rs.getString("directorname");
                System.out.println(mname+"\t\t\t"+aname+"\t\t\t\t"+dor+"\t\t"+dname);
            }
        }
 
        // Catch block to handle exception
        catch (SQLException e) {
 
            // Print exception pop-up on scrreen
            System.out.println(e);
        }
	}
	public static void main(String args[]){
		
		System.out.println("MOVIE Record");
		System.out.println("Enter 1 for Create Database;"); 
		System.out.println("Enter 2 for Create Table;");
		System.out.println("Enter 3 for Enter Movies Details;");
		System.out.println("Enter 4 for Find Movies Details;");
		System.out.println("\nEnter Input: ");
		int snum = ScannerObj.nextInt();
		ScannerObj.nextLine();
		if(snum == 1){
			//System.out.print("Enter a Database Name:");
			//dbname= ScannerObjannerObjannerObj1.nextLine();
			MoviesObj.CreateDatabase();
			
		}else if(snum == 2){
			MoviesObj.CreateTable();
			System.out.println("Table created successfully");
			//System.out.println(dbname);
			
		}
		else if(snum == 3){
			MoviesObj.Insert();
		}
		else if(snum == 4){
			MoviesObj.Fetch();
		}
	}
} 