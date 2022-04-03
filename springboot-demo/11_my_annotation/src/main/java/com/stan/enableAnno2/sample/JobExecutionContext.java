package com.stan.enableAnno2.sample;


public class JobExecutionContext {
    private String parameter;
    private String jobId;
    private boolean isSuccess;

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "JobExecutionContext{" +
                "parameter='" + parameter + '\'' +
                ", jobId='" + jobId + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
