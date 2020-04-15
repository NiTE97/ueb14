public class Uhrzeit{
    private int stunde;
    private int minute;

    //Konstruktor
    public Uhrzeit(int stunde, int minute){
        this.stunde = stunde;
        this.minute = minute;
    }

    public boolean equals(Object object){
        boolean equals = false;
        return equals;
    }

    public String toString(){
        String ausgabe;
        ausgabe = getStunde() + ":" + getMinute() + " Uhr";
        return ausgabe;
    }

    //Get-Methoden
    public int getStunde(){
        return stunde;
    }

    public int getMinute() {
        return minute;
    }
}