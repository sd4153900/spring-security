package com.study.permission.model.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.study.permission.model.entity.BaseEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @author caad
 * @date: Create in 11:23 2019/4/3
 */
public class MyGenerator {

    public static void main(String[] args) {
       for(Type type : Type.values()){
           generator(type);
       }

    }

    public static void generator(Type type) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取项目根目录
        String projectPath = System.getProperty("user.dir");
        //多模块路径获取方式
        File file = new File(type.path);
        String path = file.getAbsolutePath();
        //设置全局输出路径
        gc.setOutputDir(path + "/src/main/java");
        //获取计算机用户名
        String userName = System.getenv().get("USERNAME");
        //设置全局用户信息
        gc.setAuthor(userName);
        //是否覆盖文件
        gc.setFileOverride(false);
        //是否打开文件
        gc.setOpen(true);
        //xml 添加二级缓存配置
        gc.setEnableCache(false);
        //开启kotlin模式
        gc.setKotlin(false);
        //开启swagger2 模式，接口文档
        gc.setSwagger2(false);
        //开启ActiveRecord 模式,实体类进行sql
        gc.setActiveRecord(false);
        //xml 创建BaseResultMap
        gc.setBaseResultMap(true);
        //xml 创建BaseColumnList
        gc.setBaseColumnList(false);
        //设置时间类型
        gc.setDateType(DateType.TIME_PACK);
        //设置名称 %s自动生成名称
        gc.setEntityName("%sEntity");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        //设置主键类型
        gc.setIdType(IdType.AUTO);
        //添加全局变量类
        generator.setGlobalConfig(gc);
        //设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://172.16.3.197:3306/study_sys?characterEncoding=UTF-8");
        dsc.setUsername("root");
        dsc.setPassword("Daohaode@4");
        generator.setDataSource(dsc);

        //数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        //实体类映射命名规则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //实体类字段映射命名规则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //实体类继承类
        strategy.setSuperEntityClass(BaseEntity.class);
        // 父类字段
        strategy.setSuperEntityColumns("id","creator","operator_time","operator_ip");
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        strategy.setSuperServiceClass("com.study.permission.service.service.BaseService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass("com.study.permission.service.service.impl.BaseServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 包含的表名
        // strategy.setInclude("表名，多个英文逗号分割");
        // 排除的表名
        // strategy.setExclude("表名，多个英文逗号分割");
        // 生成字段常量
        strategy.setEntityColumnConstant(false);
        // 是否为构建者模型
        strategy.setEntityBuilderModel(false);
        // Boolean类型字段是否移除is前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(false);
        // 是否为lombok模型
        strategy.setEntityLombokModel(true);
        // 生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 表前缀
        strategy.setTablePrefix("sys_");
        // 字段前缀
//        strategy.setFieldPrefix("");
        generator.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.study.permission");
//        pc.setModuleName("")
        pc.setEntity("model.entity");
        pc.setService("service.service");
        pc.setServiceImpl("service.service.impl");
        pc.setMapper("model.mapper");
        pc.setController("web.controller");
        generator.setPackageInfo(pc);

        switch (type) {
            case XML:
                // 自定义配置
                InjectionConfig cfg = new InjectionConfig() {
                    @Override
                    public void initMap() {
                        // to do nothing
                    }
                };

                String templatePath = "/templates/mapper.xml.vm";

                // 自定义输出配置
                List<FileOutConfig> focList = new ArrayList<>();
                // 自定义配置会被优先输出
                focList.add(new FileOutConfig(templatePath) {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                        return projectPath + "/permission-model/src/main/resources/mapper/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                    }
                });
                cfg.setFileOutConfigList(focList);
                generator.setCfg(cfg);
                break;
            default:
                break;
        }
        generator.setTemplate(type.getTemplateConfig());

        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
//        templateConfig.setController(null);
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
//        templateConfig.setMapper();
//        templateConfig.setServiceImpl();
//        generator.setTemplate(templateConfig);
        generator.execute();
    }

    public enum Type {
        ENTITY("permission-model"),
        MAPPER("permission-model"),
        XML(""),
        SERVICE("permission-service"),
        SERVICEIMPL("permission-service"),
        CONTROLLER("permission-web");

        private String path;
        private TemplateConfig templateConfig;

        Type(String path) {
            this.path = path;
            this.templateConfig.setController(null);
            this.templateConfig.setService(null);
            this.templateConfig.setServiceImpl(null);
            this.templateConfig.setMapper(null);
            this.templateConfig.setEntity(null);
            this.templateConfig.setEntityKt(null);
            this.templateConfig.setXml(null);
            switch (this) {
                case CONTROLLER:
                    //templateConfig.setController(ConstVal.TEMPLATE_CONTROLLER);
                    break;
                case SERVICE:
                    this.templateConfig.setService(ConstVal.TEMPLATE_SERVICE);
                    break;
                case SERVICEIMPL:
                    this.templateConfig.setServiceImpl(ConstVal.TEMPLATE_SERVICE_IMPL);
                    break;
                case MAPPER:
                    this.templateConfig.setMapper(ConstVal.TEMPLATE_MAPPER);
                    break;
                case ENTITY:
                    this.templateConfig.setEntity(ConstVal.TEMPLATE_ENTITY_JAVA);
                    break;
                case XML:
                    break;
            }
        }

        public String getPath() {
            return path;
        }

        public TemplateConfig getTemplateConfig() {
            return templateConfig;
        }
    }
}
