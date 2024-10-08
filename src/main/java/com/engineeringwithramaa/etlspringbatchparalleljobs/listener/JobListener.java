package com.engineeringwithramaa.etlspringbatchparalleljobs.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class JobListener implements JobExecutionListener {
    private JobExecution active;

    @Autowired
    private JobOperator jobOperator;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        final String jobName = jobExecution.getJobInstance().getJobName();
        final BatchStatus jobStatus = jobExecution.getStatus();

        System.out.println("JobListener::beforeJob() -> jobExecution: " + jobName + ", " + jobStatus.getBatchStatus());

        synchronized (jobExecution) {
            if (active != null && active.isRunning()) {
                System.out.println("JobListener::beforeJob(): isRunning() -> jobExecution: " + jobName + ", "
                        + jobStatus.isRunning());
                try {
                    jobOperator.stop(jobExecution.getId());
                } catch (NoSuchJobExecutionException | JobExecutionNotRunningException e) {
                    e.printStackTrace();
                }
            } else {
                active = jobExecution;
            }
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        final String jobName = jobExecution.getJobInstance().getJobName();
        final BatchStatus jobStatus = jobExecution.getStatus();

        System.out.println("JobListener::afterJob() -> jobExecution: " + jobName + ", " + jobStatus.getBatchStatus());

        synchronized (jobExecution) {
            if (jobExecution == active) {
                active = null;
            }
        }
    }

}
