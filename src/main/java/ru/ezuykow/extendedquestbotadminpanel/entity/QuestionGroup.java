package ru.ezuykow.extendedquestbotadminpanel.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

@JmixEntity
@Table(name = "QUESTION_GROUP")
@Entity
public class QuestionGroup {

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @NotBlank
    @NotNull
    @Column(name = "GROUP_NAME", nullable = false)
    private String groupName;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;
    @JoinTable(name = "GAME_QUESTION_GROUP_LINK",
            joinColumns = @JoinColumn(name = "QUESTION_GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "GAME_ID"))
    @ManyToMany
    private Set<Game> games;

    public Set<Game> getGames() {
        return games;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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