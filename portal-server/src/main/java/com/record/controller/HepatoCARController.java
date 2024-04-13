package com.record.controller;

import com.record.entity.HepatoCAR;
import com.record.entity.Slideshow;
import com.record.service.HepatoCARService;
import com.record.service.SlideshowService;
import com.record.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2024-04-13
 */
@Api(tags = "肝细胞癌风险评估")
@RestController
@RequestMapping("/api")
public class HepatoCARController {

    @Autowired
    private HepatoCARService hepatoCARService;
    @ApiOperation(value = "获取评估分")
    @PostMapping("/getScore")
    public Result getScore(@RequestBody HepatoCAR hepatoCAR){
        HepatoCAR result = hepatoCARService.getScore(hepatoCAR);
        return Result.success(result);
    }

}
