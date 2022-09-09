package aula_pittest.exemplo_pit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TransacaoTest {

	Transacao transacao;
	
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3; // Adicionei esta nova locacao para verificar os casso de falha
	
	Filme filme1;
	Filme filme2;
	Filme filme3; // Adicionei este novo filme para verificar os casos de falha

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme1.valorCompra = 100;

		filme2 = new Filme("JavaScript", Genero.DRAMA);
		filme2.valorCompra = 50;
		filme2.id=20;
		
		filme3 = new Filme("O conde de montecristo", Genero.DRAMA);
		filme3.valorCompra = 60;
		filme3.id = 21;
		
		locacao1.alugar(new Cliente("Izaias", 2, true), filme1);
		locacao2.alugar(new Cliente("Thiago", 3, true), filme2);
		locacao3.alugar(new Cliente("Lucas Gabriel", 999), filme3);

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
	public void valorLocacaoTotalTest3() {
		System.out.println("Alugando...");
		transacao.addLocacao(locacao1);
		transacao.addLocacao(locacao2);
		transacao.addLocacao(locacao3);
		System.out.println(transacao.valorLocacaoTotal());
		assertEquals(150, transacao.valorLocacaoTotal(), 0.1);
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
	
	@Test 
	public void consultaGeneroMaisAlugados() {
		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		System.out.println(transacao.consultaGeneroMaisAlugados());
		assertEquals(transacao.consultaGeneroMaisAlugados(), Genero.DRAMA);
	}

}
