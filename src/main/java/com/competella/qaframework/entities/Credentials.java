package com.competella.qaframework.entities;

public class Credentials {
	private static Credentials instance;

    private static String userName;
    private static String password;
    private static String queueName;
    private static String queueDisplayName;
    private static String queueSipAddress;
    private static String scheduleName;
    private static String scheduleDisplayName;
    private static String accessURL;
    private static String accessGOURL;
    private static String screenshotPath ;
    
    private Credentials() {
	}
    
    public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {
		Credentials.screenshotPath = screenshotPath;
	}

	public static Credentials getInstance() {
		if (instance == null) {
			instance = new Credentials();
		} 
		return instance;
	}


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
	
	public String getAccessGOURL() {
		return accessGOURL;	
	}

	public void setAccessGOURL(String accessGOURL) {
		this.accessGOURL = accessGOURL;
	}
    
}
