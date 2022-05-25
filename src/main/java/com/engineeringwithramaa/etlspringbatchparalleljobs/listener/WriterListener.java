package com.engineeringwithramaa.etlspringbatchparalleljobs.listener;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WriterListener<S> implements ItemWriteListener<S> {
    @Override
    public void beforeWrite(List<? extends S> items) {
        System.out.println("ReaderListener::beforeWrite() -> " + items);
    }

    @Override
    public void afterWrite(List<? extends S> items) {
        System.out.println("ReaderListener::afterWrite() -> " + items);
    }

    @Override
    public void onWriteError(Exception e, List<? extends S> items) {
        System.out.println("ReaderListener::onWriteError() -> " + e + ", " + items);
    }
}
