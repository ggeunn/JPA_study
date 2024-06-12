package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @Autowired
    private EntityManager entityManager;


    public String selectSingleMenuByTypedQuery() {

        String jpql = "SELECT m.menuName FROM section01Menu m WHERE m.menuCode = 8";

        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);

        String result = query.getSingleResult();

        return result;

    }

    public Menu findMenu(int menuCode) {
        Menu menu = entityManager.find(Menu.class, menuCode);
        System.out.println("menu = " + menu);
        return menu;

    }

    public Object selectSingleMenuByQuery() {

        String jpql = "SELECT m.menuName FROM section01Menu m WHERE m.menuCode = 8";

        Query query = entityManager.createQuery(jpql);

        return query.getSingleResult();

    }

    public Menu selectSingleRowByTypedQuery() {


        String jpql = "SELECT m FROM section01Menu m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu result = query.getSingleResult();
        return result;

    }

    public List<Menu> selectMultiRowByTypedQuery() {

        String jpql = "SELECT m FROM section01Menu m";

        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> result = query.getResultList();
        return result;
    }


    public List<Menu> selectMultiRowByQuery() {

        String jpql = "SELECT m FROM section01Menu m";
        Query query = entityManager.createQuery(jpql);
        List<Menu> result = query.getResultList();

        return result;
    }

    public List<Integer> selectUseDistinct() {

        String jpql = "SELECT DISTINCT m.categoryCode FROM section01Menu m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> result = query.getResultList();

        return result;
    }
}
