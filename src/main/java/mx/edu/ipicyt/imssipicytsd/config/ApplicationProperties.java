package mx.edu.ipicyt.imssipicytsd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Ipicyt Buss.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private String glpiAuthorization;
    private String glpiToken;
    private String glpiUrl;
    private String glpiuser;
    private String glpipass;
    private String appTransfromEnable;

    public String getAppTransfromEnable() {
        return appTransfromEnable;
    }

    public void setAppTransfromEnable(String appTransfromEnable) {
        this.appTransfromEnable = appTransfromEnable;
    }

    public String getGlpiuser() {
        return glpiuser;
    }

    public void setGlpiuser(String glpiuser) {
        this.glpiuser = glpiuser;
    }

    public String getGlpipass() {
        return glpipass;
    }

    public void setGlpipass(String glpipass) {
        this.glpipass = glpipass;
    }

    public String getGlpiAuthorization() {
        return glpiAuthorization;
    }

    public void setGlpiAuthorization(String glpiAuthorization) {
        this.glpiAuthorization = glpiAuthorization;
    }

    public String getGlpiToken() {
        return glpiToken;
    }

    public void setGlpiToken(String glpiToken) {
        this.glpiToken = glpiToken;
    }

    public String getGlpiUrl() {
        return glpiUrl;
    }

    public void setGlpiUrl(String glpiUrl) {
        this.glpiUrl = glpiUrl;
    }
}
