package interfacce;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancaRemota extends Remote {
	
	void accredito(String iban, double importo, String causale) throws RemoteException;
	void addebito(String iban, double importo, String causale) throws RemoteException;
}

