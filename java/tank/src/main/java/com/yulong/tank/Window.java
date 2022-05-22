package com.yulong.tank;

import com.yulong.tank.component.GameComponent;
import com.yulong.tank.roles.Home;
import com.yulong.tank.roles.Player;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Window extends JFrame implements Runnable {

    public static int width = 800;
    public static int height = 610;

    private Image screenImage;

    public final List<GameComponent> gameComponents = new ArrayList<>(72);

    private Player player1;

    private Player player2;

    public Window() {
        setTitle("Ì¹¿Ë´óÕ½");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(Boolean.FALSE);
        setVisible(Boolean.TRUE);
        addComponent();

        this.addKeyListener(new KeyMonitor(player1, player2));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (Objects.isNull(screenImage)) {
            screenImage = createImage(width, height);
        }
        Graphics graphics = screenImage.getGraphics();
        graphics.fillRect(0, 0, width, height);

        gameComponents.forEach(o -> o.join(graphics, this));
        g.drawImage(screenImage, 0, 0, this);
    }

    private void addComponent() {
        this.player1 = new Player(1);
        gameComponents.add(player1);
        gameComponents.add(new Home());
    }

    @SneakyThrows
    @Override
    public void run() {
        for (; ; ) {
            repaint();
            Thread.sleep(50);
        }
    }
}
