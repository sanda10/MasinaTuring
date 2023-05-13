package masina.turing;


public class Tranzitie {
    private string stareCurenta;
    private char simbolCitit;
    private string stareUrmatoare;
    private char simbolScris;
    private char directie;

    public Tranzitie(char stareCurenta, char simbolCitit, char stareUrmatoare, char simbolScris, char directie) {
        this.stareCurenta = stareCurenta;
        this.simbolCitit = simbolCitit;
        this.stareUrmatoare = stareUrmatoare;
        this.simbolScris = simbolScris;
        this.directie = directie;
    }

    public char getStareCurenta() {
        return stareCurenta;
    }

    public char getSimbolCitit() {
        return simbolCitit;
    }

    public char getStareUrmatoare() {
        return stareUrmatoare;
    }

    public char getSimbolScris() {
        return simbolScris;
    }

    public char getDirectie() {
        return directie;
    }
}
    

