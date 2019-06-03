package com.builderPattern.actor;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 20:23 2019/5/16
 */
public class DevilBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        actor.setConstume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }

    @Override
    public boolean isBareheaded() {
        return true;
    }
}
