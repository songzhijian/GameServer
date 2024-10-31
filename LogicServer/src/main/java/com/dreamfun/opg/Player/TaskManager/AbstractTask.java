package com.dreamfun.opg.Player.TaskManager;

import com.dreamfun.opg.Common.ActionType;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 任务相关共通
 */
public abstract class AbstractTask {

    protected String id;
    protected String uid;
    protected long num;
    protected int state;
    protected String param;
    protected int type;
    protected long time;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    public boolean isCompleted(String para2) {
        String[] numArr = StringUtils.split(para2, "|");
        long max = 0;
        for(String str : numArr) {
            max += Long.parseLong(str);
        }
        if(num > max)
            num = max;
        return num == max;
    }



    public boolean handleTask(ActionType actionType, Map<String,String> taskMap,Object matchingKey, int currCount){
        switch (actionType){
            case Build_Update:
                break;

            default:
        }
        return false;
    }


    public enum TaskState {
        ACCEPT, COMPLETE, REWARD;

        public static TaskState get(int index) {
            TaskState[] tsArr = values();
            return tsArr[index];
        }
    }

}
