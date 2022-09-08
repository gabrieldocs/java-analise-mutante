package aula_pittest.exemplo_pit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Filme filme1;
	Filme filme2;

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme1.valorCompra = 100;

		filme2 = new Filme("JavaScript", Genero.ROMANCE);
		filme2.valorCompra = 50;
		filme2.id=20;

		locacao1.alugar(new Cliente("Izaias", 2), filme1);
		locacao2.alugar(new Cliente("Thiago", 3), filme2);
		

		transacao = new Transacao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void valorLocacaoTotalTest() {

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Izaias");
		assertTrue("Filme deveria ser selecionado corretamente",transacao.alugueis.get(1).filme.id==20);
		assertEquals(150, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test
	public void valorLocacaoTotalTest2() {

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao2);
		assertEquals(200, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test 
	public void buscaClienteIdTest() {
		
		transacao.alugueis.add(locacao2);
		assertEquals("Thiago",transacao.buscaCliente(3).nome);
	}
	
	@Test
	public void buscarClientePorIdNulo() {
		transacao.alugueis.add(locacao2);
		assertTrue(transacao.buscaCliente(4)==null);	
	}
	@Test 
	public void calculoLucroTest() {
		
		locacao2.setValorAluguel(25);
		transacao.alugueis.add(locacao2);
		
		assertEquals(50,transacao.calculoLucro(20),0.01);
	}
	public void test1() {

		assertEquals(Math.PI, 3.14, 0.01);
		assertTrue("java".equalsIgnoreCase("Java"));
		Filme f =new Filme("a", Genero.ROMANCE);
		assertNull(f); // assertNotNull();
		Filme f2 =new Filme("a", Genero.ROMANCE);

		assertTrue(f==f2);
		
		assertSame(f, f2); // asserNotSame)();

		assertTrue("Comparacao de objetos", f == f2);

	}

}
