package corso.manpowerformazione.id148911;

import corso.manpowerformazione.id148911.interfacce.Bancomat;
import corso.manpowerformazione.id148911.interfacce.CC;
import corso.manpowerformazione.id148911.interfacce.Intestatario;

public class BancomatImpl extends CartaImpl implements Bancomat{

	public BancomatImpl(String pin, CC cc, Intestatario intestatario, String scadenza, double commissione,
			double GI, double GO, double MI, double MO) {
		super(pin, cc, intestatario, scadenza, commissione, GI, GO, MI, MO, 1);
	}
}
