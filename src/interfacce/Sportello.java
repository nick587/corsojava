package interfacce;


public interface Sportello {
	    void espelliCarta();
	    
	    boolean checkPIN(int tentativo);
	    
	    double preleva(double importoRichiesto);
	    
	    double versa(double importoVersato);
	    
	    void visualizzaSaldoEMovimenti();
	    
	    boolean bloccaCarta();
	    
	    int scegliOperazione();
	    
	    void SportelloMain() throws Exception;
	    
	    Object Movimento(String data, String ora, String causale,
				double importoVersato, String dove2);

	    void inserisciCarta(Carta carta);

		Object getId();
}
