package aula_pittest.exemplo_pit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
    public Cliente c1;
    public Cliente c2;
    public Cliente c3;
    
    public Filme f1;
    public Filme f2;
    public Filme f3;
    
    public Transacao t1;
    public Locacao l1;

    @Before
    public void setUp() {
        c1 = new Cliente("Lucas", 1);
        c2 = new Cliente("Gabriel", 2);
        c3 = new Cliente("Guilherme", 1, true);
        
        f1 = new Filme("O auto da compadecida", Genero.COMEDIA);
        f2 = new Filme("Minority report: a nova lei", Genero.DRAMA);
        f3 = new Filme("O senhor dos Anéis: As duas torres", Genero.DRAMA);
        
        t1 = new Transacao();
        l1 = new Locacao();
    }

    @After
    public void tearDown() {
        c1 = null;
        c2 = null; 
        c3 = null;
    }

    @Test
    public void testa_cliente_ativo() {
        assertTrue(c1.ativo == false);
        assertTrue(c2.ativo == false);
        assertTrue(c3.ativo == true);
    }
    
    @Test
    public void adiciona_filmes_favoritos() {
    	c3.addFavorito(f1);
    	c3.addFavorito(f2);
    	c3.addFavorito(f3);
    	
    	assertTrue(c3.getFavoritos().get(1).nome.equals(f2.nome));
    	assertTrue(c3.getFavoritos().get(1).genero.equals(f2.genero));
    	assertTrue(c3.getFavoritos().size() == 3);
    }
    
    @Test
    public void cliente_aluga_filme_de_favorito() throws Exception {
    	// Aluga favoritos na lista de c1
    	c3.addFavorito(f1);
    	c3.addFavorito(f2);
    	c3.addFavorito(f3);
    	
    	// Adiciona favoritos na lista de c2
    	c2.ativo = true;
    	c2.addFavorito(f1);
    	c2.addFavorito(f3);
    	
    	// Aluga filmes da lista de favoritos de c3
    	c3.alugaFilmeFavorito(c3.favoritos.get(0), t1);
    	c3.alugaFilmeFavorito(c3.favoritos.get(1), t1);
    	
    	// Aluga filmes da lista de favoritos de c3
    	c2.alugaFilmeFavorito(c2.favoritos.get(0), t1);
    	c2.alugaFilmeFavorito(c2.favoritos.get(1), t1);
    	
    	t1.imprimeLocacoes();
    	
    	assertTrue(t1.alugueis.size() == 4);
    	assertTrue(t1.alugueis.get(0).cliente.nome.equals(c3.nome));
    	assertTrue(t1.alugueis.get(1).cliente.nome.equals(c3.nome));
    	assertTrue(t1.alugueis.get(2).cliente.nome.equals(c2.nome));
    	assertTrue(t1.alugueis.get(3).cliente.nome.equals(c2.nome));
    	
    }
    
    
}
