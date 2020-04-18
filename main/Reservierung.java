import java.util.Objects;

public class Reservierung{
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Raum raum;
    private Mitarbeiter mitarbeiter;
    private static final String bemerkungErr = "Die Bemerkung darf nicht leer sein!";

    public Reservierung(Uhrzeit beginn, Uhrzeit ende){
        this.beginn = beginn;
        this.ende = ende;
    }

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

    @Override
    public String toString(){
        String ausgabe;
        ausgabe = "\n gebucht von " + getMitarbeiter() +  " von " + getBeginn() + " bis " + getEnde() + " für " + getBemerkung();
        return ausgabe;
    }

    private Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    private String getBemerkung(){
        return bemerkung;
    }
    private Uhrzeit getBeginn(){
        return beginn;
    }
    private Uhrzeit getEnde(){
        return ende;
    }

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