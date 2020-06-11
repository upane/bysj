package com.pan.main.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.menu.dao.HrzMangerDao;
import com.pan.main.menu.entity.HrzManger;
import com.pan.main.menu.service.HrzMangerService;
import org.springframework.stereotype.Service;

/**
 * (HrzManger)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 09:27:50
 */
@Service("hrzMangerService")
public class HrzMangerServiceImpl extends ServiceImpl<HrzMangerDao, HrzManger> implements HrzMangerService {

}