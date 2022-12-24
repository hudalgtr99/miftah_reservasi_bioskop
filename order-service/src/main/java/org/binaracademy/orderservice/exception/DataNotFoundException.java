package org.binaracademy.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException{

    private final Map<String, String> messageMap = new HashMap<>();

    public final String resourceName;
    private final String fieldName;
    private final transient Object fieldValue;

    public DataNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super();
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public Map<String, String> getMessageMap() {
        return messageMap;
    }

    public void setApiResponse() {
        String msg = String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue);
        messageMap.put("error", msg);
    }
}
