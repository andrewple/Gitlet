package gitlet;

public class NoSuchCommandException extends IllegalArgumentException {
    public NoSuchCommandException(String s) {
        super(s);
    }
}
