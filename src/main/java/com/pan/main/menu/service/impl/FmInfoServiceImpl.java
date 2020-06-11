package com.pan.main.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.menu.dao.FmInfoDao;
import com.pan.main.menu.entity.FmInfo;
import com.pan.main.menu.service.FmInfoService;
import org.springframework.stereotype.Service;

/**
 * (FmInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 09:17:58
 */
@Service("fmInfoService")
public class FmInfoServiceImpl extends ServiceImpl<FmInfoDao, FmInfo> implements FmInfoService {

}