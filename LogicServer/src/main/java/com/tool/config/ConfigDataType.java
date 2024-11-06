package com.tool.config;

import com.tool.config.type.primitive.*;
import com.tool.config.type.struct.*;

import java.util.function.Function;

public enum ConfigDataType {
    INT("int",Integer.class.getSimpleName(),"int",IntParse.class,IntParse::parse),
    LONG("long",Integer.class.getSimpleName(),"long",LongParse.class,LongParse::parse),
    FLOAT("float",Float.class.getSimpleName(),"float",FloatParse.class,FloatParse::parse),
    DOUBLE("double",Double.class.getSimpleName(),"double",DoubleParse.class,DoubleParse::parse),
    STRING("string",String.class.getSimpleName(),"String",StringParse.class,StringParse::parse),
    BOOL("bool",Boolean.class.getSimpleName(),"boolean",BooleanParse.class,BooleanParse::parse),
    BOOLEAN("boolean",Boolean.class.getSimpleName(),"boolean",BooleanParse.class,BooleanParse::parse),

    INT_ARRAY("int[]","","int[]",IntArrayParse.class,IntArrayParse::parse),
    LONG_ARRAY("long[]","","long[]",LongArrayParse.class,LongArrayParse::parse),
    FLOAT_ARRAY("float[]","","float[]",FloatArrayParse.class,FloatArrayParse::parse),
    DOUBLE_ARRAY("double[]","","double[]",DoubleArrayParse.class,DoubleArrayParse::parse),
    STRING_ARRAY("string[]","","String[]",StringArrayParse.class,StringArrayParse::parse),
    BOOL_ARRAY("bool[]","","boolean[]",BooleanArrayParse.class,BooleanArrayParse::parse),
    BOOLEAN_ARRAY("boolean[]","","boolean[]",BooleanArrayParse.class,BooleanArrayParse::parse),

    INT_ARRAY_2("int[][]","","int[][]",IntArray2Parse.class,IntArray2Parse::parse),
    LONG_ARRAY_2("long[][]","","long[][]",LongArray2Parse.class,LongArray2Parse::parse),
    FLOAT_ARRAY_2("float[][]","","float[][]",FloatArray2Parse.class,FloatArray2Parse::parse),
    DOUBLE_ARRAY_2("double[][]","","double[][]",DoubleArray2Parse.class,DoubleArray2Parse::parse),
    STRING_ARRAY_2("string[][]","","String[][]",StringArray2Parse.class,StringArray2Parse::parse),
    BOOL_ARRAY_2("bool[][]","","boolean[][]",BooleanArray2Parse.class,BooleanArray2Parse::parse),
    BOOLEAN_ARRAY_2("boolean[][]","","boolean[][]",BooleanArray2Parse.class,BooleanArray2Parse::parse),

    INT_ARRAY_3("int[][][]","","int[][][]",IntArray3Parse.class,IntArray3Parse::parse),

    MAP_INT_INT("map<int,int>","","Map<Integer,Integer>",MapIntIntParse.class,MapIntIntParse::parse),
    MAP_INT_STRING("map<int,string>","","Map<Integer,String>",MapIntStringParse.class,MapIntStringParse::parse),
    MAP_INT_FLOAT("map<int,float>","","Map<Integer,Float>",MapIntFloatParse.class,MapIntFloatParse::parse),
    MAP_INT_DOUBLE("map<int,double>","","Map<Integer,Double>",MapIntDoubleParse.class,MapIntDoubleParse::parse),
    MAP_INT_BOOL("map<int,bool>","","Map<Integer,Boolean>",MapIntBooleanParse.class,MapIntBooleanParse::parse),
    MAP_INT_BOOLEAN("map<int,boolean>","","Map<Integer,Boolean>",MapIntBooleanParse.class,MapIntBooleanParse::parse),

//    MAP_DOUBLE_INT("map<double,int>","","Map<Double,Integer>",MapDoubleIntParse.class,MapDoubleIntParse::parse),
//    MAP_DOUBLE_STRING("map<double,string>","","Map<Double,String>",MapDoubleStringParse.class,MapDoubleStringParse::parse),
//    MAP_DOUBLE_FLOAT("map<double,float>","","Map<Double,Float>",MapDoubleFloatParse.class,MapDoubleFloatParse::parse),
//    MAP_DOUBLE_DOUBLE("map<double,double>","","Map<Double,Double>",MapDoubleDoubleParse.class,MapDoubleDoubleParse::parse),
//    MAP_DOUBLE_BOOL("map<double,bool>","","Map<Double,Boolean>",MapDoubleBooleanParse.class,MapDoubleBooleanParse::parse),
//    MAP_DOUBLE_BOOLEAN("map<double,boolean>","","Map<Double,Boolean>",MapDoubleBooleanParse.class,MapDoubleBooleanParse::parse),

