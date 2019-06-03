package com.builderPattern.player;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:11 2019/5/17
 */
public class FullModePlayerBuilder extends PlayerBuilder {
    @Override
    public void buildMenu() {
        player.setMenu(true);
    }

    @Override
    public void buildList() {
        player.setList(true);
    }

    @Override
    public void buildWindow() {
        player.setWindow(true);
    }

    @Override
    public void buildBar() {
        player.setBar(true);
    }

    @Override
    public void buildCollect() {
    }

}
