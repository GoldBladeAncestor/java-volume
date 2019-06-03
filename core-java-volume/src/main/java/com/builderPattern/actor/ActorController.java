package com.builderPattern.actor;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 20:12 2019/5/16
 */
public class ActorController {
    public Actor construct(ActorBuilder actorBuilder){
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        if (!actorBuilder.isBareheaded()){
            actorBuilder.buildHairstyle();
        }
        return actorBuilder.createActor();
    }
}
