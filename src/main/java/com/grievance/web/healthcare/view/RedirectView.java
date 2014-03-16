package com.grievance.web.healthcare.view;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedirectView extends
		org.springframework.web.servlet.view.RedirectView {

	private Logger logger = LoggerFactory.getLogger(RedirectView.class);

	//private String className = RedirectView.class.getSimpleName();

	/**
	 * The method to replace http:// URLs to https://
	 */
	protected void sendRedirect(HttpServletRequest request,
			HttpServletResponse response, String targetUrl,
			boolean http10Compatible) throws IOException {

		if (secure && targetUrl.startsWith("http://")) {
			targetUrl = StringUtils.replaceOnce(targetUrl, "http://",
					"https://");
		}

		if (!targetUrl.startsWith("http")) {
			// Get the secure URL and build complete URL
			StringBuffer sb = new StringBuffer();
			
			if (!ignoreContext) {
				sb.append(request.getServletPath());
			}
			sb.append("/");
			sb.append(targetUrl);
			targetUrl = sb.toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Redirecting to URL : [" + targetUrl + "]");
		}

		super.sendRedirect(request, response, targetUrl, http10Compatible);
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public boolean isIgnoreContext() {
		return ignoreContext;
	}

	public void setIgnoreContext(boolean ignoreContext) {
		this.ignoreContext = ignoreContext;
	}

	private boolean secure;
	private boolean ignoreContext;
}
