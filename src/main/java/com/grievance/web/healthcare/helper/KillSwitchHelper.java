package com.grievance.web.healthcare.helper;

import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.ServletContextAware;

public class KillSwitchHelper implements ServletContextAware {
	private ServletContext servletContext;
	@Qualifier("killswitchProperties")
	private Properties killswitchProperties;

	@Autowired
	public void setKillSwitchProperties(Properties killswitchProperties) {
		this.killswitchProperties = killswitchProperties;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		if (this.servletContext != null) {
			initializeKillSwitchProperties();
		}
	}

	private String controlEmail;

	public void initializeKillSwitchProperties() {
		this.controlEmail = killswitchProperties.getProperty("controlEmail");
	}

	public String getControlEmail() {
		return controlEmail;
	}

	public void setControlEmail(String controlEmail) {
		this.controlEmail = controlEmail;
	}
}
