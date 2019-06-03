package com.builderPattern.actor;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 20:10 2019/5/16
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();
    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();
    public Actor createActor(){
        return actor;
    }

    public boolean isBareheaded(){
        return false;
    }
}
