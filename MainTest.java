package Exam;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
	
	static protected String paraules[] = {"hola","adeu","error"};
    static public int index;
    static protected String p;

    static public boolean nova_lletra(char nova) {
        boolean trobada = false;
        String paraula_old = p;
        p = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                p += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                p += paraula_old.charAt(i);
            }
        }
        return trobada;
    }

	@Test
	public void testHauriaDeSerVeritat() {
		//fail("Not yet implemented");
		index = 0;
		for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }
		assertTrue("Prova que sigui true amb 'hola'", nova_lletra('h'));
		
	}
	
	@Test
	public void testHauriaDeSerFals() {
		//fail("Not yet implemented");
		index = 0;
		for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }
		assertFalse("Prova que sigui false amb 'hola'", nova_lletra('z'));
		
	}
	
	@Test
	public void testHauriaDeSerFalsAmbDiferentIndex() {
		//fail("Not yet implemented");
		index = 1;
		for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }
		assertFalse("Prova que sigui false amb 'adeu' amb lletra d'altres índex", nova_lletra('h'));
		
	}
	
	@Test
	public void testHauriaDeSerFalseAmbNombres() {
		//fail("Not yet implemented");
		//Comprovació amb nombres, podria ser qualsevol altre caràcter no lletra
		index = 2;
		for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }
		
		assertFalse("Prova que sigui false amb nombres", nova_lletra('1'));
		
	}

}

