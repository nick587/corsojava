package corso.manpowerformazione.id148911;

import corso.manpowerformazione.id148911.interfacce.CC;
import corso.manpowerformazione.id148911.interfacce.Intestatario;
import corso.manpowerformazione.id148911.interfacce.Sportello;

//TODO aggiungere enumeratore per stati
public class CartaImpl {

	protected final String pin;
	protected final CC cc;
	protected final Intestatario intestatario;
	protected final String scadenza;
	protected Sportello sportello;
	protected final double commissione;
	protected final double maxGI;
	protected final double maxGO;
	protected final double maxMI;
	protected final double maxMO;
	protected int stato;//TODO aggiungere enumeratore al posto di int
	
	public int getStato() {
		return stato;
	}

	public void cambiaStato(int stato) {//TODO usare enumeratore al posto di int
		this.stato = stato;
	}

	//TODO usare builder pattern
	public CartaImpl(String pin, CC cc, Intestatario intestatario, String scadenza, double commissione, double GI, double GO, double MI, double MO, int stato){
		this.pin = pin;
		this.cc = cc;
		this.intestatario = intestatario;
		this.scadenza = scadenza;
		this.commissione = commissione;
		this.maxGI=GI;
		this.maxGO=GO;
		this.maxMI=MI;
		this.maxMO=MO;
		this.stato=stato;
		this.sportello = null;
	}
	

	public boolean checkPin(String pin){
		return this.pin.equals(pin);
	}
	
	public int checkTetti(double importo){
		if (cc.getBanca().equals(sportello.getId())){	
			if (importo<=maxMI) return 2;	
			if (importo<=maxGI) return 1;
			return 0;
		}else{
			if (importo<=maxMO) return 2;	
			if (importo<=maxGO) return 1;
			return 0;
		}
	}

	public void collegaSportello(SportelloImpl sportello){
		this.sportello = sportello;

	}
	
	public void scollegaSportello(){
		this.sportello = null;

	}

	public CC getCC() {
		// TODO Auto-generated method stub
		return this.cc;
	}

	public String getPIN() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getSaldo() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addMovimento(Object movimento) {
		// TODO Auto-generated method stub
		
	}

	
}
