package com.lucas.slaintecare.views;

import java.util.Scanner;

public abstract class ConsoleView implements View {
    protected final Scanner scanner;
    
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
}
