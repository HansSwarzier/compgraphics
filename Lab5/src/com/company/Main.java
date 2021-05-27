package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            IPad window = new IPad();

            window.setVisible(true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
