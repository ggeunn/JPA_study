package com.ohgiraffers.springdatajpa.menu.model.dao;


import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/* 필기.
*   JPARepository 상속 받아야 한다. (<사용할 엔티티 , 해당 클래스의 아이디 자료형 >)
*   Repository <- CRUDRepository <- PagingAndSortingRepository <- JPARepository
*   - EntityManagerFactory, EntityManager, EntityTransaction 자동 구현
*  */

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {


    List<Menu> findByMenuPriceGreaterThan(int menuPrice);

    List<Menu> findByMenuPriceGreaterThan(int menuPrice, Sort sort);

    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(int menuPrice);
}
