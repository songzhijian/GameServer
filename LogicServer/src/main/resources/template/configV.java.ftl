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
    public static ${column.type} ${column.nameCamel};
</#list>

}