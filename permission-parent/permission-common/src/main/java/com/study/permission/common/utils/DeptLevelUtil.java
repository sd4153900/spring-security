package com.study.permission.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author caad
 * @date: Create in 15:22 2019/4/9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeptLevelUtil {


    public final static String SEPARATOR = ".";
    public final static String ROOT = "0";

    public static String calculateLevel(String parentLevel,Integer parentId){
        if(StringUtils.isEmpty(parentLevel)){
            return ROOT;
        }
        return StringUtils.join(parentLevel,SEPARATOR,parentId);
    }
}
