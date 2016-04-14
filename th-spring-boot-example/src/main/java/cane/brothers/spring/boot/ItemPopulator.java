package cane.brothers.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import cane.brothers.spring.model.Item;
import cane.brothers.spring.repo.ItemRepository;

/**
 * ApplicationStartedEvent
* ApplicationEnvironmentPreparedEvent
* ApplicationPreparedEvent
* ApplicationReadyEvent
* ApplicationFailedEvent
* 
* ContextRefreshedEvent
 */
@Component
public class ItemPopulator {

	@Autowired
	private ItemRepository repo;
	
	@EventListener
	public void handleContextRefresh(ApplicationReadyEvent event) {
		Item item1 = new Item(true, "heh");
		repo.save(item1);
    }
}
