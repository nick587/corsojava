package interfacce;



public interface Carta {
	
	public boolean checkPin(String pin);
	
	public int checkTetti(double importo);

	public void collegaSportello(Sportello sportello);
	
	public void scollegaSportello();

	public CC getCC();

	public String getPIN();

	public double getSaldo();

	public void addMovimento(Object movimento);

	
}

