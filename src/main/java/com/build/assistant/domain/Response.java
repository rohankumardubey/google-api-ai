
package com.build.assistant.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speech",
    "displayText",
    "data",
    "contextOut",
    "source"
})
public class Response {

    @JsonProperty("speech")
    private String speech;
    @JsonProperty("displayText")
    private String displayText;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("contextOut")
    private List<Object> contextOut = null;
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("speech")
    public String getSpeech() {
        return speech;
    }

    @JsonProperty("speech")
    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public Response withSpeech(String speech) {
        this.speech = speech;
        return this;
    }

    @JsonProperty("displayText")
    public String getDisplayText() {
        return displayText;
    }

    @JsonProperty("displayText")
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public Response withDisplayText(String displayText) {
        this.displayText = displayText;
        return this;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    public Response withData(Data data) {
        this.data = data;
        return this;
    }

    @JsonProperty("contextOut")
    public List<Object> getContextOut() {
        return contextOut;
    }

    @JsonProperty("contextOut")
    public void setContextOut(List<Object> contextOut) {
        this.contextOut = contextOut;
    }

    public Response withContextOut(List<Object> contextOut) {
        this.contextOut = contextOut;
        return this;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public Response withSource(String source) {
        this.source = source;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Response withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
