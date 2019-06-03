package com.builderPattern.player;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:20 2019/5/17
 */
public class StreamlinedModePlayerBuilder extends PlayerBuilder {
    @Override
    public void buildMenu() {
    }

    @Override
    public void buildList() {

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
