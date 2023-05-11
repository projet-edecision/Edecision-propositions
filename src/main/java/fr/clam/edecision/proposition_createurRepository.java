package fr.clam.edecision;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface proposition_createurRepository extends CrudRepository<proposition_createurEntity, UUID> {

    List<proposition_createurEntity> findByUuidMembre(UUID uuidMembre);
    List<proposition_createurEntity> findByUuidProposition(UUID uuidProposition);

}
