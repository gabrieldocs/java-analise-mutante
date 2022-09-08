package aula_pittest.exemplo_pit;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	
	public void alugar(Cliente c, Filme f) {
		this.cliente = c;
		this.filme = f;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel=valorAluguel;
	}
}
