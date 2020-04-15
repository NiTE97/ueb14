public class Reservierung{
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;

    public Reservierung(Uhrzeit beginn, Uhrzeit ende){
        this.beginn = beginn;
        this.ende = ende;
    }
    public Reservierung(Uhrzeit beginn, Uhrzeit ende, Raum raum, String bemerkung){
        this.beginn = beginn;
        this.ende = ende;
        setRaum(raum);
        setBemerkung(bemerkung);
    }

    public void setBemerkung(String bemerkung){
        this.bemerkung = bemerkung;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter){

    }

    public void setRaum(Raum raum){

    }

    public String toString(){
        String ausgabe;
        ausgabe = "gebucht von ";
        return ausgabe;
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

    public boolean equals(Object object){
        boolean equals = false;
        return equals;
    }
}