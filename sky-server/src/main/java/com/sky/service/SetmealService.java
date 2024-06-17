package com.sky.service;

import com.sky.dto.SetmealDTO;

public interface SetmealService {

    /**
     * 新增套餐数据
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);
}
