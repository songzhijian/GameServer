package ${template.entityPackageName};

import ${template.loaderPackageName}.${template.loaderName};
import com.im30.esg.config.util.gen.old.support.AbstractConfig;
import com.im30.esg.config.util.gen.old.support.IConfig;
<#list template.packages as package>
<#if package != "">
import ${package};
</#if>
</#list>

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 ${template.filename}.xml
*/
public class ${template.className} extends AbstractConfig implements IConfig {

<#list template.columns as column>
    <#if column.doc != "">
    /**${column.doc}*/
    <#else>
    /**${column.nameConfig}*/
    </#if>
    private final ${column.type} ${column.nameCamel};
</#list>

    /**
     * 获取所有配置
     */
    public static List<${template.className}> findAll(){
        return ${template.loaderName}.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ${template.className} getByKey(${template.keyType} key){
        return ${template.loaderName}.getByKey(key);
    }

    //#region getter
<#list template.columns as column>
    <#if column.type == "boolean" || column.type == "Boolean">
        <#assign prefix="is"/>
    <#else>
        <#assign prefix="get"/>
    </#if>
    <#if column.doc != "">
    /**
     * ${column.doc}
     */
    </#if>
    public ${column.type} ${prefix}${column.nameFirstUpper}() {
        return ${column.nameCamel};
    }

</#list>
    //#endregion

    //#region 构造函数

    public ${template.className}(<#list template.columns as column>${column.type} ${column.nameCamel}<#sep>, </#list>){
    <#list template.columns as column>
        this.${column.nameCamel} = ${column.nameCamel};
    </#list>
    }

    //#endregion
}
