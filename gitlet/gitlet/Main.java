package gitlet;

/* Driver class for Gitlet, the tiny simplified version-control system.
   @author
*/
public class Main {

    /* Usage: java gitlet.Main ARGS, where ARGS contains
       <COMMAND> <OPERAND> .... */
    public static void main(String[] args) {
        CommandParser parser = new CommandParser(args);
        try {
            parser.parseCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.exit(0); // defaultedly exits with 0
    }

}
