package additional;

public class Communicator {
    public static void messageFirstArg(){
        System.out.println("First arg is not correct. Enter right arg (\"encode/decode\")");
    }public static void messageSecondArg(){
        System.out.println("File for encoding does not exist, restart application and enter right path");
    }public static void messageThirdArg(){
        System.out.println("Third arg must be number, please restart application with correct arg.");
    }public static void messageFileExists(){
        System.out.println("File exists with such name as we are creating. " +
                "Please delete file or move this file and then restart application");
    }

}
