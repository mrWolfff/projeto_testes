
package Testes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Main.ConstNameEval;

@RunWith(Parameterized.class)
public class ConstNameEvalTests {

	private ConstNameEval evaluator;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "@AAA", false }, { "1AAA", false }, { " ", false }, { "_AAA", true } });
	}

	@Before
	public void setUp() {
		evaluator = new ConstNameEval();
	}

	@Test
	public void falseFirstNumericCase() {
		boolean result = evaluator.isValid("1AAA");
		Assert.assertEquals(false, result);
	}

	@Test(timeout = 1000, expected = IndexOutOfBoundsException.class)
	public void falseFirstAlphanumericCase() {
		boolean result = evaluator.isValid("@AAA");
		Assert.assertEquals(false, result);
	}

	@Test(expected = NullPointerException.class)
	public void falseNullCase() {
		boolean result = evaluator.isValid(" ");
		Assert.assertEquals(false, result);
	}

	@Test
	public void TrueFirstUnderlineCase() {
		boolean result = evaluator.isValid("_AAA");
		Assert.assertEquals(true, result);
	}
}
