package com.engineeringwithramaa.etlspringbatchparalleljobs.batch;

import com.engineeringwithramaa.etlspringbatchparalleljobs.model.Item;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class JobWriter implements ItemWriter<Item> {
    private Item item = new Item();
    @Override
    public void write(List<? extends Item> items) throws Exception {
      System.out.println("JobWriter:: write() -> item: " + item);

      item.setId(items.get(0).getId());
      item.setDate(items.get(0).getDate());
    }
    public Item getOutput() {
        return item;
    }
}
