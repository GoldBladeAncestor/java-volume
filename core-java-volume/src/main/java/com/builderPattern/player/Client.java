package com.builderPattern.player;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:32 2019/5/17
 */
public class Client {
    public static void main(String[] args) {
        PlayerControler playerControler = new PlayerControler();
        Player player = playerControler.construct(new FullModePlayerBuilder());
        System.out.println("播放器将展示以下元素：");
        System.out.println("是否展示菜单:" + player.isMenu());
        System.out.println("是否展示播放列表:" + player.isList());
        System.out.println("是否展示主窗口:" + player.isWindow());
        System.out.println("是否展示控制条:" + player.isBar());
        System.out.println("是否展示收藏列表:" + player.isCollect());
    }
}
