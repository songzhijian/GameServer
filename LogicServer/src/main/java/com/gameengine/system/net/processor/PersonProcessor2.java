package com.gameengine.system.net.processor;

import com.dreamfun.opg.message.GameMsg;
import com.gameengine.system.net.session.GameSession;

import java.util.ArrayList;
import java.util.List;

public class PersonProcessor2 extends MsgProcessor<GameMsg.Student2>{
    @Override
    public void process(GameSession session, GameMsg.Student2 msg) throws Exception {
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
        System.out.println("--------     PersonProcessor2 END      ---------------");
    }
}
