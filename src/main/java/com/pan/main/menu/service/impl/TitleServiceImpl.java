package com.pan.main.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.menu.dao.TitleDao;
import com.pan.main.menu.entity.Title;
import com.pan.main.menu.service.TitleService;
import org.springframework.stereotype.Service;

/**
 * (Title)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 10:48:27
 */
@Service("titleService")
public class TitleServiceImpl extends ServiceImpl<TitleDao, Title> implements TitleService {

}