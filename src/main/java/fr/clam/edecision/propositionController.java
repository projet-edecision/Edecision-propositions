package fr.clam.edecision;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class propositionController {

    private final propositionRepository repository;

    public propositionController(propositionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/propositions")
    List<propositionEntity> allPropositions() {
        return (List<propositionEntity>) repository.findAll();
    }

    @PostMapping("/equipe")
    propositionEntity newProposition(@RequestBody propositionEntity newProposition) {
        return repository.save(newProposition);
    }

    @PutMapping("/proposition/{id}")
    propositionEntity editProposition(@RequestBody propositionEntity newProposition, @PathVariable UUID id) {

        return repository.findById(id)
                .map(proposition -> {
                    proposition.setUuid(newProposition.getUuid());
                    proposition.setUuidMembre(newProposition.getUuidMembre());
                    proposition.setUuidProjet(newProposition.getUuidProjet());
                    proposition.setState(newProposition.getState());
                    proposition.setDescription(newProposition.getDescription());
                    proposition.setTitle(newProposition.getTitle());
                    proposition.setEndVoteDate(newProposition.getEndVoteDate());
                    proposition.setCreationDate(newProposition.getCreationDate());
                    return repository.save(proposition);
                })
                .orElseGet(() -> {
                    newProposition.setUuid(id);
                    return repository.save(newProposition);
                });
    }

    @GetMapping("/projetListPropositions/{uuidProjet}")
    List<propositionEntity> allProjetListPropositions(@PathVariable("uuidProjet") UUID uuidProjet) {
        return repository.findByUuidProjet(uuidProjet);
    }

    @DeleteMapping("/proposition/{id}")
    void deleteProposition(@PathVariable("id") UUID id) {
        repository.deleteById(id);
    }
}
