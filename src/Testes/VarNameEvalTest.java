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

import Main.VarNameEval;

@RunWith(Parameterized.class)
public class VarNameEvalTest {

	private VarNameEval varNameEval;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"aaa", true},
			{"Baa", false},
			{"1aa", false},
			{"@aa", false},
			{" ", false},
			{"_aaa", true}
		});
	}
	
	@Before
	public void setUp() {
		varNameEval = new VarNameEval();
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Iniciando Testes: ");
	}
	
	@Test
	public void trueFirstLowerCase() {
		boolean result = varNameEval.isValid("a");
		Assert.assertEquals(true, result);
	}

	@Test(timeout = 1000, expected = IndexOutOfBoundsException.class)
	public void falseFirstLowerCase() {
		boolean result = varNameEval.isValid("A");
		Assert.assertEquals(false, result);
	}

	@Test
	public void falseFirstNumberCase() {
		boolean result = varNameEval.isValid("1aaa");
		Assert.assertEquals(false, result);
	}
	@Test
	public void falseFirstAlphanumericCase() {
		boolean result = varNameEval.isValid("@aaa");
		Assert.assertEquals(false, result);
	}
	@Test(expected = NullPointerException.class)
	public void falseNullCase() {
		boolean result = varNameEval.isValid(" ");
		Assert.assertEquals(false, result);
	}
	@Test
	public void TrueFirstUnderlineCase() {
		boolean result = varNameEval.isValid("_aaa");
		Assert.assertEquals(true, result);
	}
}
