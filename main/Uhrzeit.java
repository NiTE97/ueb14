import java.util.Objects;
/**
 * Klasse Uhrzeit
 * 
 * Autor Niklas Terwort && Tobias Steuer
 */
public class Uhrzeit{
    /**
     * Klassenattribute
     */
    private int stunde;
    private int minute;
    /**
     * Fehlermeldungen
     */
    private static final String stundeErr = "Die Stunde muss zwischen 0 und 23 liegen";
    private static final String minuteErr = "Die Minute muss zwischen 0 und 59 liegen";

    /**
     * Konstruktor
     * param int stunde     Stunde      Muss zwischen 0 und 23 liegen
     * param int minute     Minute      Muss zwischen 0 und 59 liegen
     */
    public Uhrzeit(int stunde, int minute){
        Validator.check(stunde < 0 || stunde >= 24, stundeErr);
        Validator.check(minute < 0 || minute > 59, minuteErr);

        this.stunde = stunde;
        this.minute = minute;
    }
    
    /**
     * Methode zum vergleichen von Objekten
     * 
     * return boolean
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Uhrzeit uhrzeit = (Uhrzeit) object;
        return stunde == uhrzeit.stunde &&
                minute == uhrzeit.minute;
    }
    
    /**
     * Methode zum Ausgeben der Uhrzeit
     * Form: $Stunde : $Minute
     */
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