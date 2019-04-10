package com.study.permission.model.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

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
        ascs = Lists.newArrayList();
        descs = Lists.newArrayList();
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
        if(CollectionUtils.isNotEmpty(ascs)){
            page.setAscs(ascs);
        }
        if(CollectionUtils.isNotEmpty(descs)){
            page.setDescs(descs);
        }
        return page;
    }

    public enum Direction {
        ASC, DESC
    }

}
