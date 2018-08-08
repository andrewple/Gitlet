package gitlet;

import java.io.FileNotFoundException;

public class Gitlet {

    private boolean isGitletInitialised() {
        return false;
    }

    private boolean doesFileExist(String fileName) {
        return true;
    }

    /**
     * Adds a copy of the file as it currently exists to the "staging area" (adding a file is also
     * called "staging the file"), somewhere in the .gitlet directory.
     * If the current working version of the file is in the current commit, do not stage it to be added.
     * If the file has been marked to be removed (via gitlet rm), removes that mark before adding the file.
     *
     * Runtime: O(n), where n is the size of the added file
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void addFileToStaging(String fileName) throws FileNotFoundException {

        if (!doesFileExist(fileName)) {
            throw new FileNotFoundException();
        }

        /* File currently on the commit - do not stage it to be added. */

        /* File marked for removal - remove the tag. */

    }

    /**
     * Untracks the file; that is, indicates (somewhere in the .gitlet directory) that it is not
     * to be included in the next commit, even if it is tracked in the current commit (which
     * becomes the next commit's parent).
     *
     * - If the file is tracked by the current commit: deletes the file from the working directory,
     * unstages if staged, and marks the file untracked by the next commit.
     * - If the file isn't tracked by current commit but is staged, unstage and do nothing else.
     * - If neither staged nor tracked by head commit, errors.
     * @param fileName
     * @throws FileNotFoundException if file is neither staged nor tracked by the head commit.
     */
    public void removeFile(String fileName) throws FileNotFoundException {
        /* File is neither staged nor tracked */
        throw new FileNotFoundException();

    }

    /**
     * Creates a new gitlet version-control system in the current directory.
     * The system will automatically start with one commit:
     *  - a commit with no files
     *  - with the commit message "initial commit"
     *  - single branch: "master", pointing to this commit
     *  - repository will be on master branch
     *
     * Runtime: O(1)
     *
     * @throws GitletAlreadyExistsException if gitlet already initialised in directory.
     */
    public boolean initGitletHere() throws GitletAlreadyExistsException {
        if (isGitletInitialised()) {
            throw new GitletAlreadyExistsException();
        }

        /* Init stuff. */
        return true;
    }

    public Gitlet(String path) {
    }

    public void printLog() {
    }

    public void printGlobalLog() {
    }

    public void printStatus() {

    }
}
