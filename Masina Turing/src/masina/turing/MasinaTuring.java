
package masina.turing;
import java.io.*;


public class MasinaTuring {
    private String currentState;
    private String[] finalStates;
    private ListaTranzitii transitions = new ListaTranzitii();
    private char[] tape;
    private int currentPos;

    MasinaTuring(String filename) throws Exception {
        BufferedReader buf = new BufferedReader(new FileReader(filename));
        this.currentState = buf.readLine();
        String finalStatesStr = buf.readLine();
        this.finalStates = finalStatesStr.split(" ");
        while (true) {
            String line = buf.readLine();
            if (line == null)
                break;
            else {
                String[] tbl = line.split(" ");
                Tranzitie tr = new Tranzitie(tbl[0].charAt(0), tbl[1].charAt(0), tbl[2].charAt(0), tbl[1].charAt(1), tbl[1].charAt(2));
                this.transitions.adaugaTranzitie(tr);
            }
        }
        buf.close();
    }

    boolean acceptaCuvant(String input) {
        // Initializam banda cu input si o completam cu spatii libere la dreapta
        this.tape = (input + " ").toCharArray();
        this.currentPos = 0;
        // Cat timp suntem intr-o stare care nu este finala
        while (!isFinalState(this.currentState)) {
            // Cautam tranzitia corespunzatoare starii si simbolului curent de pe banda
            Tranzitie transition = this.transitions.gasesteTranzitie(this.currentState, getCurrentSymbol());
            // Schimbam starea curenta si scriem simbolul specificat pe banda
            this.currentState = transition.spuneStSfarsit();
            this.tape[this.currentPos] = transition.spuneSimbolScrie();
            // Deplasam capul de citire/scriere pe banda in directia specificata de tranzitie
            if (transition.spuneDirectie() == 'L') {
                this.currentPos--;
            } else if (transition.spuneDirectie() == 'R') {
                this.currentPos++;
            }
        }
        // Verificam daca am ajuns intr-o stare finala si daca banda contine doar spatii libere la dreapta
        return isFinalState(this.currentState) && isTapeEmpty();
    }

    private char getCurrentSymbol() {
        // Daca capul de citire/scriere este in afara benzii, returnam un spatiu gol
        if (this.currentPos < 0 || this.currentPos >= this.tape.length) {
            return ' ';
        }
        return this.tape[this.currentPos];
    }

    private boolean isFinalState(String state) {
        for (String finalState : this.finalStates) {
            if (state.equals(finalState)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTapeEmpty() {
        for (int i = this.currentPos; i < this.tape.length; i++) {
            if (this.tape[i] != ' ') {
                return false;
            }
        
   
    

