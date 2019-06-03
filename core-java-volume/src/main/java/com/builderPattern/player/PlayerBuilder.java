package com.builderPattern.player;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:08 2019/5/17
 */
public abstract class PlayerBuilder {
    protected Player player = new Player();
    public abstract void buildMenu();
    public abstract void buildList();
    public abstract void buildWindow();
    public abstract void buildBar();
    public abstract void buildCollect();

    public Player createPlayer(){
        return player;
    }
}
