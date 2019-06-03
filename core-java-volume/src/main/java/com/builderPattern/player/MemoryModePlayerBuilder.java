package com.builderPattern.player;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:21 2019/5/17
 */
public class MemoryModePlayerBuilder extends PlayerBuilder {
    @Override
    public void buildMenu() {
        player.setMenu(true);
    }

    @Override
    public void buildList() {
    }

    @Override
    public void buildWindow() {
    }

    @Override
    public void buildBar() {
        player.setBar(true);
    }

    @Override
    public void buildCollect() {
        player.setMenu(true);
    }

}
