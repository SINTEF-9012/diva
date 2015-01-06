package diva.rest.input.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import diva.rest.input.abstracts.ServiceAttribute;
import diva.rest.input.abstracts.ServiceCategory;

public class TestJsonInput {
	
	
	
//	@Before
//	public void setUp(){
//		jsonRoot = JsonRoot.INSTANCE;
//	}
	
	@Test 
	public void testNumOfOfferings(){
		assertEquals(3, JsonRoot.INSTANCE.offerings.size());
	}

	@Test
	public void testServiceCategory() {
		ServiceCategory sc = new ServiceCategoryJson();
		System.out.println(sc.getCategories());
		assertEquals(3, sc.getCategories().size());
		assertEquals("OrbiInstance1",sc.getServices("OrbiServiceLevelProfile").get(0));
		assertEquals(0, sc.getServices("SomethingElse").size());
		assertEquals("DBInstance1", sc.getGroup("DBInstance1").get(0));
		assertEquals(0, sc.getGroup("SomethingElse").size());
	}
	
	@Test
	public void testServiceAttribute(){
		ServiceAttribute sa = new ServiceAttributeJson();
		System.out.println(sa.listCommonAttributes());
		assertEquals(2000, sa.get("OrbiInstance1", "HTTPResponseTime"));
		assertEquals(2, sa.get("OrbiInstance1", "CPUvCores"));
		assertEquals(98, sa.get("ASInstance1", "Uptime"));
		assertEquals(8, sa.get("ASInstance1", "CPULoadAvgPerCore"));
		
	}

}
