package com.yulong.tank;

import com.yulong.tank.component.MoveStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Speed {
    int x;
    int y;

    public boolean isMoving() {
        return x != 0 || y != 0;
    }

    public void stop(MoveStatus moveStatus) {
        switch (moveStatus) {
            case UP:
            case DOWN:
                this.y = 0;
                break;
            case LEFT:
            case RIGHT:
                this.x = 0;
                break;
            default:
                this.x = 0;
                this.y = 0;
        }
    }

    public void moveX(int speed) {
        this.x = speed;
        this.y = 0;
    }

    public void moveY(int speed) {
        this.x = 0;
        this.y = speed;
    }
}
