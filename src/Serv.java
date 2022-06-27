import java.sql.*;
public class SQLiteConnection {
	public static void main(String[] ar) {
		String jdbcUrl = "jdbc:sqlite:/userdb.db";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl);
			String createStatement1 = "create table movies(movie_name varchar(20),hero varchar(20),heoine varchar(20))";
			Statement s = con.createStatement();
			s.execute(createStatement1);
			PreparedStatement ps = con.prepareStatement("insert into movies(movie_name,hero,heroine) values(?,?,?);");
			ps.setString(0, "RRR");
			ps.setString(1, "NTR");
			ps.setString(2, "Aliya");
			
			ps.executeUpdate();
			Statement query = con.createStatement();
			ResultSet rs = query.executeQuery("select * from movies;");
			
			while(rs.next()) {
				System.out.println("Movie : "+rs.getString(0)+"Hero : "+rs.getString(1)+"Heroine : "+rs.getString(2));
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
