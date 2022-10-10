package seedu.travelr.logic.parser;

import static seedu.travelr.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.travelr.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.travelr.logic.commands.AddCommand;
import seedu.travelr.logic.commands.AddEventCommand;
import seedu.travelr.logic.commands.AddEventToTripCommand;
import seedu.travelr.logic.commands.ClearCommand;
import seedu.travelr.logic.commands.Command;
import seedu.travelr.logic.commands.DeleteCommand;
import seedu.travelr.logic.commands.DeleteEventFromTripCommand;
import seedu.travelr.logic.commands.EditCommand;
import seedu.travelr.logic.commands.EventListCommand;
import seedu.travelr.logic.commands.ExitCommand;
import seedu.travelr.logic.commands.FindCommand;
import seedu.travelr.logic.commands.HelpCommand;
import seedu.travelr.logic.commands.ListCommand;
import seedu.travelr.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case DeleteEventFromTripCommand.COMMAND_WORD:
            return new DeleteEventFromTripCommandParser().parse(arguments);

        case AddEventToTripCommand.COMMAND_WORD:
            return new AddEventToTripCommandParser().parse(arguments);

        case AddEventCommand.COMMAND_WORD:
            return new AddEventCommandParser().parse(arguments);

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case EventListCommand.COMMAND_WORD:
            return new EventListCommand();

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}