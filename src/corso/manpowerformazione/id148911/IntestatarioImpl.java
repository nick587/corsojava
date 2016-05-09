package corso.manpowerformazione.id148911;


import java.util.ArrayList;
import corso.manpowerformazione.id148911.PersonaImpl;
import corso.manpowerformazione.id148911.interfacce.Carta;
import corso.manpowerformazione.id148911.interfacce.Intestatario;

public class IntestatarioImpl extends PersonaImpl implements Intestatario{
	
	 ArrayList<Carta> carte=new ArrayList<Carta>();
	 
	 public IntestatarioImpl(String nome, String cognome, String cf){
		 
		 super(nome,cognome,cf);
	 }	
	 
	 public void aggiungiCarta(Carta c){
		 carte.add(c);
	 }
}
