package com.builderPattern.player;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:04 2019/5/17
 */
public class Player {
    private boolean menu;
    private boolean list;
    private boolean window;
    private boolean bar;
    private boolean collect;

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean isWindow() {
        return window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }
}
