package com.yulong.tank.roles;

import com.yulong.tank.Window;
import com.yulong.tank.component.BackGround;
import com.yulong.tank.component.Star;
import com.yulong.tank.component.Wall;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@AllArgsConstructor
public class Home implements GameRole {

    public static final int width = Wall.width * 3;
    public static final int height = Wall.height * 2;

    private BackGround currentBackGround;

    private Wall wall;
    private Star star;

    public Home() {
        this.wall = new Wall();
        this.star = new Star();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void join(Graphics graphics, Window window) {
        final int half = (Window.width - width) / 2;
        /**
         * 1,2,3,4,5 is Wall, 6 is Star
         * |2|3|4|
         * |1|6|5|
         */
        BufferedImage wallImage = wall.getBackGround().getImage();
        graphics.drawImage(wallImage, half, Window.height - Wall.height, window);
        graphics.drawImage(wallImage, half, Window.height - height, window);
        graphics.drawImage(wallImage, half + Wall.width, Window.height - height, window);
        graphics.drawImage(wallImage, half + Wall.width * 2, Window.height - height, window);
        graphics.drawImage(wallImage, half + Wall.width * 2, Window.height - Wall.height, window);
        graphics.drawImage(star.getBackGround().getImage(), half + Wall.width + ((Wall.width - Star.width) / 2), Window.height - (Star.height + 10), window);
    }
}
