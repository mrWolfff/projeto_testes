package Testes;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Main.ConstNameEval;

@RunWith(Parameterized.class)
public class ConstNameEvalTest {

	private ConstNameEval evaluator;
	private String param;
	private boolean result;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"AAA", true}
		});
	}

	public ConstNameEvalTest(String param, boolean result) {
		this.param = param;
		this.result = result;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Iniciando Testes: ");
	}
	
	@Before
	public void setUp() {
		evaluator = new ConstNameEval();
	}
	
	@Test
	public void validate() {
		boolean value = evaluator.isValid(param);
		Assert.assertEquals(value, result);
	}
	@Test
	public void trueAllUpperCase() {
		boolean result = evaluator.isValid("AAA");
		Assert.assertEquals(true, result);
	}
}
