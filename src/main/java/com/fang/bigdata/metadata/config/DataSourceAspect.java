package com.fang.bigdata.metadata.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/3/9.
 */
@Aspect
@Component
public class DataSourceAspect {
    @Autowired
    HttpServletRequest request;

    @Pointcut("execution(* com.fang.bigdata.metadata.dao.*Mapper.*(..))")
    public void pointCutAt_Mysql() {
    }

    @Before("pointCutAt_Mysql()")
    public void setDataSource_contractWrite(JoinPoint jointPoint) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.MYSQL);
        System.out.println("CW:" + DatabaseContextHolder.getDatabaseType());
    }


    @Pointcut("execution(* com.fang.bigdata.metadata.daokylin.*Mapper.*(..))")
    public void pointCutAt_Kylin() {
    }

    @Before("pointCutAt_Kylin()")
    public void setDataSource_contractRead(JoinPoint joinPoint) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.KYLIN);
        System.out.println("CR:" + DatabaseContextHolder.getDatabaseType());
    }

    @Pointcut("execution(* com.fang.bigdata.metadata.daokylinnewsfb.*Mapper.*(..))")
    public void pointCutAt_Kylin_Newsfb() {
    }

    @Before("pointCutAt_Kylin_Newsfb()")
    public void setDataSource_contractReadNewsfb(JoinPoint joinPoint) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.KYLIN_NEWSFB);
        System.out.println("CR:" + DatabaseContextHolder.getDatabaseType());
    }

    @Pointcut("execution(* com.fang.bigdata.metadata.daoimpala.*Mapper.*(..))")
    public void pointCutAt_Impala_Dwd() {
    }

    @Before("pointCutAt_Impala_Dwd()")
    public void setDataSource_contractImpalaDwd(JoinPoint joinPoint) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.IMPALA_DWD);
        System.out.println("CR:" + DatabaseContextHolder.getDatabaseType());
    }


    @Pointcut("execution(* com.fang.bigdata.metadata.daoub.*Mapper.*(..))")
    public void pointCutAt_UB() {
    }

    @Before("pointCutAt_UB()")
    public void setDataSource_ubWrite(JoinPoint jointPoint) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.UB);
        System.out.println("CUB:" + DatabaseContextHolder.getDatabaseType());
    }

}