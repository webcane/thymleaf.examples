package cane.brothers.spring;

import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cane.brothers.spring.model.Item;
import cane.brothers.spring.repo.ItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
@WebAppConfiguration
public class ThSpringBootExampleApplicationTests {

	@Resource
	private ItemRepository repo;
	
	@Before
	protected void createTestData() {
		Item item1 = new Item(true, "first checked item");
		repo.save(item1);
		
		
		Item item2 = new Item(false, "seccond unchecked item");
		repo.save(item2);
	}
	
	@Test
	public void testGetItemById() {
		Item i = repo.findOne(1);
		assertThat(i, CoreMatchers.notNullValue());
	}
	
	@Test
	public void testGetCheckedItems() {
		List<Item> checkedItems = repo.findByChecked(true);
		assertThat(checkedItems.size(), CoreMatchers.is(1));
	}
	
	@Test
	public void contextLoads() {
	}

}
