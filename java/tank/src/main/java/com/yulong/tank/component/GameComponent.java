package com.yulong.tank.component;

import com.yulong.tank.Window;

import java.awt.*;

public interface GameComponent {

    int getWidth();

    int getHeight();

    default void join(Graphics graphics, Window window) {

    }
}
