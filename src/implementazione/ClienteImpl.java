package implementazione;

import interfacce.CC;
import interfacce.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteImpl extends PersonaImpl implements Cliente{
	
	 List<CC> conti = new ArrayList<CC>();
	 
	 public ClienteImpl(String nome, String cognome, String cf){
		 
		 super(nome,cognome,cf);
	 }
	 
	 public void registraConto(CC conto){
		 conti.add(conto);
	 }

}
