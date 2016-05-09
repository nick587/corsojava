package corso.manpowerformazione.id148911;

import java.util.ArrayList;
import java.util.List;

import corso.manpowerformazione.id148911.interfacce.CC;
import corso.manpowerformazione.id148911.interfacce.Cliente;

public class ClienteImpl extends PersonaImpl implements Cliente{
	
	 List<CC> conti = new ArrayList<CC>();
	 
	 public ClienteImpl(String nome, String cognome, String cf){
		 
		 super(nome,cognome,cf);
	 }
	 
	 public void registraConto(CC conto){
		 conti.add(conto);
	 }

}
