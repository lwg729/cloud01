package com.lwg.springcloud.myHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lwg.springcloud.pojo.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义限流降级处理.......customerBlockHandler");
    }
}
