package com.study.permission.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.permission.model.entity.BaseEntity;
import com.study.permission.model.page.PageBuilder;
import com.study.permission.service.service.BaseService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author caad
 * @date: Create in 15:52 2019/4/3
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T extends BaseEntity> extends ServiceImpl<M,T> implements BaseService<T> {
    @Override
    public T get(Serializable id) {
        return getById(id);
    }

    @Override
    public T get(Wrapper<T> wrapper) throws Exception {
        return getOne(wrapper);
    }

    @Override
    public List<T> getList(Collection<? extends Serializable> idList) {
        return (List<T>) listByIds(idList);
    }

    @Override
    public List<T> getList(Wrapper<T> wrapper) {
        return list(wrapper);
    }

    @Override
    public IPage<T> getPage(PageBuilder pageBuilder) {
        return page(pageBuilder.builder());
    }

    @Override
    public IPage<T> getPage(PageBuilder pageBuilder, Wrapper<T> wrapper) {
        return page(pageBuilder.builder(),wrapper);
    }
}
