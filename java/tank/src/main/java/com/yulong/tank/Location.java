package com.yulong.tank;

import com.yulong.tank.roles.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    int x;
    int y;

    public void moveX(Speed speed) {
        this.x = x + speed.getX();
    }

    public void moveY(Speed speed) {
        this.y = y + speed.getY();
    }

    public boolean isInBoundary() {
        return isInLeftBoundary()
                || isInRightBoundary()
                || isInTopBoundary()
                || isInBottomBoundary();
    }

    public boolean isInLeftBoundary() {
        return x <= 0;
    }

    public boolean isInRightBoundary() {
        return x >= Window.width - Player.width;
    }

    public boolean isInTopBoundary() {
        return y <= 0;
    }

    public boolean isInBottomBoundary() {
        return y >= Window.height - Player.height;
    }
}
