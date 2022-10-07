package seedu.travelr.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.travelr.commons.util.AppUtil.checkArgument;
import static seedu.travelr.logic.parser.ParserUtil.EVENT_DESCRIPTION_PLACEHOLDER;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Event {

    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String title;
    public final String description;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     */
    public Event(String tagName, String description) {
        requireNonNull(tagName);
        //checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.title = tagName;
        this.description = description;
    }

    public Event(String eventName) {
        requireNonNull(eventName);
        this.title = eventName;
        this.description = EVENT_DESCRIPTION_PLACEHOLDER;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Event // instanceof handles nulls
                && title.equals(((Event) other).title)); // state check
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + title + ']';
    }

}
