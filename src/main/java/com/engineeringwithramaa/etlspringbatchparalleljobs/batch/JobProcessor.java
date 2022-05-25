package com.engineeringwithramaa.etlspringbatchparalleljobs.batch;

import com.engineeringwithramaa.etlspringbatchparalleljobs.model.Item;
import org.springframework.batch.item.ItemProcessor;

public class JobProcessor implements ItemProcessor<Item, Item> {
    @Override
    public Item process(Item item) throws Exception {
        System.out.println("JobProcessor::process() -> item: " + item);

        Item model = new Item();
        model.setId(item.getId());
        model.setDate(item.getDate());

        return model;
    }
}
