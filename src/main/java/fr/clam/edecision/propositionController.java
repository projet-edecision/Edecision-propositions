package fr.clam.edecision;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class propositionController {

    private final propositionRepository repositoryProposition;
    private final proposition_createurRepository proposition_createurRepository;

    private final proposition_equipeRepository proposition_equipeRepository;

    public propositionController(propositionRepository repositoryProposition, proposition_createurRepository propositionCreateurRepository, proposition_equipeRepository propositionEquipeRepository) {
        this.repositoryProposition = repositoryProposition;
        this.proposition_createurRepository = propositionCreateurRepository;
        this.proposition_equipeRepository = propositionEquipeRepository;
    }

    @GetMapping("/propositions")
    List<propositionEntity> allPropositions() {
        return (List<propositionEntity>) repositoryProposition.findAll();
    }

    @PostMapping("/equipe")
    propositionEntity newProposition(@RequestBody propositionEntity newProposition) {
        return repositoryProposition.save(newProposition);
    }

    @PutMapping("/proposition/{id}")
    propositionEntity editProposition(@RequestBody propositionEntity newProposition, @PathVariable UUID id) {

        return repositoryProposition.findById(id)
                .map(proposition -> {
                    proposition.setUuid(newProposition.getUuid());
                    proposition.setUuidMembre(newProposition.getUuidMembre());
                    proposition.setUuidProjet(newProposition.getUuidProjet());
                    proposition.setState(newProposition.getState());
                    proposition.setDescription(newProposition.getDescription());
                    proposition.setTitle(newProposition.getTitle());
                    proposition.setEndVoteDate(newProposition.getEndVoteDate());
                    proposition.setCreationDate(newProposition.getCreationDate());
                    return repositoryProposition.save(proposition);
                })
                .orElseGet(() -> {
                    newProposition.setUuid(id);
                    return repositoryProposition.save(newProposition);
                });
    }

    @GetMapping("/projetListPropositions/{uuidProjet}")
    List<propositionEntity> allProjetListPropositions(@PathVariable("uuidProjet") UUID uuidProjet) {
        return repositoryProposition.findByUuidProjet(uuidProjet);
    }

    @DeleteMapping("/proposition/{id}")
    void deleteProposition(@PathVariable("id") UUID id) {
        repositoryProposition.deleteById(id);
    }


    //proposition_createur

    @GetMapping("/propositionsCreateurs")
    List<proposition_createurEntity> allPropositionsCreateurs() {
        return (List<proposition_createurEntity>) proposition_createurRepository.findAll();
    }

    @GetMapping("/membreListPropositions/{uuidMembre}")
    List<proposition_createurEntity> filterMembresPropositions(@PathVariable("uuidMembre") UUID uuidMembre) {


        return proposition_createurRepository.findByUuidMembre(uuidMembre);
    }

    @GetMapping("/propositionListMembres/{uuidProposition}")
    List<proposition_createurEntity> filterPropositionsMembres(@PathVariable("uuidProposition") UUID uuidProposition) {


        return proposition_createurRepository.findByUuidProposition(uuidProposition);
    }

    @PostMapping("/propositionsCreateurs")
    proposition_createurEntity newPropositionMembre(@RequestBody proposition_createurEntity newPropositionMembre) {
        return proposition_createurRepository.save(newPropositionMembre);
    }

    @DeleteMapping("/propositionsCreateurs/{id}")
    void deleteMembreEquipe(@PathVariable("id") UUID id) {
        proposition_createurRepository.deleteById(id);
    }

    //proposition_equipe

    @GetMapping("/propositionsEquipes")
    List<proposition_equipeEntity> allPropositionsEquipes() {
        return (List<proposition_equipeEntity>) proposition_equipeRepository.findAll();
    }

    @GetMapping("/equipeListPropositions/{uuidEquipe}")
    List<proposition_equipeEntity> filterEquipesPropositions(@PathVariable("uuidEquipe") UUID uuidEquipe) {


        return proposition_equipeRepository.findByUuidEquipe(uuidEquipe);
    }

    @GetMapping("/propositionListEquipes/{uuidProposition}")
    List<proposition_equipeEntity> filterPropositionsEquipes(@PathVariable("uuidProposition") UUID uuidProposition) {


        return proposition_equipeRepository.findByUuidProposition(uuidProposition);
    }

    @PostMapping("/propositionsEquipes")
    proposition_equipeEntity newPropositionEquipe(@RequestBody proposition_equipeEntity newPropositionEquipe) {
        return proposition_equipeRepository.save(newPropositionEquipe);
    }

    @DeleteMapping("/propositionsEquipes/{id}")
    void deletePropositionEquipe(@PathVariable("id") UUID id) {
        proposition_equipeRepository.deleteById(id);
    }
}
