import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReservierungTest {

    @Test
    public void konstuktorTest(){
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String bemerkung = "VOOP";
        r1.setMitarbeiter(m1);
        r1.setBemerkung(bemerkung);
        assert r1.getBeginn().equals(new Uhrzeit(13, 30));
        assert r1.getEnde().equals(new Uhrzeit(14, 30));
        assert r1.getMitarbeiter().equals(new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de"));
        assert r1.getBemerkung().equals("VOOP");
    }

    @Test
    public void setBemerkungTest() {
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String bemerkung = "VOOP";
        r1.setMitarbeiter(m1);
        r1.setBemerkung(bemerkung);
        assertEquals("VOOP", r1.getBemerkung());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setBemerkungTestIllegalArgumentException() throws IllegalArgumentException{
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String bemerkung = "";
        r1.setMitarbeiter(m1);
        r1.setBemerkung(bemerkung);
        r1.getBemerkung();
    }


    @Test
    public void setMitarbeiter() {
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String bemerkung = "VOOP";
        r1.setMitarbeiter(m1);
        r1.setBemerkung(bemerkung);
        assertEquals(r1.getMitarbeiter(), new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void setMitarbeiterVornameTestIllegalArgumentException() throws IllegalArgumentException{
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Mitarbeiter m1 = new Mitarbeiter("", "Mustermann", "max@htwsaar.de");
        String bemerkung = "";
        r1.setMitarbeiter(m1);
        r1.setBemerkung(bemerkung);
        r1.getBemerkung();
    }

    @Test
    public void setRaumTest() {
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String bemerkung = "VOOP";
        Raum raum = new Raum (18,0,1);
        r1.setRaum(raum);
        r1.setMitarbeiter(m1);
        r1.setBemerkung(bemerkung);
        assertEquals(r1.getRaum(), new Raum(18,0,1));
    }

    @Test
    public void testToString() {
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String bemerkung = "VOOP";
        Raum raum = new Raum (18,0,1);
        r1.setRaum(raum);
        r1.setMitarbeiter(m1);
        r1.setBemerkung(bemerkung);
        String expected = "\n gebucht von Max Mustermann (max@htwsaar.de) von 13:30 Uhr bis 14:30 Uhr für VOOP";
        String actual = r1.toString();
        assertEquals(actual, expected);
    }

    @Test
    public void testEqualsTrueTest() {
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Reservierung r2 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        assertEquals(r1, r2);
    }
    @Test
    public void testEqualsFalseTest() {
        Reservierung r1 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(14,30));
        Reservierung r2 = new Reservierung(new Uhrzeit(13,30), new Uhrzeit(15,30));
        assertNotEquals(r1, r2);
    }
}
