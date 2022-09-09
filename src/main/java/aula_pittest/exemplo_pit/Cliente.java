package aula_pittest.exemplo_pit;

import java.util.ArrayList;

public class Cliente {

	protected String nome; 					//Nome do usuário
	protected int id; 						// Propriedade a ser atribuida ao cadastrar usuário
	protected boolean ativo;				// 2) O sistema deve impedir que usuarios inativos possam alugar filmes
	protected ArrayList<Filme> favoritos; 	// 5) O sistema deve permitir que o usuário tenha uma lista de favoritos
	/**
	 * 
	 * @param nome
	 * @param id
	 */
	public Cliente(String nome, int id) {
		this.nome= nome;
		this.id= id;
		this.ativo = false; // 2) O sistema deve impedir que usuarios inativos possam alugar filmes
		this.favoritos = new ArrayList<Filme>();
	}

	/**
	 * 
	 * @param nome
	 * @param id
	 * @param ativo
	 */
	public Cliente(String nome, int id, boolean ativo) {
		this.nome= nome;
		this.id= id;
		this.ativo = ativo; // 2) O sistema deve impedir que usuarios inativos possam alugar filmes
		this.favoritos = new ArrayList<Filme>();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Filme> getFavoritos() {
		return this.favoritos;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public void addFavorito(Filme f) {
		this.favoritos.add(f);
	}
	
	/**
	 * 5) O sistema deve permitir que o cliente alugue de sua lista de favoritos
	 * @param f
	 * @param t
	 * @throws Exception
	 */
	public void alugaFilmeFavorito(Filme f, Transacao t) throws Exception {
		if(this.favoritos != null && this.favoritos.contains(f)) {
			if(this.ativo) {				
				Locacao l = new Locacao();
				l.alugar(new Cliente(this.nome, this.id, this.ativo), f);
				t.addLocacao(l);
			}
		}
	}
	
}
