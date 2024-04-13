package com.record.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.record.entity.HepatoCAR;
import com.record.mapper.HepatoCARMapper;
import com.record.service.HepatoCARService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wz
 * @since 2024-04-13
 */
@Service
public class HepatoCARServiceImpl extends ServiceImpl<HepatoCARMapper, HepatoCAR> implements HepatoCARService {

    @Override
    public HepatoCAR getScore(HepatoCAR hepatoCAR) {
        double hccRisk = calculateHCCRisk(Double.parseDouble(hepatoCAR.getMiRNA15a()), Double.parseDouble(hepatoCAR.getMiRNA16()), Double.parseDouble(hepatoCAR.getAfp()));
        hepatoCAR.setScore(String.valueOf(hccRisk));
        saveHepatoCAR(hepatoCAR);
        return hepatoCAR;
    }

    /**
     * 计算肝细胞癌的风险评估值
     * logit[p=HCC]=-0.006-0.456×miR15a-1.439×miR16+0.620×AFP
     *
     * @param miR15a miR15a的值
     * @param miR16  miR16的值
     * @param AFP    AFP的值
     * @return logit[p=HCC]的值
     */
    public static double calculateHCCRisk(double miR15a, double miR16, double AFP) {
        // 公式中的系数
        double coefficient1 = -0.006;
        double coefficient2 = -0.456;
        double coefficient3 = -1.439;
        double coefficient4 = 0.620;

        // 根据公式进行计算
        double logit = coefficient1 + (coefficient2 * miR15a) + (coefficient3 * miR16) + (coefficient4 * AFP);

        return logit;
    }

    public boolean saveHepatoCAR(HepatoCAR hepatoCAR) {
        // Ensure hepatoCAR is not null
        if (Objects.isNull(hepatoCAR)) {
            return false;
        }

        // 获取当前日期时间
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 将日期时间格式化为指定格式的字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        // Create a query wrapper
        QueryWrapper<HepatoCAR> queryWrapper = new QueryWrapper<>();

        // Build the query wrapper
        queryWrapper.eq("sex", hepatoCAR.getSex())
                .eq("age", hepatoCAR.getAge())
                .eq("isaod", hepatoCAR.getIsaod())
                .eq("ischbi", hepatoCAR.getIschbi())
                .eq("hbvdna", hepatoCAR.getHbvdna())
                .eq("alt", hepatoCAR.getAlt())
                .eq("ast", hepatoCAR.getAst())
                .eq("alb", hepatoCAR.getAlb())
                .eq("tbil", hepatoCAR.getTbil())
                .eq("plt", hepatoCAR.getPlt())
                .eq("afp", hepatoCAR.getAfp())
                .eq("MiRNA15a", hepatoCAR.getMiRNA15a())
                .eq("MiRNA16", hepatoCAR.getMiRNA16())
                .eq("score", hepatoCAR.getScore())
                .eq("createtime", formattedDateTime);

        // Use MyBatis-Plus save method
        return save(hepatoCAR);
    }
}
