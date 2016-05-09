package implementazione;


import implementazione.PersonaImpl;
import interfacce.Carta;
import interfacce.Intestatario;

import java.util.ArrayList;

public class IntestatarioImpl extends PersonaImpl implements Intestatario{
	
	 ArrayList<Carta> carte=new ArrayList<Carta>();
	 
	 public IntestatarioImpl(String nome, String cognome, String cf){
		 
		 super(nome,cognome,cf);
	 }	
	 
	 public void aggiungiCarta(Carta c){
		 carte.add(c);
	 }
}
