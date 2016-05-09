package corso.manpowerformazione.id148911;

import javax.swing.JOptionPane;

import corso.manpowerformazione.id148911.interfacce.Banca;
import corso.manpowerformazione.id148911.interfacce.Sportello;
import corso.manpowerformazione.id148911.interfacce.Carta;

import java.time.*;

public class SportelloImpl implements Sportello {

	Banca banca;
	String dove;
	double disponibilita;
	Carta carta;
	
	public SportelloImpl(Banca banca, String dove, double disponibilita){
		
		this.banca=banca;
		this.dove=dove;
		this.disponibilita=disponibilita;
		this.carta=null;
	}
	
	public void espelliCarta(){
		
		if (carta==null){
			System.out.println("Attenzione! Nessuna carta inserita.");
		}
		else {
			System.out.println("Ritirare la carta");
			carta=null;
		}
		
	}
    
	public boolean checkPIN(int tentativo){
	   /*Scanner input1 = new Scanner(System.in);
		String PIN = input1.nextString();
    	if(PIN == carta.getPIN()) return true;
    	else{
    		if(tentativo <3) return checkPIN(tentativo+1);
    		else return false;
    	}*/
	   String PIN = JOptionPane.showInputDialog("Inserisci il PIN");
	   if(PIN == carta.getPIN()) return true;
	   else{
		   if(tentativo <3) return checkPIN(tentativo+1);
		   else return false;
     	}
   }
    
	public double preleva(double importoRichiesto){
    	if(carta.checkTetti(importoRichiesto)==0){
    		if(importoRichiesto<=carta.getCC().getSaldo()){
    			if(importoRichiesto <= disponibilita){
        			System.out.println("Operazione andata a buon fine. Lei ha prelevato"+importoRichiesto);
       		        return importoRichiesto;
       		     }
       		    else{
       			    System.out.println("Disponibilit� massima = "+disponibilita);
       			    return 0;
       		    }
    		}
    		else{
    			System.out.println("Saldo non disponibile");
    			return 0;
    		}
    	}
    	else if(carta.checkTetti(importoRichiesto)==1){
    			System.out.println
    			("Limite massimo giornaliero raggiunto. Impossibile prelevare l'importo richiesto");
    		    return 0;	
    	}
    	else if(carta.checkTetti(importoRichiesto)==2){
			System.out.println
			("Limite massimo mensile raggiunto. Impossibile prelevare l'importo richiesto");
			return 0;
		}
    	else{
    		System.err.println
    		("ERRORE!! Il tuo checkTetti � malfunzionante.");
    		return 0;
    	}
    }
	public double versa(double importoVersato){
    	
    	System.out.println("Operazione andata a buon fine. Lei ha versato"+importoVersato);
       	return importoVersato;
    
    }
    
	public void visualizzaSaldoEMovimenti(){
    }
	public boolean bloccaCarta(){
		return false;
    }
	public int scegliOperazione(){
    	
    	String messaggio = "Scegli operazione:\n" +
    	"Prelievo --> digiti 1\n" +
    	"Versamento --> digiti 2\n" +
    	"Visualizza saldo & movimenti --> digiti 3\n" +
    	"Espelli carta --> digiti 0";
    	
    	/*System.out.println( messaggio );
    	Scanner input1 = new Scanner(System.in);
		int Scelta = input1.nextInt();
		
		if (Scelta!= 0 && Scelta !=1 && Scelta !=2 && Scelta !=3){
			System.out.println(Scelta+" non � una scelta disponibile");
			return scegliOperazione();
		}
		else return Scelta;*/
		
		int Scelta = Integer.parseInt( JOptionPane.showInputDialog(messaggio) );
		
		if (Scelta!= 0 && Scelta !=1 && Scelta !=2 && Scelta !=3){
			JOptionPane.showMessageDialog(null, Scelta+" non � una scelta disponibile");
			return scegliOperazione();
		}
		else return Scelta;
    }
    
	public void SportelloMain() throws Exception{
    	
    	String messaggio = "Scegli operazione";
    	
    	boolean controlloPIN = checkPIN(1);
    	if(controlloPIN){
    		int Scelta = scegliOperazione();
        	if (Scelta == 1){
    			System.out.println("Inserisci importo desiderato");
    			//Scanner input2 = new Scanner(System.in);
    			//double importoRichiesto = input2.nextDouble();
    			double importoRichiesto = Double.parseDouble( messaggio );
    			if (importoRichiesto<=0){
    				//System.out.println("Importo desiderato negativo. CartaImpl in espulsione");
    				JOptionPane.showMessageDialog(null,"Importo desiderato negativo. CartaImpl in espulsione");
    				espelliCarta();
    			}
    			else{
    			    double denaroInUscita = preleva(importoRichiesto);
    			    if(denaroInUscita !=0){
    				    LocalDateTime oggi=LocalDateTime.now();
    				    String data = 
    						(oggi.getDayOfMonth()+"/"+
    				         oggi.getMonth().getValue()+"/"+
    				         oggi.getYear());
    				    LocalTime adesso=LocalTime.now();
    				    String ora =(adesso.getHour()+":"+adesso.getMinute());
    				    String causale = "prelievo";
    				    carta.getCC().addebito(-importoRichiesto, causale);
    			   }
    			}
    		}
    		else if (Scelta == 2){
    			//System.out.println("Inserisci importo versato");
    			//Scanner input2 = new Scanner(System.in);
    			//double importoVersato = input2.nextDouble();
    			double importoVersato = Integer.parseInt( "Inserisci importo versato" );

    			if (importoVersato<=0){
    				System.out.println("Importo versato negativo. CartaImpl in espulsione");
    				espelliCarta();
    			}
    			else{
    			    double denaroInEntrata = versa(importoVersato);
    			    if(denaroInEntrata !=0){
    				    LocalDateTime oggi=LocalDateTime.now();
    				    String data = 
    						(oggi.getDayOfMonth()+"/"+
    				         oggi.getMonth().getValue()+"/"+
    				         oggi.getYear());
    				    LocalTime adesso=LocalTime.now();
    				    String ora =(adesso.getHour()+":"+adesso.getMinute());
    				    String causale = "versamento";
    				    carta.getCC().addebito(importoVersato,causale);
    			   }
    			}
    		}
    		else if (Scelta == 3);
    		
    	    espelliCarta();	
    	}	
    	else{
    		//boolean cartaBloccata = bloccaCarta();
    	}
    }
    
	public Object Movimento(String data, String ora, String causale,
			double importoVersato, String dove2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserisciCarta(Carta carta){
		
		if (this.carta!=null){
			System.out.println("Impossibile inserire carta. Altra carta in fase di lettura.");
		}
		else {
			try{
				this.carta=carta;
				carta.collegaSportello(this);	
				SportelloMain();
			}catch(Exception e){
				carta.scollegaSportello();
				this.carta=null;
				JOptionPane.showMessageDialog(null, "La carta è stata espulsa : "+e.getMessage());
			}
		}
		
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
