package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.mapper.SetmealMapper;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 套餐管理
 */
@RestController
@RequestMapping("/admin/setmeal")
@Slf4j
@Api(tags = "套餐相关接口")
public class SetmealController {

    @Autowired
    private  SetmealService setmealService;
    @Autowired
    private DishService dishService;

    @PostMapping
    @ApiOperation("新增套餐")
    public Result save(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐：{}",setmealDTO);

        //查询当前菜品
        dishService.getByIdWithFlavor();
        setmealService.saveWithDish(setmealDTO);
        return Result.success();
    }
}
