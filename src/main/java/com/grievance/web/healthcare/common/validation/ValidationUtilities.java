package com.grievance.web.healthcare.common.validation;

import com.grievance.web.healthcare.helper.RegularExpressionViewHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationUtilities {

	private RegularExpressionViewHelper regularExpression;

	@Autowired
	public void setRegularExpressionViewHelper(
			RegularExpressionViewHelper regularExpression) {
		this.regularExpression = regularExpression;
	}

	public void rejectIfNotValidName(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidName((String) value)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	public void rejectIfNotValidLastName(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidLastName((String) value)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	public void rejectIfNotValidAddress(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidAddress((String) value)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	public void rejectIfNotValidAddressLine1(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (((String) value).toLowerCase().trim().contains("c/o")) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	public void rejectIfDefaultValue(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (value.equals("-1")) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	public void rejectIfNotValidCity(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidCity((String) value)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	public void rejectIfNotValidZipCode(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if ((value.toString().length() != 5)
					|| !isValidZipCode((String) value)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	/**
	 * The method to check given value is valid positive numeric or not.
	 * 
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfNotValidPositiveNumeric(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidPositiveNumeric(value.toString())) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	/**
	 * The method to check given value is valid positive numeric or not with min
	 * & max value range.
	 * 
	 * @param errors
	 * @param field
	 * @param errorCode
	 * @param minValue
	 * @param maxValue
	 */
	public void rejectIfNotValidPositiveNumeric(Errors errors, String field,
			String errorCode, int minValue, int maxValue) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidPositiveNumeric(value.toString(), minValue, maxValue)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	/**
	 * The Method To Check given email is in Standard Format i.e
	 * jane47@macys.com
	 * 
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfNotEmail(Errors errors, String field, String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidEmail((String) value)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	/**
	 * The method to check given phnoneNumber is in standard format i.e
	 * 123-123-1234
	 * 
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfNotPhoneNumber(Errors errors, String field,
			String errorCode) {
		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidPhoneNumber((String) value)) {
				errors.rejectValue(field, errorCode, null, null);

			}

		}

	}

	/**
	 * The method to check given field length equal to specified length value.
	 * 
	 * @param length
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfLengthNotEqual(int length, Errors errors, String field,
			String errorCode) {
		if (length < 0) {
			return;
		}
		if (getLength(errors, field) != length) {
			errors.rejectValue(field, errorCode, null, null);
		}
	}

	/**
	 * The method to check given field length is less than minLenth
	 * 
	 * @param minLength
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfLengthLessThan(int minLength, Errors errors,
			String field, String errorCode) {
		if (minLength < 0) {
			return;
		}
		if (getLength(errors, field) < minLength) {
			errors.rejectValue(field, errorCode, null, null);
		}
	}

	/**
	 * The method to check given field length is greater than maxLenth
	 * 
	 * @param maxLength
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfLengthMoreThan(int maxLength, Errors errors,
			String field, String errorCode) {
		if (maxLength < 0) {
			return;
		}
		if (getLength(errors, field) > maxLength) {
			errors.rejectValue(field, errorCode, null, null);
		}
	}

	/**
	 * The method to check given field is outOfRange i.e less than the minLength
	 * and greater than maxLength.
	 * 
	 * @param minLength
	 * @param maxLength
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfLengthIsOutOfRange(int minLength, int maxLength,
			Errors errors, String field, String errorCode) {
		if (minLength < 0 || maxLength < 0 || minLength > maxLength) {
			return;
		}
		int length = getLength(errors, field);
		if (length < minLength || length > maxLength) {
			errors.rejectValue(field, errorCode, null, null);
		}
	}

	/**
	 * The method to check given password is valid or not
	 * 
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public void rejectIfNotPassword(Errors errors, String field,
			String errorCode) {
		String value = errors.getFieldValue(field).toString();
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (!isValidPassword(value)) {
				errors.rejectValue(field, errorCode, null, null);
			}
		}
	}

	/**
	 * The method to check given value is valid positive numeric or not
	 * 
	 * @param value
	 * @return
	 */
	public boolean isValidPositiveNumeric(String value) {
		int min = 0;
		boolean isValid = false;
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (isNumeric(value)) {
				double fieldValue = new Double(value);
				if (fieldValue >= min) {
					isValid = true;
				}
			}
		}
		return isValid;
	}

	/**
	 * The method to check given value is positive numeric within the range i.e
	 * minValue & maxValue.
	 * 
	 * @param value
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public boolean isValidPositiveNumeric(String value, int minValue,
			int maxValue) {
		boolean isValid = false;
		if (value != null && StringUtils.hasLength(value.toString())) {
			if (isNumeric(value)) {
				int fieldValue = Integer.valueOf(value);
				if (fieldValue >= minValue && fieldValue <= maxValue) {
					isValid = true;
				}
			}
		}
		return isValid;
	}

	/**
	 * The method to retrieve length of the given field
	 * 
	 * @param errors
	 * @param field
	 * @return
	 */
	public int getLength(Errors errors, String field) {
		int length = 0;

		Object value = errors.getFieldValue(field);
		if (value != null && StringUtils.hasLength(value.toString())) {
			length = value.toString().length();
		}

		return length;
	}

	public boolean isValidEmail(String email) {
		return isValid(this.regularExpression.getEmail(), email);
	}

	public boolean isValidName(String name) {
		return isValid(this.regularExpression.getName(), name);
	}

	public boolean isValidAddress(String addressLine) {
		return isValid(this.regularExpression.getAddress(), addressLine);
	}

	public boolean isValidPhoneNumber(String phoneNumber) {
		return isValid(this.regularExpression.getPhone(), phoneNumber, true);
	}

	public boolean isNumeric(String number) {
		return isValid(this.regularExpression.getNumeric(), number, true);
	}

	public boolean isValidCity(String city) {
		return isValid(this.regularExpression.getCity(), city);
	}

	public boolean isValidZipCode(String zipCode) {
		return isValid(this.regularExpression.getPostalCode(), zipCode, true);
	}

	public boolean isValidPassword(String pwd) {
		return isValid(this.regularExpression.getPassword(), pwd, true);
	}

	public boolean isValidLastName(String lastname) {
		return isValid(this.regularExpression.getLastname(), lastname);
	}

	private boolean isValid(String expression, String str) {
		return isValid(expression, str, false);
	}

	/**
	 * The method to check given value is in specified validation expression or
	 * not
	 * 
	 * @param expression
	 * @param str
	 * @param isCaseSensitive
	 * @return
	 */
	private boolean isValid(String expression, String str,
			boolean isCaseSensitive) {
		boolean isValid = false;

		CharSequence inputStr = str;

		System.out.println("In Valid"+expression+"String:"+str);
		Pattern pattern = null;
		if (isCaseSensitive) {
			pattern = Pattern.compile(expression);
		} else {
			pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		}
		System.out.println(pattern);
		Matcher matcher = pattern.matcher(inputStr);
		System.out.println("In ..Valid");
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * The method to check given Two fields are same or not
	 * 
	 * @param errors
	 * @param field1
	 * @param field2
	 * @param errorCode
	 */
	public void rejectIfNotSimilar(Errors errors, String field1, String field2,
			String errorCode) {
		Object value1 = errors.getFieldValue(field1);
		Object value2 = errors.getFieldValue(field2);
		if (!(value1.equals(value2))) {
			errors.rejectValue(field2, errorCode, null, null);
		}
	}

	/**
	 * The method to check given Two fields(email and password) are same or not
	 * 
	 * @param errors
	 * @param field1
	 * @param field2
	 * @param errorCode
	 */
	public void rejectIfSimilar(Errors errors, String field1, String field2,
			String errorCode) {
		Object value1 = errors.getFieldValue(field1);
		Object value2 = errors.getFieldValue(field2);
		if (value1.equals(value2)) {
			errors.rejectValue(field2, errorCode, null, null);
		}
	}

	/**
	 * The method to check expiry date validity
	 * 
	 * @param errors
	 * @param field1
	 * @param field2
	 * @param errorCode
	 */
	public void rejectIfBirthYearEmpty(Errors errors, String field1,
			String field2, String field3, String errorCode) {

		try {
			boolean isValid = true;
			String value1 = errors.getFieldValue(field1).toString();
			String value2 = errors.getFieldValue(field2).toString();
			String value3 = errors.getFieldValue(field3).toString();

			if (("-1").equals(value1) || ("-1").equals(value2)
					|| ("-1").equals(value3)) {
				isValid = false;
			}
			if (!isValid) {
				errors.rejectValue(field3, errorCode, null, null);
			}
		} catch (final Exception e) {
			// Field validation exception, since logging it as DEBUG
			errors.rejectValue(field3, errorCode, null, null);
		}
	}

}
