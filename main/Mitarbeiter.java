public class Mitarbeiter extends Person{
    private String email;

    //Konstruktor
    public Mitarbeiter (String vorname, String nachname, String email){
        super(vorname, nachname);
        setEmail(email);
    }


    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung){
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setBemerkung(bemerkung);
        raum.addReservierung(reservierung);
    }

    public boolean equals(Object object){
        boolean equals = false;
        return equals;
    }


    public String toString(){
        String ausgabe;
        ausgabe = getVorname() + " " + getNachname() + " (" + getEmail() + ")";
        return ausgabe;
    }



    //Get-Methode
    public String getEmail(){

        return email;
    }

    //Set-Methode
    private void setEmail(String email){

        this.email = email;
    }
}