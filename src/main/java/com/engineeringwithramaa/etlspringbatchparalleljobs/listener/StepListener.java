package com.engineeringwithramaa.etlspringbatchparalleljobs.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import java.awt.event.ItemListener;

public class StepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("StepListener::beforeStep() -> Step " + stepExecution.getStepName() + " completed for "
                + stepExecution.getJobExecution().getJobInstance().getJobName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("StepListener::afterStep() -> Step " + stepExecution.getStepName() + " started for "
                + stepExecution.getJobExecution().getJobInstance().getJobName());

        return null;
    }
}
