package com.grievance.web.healthcare.transform;

import com.grievance.web.healthcare.constants.GenderEnum;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

public class EnumToStringConverter implements CustomConverter {

	public Object convert(Object destination, Object source,
			Class<?> destClass, Class<?> sourceClass) {
		
		if (source == null) {
			return null;
		}
		if (source instanceof GenderEnum) {
			GenderEnum genderEnum = (GenderEnum) source;
			return genderEnum.name();
		} else if (source instanceof String) {
			String value = (String) source;
			if (value.equalsIgnoreCase("-1")) {
				return null;
			}
			return GenderEnum.valueOf(value.toUpperCase());
		} else {
			throw new MappingException(
					"Converter EnumToStringConverter used incorrectly. Arguments passed in were:"
							+ destination + " and " + source);
		}
	}
}
