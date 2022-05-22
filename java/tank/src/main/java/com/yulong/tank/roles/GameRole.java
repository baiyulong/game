package com.yulong.tank.roles;

import com.yulong.tank.component.BackGround;
import com.yulong.tank.component.GameComponent;

public interface GameRole extends GameComponent {
    String player1 = "player1";
    String player2 = "player2";

    BackGround getCurrentBackGround();
}
