package com.yulong.tank.component;

import com.yulong.tank.Location;
import com.yulong.tank.Speed;

public interface MovableComponent extends Runnable {
    Thread getThread();

    Speed getSpeed();

    Location getLocation();

    MoveStatus getMoveStatus();

    default void move() {
        if (isMovingLeft() || isMovingRight()) {
            getLocation().moveX(getSpeed());
        }
        if (isMovingUp() || isMovingDown()) {
            getLocation().moveY(getSpeed());
        }
    }

    default boolean isMoving() {
        return getSpeed().isMoving();
    }

    default boolean isMovingLeft() {
        return MoveStatus.LEFT.equals(getMoveStatus());
    }

    default boolean isMovingRight() {
        return MoveStatus.RIGHT.equals(getMoveStatus());
    }

    default boolean isMovingUp() {
        return MoveStatus.UP.equals(getMoveStatus());
    }

    default boolean isMovingDown() {
        return MoveStatus.DOWN.equals(getMoveStatus());
    }
}
