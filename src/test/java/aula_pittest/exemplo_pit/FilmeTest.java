package aula_pittest.exemplo_pit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FilmeTest {

	Filme filme;
	@Before
	public void setUp() throws Exception {
		System.out.println("[" + new Date() + "]> Iniciando teste...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("[" + new Date() + "]> Finalizando teste...");
	}

	@Test
	public void testFilme() {
		filme= new Filme("Java", Genero.DRAMA);
		assertEquals("Java", filme.nome);
	}
}
