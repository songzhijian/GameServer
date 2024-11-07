package ${template.loaderPackageName};

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
<#if template.saveOld>
import com.jx.config.custom.${template.className}CustomLoader;
</#if>
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

    private static Map<${template.mapType}/*唯一Id*/, ${template.className}> data = new HashMap<>();
    private static List<${template.className}> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<${template.className}> findAll(){
        return configs;
    }

    public static Map<${template.mapType}/*唯一Id*/, ${template.className}> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ${template.className} getByKey(${template.keyType} key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<${template.mapType}, ${template.className}> tempMap = new HashMap<>();
        List<${template.className}> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
            <#list template.columns as column>
                fieldName = "${column.nameConfig}";
                <#if column.nameConfig == "ALL_CONFIG_MAP">
                    <#assign value = '${column.parseType}.parse(entry)'/>
                <#else>
                    <#assign value = '${column.parseType}.parse(entry.get("${column.nameConfig}"))'/>
                </#if>
                ${column.type} ${column.nameCamel} = ${value};<#if column.nameConfig == template.keyName>
                errorId = ${column.nameCamel};</#if>
            </#list>

                ${template.className} config = new ${template.className}(<#list template.columns as column>${column.nameCamel}<#sep>, </#list>);
                tempMap.put(${template.keyName}, config);
                tempList.add(config);
            } catch (Exception e) {
                ConfigGlobalManager.error = String.format("[ConfigLoader] load config %s error, id = %s, fieldName = %s message = %s", CONFIG_NAME, errorId, fieldName, e.getMessage());
                LogUtils.logger.warn(ConfigGlobalManager.error,e);
<#--                String errorMsg = ConfigGlobalManager.error;-->
<#--                ToolManager.getWarnService().sendException(e,errorMsg, AppManger.warnAddresses.getConfig(),5000);-->
                throw e;
            }
        }
        LogUtils.logger.info("[ConfigLoader] load config {} finish, data size = {}", CONFIG_NAME, tempList.size());
<#if template.saveOld>
        ${template.className}CustomLoader.oldConfig = configs;
<#else>

</#if>
        data = Collections.unmodifiableMap(tempMap);
        configs = Collections.unmodifiableList(tempList);
    }
}
