package db.postgres.copy.LoadFile;

import java.sql.Connection;
import java.sql.DriverManager;





public class PostgreSQLJDBC {

   public static void main(String[] args) {
		try {

			CSVLoader loader = new CSVLoader(getConnection());
			loader.loadCSV("C://Users/ABSD491/Desktop/Projects/Card Tokenization/200records_Atmrep.csv", "atmrep", false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   private static Connection getConnection() {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://oss-vip-3941.corp.dsarena.com:5433/sparrow",
            "app_account", "rguvhBsWF4");
            System.out.println("Opened database successfully");
      
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      
      return c;
   }
}