package training.reader;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String getLine(){
        return scanner.nextLine();
    }
    public int getInt(){ return scanner.nextInt(); };
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

}
