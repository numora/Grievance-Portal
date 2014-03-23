package com.grievance.web.healthcare.transform;

import java.util.List;

import org.dozer.DozerBeanMapper;

public class DozerTransformer extends DozerBeanMapper {

	public DozerTransformer(List<String> mappingFiles) {
		super(mappingFiles);
	}

	public Object retrieveMap(Object a, Object b, String mappingType) {
		this.map(a, b);
		return b;
	}

	public Object mapTopLevel(Object a, Class<?> classz) {
		Object b = this.map(a, classz);
		return b;
	}
}
