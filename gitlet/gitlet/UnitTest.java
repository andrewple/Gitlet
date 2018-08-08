package gitlet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/* The suite of all JUnit tests for the gitlet package.
   @author Andrew Le
 */
public class UnitTest {

    private String commandArgArrayToString(String[] args) {
        if (args.length == 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder();
        for (String token : args) {
            buffer.append(token);
            buffer.append(" " );
        }
        buffer.setLength(buffer.length() - 1);
        return buffer.toString();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testParserNonExistantCommand_01() throws IllegalArgumentException {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("No such command found.");
        String[] args = {"DoesntExist"};
        CommandParser parser = new CommandParser(args);
        parser.parseCommand();
    }


    @Test
    public void testParserNonExistantCommand_02() throws IllegalArgumentException {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("No such command found.");
        String[] args = {"DoesntExist", "5"};
        CommandParser parser = new CommandParser(args);
        parser.parseCommand();
    }



    public static <X extends Throwable> Throwable assertThrows(
            final Class<X> exceptionClass, final Runnable block,
            final String exceptionMessage, final String errorMessage) {
        try {
            block.run();
        } catch(Throwable ex) {
            if (!exceptionClass.isInstance(ex)) {
                fail(errorMessage + "\nActual: " + ex.toString() +
                        "\nExpected: " + exceptionClass.getName());
            }

            if (!ex.getMessage().equals(exceptionMessage)) {
                fail(errorMessage + "\nActual:   " + ex.toString() +
                    "\nExpected: " + exceptionClass.getName() +
                    ": " + exceptionMessage);
            }
            return ex;
        }
        fail(errorMessage);
        return null;
    }

    @Test
    public void testParserNoCommands() {
        String[] args = {};
        CommandParser parser = new CommandParser(args);

        assertThrows(IllegalArgumentException.class,
                () -> parser.parseCommand(),
                "Please enter a command.",
                "No command-line arguments does not throw an IllegalArgumentException with error message.");
    }

    @Test
    public void testParserIllegalAdd() {
        String[][] args = {
                {"add"},
                {"add", "5", "10"}
        };

        for (String[] arg : args) {
            CommandParser parser = new CommandParser(arg);
            assertThrows(IllegalArgumentException.class,
                    () -> parser.parseCommand(),
                    "Incorrect operands.",
                    "add with bad arguments does not throw an IllegalArgumentException with error message.");
        }
    }

    @Test
    public void testAddMissingFile() {
        String[][] args = {
                {"add", "no_such_file"},
        };

        for (String[] arg : args) {
            CommandParser parser = new CommandParser(arg);
            assertThrows(IllegalArgumentException.class,
                    () -> parser.parseCommand(),
                    "File does not exist.",
                    "add with non-existant file does not throw an IllegalArgumentException with error message.");
        }

    }


}


