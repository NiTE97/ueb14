import java.util.Objects;

public class Mitarbeiter extends Person{
    private String email;

    private static final String emailErr = "Die Email darf nicht leer sein!";

    //Konstruktor
    public Mitarbeiter (String vorname, String nachname, String email){
        super(vorname, nachname);
        setEmail(email);
    }

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung){
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        reservierung.setRaum(raum);
        Mitarbeiter reservierenderMitarbeiter = new Mitarbeiter(getVorname(), getNachname(), getEmail());
        reservierung.setMitarbeiter(reservierenderMitarbeiter);
        raum.addReservierung(reservierung);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Mitarbeiter that = (Mitarbeiter) object;
        return Objects.equals(email, that.email);
    }

    @Override
    public String toString(){
        String ausgabe;
        ausgabe = super.toString() + " (" + getEmail() + ")";
        return ausgabe;
    }



    //Get-Methode
    public String getEmail(){

        return email;
    }

    //Set-Methode
    private void setEmail(String email){
        Validator.check(email == null || email.trim().isEmpty(), emailErr);
        this.email = email;
    }
}