package additional;

public class Reviser {
    String[] args;
    public Reviser(String[] args) {
        this.args = args;
    }

    public boolean firstArg(){
        if (args[0].equalsIgnoreCase("encoded") || args[0].equalsIgnoreCase("decoded")){
            System.out.println("First arg is not correct. Enter right arg (\"encode/decode\")");
            return false;
        }
        return true;
    }

    public boolean secondArg(){
        if (args[0].equalsIgnoreCase("encoded") || args[0].equalsIgnoreCase("decoded")){
            System.out.println("First arg is not correct. Enter right arg (\"encode/decode\")");
            return false;
        }
        return true;
    }


}
