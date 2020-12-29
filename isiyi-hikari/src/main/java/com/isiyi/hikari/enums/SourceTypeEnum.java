package com.isiyi.hikari.enums;

import lombok.Getter;

@Getter
public enum  SourceTypeEnum {
    KUAI_DAI_LI("快代理");

    private String source;
    SourceTypeEnum(String source){
        this.source = source;
    }
}
