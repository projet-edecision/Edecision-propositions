package fr.clam.edecision;

import java.util.UUID;

public class propositionNotFoundException extends RuntimeException {
    propositionNotFoundException(UUID id) {
        super("Could not find proposition " + id.toString());
    }
}
