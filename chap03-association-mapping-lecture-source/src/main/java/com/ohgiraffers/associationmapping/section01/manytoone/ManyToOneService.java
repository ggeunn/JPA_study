package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.Table;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManyToOneService {

    private ManyToOneRepository manyToOneRepository;

    public ManyToOneService(ManyToOneRepository manyToOneRepository) {
        this.manyToOneRepository = manyToOneRepository;
    }

    public Menu findMenu(int menuCode) {

        return manyToOneRepository.find(menuCode);
    }

    public String findCategoryNameBYJpql(int menuCode) {

        return manyToOneRepository.findCategoryNameByJpql(menuCode);
    }

    @Transactional
    public void registMenu(MenuDTO menu) {
        Menu newMenu = new Menu(
                menu.getMenuCode(),
                menu.getMenuName(),
                menu.getMenuPrice(),
                new Category(
                        menu.getCategoryDTO().getCategoryCode(),
                        menu.getCategoryDTO().getCategoryName(),
                        menu.getCategoryDTO().getRefCategoryCode()
                ),
                menu.getOrderableStatus()
        );

        manyToOneRepository.regist(newMenu);

    }
}
