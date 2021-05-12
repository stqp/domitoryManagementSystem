package jp.co.dms.domain.model.location;

import java.io.Serializable;

public class UnLocode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String unlocode;
    private static final java.util.regex.Pattern VALID_PATTERN
            = java.util.regex.Pattern.compile("[a-zA-Z]{2}[a-zA-Z2-9]{3}");

    public UnLocode() {
        // Nothing to initialize.
    }

    /**
     * @param countryAndLocation Location string.
     */
    public UnLocode(String countryAndLocation) {
        this.unlocode = countryAndLocation.toUpperCase();
    }

    /**
     * @return country code and location code concatenated, always upper case.
     */
    public String getIdString() {
        return unlocode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UnLocode other = (UnLocode) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return unlocode.hashCode();
    }

    boolean sameValueAs(UnLocode other) {
        return other != null && this.unlocode.equals(other.unlocode);
    }

    @Override
    public String toString() {
        return getIdString();
    }
}
