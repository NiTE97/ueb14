import java.util.Objects;

/**
 * Klasse Person
 * 
 * Autor Niklas Terwort && Tobias Steuer
 */
public class Person{
    /**
     * Klassenattribute
     */
    private String vorname;
    private String nachname;
    /**
     * Fehlermeldung
     */
    private static final String nameErr = "Der Name darf nicht leer sein!";

    /**
     * Konstruktor
     * param String vorname     Vorname
     * param String nachname    Nachname
     */
    public Person(String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);
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
        Person person = (Person) object;
        return Objects.equals(vorname, person.vorname) &&
                Objects.equals(nachname, person.nachname);
    }

    //Set-Methoden
    private void setVorname(String vorname){
        Validator.check(vorname == null || vorname.trim().isEmpty(), nameErr);
        this.vorname = vorname;
    }
    private void setNachname(String nachname){
        Validator.check(nachname == null || nachname.trim().isEmpty(), nameErr);
        this.nachname = nachname;
    }
    /**
     * Methode zum Ausgeben der Person
     * Form: $Vorname $Nachname
     * 
     * return ausgabe
     */
    public String toString(){
        String ausgabe;
        ausgabe = getVorname() + " " + getNachname();
        return ausgabe;
    }
    //Get-Methoden
    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }
}