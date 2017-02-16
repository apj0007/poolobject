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
	private ReusablePool rePool;
	Reusable elemento=new Reusable();
	Client cliente=new Client();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rePool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 * Se realiza una llamada al metodo getInstance() comprobando que no devuelve una instancia null
	 */
	@Test
	public void testGetInstance() {
		ReusablePool rePool2 = ReusablePool.getInstance();
		assertTrue(rePool instanceof ReusablePool);
		assertTrue(rePool2 instanceof ReusablePool);
		assertTrue(rePool.equals(rePool2));
	}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		assert(ReusablePool.getInstance().acquireReusable() instanceof Reusable);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
