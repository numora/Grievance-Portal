/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grievance.web.healthcare.util;

/**
 *
 * @author sabbani
 */
public class StringUtils {

    /**
	 * Append list name.
	 *
	 * @param stringBuffer
	 *            the string buffer
	 * @param ajaxResponse
	 *            the ajax response
	 * @param listName
	 *            the list name
	 * @return the string buffer
	 */
	private StringBuffer appendListName(StringBuffer stringBuffer,
			String ajaxResponse, String listName) {
		stringBuffer
				.append(ApplicationConstants.CHARACTER_TILDE)
				.append(ApplicationConstants.OPENING_CURLY_BRACE)
				.append(ApplicationConstants.OPENING_INNER_QOUTES + listName
						+ ApplicationConstants.CLOSING_INNER_QOUTES)
				.append(ApplicationConstants.CHARACTER_COLON)
				.append(ajaxResponse)
				.append(ApplicationConstants.CLOSING_CURLY_BRACE);
		return stringBuffer;
	}
}
