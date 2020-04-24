import java.util.ArrayList;
import java.util.Arrays;
/**
 * Klasse Raum
 * 
 * Autor Niklas Terwort && Tobias Steuer
 */
public class Raum{
    /**
     * Klassenattribute
     */
    private int geb;
    private int etage;
    private int raum;
    private Reservierung [] reservierungen;
    private static final int maxReservierungen = 10;
    /**
     * Fehlermeldungen
     */
    private static final String numberErr = "Die Zahl muss größer als 0 sein";
    private static final String numberErr2 = "Die Zahl muss größer oder gleich 0 sein";
    private static final String indexErr = "Diese Reservierung ist noch nicht erstellt";
    private static final String indexErr2= "Dieser Raum ist schon voll belegt";

    /**
     * Konstruktor
     * param int geb    Gebaeude    Darf nicht kleiner oder gleich 0 sein
     * param int etage  Etage       Darf nicht kleiner als 0 sein
     * param int raum   Raum        Darf nicht kleiner oder gleich 0 sein
     */
    public Raum(int geb, int etage, int raum){
        Validator.check(geb <= 0, numberErr);
        Validator.check(etage < 0, numberErr2);
        Validator.check(raum <= 0, numberErr);

        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        //ArrayList<Reservierung> reservierungen = new ArrayList<Reservierung>();   Könnte auch mit ArrayList geloest werden
        reservierungen = new Reservierung[maxReservierungen];
    }
    /**
     * Methode zum Hinzufuegen einer Reservierung im Array reservierungen
     * param Reservierung reservierung   Reservierung
     * 
     * Bedingung if     Wenn die Stelle leer fuege die Reservierung hinzu
     */
    public void addReservierung(Reservierung reservierung) {
        Validator.check(getAnzahlReservierungen() >= maxReservierungen, indexErr2);
        for (int i = 0; i < reservierungen.length; i++) {
            if (reservierungen[i] == null) {
                    reservierungen[i] = reservierung;
                    break;
            }

        }
    }
    /**
     * Methode zum Vergleichen von Objekten
     * 
     * return boolean
     */
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
    /**
     * Methode zum Ausgeben einer bestimmten Reservierung
     * param int index  Index       Muss schon gefuellt sein
     */
    public Reservierung getReservierung(int index){
        Validator.check(reservierungen[index] == null, indexErr);
        return reservierungen[index];
    }
    /**
     * Methode zum Ausgeben der Anzahl der getaetigten Reservierungen
     * Ueberprueft wo die erste leere Stelle im Array ist
     * 
     * return anzahl
     */
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
    /**
     * Methode zum Ausgeben des Raums
     * Form: Raum $Gebaude - $Etage . $Raum
     */
    @Override
    public String toString(){
        int i;
        StringBuilder ausgabe;
        ausgabe = new StringBuilder("Raum " + getGeb() + "-" + getEtage() + "." + getRaum());
        i = getAnzahlReservierungen();
        if (reservierungen[0] != null) {
            for (int p = 0; p < i; p++) {
                ausgabe.append(getReservierung(p));
            }
        } else {
            ausgabe.append("\n Es liegen keine Reservierungen vor.");
        }
        return ausgabe.toString();
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