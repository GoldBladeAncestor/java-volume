package com.builderPattern.player;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:15 2019/5/17
 */
public class PlayerControler {
    public Player construct(PlayerBuilder playerBuilder){
        playerBuilder.buildMenu();
        playerBuilder.buildList();
        playerBuilder.buildWindow();
        playerBuilder.buildBar();
        playerBuilder.buildCollect();
        Player player = playerBuilder.createPlayer();
        return player;
    }
}
