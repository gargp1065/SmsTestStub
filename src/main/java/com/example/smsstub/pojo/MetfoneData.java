package com.example.smsstub.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Output")
public class MetfoneData {
    private int errorCode;
    private String errorDescription;

    public MetfoneData() {
    }

    public MetfoneData(int errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    @XmlElement
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @XmlElement
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
