package com.tool.config;


import com.tool.utils.ConfigUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConfigTemplate {
    private static final String CLASS_LOADER_NAME_SUFFIX = "Loader";
    private static final String CLASS_NAME_SUFFIX = "Config";

    private static final String CONFIG_NAME = "model";
    private static final String LOADER_NAME = "loader";

    private static final String CUSTOM_LOADER_NAME = "custom";

    /**配置文件 xml 的文件名*/
    private final String filename;
    /**配置文件类名*/
    private final String className;
    /**加载类的名字*/
    private final String loaderName;
    /** 主键类型 */
    private String keyType;

    private String keyName;
    /**额外导入的包*/
    private final Set<String> packages = new HashSet<>();

    private final String entityPackageName;
    private final String loaderPackageName;
    private final String customLoaderPackageName;

    private String mapType;

    /**配置文件列名*/
    private final List<Column> columns = new ArrayList<>();

    private boolean saveOld;

    public ConfigTemplate(String filename, String packageName) {
        this.filename = filename;
        // 转换 loaderName
        this.className = filename.replace("_", "") + CLASS_NAME_SUFFIX;
        this.loaderName = className + CLASS_LOADER_NAME_SUFFIX;
        this.entityPackageName = packageName + CONFIG_NAME;
        this.loaderPackageName = packageName + LOADER_NAME;
        this.customLoaderPackageName = packageName + CUSTOM_LOADER_NAME;
    }

    public void addColumn(ColData data) {
        try {
            // 字段注释
            String doc = data.getComment() == null ? "" : data.getComment();
            //字段名
            String nameConfig = data.getTitle();
            ConfigDataType type = ConfigDataType.getType(data.getType());
            if (type == null) {
                System.out.println("sheet：" + filename + "的列" + data.getTitle() + "的数据类型" + data.getType() + "无法解析");
                return;
            }

            Column column = new Column(nameConfig, data.getTitle(), doc, type.getPropertyType(), type.getParseType().getSimpleName());
            addColumn(column);

            if (data.isKey()) {
                this.keyType = column.getType();
                this.keyName = column.getNameCamel();
                this.mapType = type.getMapType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * map集合key，基础类型转换
     * @param dataType
     * @return
     */
    private String mapType(String dataType) {
        ConfigDataType type = ConfigDataType.getType(dataType);
        if (type != null) {
            return type.getMapType();
        }
        return "dataType类型不存在";
    }

    private String coverToClassName(String dataType) {
        ConfigDataType type = ConfigDataType.getType(dataType);
        if (type != null) {
            return type.getPropertyType();
        }
        return "dataType类型不存在";
    }

    private static String pase(String dataType) {
        ConfigDataType type = ConfigDataType.getType(dataType);
        if (type != null) {
            return type.getPropertyType();
        }
        return "dataType类型不存在";
    }

    private void addColumn(Column column) {
        this.columns.add(column);
    }

    /**
     * 属性相关信息
     */
    public static class Column {
        /**字段名 - 原始 xml 文件中的名字 */
        private final String nameConfig;
        /**字段名 - 驼峰名字，用于 K */
        private final String nameCamel;
        /**字段名 - 下划线，默认是 nameOrigin */
        private String nameUnderLine;
        /**字段名 - 首字母大写，可以用于 get set */
        private String nameFirstUpper;
        /**字段名 - 全大写，下划线间隔 */
        private String nameUpperAll;
        /**注释*/
        private final String doc;
        /**参数类型*/
        private final String type;

        private String parseType;

        public Column(String nameConfig, String nameCamel, String doc, String classType, String parseType) {
            this.type = classType;
            this.nameConfig = nameConfig;
            this.nameUnderLine = nameConfig;
            this.nameCamel = nameCamel;
            this.doc = doc;
            this.parseType = parseType;

            this.nameUnderLine = ConfigUtils.camelToUnderline(this.nameCamel);
            this.nameFirstUpper = ConfigUtils.firstToUpperCase(this.nameCamel);
            this.nameUpperAll = ConfigUtils.charToUpper(this.nameUnderLine);
        }

        /**
         * 转换指定格式文本，默认构建对象的时候会转换一次，如果重新指定 下划线名字，则需要重新抓换
         */

        public String getNameConfig() {
            return nameConfig;
        }

        public String getNameUnderLine() {
            return nameUnderLine;
        }

        public String getNameCamel() {
            return nameCamel;
        }

        public String getNameFirstUpper() {
            return nameFirstUpper;
        }

        public String getNameUpperAll() {
            return nameUpperAll;
        }

        public String getParseType() {
            return parseType;
        }

        public String getType() {
            return type;
        }

        public String getDoc() {
            return doc;
        }

    }

    public String getFilename() {
        return filename;
    }

    public String getClassName() {
        return className;
    }

    public String getLoaderName() {
        return loaderName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public String getKeyType() {
        return keyType;
    }

    public Set<String> getPackages() {
        return packages;
    }

    public String getEntityPackageName() {
        return entityPackageName;
    }

    public String getLoaderPackageName() {
        return loaderPackageName;
    }

    public String getCustomLoaderPackageName() {
        return customLoaderPackageName;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType;
    }

    public boolean isSaveOld() {
        return saveOld;
    }

    public void setSaveOld(boolean saveOld) {
        this.saveOld = saveOld;
    }
}
