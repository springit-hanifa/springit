package com.hanifa.springit.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("springit")
public class SpringitProperties {
    /**
     * This is our welcome message
     */
    private String welcomeMsg = "Assalamu Alaikkum";

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
