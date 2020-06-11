package com.pan.main.menu.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (JzqManager)表实体类
 *
 * @author makejava
 * @since 2020-05-01 09:43:15
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class JzqManager extends Model<JzqManager> {

    @TableId(type = IdType.AUTO)    
        
    private Integer id;

        
        
    private Integer jzqnum;

        
        
    private String address;

        
        
    private Integer fmid;
}