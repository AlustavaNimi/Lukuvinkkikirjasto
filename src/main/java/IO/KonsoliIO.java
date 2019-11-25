package IO;

import java.util.Scanner;

public class KonsoliIO implements IO {
    private Scanner scanner;
    
    public KonsoliIO() {
        scanner = new Scanner(System.in);
    }
    
    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public void print(String output) {
        System.out.println(output);
    }
    
}
