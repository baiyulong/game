package com.yulong.tank.roles;

import com.yulong.tank.Location;
import com.yulong.tank.ResourcePath;
import com.yulong.tank.Speed;
import com.yulong.tank.Window;
import com.yulong.tank.component.BackGround;
import com.yulong.tank.component.MovableComponent;
import com.yulong.tank.component.MoveStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.awt.*;

@Getter
@AllArgsConstructor
public class Player implements GameRole, MovableComponent {

    public static final int width = 60;
    public static final int height = 60;

    private final String name = player1;

    private Speed speed;

    private BackGround currentBackGround;

    private BackGround up;
    private BackGround down;
    private BackGround left;
    private BackGround right;

    private int initX;
    private int initY;

    private Thread thread;

    private Location location;

    private MoveStatus moveStatus;

    public Player(int p) {
        this.initY = Window.height - height;
        final int half = (Window.width - Home.width - width * 2) / 2;
        switch (p) {
            case 2:
                this.up = new BackGround(ResourcePath.p2tankU);
                this.down = new BackGround(ResourcePath.p2tankD);
                this.left = new BackGround(ResourcePath.p2tankL);
                this.right = new BackGround(ResourcePath.p2tankR);
                this.initX = half + width + Home.width;
                break;
            case 1:
            default:
                this.up = new BackGround(ResourcePath.p1tankU);
                this.down = new BackGround(ResourcePath.p1tankD);
                this.left = new BackGround(ResourcePath.p1tankL);
                this.right = new BackGround(ResourcePath.p1tankR);
                this.initX = half;
                break;
        }
        this.currentBackGround = up;
        this.location = new Location(initX, initY);
        this.moveStatus = MoveStatus.STOP;
        this.speed = new Speed(0, 0);
        this.thread = new Thread(this, name);
        thread.start();
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
        graphics.drawImage(currentBackGround.getImage(), location.getX(), location.getY(), window);
    }

    public void moveLeft() {
        this.currentBackGround = left;
        this.moveStatus = MoveStatus.LEFT;
        if (!location.isInLeftBoundary()) {
            speed.moveX(-5);
        }
    }

    public void moveRight() {
        this.currentBackGround = right;
        this.moveStatus = MoveStatus.RIGHT;
        if (!location.isInRightBoundary()) {
            speed.moveX(5);
        }
    }

    public void moveUp() {
        this.currentBackGround = up;
        this.moveStatus = MoveStatus.UP;
        if (!location.isInTopBoundary()) {
            speed.moveY(-5);
        }
    }

    public void moveDown() {
        this.currentBackGround = down;
        this.moveStatus = MoveStatus.DOWN;
        if (!location.isInBottomBoundary()) {
            speed.moveY(5);
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        for (; ; ) {
            if (isMoving()) {
                this.move();
                if (location.isInBoundary()) {
                    speed.stop(moveStatus);
                }
            }
            Thread.sleep(50);
        }
    }
}
