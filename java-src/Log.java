import java.io.*;
public class Log {
    public static final String ANSI_RESET = "\u001B[0m"; 
  
    // Declaring the color 
    // Custom declaration 
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
   
    public static void yellow(String ...message){
        String toPrint = "";
        for(var x : message){
            toPrint = toPrint + " " + x;
        }
        System.out.print(ANSI_YELLOW 
                           + toPrint
                           + ANSI_RESET);
    }

    public static void red(String ...message){
        String toPrint = "";
        for(var x : message){
            toPrint = toPrint + " " + x;
        }
        System.out.print(ANSI_RED 
                           + toPrint
                           + ANSI_RESET);
    }
    public static void gr(String ...message){
        String toPrint = "";
        for(var x : message){
            toPrint = toPrint + " " + x;
        }
        System.out.print(ANSI_GREEN 
                           + toPrint
                           + ANSI_RESET);
    }
    public static void bl(String ...message){
        String toPrint = "";
        for(var x : message){
            toPrint = toPrint + " " + x;
        }
        System.out.print(ANSI_BLUE 
                           + toPrint
                           + ANSI_RESET);
    }
    public static void purple(String ...message){
        String toPrint = "";
        for(var x : message){
            toPrint = toPrint + " " + x;
        }
        System.out.print(ANSI_PURPLE 
                           + toPrint
                           + ANSI_RESET);
    }
    public static void cyan(String ...message){
        String toPrint = "";
        for(var x : message){
            toPrint = toPrint + " " + x;
        }
        System.out.print(ANSI_CYAN 
                           + toPrint
                           + ANSI_RESET);
    }
}


