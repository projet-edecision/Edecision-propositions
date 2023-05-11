package fr.clam.edecision;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.UUID;
import java.io.Serializable;
@Entity
@Table(name = "propositions")
public class propositionEntity implements Serializable {

    @Id
    private UUID uuid;

    private UUID uuidMembre;
    private UUID uuidProjet;
    private String state;
    private String title;
    private String description;
    private Date creationDate;
    private Date endVoteDate;

    public propositionEntity(){
        this.uuid = UUID.randomUUID();
    }

    public propositionEntity(UUID uuidMembre, UUID uuidProjet, String state, String title, String description, Date creationDate, Date endVoteDate){
        this.uuid = UUID.randomUUID();
        this.uuidMembre = uuidMembre;
        this.uuidProjet = uuidProjet;
        this.state = state;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.endVoteDate = endVoteDate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuidMembre() {
        return uuidMembre;
    }

    public void setUuidMembre(UUID uuidMembre) {
        this.uuidMembre = uuidMembre;
    }

    public UUID getUuidProjet() {
        return uuidProjet;
    }

    public void setUuidProjet(UUID uuidProjet) {
        this.uuidProjet = uuidProjet;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndVoteDate() {
        return endVoteDate;
    }

    public void setEndVoteDate(Date endVoteDate) {
        this.endVoteDate = endVoteDate;
    }
}
