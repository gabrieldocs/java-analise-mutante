package aula_pittest.exemplo_pit;

import java.util.Date;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected long data_locacao; // 1) O sistema devera registrar a data e hora da locacao

	/**
	 * 
	 * @param c
	 * @param f
	 * @throws Exception 
	 */
	public void alugar(Cliente c, Filme f) throws Exception {
		try {			
			if(!c.ativo) 
				// 2) O sistema deve impedir que usuarios inativos possam alugar filmes
				throw new Exception("Usuario inativo, aluguel bloqueado!"); 
			
			this.cliente = c;
			this.filme = f;
			this.data_locacao = new Date().getTime(); // 1) O sistema deve registrar a data e hora da locacao
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param c
	 * @param f
	 * @throws Exception 
	 */
	public void alugar(Cliente c, Filme f, long d) throws Exception {
		try {
			if(!c.ativo) 
				// 2) O sistema deve impedir que usuarios inativos possam alugar filmes
				throw new Exception("Nao eh possivel alugar, usuario inativo"); 
	
			this.cliente = c;
			this.filme = f;
			this.data_locacao = d;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param valorAluguel
	 */
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel=valorAluguel;
	}
}
