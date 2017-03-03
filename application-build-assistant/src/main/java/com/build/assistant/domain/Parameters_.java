
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
    "Environment.original",
    "Branch",
    "Branch.original",
    "Environment",
    "applicationName.original",
    "applicationName"
})
public class Parameters_ {

    @JsonProperty("Environment.original")
    private String environmentOriginal;
    @JsonProperty("Branch")
    private List<String> branch = null;
    @JsonProperty("Branch.original")
    private String branchOriginal;
    @JsonProperty("Environment")
    private String environment;
    @JsonProperty("applicationName.original")
    private String applicationNameOriginal;
    @JsonProperty("applicationName")
    private String applicationName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Environment.original")
    public String getEnvironmentOriginal() {
        return environmentOriginal;
    }

    @JsonProperty("Environment.original")
    public void setEnvironmentOriginal(String environmentOriginal) {
        this.environmentOriginal = environmentOriginal;
    }

    public Parameters_ withEnvironmentOriginal(String environmentOriginal) {
        this.environmentOriginal = environmentOriginal;
        return this;
    }

    @JsonProperty("Branch")
    public List<String> getBranch() {
        return branch;
    }

    @JsonProperty("Branch")
    public void setBranch(List<String> branch) {
        this.branch = branch;
    }

    public Parameters_ withBranch(List<String> branch) {
        this.branch = branch;
        return this;
    }

    @JsonProperty("Branch.original")
    public String getBranchOriginal() {
        return branchOriginal;
    }

    @JsonProperty("Branch.original")
    public void setBranchOriginal(String branchOriginal) {
        this.branchOriginal = branchOriginal;
    }

    public Parameters_ withBranchOriginal(String branchOriginal) {
        this.branchOriginal = branchOriginal;
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

    public Parameters_ withEnvironment(String environment) {
        this.environment = environment;
        return this;
    }

    @JsonProperty("applicationName.original")
    public String getApplicationNameOriginal() {
        return applicationNameOriginal;
    }

    @JsonProperty("applicationName.original")
    public void setApplicationNameOriginal(String applicationNameOriginal) {
        this.applicationNameOriginal = applicationNameOriginal;
    }

    public Parameters_ withApplicationNameOriginal(String applicationNameOriginal) {
        this.applicationNameOriginal = applicationNameOriginal;
        return this;
    }

    @JsonProperty("applicationName")
    public String getApplicationName() {
        return applicationName;
    }

    @JsonProperty("applicationName")
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Parameters_ withApplicationName(String applicationName) {
        this.applicationName = applicationName;
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

    public Parameters_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
