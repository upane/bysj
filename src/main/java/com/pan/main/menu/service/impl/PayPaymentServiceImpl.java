package com.pan.main.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.menu.dao.PayPaymentDao;
import com.pan.main.menu.entity.PayPayment;
import com.pan.main.menu.service.PayPaymentService;
import org.springframework.stereotype.Service;

/**
 * (PayPayment)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 10:48:14
 */
@Service("payPaymentService")
public class PayPaymentServiceImpl extends ServiceImpl<PayPaymentDao, PayPayment> implements PayPaymentService {

}