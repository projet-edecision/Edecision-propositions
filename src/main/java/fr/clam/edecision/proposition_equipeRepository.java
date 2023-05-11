package fr.clam.edecision;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface proposition_equipeRepository extends CrudRepository<proposition_equipeEntity, UUID> {

    List<proposition_equipeEntity> findByUuidProposition(UUID uuidProposition);
    List<proposition_equipeEntity> findByUuidEquipe(UUID uuidEquipe);

}
