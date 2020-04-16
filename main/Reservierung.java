public class Reservierung{
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;

    public Reservierung(Uhrzeit beginn, Uhrzeit ende){
        this.beginn = beginn;
        this.ende = ende;
    }

    public void setBemerkung(String bemerkung){
        this.bemerkung = bemerkung;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter){

    }

    public void setRaum(Raum raum){
        String bemerkung = getBemerkung();
        Reservierung reservierung = new Reservierung(getBeginn(), getEnde());
        reservierung.setBemerkung(bemerkung);
        raum.addReservierung(reservierung);
    }

    @Override
    public String toString(){
        String ausgabe;
        ausgabe = "\n gebucht von " +  " von " + getBeginn() + " bis " + getEnde() + " für " + getBemerkung();
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

    @Override
    public boolean equals(Object object){
        boolean equals = false;
        return equals;
    }
}