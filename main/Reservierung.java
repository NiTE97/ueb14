import java.util.Objects;
/**
 * Klasse Reservierung
 * 
 * Autor Niklas Terwort && Tobias Steuer
 */
public class Reservierung{
    /**
     * Klassenattribute
     */
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Raum raum;
    private Mitarbeiter mitarbeiter;
    
    /**
     * Fehlermeldung
     */
    private static final String bemerkungErr = "Die Bemerkung darf nicht leer sein!";
    
    /**
     * Konstruktor
     * param Uhrzeit beginn     Beginn
     * param Uhrzeit ende       Ende
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende){
        this.beginn = beginn;
        this.ende = ende;
    }
    
    //Set-Methoden fuer Klassenattribute
    public void setBemerkung(String bemerkung){
        Validator.check(bemerkung == null || bemerkung.trim().isEmpty(), bemerkungErr);
        this.bemerkung = bemerkung;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter){
        this.mitarbeiter = mitarbeiter;
    }

    public void setRaum(Raum raum){
        this.raum = raum;
    }
    
    /**
     * Methode zum Ausgeben der Reservierung
     * Form: gebucht von $Mitarbeiter von $Beginn bis $Ende fuer $Bemerkung
     * 
     * return ausgabe
     */
    @Override
    public String toString(){
        String ausgabe;
        ausgabe = "\n gebucht von " + getMitarbeiter() +  " von " + getBeginn() + " bis " + getEnde() + " für " + getBemerkung();
        return ausgabe;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }
    public String getBemerkung(){
        return bemerkung;
    }
    public Uhrzeit getBeginn(){
        return beginn;
    }
    public Uhrzeit getEnde(){
        return ende;
    }

    public Raum getRaum() {
        return raum;
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
        Reservierung that = (Reservierung) object;
        return Objects.equals(bemerkung, that.bemerkung) &&
                Objects.equals(beginn, that.beginn) &&
                Objects.equals(ende, that.ende) &&
                Objects.equals(raum, that.raum) &&
                Objects.equals(mitarbeiter, that.mitarbeiter);
    }
}