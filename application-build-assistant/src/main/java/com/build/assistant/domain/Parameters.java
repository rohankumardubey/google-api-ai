
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
    "applicationName",
    "Branch",
    "Environment"
})
public class Parameters {

    @JsonProperty("applicationName")
    private String applicationName;
    @JsonProperty("Branch")
    private String branch = null;
    @JsonProperty("Environment")
    private String environment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("applicationName")
    public String getApplicationName() {
        return applicationName;
    }

    @JsonProperty("applicationName")
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Parameters withApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }

    @JsonProperty("Branch")
    public String getBranch() {
        return branch;
    }

    @JsonProperty("Branch")
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Parameters withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    @JsonProperty("Environment")
    public String getEnvironment() {
        return environment;
    }

    @JsonProperty("Environment")
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Parameters withEnvironment(String environment) {
        this.environment = environment;
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

    public Parameters withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
