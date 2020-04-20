import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MitarbeiterTest {

    @Test
    public void konstuktorTest(){
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        assert m1.getEmail().equals("max@htwsaar.de");
        assert m1.getVorname().equals("Max");
        assert m1.getNachname().equals("Mustermann");
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestVornameLeer() throws IllegalArgumentException{
        Mitarbeiter m1 = new Mitarbeiter("", "Mustermann", "max@htwsaar.de");
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestNachnameLeer() throws IllegalArgumentException{
        Mitarbeiter m1 = new Mitarbeiter("Max", "", "max@htwsaar.de");
    }


    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestEmailLeer() throws IllegalArgumentException{
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "");
    }


    @Test
    public void reserviereTest() {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Raum r1 = new Raum(18,0,1);
        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14,30), "VOOP");
        String expected = "Raum 18-0.1\n" + " gebucht von Max Mustermann (max@htwsaar.de) von 12:30 Uhr bis 14:30 Uhr für VOOP";
        String actual = r1.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    public void testEqualsTrue() {
        Mitarbeiter m1 = new Mitarbeiter ("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter ("Max", "Mustermann", "max@htwsaar.de");
        assertEquals(m1, m2);
    }
    @Test
    public void testEqualsFalse() {
        Mitarbeiter m1 = new Mitarbeiter ("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter ("Max", "AndererMustermann", "max@htwsaar.de");
        assertNotEquals(m1, m2);
    }

    @Test
    public void testToString() {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String expected = "Max Mustermann (max@htwsaar.de)";
        String actual = m1.toString();
        assertEquals(actual, expected);
    }

    @Test
    public void getEmail() {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String expected = "max@htwsaar.de";
        String actual = m1.getEmail();
        assertEquals(actual, expected);
    }
}
