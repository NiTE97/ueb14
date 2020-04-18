import java.util.Objects;

public class Person{
    private String vorname;
    private String nachname;
    private static final String nameErr = "Der Name darf nicht leer sein!";


    //Konstruktor
    public Person(String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);
    }

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

    public String toString(){
        String ausgabe;
        ausgabe = getVorname() + " " + getNachname();
        return ausgabe;
    }

    public String getVorname() {

        return vorname;
    }

    public String getNachname() {

        return nachname;
    }
}