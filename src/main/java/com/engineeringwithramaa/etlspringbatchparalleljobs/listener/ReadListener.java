package com.engineeringwithramaa.etlspringbatchparalleljobs.listener;

import org.springframework.batch.core.ItemReadListener;

public class ReadListener<T> implements ItemReadListener {
    @Override
    public void beforeRead() {
        System.out.println("ReaderListener::beforeRead()");
    }

    @Override
    public void afterRead(Object item) {
        System.out.println("ReaderListener::afterRead() -> " + item);
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("ReaderListener::onReadError() -> " + e);
    }
}
