package seedu.address.model.record;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Record's client id.
 * Guarantees: immutable; is valid as declared in {@link #isValidClientID(String)}
 */
public class ClientID {
    public static final String MESSAGE_CONSTRAINTS =
            "Client Index should only contain numbers, and it should not be blank";
    public static final String VALIDATION_REGEX = "\\d{1,}";
    public final String id;

    /**
     * Constructs a {@code ClientId}.
     *
     * @param clientID A valid price number.
     */
    public ClientID(String clientID) {
        requireNonNull(clientID);
        checkArgument(isValidClientID(clientID), MESSAGE_CONSTRAINTS);
        id = clientID;
    }

    /**
     * Constructs a {@code Name}.
     *
     * @param clientName A valid name.
     */
    public ClientID(String clientName, Boolean yes) {
        requireNonNull(clientName);
        id = clientName;
    }

    /**
     * Returns true if a given string is a valid price number.
     */
    public static boolean isValidClientID(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClientID // instanceof handles nulls
                && id.equals(((ClientID) other).id)); // state check
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
