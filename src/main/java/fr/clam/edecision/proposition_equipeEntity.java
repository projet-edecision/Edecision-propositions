package fr.clam.edecision;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="propositions_equipes")

public class proposition_equipeEntity {

    @Id
    private UUID uuid;
    private UUID uuidProposition;
    private UUID uuidEquipe;

    public proposition_equipeEntity() { this.uuid = UUID.randomUUID(); }

    public proposition_equipeEntity(UUID uuidProposition, UUID uuidEquipe) {
        this.uuid = UUID.randomUUID();
        this.uuidEquipe = uuidEquipe;
        this.uuidProposition = uuidProposition;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuidProposition() {
        return uuidProposition;
    }

    public void setUuidProposition(UUID uuidProposition) {
        this.uuidProposition = uuidProposition;
    }

    public UUID getUuidEquipe() {
        return uuidEquipe;
    }

    public void setUuidEquipe(UUID uuidEquipe) {
        this.uuidEquipe = uuidEquipe;
    }
}
