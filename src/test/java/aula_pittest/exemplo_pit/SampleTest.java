package aula_pittest.exemplo_pit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SampleTest{
    
    @Before
    public void setUp() throws Exception {
        System.out.println("["+ new Date() + "]> Executa antes do teste");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("["+ new Date() + "]> Executa depois do teste");
    }
    
    @Test
    public void testSample() {
        System.out.println("Imprimindo agora o valor do teste: 10");
        assertTrue(true);
    }
}
