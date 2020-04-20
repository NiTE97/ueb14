import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RaumTest {

    @Test
    public void konstuktorTest(){
        Raum r1 = new Raum(18, 0, 1);
        assert r1.getEtage() == 0;
        assert r1.getGeb() == 18;
        assert r1.getRaum() == 1;
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestGebNegativTest() throws IllegalArgumentException{
        Raum r1 = new Raum(-1, 0, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestEtageNegativTest() throws IllegalArgumentException{
        Raum r1 = new Raum(18, -1, 1);
    }


    @Test (expected = IllegalArgumentException.class)
    public void konstruktorExceptionTestRaumNegativTest() throws IllegalArgumentException{
        Raum r1 = new Raum(18, 0, -1);
    }

    @Test
    public void addReservierungTest() {
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
        assertEquals(actual, reservierung);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addReservierungZuVollTest() throws IllegalArgumentException{
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
    }

    @Test
    public void testEqualsTrueTest() {
        Raum r1 = new Raum (18,0,1);
        Raum r2 = new Raum (18,0,1);
        assertEquals(r1, r2);
    }
    @Test
    public void testEqualsFalseTest() {
        Raum r1 = new Raum (18,0,1);
        Raum r2 = new Raum (18,0,2);
        assertNotEquals(r1, r2);
    }

    @Test
    public void getReservierungTest(){
        Raum r1 = new Raum (18,0,1);
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
        String expected = "gebucht von Max Mustermann (max@htwsaar.de) von 12:30 Uhr bis 14:30 Uhr für VOOP";
        String actual = r1.getReservierung(0).toString();
        assertTrue(actual.contains(expected));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getReservierungTestLeer() throws IllegalArgumentException {
        Raum r1 = new Raum(18, 0, 1);
        r1.getReservierung(0);
    }

    @Test
    public void getAnzahlReservierungenTest() {
        Raum r1 = new Raum(18, 0, 1);
        Mitarbeiter m1 = new Mitarbeiter("Max", "Mustermann", "max@htwsaar.de");
        m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
        int expected = 1;
        int actual = r1.getAnzahlReservierungen();
        assertEquals(actual, expected);
    }

    @Test
    public void getAnzahlReservierungenVollTest() {
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
        assertEquals(actual, expected);
    }

    @Test
    public void testToString() {
        Raum r1 = new Raum (18,0,1);
        String expected = "Raum 18-0.1";
        String actual = r1.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    public void getEtage() {
        Raum r1 = new Raum (18,0,1);
        int expected = 0;
        int actual = r1.getEtage();
        assertEquals(actual, expected);
    }

    @Test
    public void getGeb() {
        Raum r1 = new Raum (18,0,1);
        int expected = 18;
        int actual = r1.getGeb();
        assertEquals(actual, expected);
    }

    @Test
    public void getRaum() {
        Raum r1 = new Raum (18,0,1);
        int expected = 1;
        int actual = r1.getRaum();
        assertEquals(actual, expected);
    }
}
