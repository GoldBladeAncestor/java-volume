package com.builderPattern.actor;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 20:24 2019/5/16
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ActorController actorController = new ActorController();
        Object object = XMLUtil.getBean();
        Actor actor = actorController.construct((ActorBuilder) object);
        System.out.println(actor.getType()  + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
        System.out.println("服装：" + actor.getConstume());
        System.out.println("发型：" + actor.getHairstyle());
    }
}
