package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Conversor;

class ConversorTest {

	@Test
	void testCostrutor() {
		Conversor c = new Conversor("xxx");
	}
	

	@Test
	void testGetVetor() {
		Conversor c = new Conversor("XC");
		assertEquals("cx", c.getVetor().toString());
	}

	@Test
	void testInserssaoDeVetor() {
		Conversor c = new Conversor("XC");
		assertEquals("cx", c.getVetor().toString());
	}

	@Test
	void testGetResultadoComUmValor() {
		Conversor c = new Conversor("v");
		assertEquals(5, c.getResultado());
	}


	@Test
	void testGetResultadoComDoisValores() {
		Conversor c = new Conversor("xx");
		assertEquals(20, c.getResultado());
	}

	@Test
	void testGetResultadoComTresValores() {
		Conversor c = new Conversor("xxi");
		assertEquals(20, c.getResultado());
	}

	@Test
	void testValoresValidos() {
		Conversor c = new Conversor("xxxx");
		assertThrows(IllegalArgumentException.class, () ->{
			c.verificacao();
		});
	}


	@Test
	void testVerificacao() {
		Conversor c = new Conversor("xxxx");
		 assertThrows(IllegalArgumentException.class, () ->{
			 c.verificacao();
		 });
	}
	
	@Test
	void testVerificacao2() {
		Conversor c = new Conversor("vv");
		 assertThrows(IllegalArgumentException.class, () ->{
			 c.verificacao();
		 });
	}
	
	

}
