package seedu.travelr.model.event;

import seedu.travelr.model.trip.Description;
import seedu.travelr.model.trip.Title;

import static java.util.Objects.requireNonNull;
import static seedu.travelr.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.travelr.logic.parser.ParserUtil.EVENT_DESCRIPTION_PLACEHOLDER;


/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidEventName(String)}
 */
public class Event {

    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final Title title;
    public final Description description;

    /**
     * Constructs an {@code Event}.
     *
     * @param title A valid title.
     * @param description A valid description.
     */
    public Event(Title title, Description description) {
        requireAllNonNull(title, description);
        //checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.title = title;
        this.description = description;
    }

    /**
     * Constructs an {@code Event}.
     *
     * @param eventName A valid title.
     */
    public Event(Title eventName) {
        requireNonNull(eventName);
        this.title = eventName;
        this.description = new Description(EVENT_DESCRIPTION_PLACEHOLDER);
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidEventTitle(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Event // instanceof handles nulls
                && title.equals(((Event) other).title)); // state check
    }

    /**
     * Returns true if both events have the same title.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameTrip(Event otherEvent) {
        if (otherEvent == this) {
            return true;
        }

        return otherEvent != null
                && otherEvent.getTitle().equals(getTitle());
    }
    @Override
    public int hashCode() {
        return title.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append("; Description: ")
                .append(getDescription());
        return builder.toString();
    }

}
