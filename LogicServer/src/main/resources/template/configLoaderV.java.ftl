package ${template.loaderPackageName};

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import ${template.entityPackageName}.${template.className};
import com.jx.config.util.gen.support.IConfigLoader;
import com.tool.config.type.primitive.*;
import com.tool.config.type.struct.*;
<#list template.packages as package>
<#if package != "">
import ${package};
</#if>
</#list>

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* 工具生成 配置文件 ${template.filename}.xml
*/
@ConfigLoader
public class ${template.loaderName} implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "${template.filename}";

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>>all=XmlUtils.getXMLFile(CONFIG_NAME);
        if(all.size()<=0){
            return;
        }
        Map<String, String> data=all.get(0);

        // 各个字段
        String fieldName = null;
        try{
            <#list template.columns as column>
            fieldName = "${column.nameCamel}";
            ${template.className}.${column.nameCamel}=${column.parseType}.parse(data.get("${column.nameCamel}"));
            </#list>
        }catch(Exception e){
            ConfigGlobalManager.error = String.format("[ConfigLoader] load config %s error, fieldName = %s message = %s", CONFIG_NAME, fieldName, e.getMessage());
            LogUtils.logger.warn(ConfigGlobalManager.error,e);
<#--            String errorMsg = ConfigGlobalManager.error;-->
<#--            ToolManager.getWarnService().sendException(e,errorMsg, AppManger.warnAddresses.getConfig(),5000);-->
            throw e;
        }

        LogUtils.logger.info("[ConfigLoader] load config {} finish",CONFIG_NAME);

    }
}
