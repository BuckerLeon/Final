package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.RateDomainModel;

public class Rate_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		RateDomainModel rate = new RateDomainModel();
		rate.setRateID(null);
		rate.setMinCreditScore(753);
		rate.setInterestRate(0.03945);
		
		RateDAL.getRate(753);
		
	}

}
