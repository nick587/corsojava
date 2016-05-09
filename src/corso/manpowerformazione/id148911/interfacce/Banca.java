package corso.manpowerformazione.id148911.interfacce;

import java.rmi.RemoteException;

public interface Banca {
	
	void registraCC(CC cc);
	
	void accredito(String iban, double importo, String causale) throws RemoteException;

	void addebito(String iban, double importo, String causale) throws RemoteException;

}
