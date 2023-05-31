package Resursi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import Exceptions.DosloJeDoGreskeException;
import Zajednicko.Helper;
import Zajednicko.HelperPrikaz;


public class CRUD_Ops {
	 static HelperPrikaz HP = new HelperPrikaz();

	static Helper Helper = new Helper();
	static HelperPrikaz HelperP = new HelperPrikaz();
	
	public static String prikaz(JTable table) {
		String query = "SELECT * FROM knjige";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
 

	public static void Dodaj(String Naziv, String Žanr, String Autor, String Inventar, String Cena) throws DosloJeDoGreskeException {
    	if(Naziv.equals("") ||  Žanr.equals("") || Autor.equals("") || Inventar.equals("") || Cena.equals("")) {
    		throw new DosloJeDoGreskeException("Greska pri dodavanju (Nisu popunjena sva polja)!");
		}else { 
			
			Connection conn = Zajednicko.Helper.DBSetup();
			String query = "INSERT INTO knjige(Naziv, Žanr, Autor, Inventar, Cena) VALUES ('"+Naziv+"', '"+Žanr+"', '"+Autor+"', '"+Integer.valueOf(Inventar)+"', '"+Integer.valueOf(Cena)+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
	
	public static void Izmeni(String Naziv, String Žanr, String Autor, String Inventar, String ID, String Cena) throws DosloJeDoGreskeException {
    	if(Naziv.equals("") ||  Žanr.equals("") || Autor.equals("") || Inventar.equals("") || Cena.equals("")) {
    		throw new DosloJeDoGreskeException("Greska pri izmeni (Neka polja su ostala prazna, ili nista nije promenjeno)!");
		}else { 
			
			Connection conn = Zajednicko.Helper.DBSetup();
			String query = "UPDATE knjige SET Naziv ='"+Naziv+"', Žanr = '"+Žanr+"', Autor='"+Autor+"', Inventar = '"+Integer.valueOf(Inventar)+"', Cena ='"+Integer.valueOf(Cena)+"' WHERE ID = "+ID+"";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
			
		}		
    }


    public static void Obrisi(String Naziv, String Žanr, String Autor, String Inventar, String ID, String Cena) throws DosloJeDoGreskeException   {
    	Connection connect = Zajednicko.Helper.DBSetup();
		String sql = "DELETE FROM knjige WHERE ID = "+ID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DosloJeDoGreskeException("Greska pri brisanju");
		}
		
	}
    
   
    
    
}