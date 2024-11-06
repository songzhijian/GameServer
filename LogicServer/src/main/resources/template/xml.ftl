<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<tns:database xmlns:tns="http://www.iw.com/sns/platform/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<#if rowList ??>
    <#if sheetType>
     <ItemSpec
        <#list rowList as row >
             <#list row as col >
                 <#if col.value !="" >
        ${col.title}="${col.value}"
                 </#if></#list>
        </#list>
     />
    <#else>
        <#list rowList as row >
    <ItemSpec <#list row as col ><#if col.value !="" >${col.title}="${col.value}" </#if></#list> />
        </#list>
    </#if>

</#if>
</tns:database>