package com.lagrange.app;

import com.lagrange.ConsoleView;
import com.lagrange.config.Configuration;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.consoleView.start();
    }
}
