package com.nongxin.terminal.util.enumUtil.common;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlatformTypeEnum {

    BOARD(1,"看板"),
    BACK(2,"后台");

    private Integer type;
    private String name;

    PlatformTypeEnum(Integer type,String name){
        this.type = type;
        this.name = name;
    }

    public static PlatformTypeEnum getByValue(Integer value){
        PlatformTypeEnum platformTypeEnums[] = PlatformTypeEnum.values();
        for(PlatformTypeEnum platformTypeEnum : platformTypeEnums){
            if(platformTypeEnum.getType().equals(value)){
                return platformTypeEnum;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
