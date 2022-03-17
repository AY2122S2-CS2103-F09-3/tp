package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointment.Description;
import seedu.address.model.record.ClientID;
import seedu.address.model.record.EndDate;
import seedu.address.model.record.InsuranceID;
import seedu.address.model.record.StartDate;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class RecordParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String description} into an {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code description} is invalid.
     */
    public static ClientID parseClientID(String clientID) throws ParseException {
        requireNonNull(clientID);
        String trimmedClientID = clientID.trim();
        if (!ClientID.isValidClientID(clientID)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new ClientID(trimmedClientID);
    }


    /**
     * Parses a {@code String description} into an {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code description} is invalid.
     */
    public static InsuranceID parseInsuranceID(String insuranceID) throws ParseException {
        requireNonNull(insuranceID);
        String trimmedInsuranceID = insuranceID.trim();
        if (!InsuranceID.isValidInsuranceID(insuranceID)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new InsuranceID(trimmedInsuranceID);
    }

    /**
     * Parses a {@code String dateTime} into an {@code StartDate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code startdate} is invalid.
     */
    public static StartDate parseStartDate(String startDate) throws ParseException {
        requireNonNull(startDate);
        String trimmedStartDate = startDate.trim();
        LocalDate result = StartDate.validateDateTime(trimmedStartDate);
        if (result == null) {
            throw new ParseException(StartDate.MESSAGE_CONSTRAINTS);
        }
        return new StartDate(result);
    }

    /**
     * Parses a {@code String dateTime} into an {@code EndDate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code endDate} is invalid.
     */
    public static EndDate parseEndDate(String endDate) throws ParseException {
        requireNonNull(endDate);
        String trimmedEndDate = endDate.trim();
        LocalDate result = EndDate.validateDateTime(trimmedEndDate);
        if (result == null) {
            throw new ParseException(StartDate.MESSAGE_CONSTRAINTS);
        }
        return new EndDate(result);
    }
}
