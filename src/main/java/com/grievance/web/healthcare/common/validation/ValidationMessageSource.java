package com.grievance.web.healthcare.common.validation;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import static com.grievance.web.healthcare.constants.CommonConstants.NULL_VALUE;

@Component
public class ValidationMessageSource {

	private static final String className = ValidationMessageSource.class.getSimpleName();

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private MessageSource messageSource;

	public String getMessage(String code) {
		return getMessage(code, null);
	}

    public String getMessage(String code, Object[] args) {
        String resolvedMessage = "";
       
        Locale locale = LocaleContextHolder.getLocale();
        if (!NULL_VALUE.equals(code)) {
            code = code.replaceAll("\\[([^\\[]*)\\]", "");
            resolvedMessage = messageSource.getMessage(code, null, locale);
            if (resolvedMessage != null && !resolvedMessage.equalsIgnoreCase("")) {
                String finalResolvedMessage = messageSource.getMessage(
                        resolvedMessage, args, locale);
                if (finalResolvedMessage != null && !finalResolvedMessage.equalsIgnoreCase("")) {
                    resolvedMessage = finalResolvedMessage;
                } else {
                }
            }
        }
    
        return resolvedMessage;
    }

    public String getCoreMetricsCode(String code){

        Locale locale = LocaleContextHolder.getLocale();
        code = code.replaceAll("\\[([^\\[]*)\\]", "");
        String resolvedMessage = messageSource.getMessage(code, null, locale);
        return resolvedMessage;
    }
}
