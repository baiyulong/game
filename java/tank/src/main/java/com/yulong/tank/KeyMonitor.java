package com.yulong.tank;

import com.yulong.tank.roles.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KeyMonitor extends KeyAdapter {

    private Player player1;

    private Player player2;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                player1.moveLeft();
                break;
            case 38:
                player1.moveUp();
                break;
            case 39:
                player1.moveRight();
                break;
            case 40:
                player1.moveDown();
                break;
            default:
                break;
        }
    }
}
