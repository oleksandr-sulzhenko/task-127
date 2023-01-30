package org.example.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageDto implements BaseDto{
    private String code;
    private String name;
    @JsonProperty("native")
    private String nativeName;

    public LanguageDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
}
