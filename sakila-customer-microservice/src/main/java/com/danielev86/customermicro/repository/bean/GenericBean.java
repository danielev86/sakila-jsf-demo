package com.danielev86.customermicro.repository.bean;

import java.io.Serializable;

public class GenericBean implements Serializable {

    private static final long serialVersionUID = -8884266173484499792L;

    private String parameterName;

    private String paramaterValue;

    public GenericBean(String parameterName, String paramaterValue) {
        this.parameterName = parameterName;
        this.paramaterValue = paramaterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParamaterValue() {
        return paramaterValue;
    }

    public void setParamaterValue(String paramaterValue) {
        this.paramaterValue = paramaterValue;
    }
}
