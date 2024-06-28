package com.sky.service;

import com.sky.vo.TurnoverReportVO;

import java.time.LocalDate;

public interface ReportService {

    /**
     *统计指定时间区间内的营业额数据
     * @return
     */
    TurnoverReportVO getTurnoverReport(LocalDate begin, LocalDate end);
}
