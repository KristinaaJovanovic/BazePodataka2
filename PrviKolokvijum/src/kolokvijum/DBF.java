package kolokvijum;

import java.sql.*;

public class DBF {
	
	public static void unesiGlumca(Glumac g) {
		PreparedStatement pstmt=null;
		
		try {
			pstmt=DBConnection.getConnection().prepareStatement("insert into glumac values(?, ?, ?, ?)");
			pstmt.setInt(1, g.getIdg());
			pstmt.setString(2, g.getIme());
			pstmt.setString(3, g.getPrezime());
			pstmt.setInt(4, g.getGodinaRodjenja());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
	}
	//ime filma
	public static boolean izmeniHonorar(int sifra, double honorar) {
		boolean rez=false;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=DBConnection.getConnection().prepareStatement("update glumi set honorar=? where sifra=?");
			pstmt.setDouble(1, honorar);
			pstmt.setInt(2, sifra);
			pstmt.executeUpdate();
			
			rez=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return rez;
	}
	
	public static boolean obrisiFilm(int sifra) {
		boolean rezultat=false;
		PreparedStatement pstmt=null;
		
		try {
			DBConnection.getConnection().setAutoCommit(false);
			
			//kaskadno
			pstmt=DBConnection.getConnection().prepareStatement("delete from glumi where sifra=?");
			pstmt.setInt(1, sifra);
			pstmt.executeUpdate();
			
			pstmt.close();
			
			pstmt=DBConnection.getConnection().prepareStatement("delete from film where sifra=?");
			pstmt.setInt(1, sifra);
			pstmt.executeUpdate();
			
			DBConnection.getConnection().commit();
			rezultat=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				DBConnection.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return rezultat;
		
	}
	
	public static void prikaziFilm(int idg) {
		Statement stmt=null;
		ResultSet rSet=null;
		
		try {
			DBConnection.getConnection().setAutoCommit(true);
			stmt=DBConnection.getConnection().createStatement();
			rSet=stmt.executeQuery("select naziv from film f, glumi g where f.sifra=g.sifra and g.idg="+idg);
			while(rSet.next()) {
				System.out.println(rSet.getString(1));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rSet!=null) {
					rSet.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
	

}
