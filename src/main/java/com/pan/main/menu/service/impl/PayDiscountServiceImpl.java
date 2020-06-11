package com.pan.main.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.menu.dao.PayDiscountDao;
import com.pan.main.menu.entity.PayDiscount;
import com.pan.main.menu.service.PayDiscountService;
import org.springframework.stereotype.Service;

/**
 * (PayDiscount)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 10:48:03
 */
@Service("payDiscountService")
public class PayDiscountServiceImpl extends ServiceImpl<PayDiscountDao, PayDiscount> implements PayDiscountService {

}