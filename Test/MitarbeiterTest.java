import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {

    @org.junit.jupiter.api.Test
    void konstuktorTest(){
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        assert m1.getEmail().equals("max@htwsaar.de");
        assert m1.getVorname().equals("Max");
        assert m1.getNachname().equals("Mustermann");
    }

    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestVornameLeer() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Mitarbeiter m1 = new Mitarbeiter("", "Mustermann", "max@htwsaar.de");
        });
        String expectedMessage = "Name darf nicht leer sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestNachnameLeer() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Mitarbeiter m1 = new Mitarbeiter("Max", "", "max@htwsaar.de");
        });
        String expectedMessage = "Name darf nicht leer sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestEmailLeer() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "");
        });
        String expectedMessage = "Email darf nicht leer sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @org.junit.jupiter.api.Test
    void reserviereTest() {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Raum r1 = new Raum(18,0,1);
        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14,30), "VOOP");
        String expected = "Raum 18-0.1\n" + " gebucht von Max Mustermann (max@htwsaar.de) von 12:30 Uhr bis 14:30 Uhr für VOOP";
        String actual = r1.toString();
        assertTrue(actual.contains(expected));
    }

    @org.junit.jupiter.api.Test
    void testEqualsTrue() {
        Mitarbeiter m1 = new Mitarbeiter ("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter ("Max", "Mustermann", "max@htwsaar.de");
        assertTrue(m1.equals(m2));
    }
    @Test
    void testEqualsFalse() {
        Mitarbeiter m1 = new Mitarbeiter ("Max", "Mustermann", "max@htwsaar.de");
        Mitarbeiter m2 = new Mitarbeiter ("Max", "AndererMustermann", "max@htwsaar.de");
        assertFalse(m1.equals(m2));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String expected = "Max Mustermann (max@htwsaar.de)";
        String actual = m1.toString();
        assertTrue(actual.equals(expected));
    }

    @org.junit.jupiter.api.Test
    void getEmail() {
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        String expected = "max@htwsaar.de";
        String actual = m1.getEmail();
        assertTrue(actual.equals(expected));
    }
}