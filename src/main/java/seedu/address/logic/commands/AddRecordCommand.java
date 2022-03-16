package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REC_CLIENTID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REC_ENDDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REC_INSURANCEID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REC_STARTDATE;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.record.Record;


public class AddRecordCommand extends Command {
    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an record to the address book. "
            + "Parameters: "
            + PREFIX_REC_CLIENTID + "CLIENTID "
            + PREFIX_REC_INSURANCEID + "INSURANCEID "
            + PREFIX_REC_INSURANCEID + "INSURANCEID "
            + PREFIX_REC_STARTDATE + "STARTDATE "
            + PREFIX_REC_ENDDATE + "ENDDATE "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_REC_CLIENTID + "10 "
            + PREFIX_REC_INSURANCEID + "2 "
            + PREFIX_REC_STARTDATE + "23-02-2022"
            + PREFIX_REC_ENDDATE + "23-02-2024";

    public static final String MESSAGE_SUCCESS = "New record added: %1$s";
    public static final String MESSAGE_DUPLICATE_RECORD = "This record already exists in the address book";

    private final Record toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Record}
     */
    public AddRecordCommand(Record record) {
        requireNonNull(record);
        toAdd = record;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasRecord(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_RECORD);
        }

        model.addRecord(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddRecordCommand // instanceof handles nulls
                && toAdd.equals(((AddRecordCommand) other).toAdd));
    }

}