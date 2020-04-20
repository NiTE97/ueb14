import java.util.Arrays;

public class Raum{
    private int geb;
    private int etage;
    private int raum;
    private Reservierung [] reservierungen;
    private static final String numberErr = "Die Zahl muss größer als 0 sein";
    private static final String numberErr2 = "Die Zahl muss größer oder gleich 0 sein";
    private static final String indexErr = "Diese Reservierung ist noch nicht erstellt";
    private static final String indexErr2= "Dieser Raum ist schon voll belegt";
    private static final int maxReservierungen = 10;

    //Konstruktor
    public Raum(int geb, int etage, int raum){
        Validator.check(geb <= 0, numberErr);
        Validator.check(etage < 0, numberErr2);
        Validator.check(raum <= 0, numberErr);

        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        reservierungen = new Reservierung[maxReservierungen];
    }

    public void addReservierung(Reservierung reservierung) {
        Validator.check(getAnzahlReservierungen() >= maxReservierungen, indexErr2);
        for (int i = 0; i < reservierungen.length; i++) {
            if (reservierungen[i] == null) {
                    reservierungen[i] = reservierung;
                    break;
            }

        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Raum raum1 = (Raum) object;
        return geb == raum1.geb &&
                etage == raum1.etage &&
                raum == raum1.raum &&
                Arrays.equals(reservierungen, raum1.reservierungen);
    }

    public Reservierung getReservierung(int index){
        Validator.check(reservierungen[index] == null, indexErr);
        return reservierungen[index];
    }

    public int getAnzahlReservierungen(){
        int anzahl = 0;
        for (int i = 0; i < reservierungen.length; i++){
            if(reservierungen[i] == null) {
                anzahl = i;
                break;
            }else{
                anzahl = reservierungen.length;
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
        if (reservierungen[0] != null) {
            for (int p = 0; p < i; p++) {
                ausgabe += getReservierung(p);
            }
        } else {
            ausgabe += "\n Es liegen keine Reservierungen vor.";
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