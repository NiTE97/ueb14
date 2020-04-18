import java.util.Objects;

public class Uhrzeit{
    private int stunde;
    private int minute;
    private static final String stundeErr = "Die Stunde muss zwischen 0 und 23 liegen";
    private static final String minuteErr = "Die Minute muss zwischen 0 und 59 liegen";

    //Konstruktor
    public Uhrzeit(int stunde, int minute){
        Validator.check(stunde < 0 || stunde >= 24, stundeErr);
        Validator.check(minute < 0 || minute >= 59, minuteErr);

        this.stunde = stunde;
        this.minute = minute;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Uhrzeit uhrzeit = (Uhrzeit) object;
        return stunde == uhrzeit.stunde &&
                minute == uhrzeit.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stunde, minute);
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