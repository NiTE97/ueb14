public class Raum{
    private int geb;
    private int etage;
    private int raum;
    private Reservierung [] reservierungen;

    //Konstruktor
    public Raum(int geb, int etage, int raum){
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        reservierungen = new Reservierung[10];
    }

    public void addReservierung(Reservierung reservierung) {
        for (int i = 0; i < reservierungen.length; i++) {
            if (reservierungen[i] == null) {
                    reservierungen[i] = reservierung;
                    break;
            }

        }
    }

    @Override
    public boolean equals(Object object){
        boolean equals = false;
        return equals;
    }

    public Reservierung getReservierung(int index){
        return reservierungen[index];
    }

    public int getAnzahlReservierungen(){
        int anzahl = 0;
        for (int i = 0; i < reservierungen.length; i++){
            if(reservierungen[i] == null) {
                anzahl = i - 1;
                break;
            }
        }
        return anzahl;
    }

    @Override
    public String toString(){
        int i;
        String ausgabe;
        ausgabe = "Raum " + getGeb() + "-" + getEtage() + "." + getRaum();
        i = getAnzahlReservierungen();
        if (i >= 0) {
            for (int p = 0; p <= i; p++) {
                ausgabe += reservierungen[p];
            }
        }
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