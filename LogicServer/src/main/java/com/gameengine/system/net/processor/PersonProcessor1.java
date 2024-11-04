package com.gameengine.system.net.processor;

import com.dreamfun.opg.message.GameMsg;
import com.gameengine.system.net.session.GameSession;

import java.util.ArrayList;
import java.util.List;

public class PersonProcessor1 extends MsgProcessor<GameMsg.Person1>{
    @Override
    public void process(GameSession session, GameMsg.Person1 msg) throws Exception {
        int age = msg.getAge();
        String name = msg.getName();
        List<String> hobbiesList = msg.getHobbiesList();

        GameMsg.Student2.Builder sendMsg = GameMsg.Student2.newBuilder();
        sendMsg.setAge(18);
        sendMsg.setName("齐天大圣");
        List<String> list = new ArrayList<>();
        list.add("吃桃子");
        list.add("翻跟头");
        sendMsg.addAllHobbies(list);
        session.sendMsg(sendMsg.build());
        session.flushMsg();
        System.out.println("--------     PersonProcessor1 END      ---------------");
    }
}
