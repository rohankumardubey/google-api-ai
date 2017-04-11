package com.build.assistant.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sunny on 21/03/17.
 */
@Entity
@Table(name = "sessions")
public class Sessions {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "tags")
    private String tags;

    @Column(name = "speaker")
    private String speaker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}