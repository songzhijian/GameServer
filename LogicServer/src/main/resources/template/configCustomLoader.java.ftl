package com.jx.config.custom;

<#if template.saveOld>
import com.jx.config.model.${template.className};
import java.util.List;
</#if>
import com.jx.config.util.gen.support.IConfigCustomLoader;

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