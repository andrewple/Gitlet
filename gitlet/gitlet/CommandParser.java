package gitlet;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * Parses command-line arguments to the program and invokes the corresponding action in the
 * Gitlet class. Handles all exceptions that result in the command failing to execute, printing out
 * the relevant message to standard out.
 * @author Andrew Le
 */
public class CommandParser {

    Gitlet git;
    String[] commandLineArgs;
    int argCount;

    /* Wrapper for readability. */
    private boolean commandMatch(String operandName) {
        return commandLineArgs[0].equals(operandName);
    }

    private void parseInitCommand() {
        if (commandMatch( "init") && argCount == 1) {
            try {
                git.initGitletHere();
            } catch (GitletAlreadyExistsException e) {
                System.out.println("A gitlet version-control system already exists in the current directory.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void parseAddFile() {
        if (commandMatch( "add")) {
            if (argCount != 2) {
                throw new IllegalArgumentException("Incorrect operands.");
            } else {
                String fileName = commandLineArgs[1];
                try {
                    git.addFileToStaging(fileName);
                } catch (FileNotFoundException e) {
                    System.out.println("File does not exist.");
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void parseRemoveFile() {
        if (commandMatch( "rm")) {
            String fileName = commandLineArgs[1];
            try {
                git.removeFile(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("No reason to remove the file.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void parseLog() {
        if (commandMatch( "log")) {
            git.printLog();
        }
    }

    private void parseGlobalLog() {
        if (commandMatch( "global-log")) {
            git.printGlobalLog();
        }
    }

    private void parseStatus() {
        if (commandMatch( "status")) {
            git.printStatus();
        }
    }

    private void parseCommit() {
        if (commandMatch( "commit")) {
            String commitMsg = commandLineArgs[1];
        }
    }

    public boolean parseCommand() throws IllegalArgumentException {


        if (argCount == 0) { /* User enters "gitlet" without an operand. */
            throw new IllegalArgumentException("Please enter a command.");
        }



        /* commit [message] */

        /* find [commit message] */

        /* checkout - has 3 variants */

        /* branch [branch name] */

        /* rm-branch [branch name] */

        /* reset [commit id] */


        /* merge [branch name] */

            parseInitCommand(); /* gitlet init */
            parseAddFile(); /* gitlet add [file name] */
            parseRemoveFile(); /* gitlet rm [file name] */
            parseLog(); /* git log */
            parseGlobalLog(); /* gitlet global-log */
            parseStatus(); /* gitlet status */



        throw new IllegalArgumentException("No command with that name exists.");
    }

    public CommandParser(String[] args) {
        git = new Gitlet("");
        commandLineArgs = args;
        argCount = commandLineArgs.length;
    }
}
