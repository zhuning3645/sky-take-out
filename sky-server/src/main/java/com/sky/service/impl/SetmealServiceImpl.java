package com.sky.service.impl;

import com.sky.dto.SetmealDTO;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.service.DishService;
import com.sky.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;

    @Transactional
    public void saveWithDish(SetmealDTO setmealDTO) {
        //传入套餐的参数
        SetmealDTO setmeal = new SetmealDTO();
        BeanUtils.copyProperties(setmealDTO,setmeal);

        //修改套餐表基本信息
        setmealMapper.insert(setmeal);

        //插入套餐菜品表数据
        //对应两个表的数据，套餐表和菜品表
        setmealDishMapper.insertWithsetmealDish(setmeal.getId(),setmeal.getSetmealDishes());

    }
}
