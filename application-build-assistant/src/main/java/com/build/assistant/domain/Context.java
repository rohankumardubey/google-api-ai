
package com.build.assistant.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "parameters",
    "lifespan"
})
public class Context {

    @JsonProperty("name")
    private String name;
    @JsonProperty("parameters")
    private Parameters_ parameters;
    @JsonProperty("lifespan")
    private long lifespan;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Context withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("parameters")
    public Parameters_ getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Parameters_ parameters) {
        this.parameters = parameters;
    }

    public Context withParameters(Parameters_ parameters) {
        this.parameters = parameters;
        return this;
    }

    @JsonProperty("lifespan")
    public long getLifespan() {
        return lifespan;
    }

    @JsonProperty("lifespan")
    public void setLifespan(long lifespan) {
        this.lifespan = lifespan;
    }

    public Context withLifespan(long lifespan) {
        this.lifespan = lifespan;
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

    public Context withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
