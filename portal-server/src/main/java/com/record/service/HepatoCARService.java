package com.record.service;

import com.record.entity.HepatoCAR;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2024-04-13
 */
public interface HepatoCARService extends IService<HepatoCAR> {

    HepatoCAR getScore(HepatoCAR hepatoCAR);
}
