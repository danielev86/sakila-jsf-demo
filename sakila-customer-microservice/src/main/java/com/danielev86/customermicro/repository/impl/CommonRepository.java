package com.danielev86.customermicro.repository.impl;

import com.danielev86.customermicro.repository.bean.GenericBean;
import org.apache.commons.collections4.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CommonRepository {

    public Query buildAndHQLQuery(EntityManager entityManager, StringBuilder sql, List<String> conditions, List<GenericBean> parameters){
        Query query = null;
        if (CollectionUtils.isNotEmpty(conditions) && CollectionUtils.isNotEmpty(parameters)){
            sql.append(" WHERE ");
            for (int i = 0; i<conditions.size(); i++){
                String condition = conditions.get(i);
                if (i == conditions.size()-1){
                    sql.append(" ").append(condition).append(" ");
                }else{
                    sql.append("  ").append(condition).append(" AND ");
                }
            }
            query = entityManager.createQuery(sql.toString());
            for (GenericBean param : parameters){
                query.setParameter(param.getParameterName(),param.getParamaterValue());
            }
        }else{
            query = entityManager.createQuery(sql.toString());
        }
        return query;
    }

    public Query buildORHQLQuery(EntityManager entityManager, StringBuilder sql, List<String> conditions, List<GenericBean> parameters){
        Query query = null;
        if (CollectionUtils.isNotEmpty(conditions) && CollectionUtils.isNotEmpty(parameters)){
            sql.append(" WHERE ");
            for (int i = 0; i<conditions.size(); i++){
                String condition = conditions.get(i);
                if (i == conditions.size()-1){
                    sql.append(" ").append(condition).append(" ");
                }else{
                    sql.append("  ").append(condition).append(" OR ");
                }
            }
            query = entityManager.createQuery(sql.toString());
            for (GenericBean param : parameters){
                query.setParameter(param.getParameterName(),param.getParamaterValue());
            }
        }else{
            query = entityManager.createQuery(sql.toString());
        }
        return query;
    }
}
