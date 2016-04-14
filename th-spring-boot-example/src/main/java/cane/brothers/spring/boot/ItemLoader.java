package cane.brothers.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cane.brothers.spring.model.Item;
import cane.brothers.spring.repo.ItemRepository;

@Component
public class ItemLoader implements ApplicationListener<ContextRefreshedEvent> {

	//private Logger log = Logger.getLogger(ItemLoader.class);
	
	@Autowired
	private ItemRepository repo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Item item1 = new Item(true, "first checked item");
		repo.save(item1);
		//log.info("Saved item - id: " + item1.getId());
		
		
		Item item2 = new Item(false, "seccond unchecked item");
		repo.save(item2);
		//log.info("Saved item - id: " + item2.getId());
	}

}
