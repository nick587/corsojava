package implementazione;

import interfacce.Persona;

public class PersonaImpl implements Persona{

	  String nome;
	  String cognome;
	  String cf;
	
	 public PersonaImpl(String nome, String cognome, String cf){
		  
		  this.nome=nome;
		  this.cognome=cognome;
		  this.cf=cf;
	  }	  
}
