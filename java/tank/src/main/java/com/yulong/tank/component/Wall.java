package com.yulong.tank.component;

import com.yulong.tank.ResourcePath;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Wall implements GameComponent {
    public static final int width = 60;
    public static final int height = 60;

    private BackGround backGround;

    public Wall() {
        this.backGround = new BackGround(ResourcePath.walls);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
