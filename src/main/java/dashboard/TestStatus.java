package dashboard;

import java.time.Duration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestStatus {

    @JsonProperty("testClass")
    private String testClass;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;
    @JsonProperty("browser")
    private String browser;

    @JsonProperty("executionTime")
    private Duration executionTime;

    
    
    
    
    
    
    public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setDescription(String description) {
        this.description = description;
    }

    public void setExecutionDate(Duration timeElapsed) {
        this.executionTime = timeElapsed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }

}
