package claranet.cdp.adapters.primary.contollers;

import claranet.cdp.application.entities.DomainError;

/**
 * Error that represents a domain error
 */
public class DomainErrorException extends Exception {

    private final DomainError domainError;

    public DomainErrorException(DomainError domainError) {
        super(domainError.getMessage());
        this.domainError = domainError;
    }

    public DomainError getDomainError() {
        return domainError;
    }
}
