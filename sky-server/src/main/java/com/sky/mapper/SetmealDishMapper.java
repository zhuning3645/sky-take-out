package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealDTO;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 根据套餐id和菜品id插入菜品套餐对应表
     * @param setmealId
     * @param setmealDishes
     */
    @AutoFill(OperationType.INSERT)
    void insertWithsetmealDish(Long setmealId,List<SetmealDish> setmealDishes);



}
