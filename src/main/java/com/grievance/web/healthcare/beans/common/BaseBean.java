package com.grievance.web.healthcare.beans.common;

import java.io.Serializable;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = -8264455226491721876L;

    private Long id;
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BaseBean");
        sb.append("{id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
