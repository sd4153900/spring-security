package com.study.permission.service.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.study.permission.common.utils.DeptLevelUtil;
import com.study.permission.model.dto.DeptTreeDto;
import com.study.permission.model.entity.DeptEntity;
import com.study.permission.model.form.DeptForm;
import com.study.permission.model.mapper.DeptMapper;
import com.study.permission.service.exception.ServiceException;
import com.study.permission.service.service.DeptService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author caad
 * @since 2019-04-04
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptMapper, DeptEntity> implements DeptService {

    @Override
    public DeptEntity save(DeptForm deptForm){
        if(checkExist(deptForm.getParentId(),deptForm.getName(),deptForm.getId())){
            throw new ServiceException("部门重复");
        }
        DeptEntity deptEntity;
        if(deptForm.getId() != null && deptForm.getId() > 0){
            deptEntity = get(deptForm.getId());
            if(deptEntity == null){
                throw new ServiceException("无对应id的部门数据");
            }
            deptEntity.setName(deptForm.getName()).setParentId(deptForm.getParentId())
                    .setSeq(deptForm.getSeq()).setRemark(deptForm.getRemark());
        }else{
            deptEntity = DeptEntity.builder().name(deptForm.getName()).parentId(deptForm.getParentId())
                    .seq(deptForm.getSeq()).remark(deptForm.getRemark()).build();
        }

        deptEntity.setLevel(DeptLevelUtil.calculateLevel(getParentLevel(deptForm.getParentId()),deptForm.getParentId()));
        return saveOne(deptEntity);
    }

    @Override
    public List<DeptTreeDto> getDeptTree() {
        List<DeptEntity> deptEntityList = getAll();
        if(CollectionUtils.isEmpty(deptEntityList)){
            return Collections.emptyList();
        }
        Multimap<String,DeptTreeDto> levelDeptMap = ArrayListMultimap.create();
        List<DeptTreeDto> rootList = Lists.newArrayList();
        for(DeptEntity deptEntity : deptEntityList){
            DeptTreeDto deptTreeDto = new DeptTreeDto(deptEntity);
            levelDeptMap.put(deptTreeDto.getLevel(),deptTreeDto);
            if(DeptLevelUtil.ROOT.equals(deptTreeDto.getLevel())){
                rootList.add(deptTreeDto);
            }
        }
        rootList.sort(Comparator.comparingInt(DeptEntity::getSeq));
        formatDeptTree(rootList,DeptLevelUtil.ROOT,levelDeptMap);
        return rootList;
    }

    private void formatDeptTree(List<DeptTreeDto> deptTreeDtoList,String parentLevel, Multimap<String,DeptTreeDto> levelDeptMap){
        for(DeptTreeDto deptTreeDto : deptTreeDtoList){
            String level = DeptLevelUtil.calculateLevel(parentLevel,deptTreeDto.getId());
            List<DeptTreeDto> chlidList = (List<DeptTreeDto>) levelDeptMap.get(level);
            if(CollectionUtils.isNotEmpty(chlidList)){
                chlidList.sort(Comparator.comparingInt(DeptEntity::getSeq));
                deptTreeDto.setDeptTreeDtoList(chlidList);
                formatDeptTree(chlidList,level,levelDeptMap);
            }

        }
    }

    private boolean checkExist(Integer parentId,String deptName,Integer deptId){
        //TODO:
        return false;
    }

    private String getParentLevel(Integer parentId){
        if(parentId == null || parentId <= 0){
            return null;
        }
        DeptEntity parentDept = get(parentId);
        if(parentDept == null){
            throw new ServiceException("无对应id的父部门数据");
        }
        return parentDept.getLevel();
    }
}
