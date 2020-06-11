package com.pan.main.menu.entity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (PayDiscount)表实体类
 *
 * @author makejava
 * @since 2020-05-01 09:43:15
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class PayDiscount extends Model<PayDiscount> {


    @TableId(type = IdType.AUTO)
    private Integer discountid;

        
        
    private String payname;

        
        
    private String paystandard;

        
        
    private Date starttime;

        
        
    private Date stoptime;

        
        
    private Double upmoney;

        
        
    private Double downmoney;

        
        
    private String oldperson;

        
        
    private String region;
}