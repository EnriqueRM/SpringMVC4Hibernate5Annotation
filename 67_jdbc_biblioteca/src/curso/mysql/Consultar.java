

package curso.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//Establecer la conexion con la base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root" ,"");
		
		System.out.println("-------Consulta con PreparedStatement----------");
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("Select * from libros");
		
		while(rs.next()) {
			System.out.println("titulo: " + rs.getString("titulo"));
			System.out.println("precio: " + rs.getFloat("precio"));
			System.out.println("fecha: " + rs.getDate("fecha_publicacion"));
		}
		
		
		
		System.out.println("------Insertando regsitros con ExecuteUpdate ------");
		
		int insertar = st.executeUpdate("Insert into libros (titulo,precio,fecha_publicacion) values ('matrix',50,'2018-01-01')");
		System.out.println("fila insertada: " + insertar);
		
		
		
		
		System.out.println("-------Consulta con PreparedStatement----------");
		
	PreparedStatement pstmt = conn.prepareStatement("Select * from libros where titulo = ?");
	pstmt.setString(1,"el quijote");
	ResultSet rs1 = pstmt.executeQuery();
	
	while(rs1.next()) {
		System.out.println("titulo: " + rs1.getString("titulo"));
		System.out.println("precio: " + rs1.getFloat("precio"));
		System.out.println("fecha: " + rs1.getDate("fecha_publicacion"));
	}
	
	
	
	System.out.println("------Consulta con CallableStatement--------");
	
	CallableStatement cstmt = conn.prepareCall("{call listalibrosporautor(?)}");
	//cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
	cstmt.setString(1, "tu");
	ResultSet rs2 = cstmt.executeQuery();
	
	while(rs2.next()) {
		System.out.println("titulo: " + rs2.getString("titulo"));
		System.out.println("precio: " + rs2.getFloat("precio"));
		System.out.println("fecha: " + rs2.getDate("fecha_publicacion"));
	}
	
	
	}

}
