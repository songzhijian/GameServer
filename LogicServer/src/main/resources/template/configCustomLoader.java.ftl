package com.im30.esg.config.custom;

<#if template.saveOld>
import com.im30.esg.config.model.${template.className};
import java.util.List;
</#if>
import com.im30.esg.config.util.gen.old.support.IConfigCustomLoader;

/**
 * 工具生成 自定义再次次整理 ${template.filename}.xml
 */
public class ${template.className}CustomLoader implements IConfigCustomLoader {

<#if template.saveOld>
    public static List<${template.className}> oldConfig;
</#if>

    public static void load() {

    }
}