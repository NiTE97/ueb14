import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaumTest {

    @org.junit.jupiter.api.Test
    void konstuktorTest(){
        Raum r1 = new Raum(18, 0, 1);
        assert r1.getEtage() == 0;
        assert r1.getGeb() == 18;
        assert r1.getRaum() == 1;
    }

    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestGebNegativTest() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Raum r1 = new Raum(-1, 0, 1);
        });
        String expectedMessage = "Die Zahl muss größer als 0 sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestEtageNegativTest() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Raum r1 = new Raum(18, -1, 1);
        });
        String expectedMessage = "Die Zahl muss größer oder gleich 0 sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @org.junit.jupiter.api.Test
    void konstruktorExceptionTestRaumNegativTest() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Raum r1 = new Raum(18, 0, -1);
        });
        String expectedMessage = "Die Zahl muss größer als 0 sein";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void addReservierungTest() {
        Raum r1 = new Raum(18, 0, 1);
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Uhrzeit beginn = new Uhrzeit(12,30);
        Uhrzeit ende = new Uhrzeit(14,30);
        String bemerkung = "VOOP";
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setMitarbeiter(m1);
        reservierung.setBemerkung(bemerkung);
        reservierung.setRaum(r1);
        r1.addReservierung(reservierung);
        Reservierung actual = r1.getReservierung(0);
        assertTrue(actual.equals(reservierung));
    }

    @Test
    void addReservierungZuVollTest() throws IllegalArgumentException{
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Raum r1 = new Raum(18, 0, 1);
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        Uhrzeit beginn = new Uhrzeit(12,30);
        Uhrzeit ende = new Uhrzeit(14,30);
        String bemerkung = "VOOP";
        Reservierung reservierung = new Reservierung(beginn, ende);
        reservierung.setMitarbeiter(m1);
        reservierung.setBemerkung(bemerkung);
        reservierung.setRaum(r1);
        r1.addReservierung(reservierung);
            Reservierung reservierung2 = new Reservierung(beginn, ende);
            reservierung2.setMitarbeiter(m1);
            reservierung2.setBemerkung(bemerkung);
            reservierung2.setRaum(r1);
            r1.addReservierung(reservierung2);
            Reservierung reservierung3 = new Reservierung(beginn, ende);
            reservierung3.setMitarbeiter(m1);
            reservierung3.setBemerkung(bemerkung);
            reservierung3.setRaum(r1);
            r1.addReservierung(reservierung3);
            Reservierung reservierung4 = new Reservierung(beginn, ende);
            reservierung4.setMitarbeiter(m1);
            reservierung4.setBemerkung(bemerkung);
            reservierung4.setRaum(r1);
            r1.addReservierung(reservierung4);
            Reservierung reservierung5 = new Reservierung(beginn, ende);
            reservierung5.setMitarbeiter(m1);
            reservierung5.setBemerkung(bemerkung);
            reservierung5.setRaum(r1);
            r1.addReservierung(reservierung5);
            Reservierung reservierung6 = new Reservierung(beginn, ende);
            reservierung6.setMitarbeiter(m1);
            reservierung6.setBemerkung(bemerkung);
            reservierung6.setRaum(r1);
            r1.addReservierung(reservierung6);
            Reservierung reservierung7 = new Reservierung(beginn, ende);
            reservierung7.setMitarbeiter(m1);
            reservierung7.setBemerkung(bemerkung);
            reservierung7.setRaum(r1);
            r1.addReservierung(reservierung7);
            Reservierung reservierung8 = new Reservierung(beginn, ende);
            reservierung8.setMitarbeiter(m1);
            reservierung8.setBemerkung(bemerkung);
            reservierung8.setRaum(r1);
            r1.addReservierung(reservierung8);
            Reservierung reservierung9 = new Reservierung(beginn, ende);
            reservierung9.setMitarbeiter(m1);
            reservierung9.setBemerkung(bemerkung);
            reservierung9.setRaum(r1);
            r1.addReservierung(reservierung9);
            Reservierung reservierung10 = new Reservierung(beginn, ende);
            reservierung10.setMitarbeiter(m1);
            reservierung10.setBemerkung(bemerkung);
            reservierung10.setRaum(r1);
            r1.addReservierung(reservierung10);
            Reservierung reservierung11 = new Reservierung(beginn, ende);
            reservierung11.setMitarbeiter(m1);
            reservierung11.setBemerkung(bemerkung);
            reservierung11.setRaum(r1);
            r1.addReservierung(reservierung11);
        });
        String expected = "Dieser Raum ist schon voll belegt";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    void testEqualsTrueTest() {
        Raum r1 = new Raum (18,0,1);
        Raum r2 = new Raum (18,0,1);
        assertTrue(r1.equals(r2));
    }
    @Test
    void testEqualsFalseTest() {
        Raum r1 = new Raum (18,0,1);
        Raum r2 = new Raum (18,0,2);
        assertFalse(r1.equals(r2));
    }

    @Test
    void getReservierungTest(){
            Raum r1 = new Raum (18,0,1);
            Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
            m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
            String expected = "gebucht von Max Mustermann (max@htwsaar.de) von 12:30 Uhr bis 14:30 Uhr für VOOP";
            String actual = r1.getReservierung(0).toString();
            assertTrue(actual.contains(expected));

    }

    @Test
    void getAnzahlReservierungenTest() {
        Raum r1 = new Raum(18, 0, 1);
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
        int expected = 1;
        int actual = r1.getAnzahlReservierungen();
        assertTrue(actual == expected);
    }

    @Test
    void getAnzahlReservierungenVollTest() {
        Raum r1 = new Raum(18, 0, 1);
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        m1.reserviere(r1, new Uhrzeit(2, 30), new Uhrzeit(4, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(4, 30), new Uhrzeit(6, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(6, 30), new Uhrzeit(8, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(8, 30), new Uhrzeit(10, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(10, 30), new Uhrzeit(12, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(14, 30), new Uhrzeit(16, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(16, 30), new Uhrzeit(18, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(18, 30), new Uhrzeit(20, 30), "VOOP");
        m1.reserviere(r1, new Uhrzeit(20, 30), new Uhrzeit(22, 30), "VOOP");
        int expected = 10;
        int actual = r1.getAnzahlReservierungen();
        assertTrue(actual == expected);
    }

    @Test
    void testToString() {
        Raum r1 = new Raum (18,0,1);
        String expected = "Raum 18-0.1";
        String actual = r1.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    void getEtage() {
        Raum r1 = new Raum (18,0,1);
        int expected = 0;
        int actual = r1.getEtage();
        assertTrue(actual == expected);
    }

    @Test
    void getGeb() {
        Raum r1 = new Raum (18,0,1);
        int expected = 18;
        int actual = r1.getGeb();
        assertTrue(actual == expected);
    }

    @Test
    void getRaum() {
        Raum r1 = new Raum (18,0,1);
        int expected = 1;
        int actual = r1.getRaum();
        assertTrue(actual == expected);
    }
}