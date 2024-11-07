package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成${name}
 */
public enum ${name} {

<#list rowList as row >
    <#list row as col >
        <#if col.value !="" >
    /**
     * ${col.comment}
     */
    ${col.title}(${col.value}),
        </#if>

    </#list>
    ;
</#list>
    private int value;

    public static ${name}[] ARRAY = {
<#list rowList as row >
    <#list row as col >
        <#if col.value !="" >
            ${col.title}<#if col_has_next>,</#if>
        </#if>
    </#list>
</#list>    };

    ${name}(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ${name} getType(int value) {
        return switch (value) {
        <#list rowList as row >
            <#list row as col >
                <#if col.value !="" >
            case ${col.value} -> ${col.title};
                </#if>
            </#list>
        </#list>
            default -> {
                LogUtils.logger.error("${name} is not find value:{}",value);
                yield null;
            }
        };
    }
}
