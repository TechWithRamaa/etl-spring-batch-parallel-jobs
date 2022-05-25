package com.engineeringwithramaa.etlspringbatchparalleljobs.batch;

import com.engineeringwithramaa.etlspringbatchparalleljobs.model.Item;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class JobReader implements ItemReader<Item> {

    private Item item;

    public JobReader(Item item) {
        this.item = item;
    }

    @Override
    public Item read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("JobReader:: read() -> item: " + item);
        return item;
    }
}
