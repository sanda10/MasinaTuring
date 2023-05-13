
package masina.turing;
import java.io.BufferedReader;
import java.io.FileReader;


public class Test {
     public static void main(String[] args) throws Exception {
        MasinaTuring m = new MasinaTuring("C:\\Users\\Sanda\\Desktop\\MasinaTuring.txt");

        // Testam cuvantul "a^n b^n"
        String cuvant = "aabb";
        boolean acceptat = m.acceptaCuvant(cuvant);
        System.out.println("Cuvantul " + cuvant + (acceptat ? " este acceptat" : " nu este acceptat"));
    }
}

     
    
     
