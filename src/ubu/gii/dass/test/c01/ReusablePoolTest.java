/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrés Pérez Juárez
 *
 */
public class ReusablePoolTest {
	//Declaracion de variables
	private ReusablePool rePool;
	Reusable elemento=new Reusable();
	Client cliente=new Client();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Inicialización de rePool y declaración de vector de Reusable
		rePool = ReusablePool.getInstance();
		reusables = new Vector<Reusable>(2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//Asserts para la clase Client() y Reusable()
		assertNotNull(cliente);
		assertNotNull(new Client());
		assertNotNull(elemento);
		assertNotNull(new Reusable());
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 * Se realiza una llamada al metodo getInstance() comprobando que no devuelve una instancia null
	 */
	@Test
	public void testGetInstance() {
		//Creación de rePool
		ReusablePool rePool2 = ReusablePool.getInstance();
		//Comprobación de que no es null
		assertTrue(rePool instanceof ReusablePool);
		assertTrue(rePool2 instanceof ReusablePool);
		//Comprobacion de que ambos ReusablePool son iguales
		assertTrue(rePool.equals(rePool2));
	}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() throws NotFreeInstanceException{
		//Creación de objeto Reusable que nos indicara cuando no existen más objetos Reusable
		Reusable flag = rePool.acquireReusable();
		try{
			while(flag!=null){
				flag=rePool.acquireReusable();
			}
		}catch(NotFreeInstanceException e){
			System.err.println(e);
		}
	
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() throws  DuplicatedInstanceException,NotFreeInstanceException{
		//reu1 y reu2 se añaden al vectro de Reusable
		reusables.add(reu1);
		reusables.add(reu2);
		try{
			//reu3 solicita un objeto Reusable
			reu3=rePool.acquireReusable();
			//reu3 se añade al vectro de Reusable
			reusables.add(reu3);
			//Se comprueba que no se puede añadir dos veces el mismo objeto Reusable
			rePool.releaseReusable(reu3);
			rePool.releaseReusable(reu3);
		}catch(DuplicatedInstanceException e){
			System.err.println(e);}
	}
}
