public class Raum{
    private int geb;
    private int etage;
    private int raum;

    //Konstruktor
    public Raum(int geb, int etage, int raum){
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
    }

    public void addReservierung(Reservierung reservierung){

    }

    @Override
    public boolean equals(Object object){
        boolean equals = false;
        return equals;
    }

    public Reservierung getReservierung(int index){
        return null;
    }

    public int getAnzahlReservierungen(){
        int anzahl = 0;
        return anzahl;
    }

    @Override
    public String toString(){
        String ausgabe;
        ausgabe = "Raum " + getGeb() + "-" + getEtage() + "." + getRaum();
        return ausgabe;
    }

    //Get-Methoden fuer Klassenattribute
    public int getEtage() {
        return etage;
    }
    public int getGeb() {
        return geb;
    }
    public int getRaum() {
        return raum;
    }
}