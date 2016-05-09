package corso.manpowerformazione.id148911;


import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import corso.manpowerformazione.id148911.interfacce.Banca;
import corso.manpowerformazione.id148911.interfacce.CC;
import corso.manpowerformazione.id148911.interfacce.Carta;
import corso.manpowerformazione.id148911.interfacce.Cliente;

class Movimento {
	private String causale;
	private double importo;
	private Date dataora;

	public Movimento( double importo, String causale ) {
		this.importo = importo;
		this.causale = causale;
		this.dataora = new Date();
	}
	
	public String getDataOra() {
		return this.dataora.toString();
	}

	public String getCausale() {
		return causale;
	}

	public double getImporto() {
		return importo;
	}
}


public class CCImpl implements CC{
	private Banca banca;
	private String iban;
	private double saldo;
	private Cliente cliente;
	private double fido;
	private ArrayList<Carta> carte=new ArrayList<Carta>();
	private ArrayList<Movimento> movimenti=new ArrayList<Movimento>();
	
	public CCImpl(Banca banca, String iban, double importoversato, Cliente cliente){
		this.banca=banca;
		this.iban=iban;
		this.saldo=importoversato;
		this.cliente=cliente;
		banca.registraCC(this);
		cliente.registraConto(this);
	}
	
		
	public Banca getBanca() {
		return banca;
	}

	public String getIban() {
		return iban;
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public ArrayList<Carta> getCarte() {
		return carte;
	}


	public double getSaldoContabile() {
		return this.saldo;
	}
	
	public double getSaldoDisponibile() {
		return this.saldo + this.fido;
	}
	
	public void accredito( double importo, String causale ) {
		this.saldo += importo;
		addMovimento(importo, causale );
	}
	
	public void addebito( double importo, String causale ) throws Exception {
		if( getSaldoDisponibile() >= importo ) {
			this.saldo -= importo;
			addMovimento(importo, causale );
		}
		else {
			throw new Exception("Disponibilità insufficente");
		}
	}
	
	private void addMovimento( double importo, String causale ){
		movimenti.add( new Movimento(importo, causale) );
	}
	

	
	public void concediFido(float importo){
		if(importo<0)
			return;
		fido=importo;
	}
	
	public void revocaFido(){
		if(fido>0)
			fido=0;
	}
	
	public void visualizzaSaldoMovimenti(){
		JOptionPane.showMessageDialog(null, "Saldo: "+saldo+"\n"+"Lista movimenti: \n"+toString());
	}
	
	public void registraCarta(Carta c){
		carte.add(c);
		//System.err.println("La carta non appartiene a questo conto");
	}
	
	public String toString(){
		String s="";
		for(Movimento m : movimenti){
			s+=m.getImporto()+" "+m.getCausale()+" "+m.getDataOra()+" "+m.getDataOra()+"\n";
		}
		return s;
	}


	public double getSaldo() {
		return saldo;
	}
}
