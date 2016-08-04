package academia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ExercicioTest {
	private Exercicio exc1;
	private Exercicio exc2;
	
	@Before
	public void criaExercicio() throws Exception {
		exc1 = new Exercicio("abdominal", 200);
	}
	
	@Test
	public void testExercicio() {
	    assertEquals("Nome do exercicio esta errado.", 
	                 "abdominal",exc1.getNome());
	    assertEquals("Cph do exercicio esta errada.", 200,exc1.getCph());

	try {
	   exc2 = new Exercicio(null, 200);
	   fail("Deveria ter lancado excecao de nome");
	} catch ( Exception exp ) {
	    assertEquals("Mensagem de excecao capturada.","O nome do exercicio não pode ser null", exp.getMessage());
		}
	}
	
	@Test
	public void testEqualsObject() throws Exception {
		
		Exercicio exc2 = new Exercicio("abdominal", 200);
		Exercicio exc3 = new Exercicio("corrida", 700);
		Exercicio exc4 = new Exercicio("abdominal", 201);
		Exercicio exc5 = new Exercicio("natacao", 700);
		
		assertEquals(exc1, exc1);
		assertEquals(exc1, exc2);
		assertNotEquals(exc1, exc3);
		assertEquals(exc1, exc4);
		assertNotEquals(exc3, exc5);
	}
	
	@Test
	public void testCalPerHoras() throws Exception {
	   // testando comportamento em situacao correta
	   assertEquals("Valor de cal por horas incorreto.", 600,exc1.calPerHoras(3));
	   
	   // Existe um valor limite? O que acontece se passar 0 minutos?      
	   // Isso deve ser especificado
	   assertEquals("Valor de cal por minutos incorreto.", 0,exc1.calPerHoras(0));
	   
	   // e se passar minutos negativos?
	   try {
	      exc1.calPerHoras(-30);
	      fail("Deveria lançar exceção de horas negativos");
	   } catch (Exception exp) {
	      assertEquals("Mensagem de excecao no metodo calPerHoras","O tempo passado nao pode ser negativo",exp.getMessage());
	   }
	}
}
	