    MAP_STRING_INT("map<string,int>","","Map<String,Integer>",MapStringIntParse.class,MapStringIntParse::parse),
//    MAP_STRING_STRING("map<string,string>","","Map<String,String>",MapStringStringParse.class,MapStringStringParse::parse),
    MAP_STRING_FLOAT("map<string,float>","","Map<String,Float>",MapStringFloatParse.class,MapStringFloatParse::parse),
    MAP_STRING_DOUBLE("map<string,double>","","Map<String,Double>",MapStringDoubleParse.class,MapStringDoubleParse::parse),
    MAP_STRING_BOOL("map<string,bool>","","Map<String,Boolean>",MapStringBooleanParse.class,MapStringBooleanParse::parse),
    MAP_STRING_BOOLEAN("map<string,boolean>","","Map<String,Boolean>",MapStringBooleanParse.class,MapStringBooleanParse::parse),

    //小球类型
    INT_ARRAY_Vertical("intV[]","","int[]",IntArrayVerticalParse.class,IntArrayVerticalParse::parse),
    INT_ARRAY_2_Vertical("intV[][]","","int[][]",IntArray2VerticalParse.class,IntArray2VerticalParse::parse),

    LONG_ARRAY_Vertical("longV[]","","long[]",LongArrayVerticalParse.class,LongArrayVerticalParse::parse),
    LONG_ARRAY_2_Vertical("longV[][]","","long[][]",LongArray2VerticalParse.class,LongArray2VerticalParse::parse),
    FLOAT_ARRAY_Vertical("floatV[]","","float[]",FloatArrayVerticalParse.class,FloatArrayVerticalParse::parse),
    FLOAT_ARRAY_2_Vertical("floatV[][]","","float[][]",FloatArray2VerticalParse.class,FloatArray2VerticalParse::parse),
    STRING_ARRAY_Vertical("stringV[]","","String[]",StringArrayVerticalParse.class,StringArrayVerticalParse::parse),
    STRING_ARRAY_2_Vertical("stringV[][]","","String[][]",StringArray2VerticalParse.class,StringArray2VerticalParse::parse),

    ;




    private String excelType;
    /**
     * map中key类型,作为key才需要
     */
    private String mapType;
    /**
     * 属性类型
     */
    private String propertyType;
    /**
     * 转换器类型
     */
    private Class parseType;

    private Function<String,Object> function;

    ConfigDataType(String excelType,String mapType,String propertyType,Class parseType,Function<String,Object> function) {
        this.excelType = excelType;
        this.mapType = mapType;
        this.propertyType = propertyType;
        this.parseType = parseType;
        this.function = function;
    }

    public static ConfigDataType getType(String type) {
        ConfigDataType[] values = values();
        for (ConfigDataType value : values) {
            if(value.excelType.equalsIgnoreCase(type)) {
                return value;
            }
        }
        return null;
    }

    public String getExcelType() {
        return excelType;
    }

    public void setExcelType(String excelType) {
        this.excelType = excelType;
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Class getParseType() {
        return parseType;
    }

    public void setParseType(Class parseType) {
        this.parseType = parseType;
    }

    public Function<String, Object> getFunction() {
        return function;
    }
}
