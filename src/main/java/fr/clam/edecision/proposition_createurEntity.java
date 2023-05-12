package fr.clam.edecision;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="propositions_createurs")
public class proposition_createurEntity {

    @Id
    private UUID uuid;
    private UUID uuidProposition;
    private UUID uuidMembre;

    public proposition_createurEntity() { this.uuid = UUID.randomUUID(); }

    public proposition_createurEntity(UUID uuidProposition, UUID uuidMembre) {
        this.uuid = UUID.randomUUID();
        this.uuidProposition = uuidProposition;
        this.uuidMembre = uuidMembre;
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

    public UUID getUuidMembre() {
        return uuidMembre;
    }

    public void setUuidMembre(UUID uuidMembre) {
        this.uuidMembre = uuidMembre;
    }
}
