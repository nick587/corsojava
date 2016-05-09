package implementazione;

import interfacce.CartaCredito;

import java.util.ArrayList;

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
