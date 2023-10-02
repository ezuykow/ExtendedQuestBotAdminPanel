package ru.ezuykow.extendedquestbotadminpanel.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "QUESTION", indexes = {
        @Index(name = "IDX_QUESTION_GROUP", columnList = "GROUP_ID"),
        @Index(name = "IDX_QUESTION_AUTHOR", columnList = "AUTHOR_ID")
}, uniqueConstraints = {
        @UniqueConstraint(name = "IDX_QUESTION_UNQ_TEXT", columnNames = {"TEXT"})
})
@Entity
public class Question {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "AUTHOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "GROUP_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private QuestionGroup group;

    @Positive
    @Column(name = "ORDER_", nullable = false)
    @NotNull
    private Integer order;

    @InstanceName
    @NotBlank
    @Column(name = "TEXT", nullable = false, length = 1024)
    @NotNull
    private String text;

    @NotEmpty
    @NotNull
    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "ADDITIONAL", length = 1024)
    private String additional;

    @OneToMany(mappedBy = "question")
    private Set<Hint> hints;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Set<Hint> getHints() {
        return hints;
    }

    public void setHints(Set<Hint> hints) {
        this.hints = hints;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getAuthor() {
        return author;
    }

    public QuestionGroup getGroup() {
        return group;
    }

    public void setGroup(QuestionGroup group) {
        this.group = group;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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