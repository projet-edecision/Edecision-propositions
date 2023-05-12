package fr.clam.edecision;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface propositionRepository extends CrudRepository<propositionEntity, UUID> {

    List<propositionEntity> findByUuidProjet(UUID uuidProjet);
}
