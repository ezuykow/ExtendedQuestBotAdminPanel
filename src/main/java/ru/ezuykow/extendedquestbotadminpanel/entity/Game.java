package ru.ezuykow.extendedquestbotadminpanel.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "GAME", indexes = {
        @Index(name = "IDX_GAME_AUTHOR", columnList = "AUTHOR_ID")
})
@Entity
public class Game {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "AUTHOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Positive
    @Column(name = "DURATION_MINS", nullable = false)
    @NotNull
    private Integer duration_mins;

    @Positive
    @Column(name = "QUESTION_COUNT", nullable = false)
    @NotNull
    private Integer question_count;

    @Positive
    @Column(name = "ACTIVE_QUESTION_COUNT", nullable = false)
    @NotNull
    private Integer active_question_count;

    @NotNull
    @PositiveOrZero
    @Column(name = "MAX_HINTS_PER_QUESTION")
    private Integer max_hints_per_question;

    @Column(name = "ADDITIONALS_WITH_QUESTION", nullable = false)
    @NotNull
    private Boolean additionals_with_question = false;

    @JoinTable(name = "GAME_QUESTION_GROUP_LINK",
            joinColumns = @JoinColumn(name = "GAME_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "QUESTION_GROUP_ID", referencedColumnName = "ID"))
    @ManyToMany
    private Set<QuestionGroup> question_groups;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public Set<QuestionGroup> getQuestion_groups() {
        return question_groups;
    }

    public void setQuestion_groups(Set<QuestionGroup> question_groups) {
        this.question_groups = question_groups;
    }

    public Integer getMax_hints_per_question() {
        return max_hints_per_question;
    }

    public void setMax_hints_per_question(Integer max_hints_per_question) {
        this.max_hints_per_question = max_hints_per_question;
    }

    public Boolean getAdditionals_with_question() {
        return additionals_with_question;
    }

    public void setAdditionals_with_question(Boolean additionals_with_question) {
        this.additionals_with_question = additionals_with_question;
    }

    public Integer getActive_question_count() {
        return active_question_count;
    }

    public void setActive_question_count(Integer active_question_count) {
        this.active_question_count = active_question_count;
    }

    public Integer getQuestion_count() {
        return question_count;
    }

    public void setQuestion_count(Integer question_count) {
        this.question_count = question_count;
    }

    public Integer getDuration_mins() {
        return duration_mins;
    }

    public void setDuration_mins(Integer duration_mins) {
        this.duration_mins = duration_mins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}