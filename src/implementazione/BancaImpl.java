package implementazione;

import interfacce.Banca;
import interfacce.BancaRemota;
import interfacce.CC;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class BancaImpl implements Banca,BancaRemota{

	String nome;
	List<CC> conti=new ArrayList<CC>();
	/**
	 * @param args
	 */
	public static void main(String args[]){
		try{
			BancaImpl banca=new BancaImpl(args[0]);
			BancaRemota stub = (BancaRemota) UnicastRemoteObject.exportObject(banca,0); //fa il casting dell'oggetto in Hello e lo esporta
			Registry registry = LocateRegistry.getRegistry();//crea istanza dell'interfaccia
			registry.bind(args[0], stub);//utilizzando il registro la istanzia
			//System.err.println("server ready"); se va tuto bene scrive che è pronto
			
		} catch(Exception e){
			System.err.println("Server exception: "+ e.toString());
			e.printStackTrace();
			
		}
	}
	public BancaImpl( String nome ) {
		this.nome = nome;
		
	}
	
	public void registraCC(CC cc){
		conti.add(cc);
	}

	private CC cercaIban(String iban){
		for (CC contoattuale: conti){
			if(contoattuale.getIban().equals(iban))
				return contoattuale;
		}
		return null;
		
	}
	
	@Override
	public void accredito(String iban, double importo, String causale) throws RemoteException {
		CC conto=cercaIban(iban);
		if(conto==null)
			throw new RemoteException("Conto non trovato");
		conto.accredito(importo, causale);
		
	}

	@Override
	public void addebito(String iban, double importo, String causale) throws RemoteException {
		CC conto=cercaIban(iban);
		if(conto==null)
			throw new RemoteException("Conto non trovato");
		try{
			conto.addebito(importo, causale);
		}catch(Exception e){
			throw new RemoteException(e.getMessage());
		}
	}

}
