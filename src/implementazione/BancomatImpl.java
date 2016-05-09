package implementazione;

import interfacce.Bancomat;
import interfacce.CC;
import interfacce.Intestatario;

public class BancomatImpl extends CartaImpl implements Bancomat{

	public BancomatImpl(String pin, CC cc, Intestatario intestatario, String scadenza, double commissione,
			double GI, double GO, double MI, double MO) {
		super(pin, cc, intestatario, scadenza, commissione, GI, GO, MI, MO, 1);
	}
}
