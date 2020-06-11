package com.pan.main.menu.entity;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (HrzManger)表实体类
 *
 * @author makejava
 * @since 2020-05-01 09:43:15
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class HrzManger extends Model<HrzManger> {

    @TableId(type = IdType.AUTO)    
        
    private Integer id;

        
        
    private String name;

        
        
    private Date starttime;

        
        
    private Date stoptime;

        
        
    private Date leadtime;

        
        
    private String address;
}