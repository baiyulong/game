package com.yulong.tank.component;

import com.yulong.tank.ResourcePath;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Star implements GameComponent {
    public static final int width = 40;
    public static final int height = 40;

    private BackGround backGround;

    public Star() {
        this.backGround = new BackGround(ResourcePath.star);
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
