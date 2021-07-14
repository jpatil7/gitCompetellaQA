package com.competella.qaframework.entities;

public class CredentialsOld {

    private String userName;
    private String password;
    private String queueName;
    private String queueDisplayName;
    private String queueSipAddress;
    private String scheduleName;
    private String scheduleDisplayName;
    private String accessURL;
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueDisplayName() {
        return queueDisplayName;
    }

    public void setQueueDisplayName(String queueDisplayName) {
        this.queueDisplayName = queueDisplayName;
    }

    public String getQueueSipAddress() {
        return queueSipAddress;
    }

    public void setQueueSipAddress(String queueSipAddress) {
        this.queueSipAddress = queueSipAddress;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleDisplayName() {
        return scheduleDisplayName;
    }

    public void setScheduleDisplayName(String scheduleDisplayName) {
        this.scheduleDisplayName = scheduleDisplayName;
    }

	public String getAccessURL() {
		return accessURL;
	}

	public void setAccessURL(String accessURL) {
		this.accessURL = accessURL;
	}
    
}
