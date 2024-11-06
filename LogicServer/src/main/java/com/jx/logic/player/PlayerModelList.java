package com.jx.logic.player;

import com.jx.logic.player.TaskManager.UserTaskManager;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PlayerModelList {


    private static Set<Class<? extends IPlayerModelManager>> modelList = new LinkedHashSet<>();


    private static Field outField;

    /**
     * 按顺序加载模块  如果有manager之间的加载  add的时候 注意先后顺序  
     */
    static {
        try {
            outField = PlayerModelList.class.getDeclaredField("playerModelOutLoaderMap");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        modelList.add(UserTaskManager.class);
     }


    private static Map<Class<? extends IPlayerModelManager>, Field> modelMap = new LinkedHashMap<>();

    private static volatile Boolean load = false;

    private  static void loadModelMap(){
         if(load==true){
             return;
         }
         synchronized (modelMap){
             Map<Class,Field> clMap = new HashMap<>();
             Field[] fields = UserProfile.class.getDeclaredFields();
             for(Field field: fields){
                 if(modelList.contains(field.getType()) ){
                     field.setAccessible(true);
                     clMap.put(field.getType(),field);
                 }
             }

             Iterator<Class<? extends IPlayerModelManager>> iter = modelList.iterator(); //按初始化顺序方
             while (iter.hasNext()){
                 Class<? extends IPlayerModelManager> cl = iter.next();
                 Field                                field = clMap.get(cl);
                 if(field==null){

                     /*ModelOutLoad outLoad  = cl.getDeclaredAnnotation(ModelOutLoad.class);
                     if(outLoad!=null){
                        field = outField;

                     }else {
                          continue;
                     }
*/

                 }
                 modelMap.put(cl,field);
             }
             load = true;
         }
    }

    public static Map<Class<? extends IPlayerModelManager>, Field> getPlayerModelMap(){
        loadModelMap();
        return modelMap;
    }


}
