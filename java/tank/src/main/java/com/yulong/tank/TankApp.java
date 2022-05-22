package com.yulong.tank;

public class TankApp {

    public static void main(String[] args) {
        Window window = new Window();
        Thread thread = new Thread(window, "window");
        thread.start();
    }
}
