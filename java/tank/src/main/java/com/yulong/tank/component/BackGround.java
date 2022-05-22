package com.yulong.tank.component;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Getter
@AllArgsConstructor
public class BackGround {

    private BufferedImage image;

    public BackGround(String path) {
        try {
            this.image = ImageIO.read(new File("src/main/resources/" + path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
