import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ContohDelete {

	public static void cetakPanduan() {
		System.out.println("Gunakan : java ContohDelete <nim>");
	}

	public static void main(String args[]) {
		if(args.length != 1) {
			cetakPanduan();
			return;
		}

		String nim = args[0];

		try {
			// langkah 1, register drivernya
			Class.forName("com.mysql.jdbc.Driver");

			// langkah 2, buat objek Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/phb","tamami","rahasia");

			// langkah 3, buat objek Statement
			Statement stmt = conn.createStatement();

			// langkah 4, eksekusi query
			int row = stmt.executeUpdate("delete from mahasiswa " +
					"where nim='"+ nim + "'");
			
			System.out.println("Jumlah baris diubah : " + row + "\n");

			ResultSet rs = stmt.executeQuery("select * from mahasiswa");

			while(rs.next()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2));
			}

			// langkah 5, tutup koneksi
			conn.close();
		} catch(Exception e) { e.printStackTrace(); }
	}
}
