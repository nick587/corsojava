package banca;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import corso.manpowerformazione.id148911.BancaImpl;
import corso.manpowerformazione.id148911.BancomatImpl;
import corso.manpowerformazione.id148911.CCImpl;
import corso.manpowerformazione.id148911.ClienteImpl;
import corso.manpowerformazione.id148911.IntestatarioImpl;
import corso.manpowerformazione.id148911.SportelloImpl;
import corso.manpowerformazione.id148911.interfacce.Banca;
import corso.manpowerformazione.id148911.interfacce.Bancomat;
import corso.manpowerformazione.id148911.interfacce.CC;
import corso.manpowerformazione.id148911.interfacce.CartaCredito;
import corso.manpowerformazione.id148911.interfacce.Cliente;
import corso.manpowerformazione.id148911.interfacce.Intestatario;
import corso.manpowerformazione.id148911.interfacce.Sportello;

public class SistemaBancario {


	private List<Cliente> clienti = new ArrayList<Cliente>();
	private List<Cliente> intestatari = new ArrayList<Cliente>();

	private List<Banca> banche = new ArrayList<Banca>();
	private List<Sportello> sportelli = new ArrayList<Sportello>();
	private List<CC> conti = new ArrayList<CC>();
	private List<Bancomat> bancomat = new ArrayList<Bancomat>();
	private List<CartaCredito> carteCredito = new ArrayList<CartaCredito>();
	
	/**
	 * @param args
	 */
	public SistemaBancario() {
		/*Cliente cliente1 = new ClienteImpl("Mario", "Rossi", "RSSMRA37474747");
		Cliente cliente2 = new ClienteImpl("Luca", "Bruni", "BRNLCU37474747");
		clienti.add( cliente1 );
		clienti.add( cliente2 );*/
		String banche[][]={{"intesa"},{"Unicredit"}};
		for(String[] s: banche){
			BancaImpl.main(s);
		}
		//Banca banca1 = new BancaImpl("Intesa SanPaolo");
		/*Banca banca2 = new BancaImpl("Unicredit");
		Banca banca3 = new BancaImpl("BancaImpl Popolare Commercio e Industria");
		Banca banca4 = new BancaImpl("BancaImpl Sella");
		banche.add( banca1 );
		banche.add( banca2 );
		banche.add( banca3 );
		banche.add( banca4 );
		
		Sportello sportello1 = new SportelloImpl(banca1, "via Roma 1, Milano", 0);
		Sportello sportello2 = new SportelloImpl(banca2, "via Firenze 100, Roma ", 0);
		sportelli.add(sportello1);
		sportelli.add(sportello2);
		
		CC conto1 = new CCImpl(banca1, "IT23B474747", 0.0, cliente1);
		CC conto2 = new CCImpl(banca2, "IT48S474747", 0.0, cliente2);
		conti.add(conto1);
		conti.add(conto2);
		
		Intestatario intestat1 = new IntestatarioImpl("Giacomo", "Neri", "NREGCM474747");
		Intestatario intestat2 = new IntestatarioImpl("Luca", "Bianchi", "BNCLCU43747");

		intestatari.add(cliente1); // TODO
		intestatari.add(cliente2);// TODO
		
		
		Bancomat bancomat1 = new BancomatImpl("12345", conto1, intestat1, "20180625", 100, 100, 100, 100, 100);
		Bancomat bancomat2 = new BancomatImpl("12345", conto2, intestat2, "20180625", 100, 100, 100, 100, 100);
		bancomat.add(bancomat1);
		bancomat.add(bancomat2);
		
		conto1.accredito(1000, "Bonifico da Peracottaro S.r.l.");
		conto1.visualizzaSaldoMovimenti();
		try {
			conto1.addebito(100, "Bolletta Telecom Italia S.p.A.");
		}
		catch( Exception ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		conto1.visualizzaSaldoMovimenti();
		try {
			conto1.addebito(100000, "Tentativo addebito fraudolento");
		}
		catch( Exception ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		conto1.visualizzaSaldoMovimenti();*/
	}
	
	public void run() {
		
	}
}
