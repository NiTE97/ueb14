public class Person{
    private String vorname;
    private String nachname;


    //Konstruktor
    public Person(String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);
    }

    public boolean equals(Object object){
        boolean equals = false;
        return equals;
    }

    //Set-Methoden
    private void setVorname(String vorname){
        this.vorname = vorname;
    }
    private void setNachname(String nachname){
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