package com.study.permission.service.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.permission.model.entity.BaseEntity;
import com.study.permission.model.page.PageBuilder;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author caad
 * @date: Create in 14:21 2019/4/3
 */
public interface BaseService<T extends BaseEntity> extends IService<T> {

    T get(Serializable id);

    T get(Wrapper<T> wrapper) throws Exception;

    List<T> getList(Collection<? extends Serializable> idList);

    List<T> getList(Wrapper<T> wrapper);

    IPage<T> getPage(PageBuilder pageBuilder);

    IPage<T> getPage(PageBuilder pageBuilder, Wrapper<T> wrapper);

//    T save(T entity);



}
