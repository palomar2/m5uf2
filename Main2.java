package Exam;

import java.util.Scanner;
import java.util.Random;

/**
 * Classe principal desde la qual es carrega el joc de paraules.
 * <p>
 * Entre ses atributs hi ha tres variables static protected:
 * una array tipus String on s'emmagatzemen les paraules del joc;
 * una tipus enter que és l'índex; i una altre tipus String.
 * <p>
 * Primer es genera el valor de la variable "index" de forma aleatòria.
 * A partir d'açò es fa un bucle amb tantes iteracions com longitud
 * de la cadena de text de la paraula escollida de l'array
 * per mitjà de l'índex. D'aquesta manera s'obté la quantitat d'espais
 * en blanc per a la variable "p".
 * <p>
 * Posteriorment s'inicialitzen les variables per al número d'errors
 * i l'objecte que agafarà les entrades de l'usuari. S'inicia tot
 * seguit un bucle condicional amb el qual es comprova no excedir
 * el límit d'intents i que la variable "p" no sigui igual que
 * la paraula escollida segons l'índex.
 * <p>
 * Dins del bucle es fa una comprovació amb el mètode {@link #nova_lletra()}
 * i si no és correcte aleshores compta un intent d'error.
 * 
 * 
 * @version 1
 * @author ies
 *
 */

public class Main2 {

    static protected String paraules[] = {"hola","programació","casa"};
    static protected int index;
    
    public static void main(String[] args) {
    	String paraula = "";

    	System.out.println("Comença el joc!");

        Random rand = new Random();
        index = rand.nextInt(3);
        for (int i=0; i<paraules[index].length(); i++) {
            paraula += "_";
        }

        System.out.println(paraula);

        Scanner reader = new Scanner(System.in);

        int num_errors = 0;

        while (!paraula.equals(paraules[index]) && num_errors < 5) {
            if (!nova_lletra(reader.next().charAt(0), paraula)) {
                num_errors++;
            }
            System.out.println(paraula);
        }
        
        reader.close();
   }

    /**
     * Mètode static booleà encarregat de saber si
     * la lletra introduïda es correcte o no d'acord
     * amb la paraula escollida.
     * <p>
     * Inicia una variable booleana amb "trobada" en estat fals,
     * emmagatzema la paraula escollida en variable auxiliar,
     * posa buida la variable original i fa un bucle.
     * En aquest bucle es comprovarà si la lletra es troba, fixant
     * a vertader la variable booleana, o bé deixant a fals dita
     * variable i recuperant el valor original que tenía la "p", fent
     * una reconstrucció.
     * 
     * @param nova Variable amb el caràcter per evaluar passada per paràmetre.
     * @return Retornarà vertader o fals segons si es troba o no la lletra a la paraula escollida.
     */
    static public boolean nova_lletra(char nova, Paraula paraula) {
        boolean trobada = false;
        Paraula auxiliar_paraula = paraula;
        String nova_paraula = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                nova_paraula += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                nova_paraula += auxiliar_paraula.charAt(i);
            }
        }
        paraula.setParaula(nova_paraula);
        return trobada;
    }
    
    //L'opció de fer servir un objecte es la primera ideia, però no és correcte.
    class Paraula {
    	String paraula;
    	
    	public Paraula (String paraula) {
    		this.paraula = paraula;
    	}
    	
    	public void setParaula (String paraula) {
    		this.paraula = paraula;
    	}
    	
    	public String getParaula () {
    		return paraula;
    	}
    	
    	public charAt(){
    		
    	}
    }

}

