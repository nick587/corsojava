package corso.manpowerformazione.id148911;

import java.util.ArrayList;

import corso.manpowerformazione.id148911.interfacce.CartaCredito;

public class CartaCreditoImpl extends CartaImpl implements CartaCredito{

	private double fido;
	public CartaCreditoImpl(String pin, CCImpl cc, IntestatarioImpl intestatario, String scadenza, SportelloImpl sportello,
			double commissione, double GI, double GO, double MI, double MO) {
		super(pin, cc, intestatario, scadenza, commissione, GI, GO, MI, MO, 1);
	}
	public double getFido() {
		return fido;
	}
	public void setFido(double fido) {
		this.fido = fido;
	}
	//TODO impostazione limiti giornalieri e mensili
	
}
