package interfacce;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public interface CC {
	public Banca getBanca();

	public String getIban();
	
	public Cliente getCliente();

	public ArrayList<Carta> getCarte();

	public double getSaldoContabile();
	
	public double getSaldoDisponibile();
	
	public void accredito( double importo, String causale );
	
	public void addebito( double importo, String causale ) throws Exception;
	
	public void concediFido(float importo);
	
	public void revocaFido();
	
	public void visualizzaSaldoMovimenti();
	
	public void registraCarta(Carta c);
	
	public String toString();


	public double getSaldo();
}

