package aula_pittest.exemplo_pit;

import java.util.ArrayList;

public class Transacao {

	protected  ArrayList<Locacao> alugueis;
	
	public Transacao() {
		alugueis = new ArrayList<Locacao>();
	}
	
	/**
	 * 
	 * @param l
	 * @return
	 */
	public boolean addLocacao(Locacao l) {
		try {			
			if(!l.cliente.ativo) {
				return false;
			}
			this.alugueis.add(l);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public double valorLocacaoTotal() {
	    double valor=0;
		for (Locacao locacao : alugueis) {
			valor +=locacao.filme.valorCompra;
		}																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
		return valor;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Cliente buscaCliente(int id) {
		for (Locacao locacao : alugueis) {
			if(locacao.cliente.id==id) {
				return locacao.cliente;
			}
			
		}
		return null;
	}
	
	/**
	 * 
	 * @param filmeId
	 * @return
	 */
	public double calculoLucro(int filmeId) {
		double valor=0;
		Filme aux = null;
		for (Locacao locacao : alugueis) {
			if(locacao.filme.id==filmeId) {
				valor += locacao.valorAluguel;
				aux = locacao.filme;
			}
			
		}
		return (valor*100)/aux.valorCompra;
	}
	
	/**
	 * 3) O sistema deverá permitir consultar quais os generos mais alugados entre todos os alugueis
	 * @return
	 */
	public ArrayList<Locacao> consultaGeneroMaisAlugados() {
		return this.alugueis;
	}
	
	public void imprimeLocacoes() {
		System.out.println("========================");
		System.out.println("=======  LOCACOES  =====");
		System.out.println("========================");
		for(Locacao l: alugueis) {
			System.out.println(l.filme.nome);
		}
		System.out.println("========================");
	}
	
}
