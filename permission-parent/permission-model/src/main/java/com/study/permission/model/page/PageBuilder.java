package com.study.permission.model.page;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caad
 * @date: Create in 14:38 2019/4/3
 */
public class PageBuilder {

    private long index;
    private long size;
    private List<String> ascs;
    private List<String> descs;

    public PageBuilder() {
        index = 1;
        size = 20;
        ascs = CollectionUtil.newArrayList();
        descs = CollectionUtil.newArrayList();
    }

    public PageBuilder(PageForm pageForm) {
        super();
    }

    public PageBuilder setIndex(long index) {
        this.index = index;
        return this;
    }

    public PageBuilder setSize(long size) {
        this.size = size;
        return this;
    }

    public PageBuilder addSort(Direction direction, String filed) {
        switch (direction) {
            case ASC:
                ascs.add(filed);
                break;
            case DESC:
                descs.add(filed);
                break;
            default:
                break;
        }
        return this;
    }

    public <T>Page<T> builder(){
        Page<T> page = new Page<>(index,size);
        if(CollectionUtil.isNotEmpty(ascs)){
            page.setAscs(ascs);
        }
        if(CollectionUtil.isNotEmpty(descs)){
            page.setDescs(descs);
        }
        return page;
    }

    public enum Direction {
        ASC, DESC
    }

}
