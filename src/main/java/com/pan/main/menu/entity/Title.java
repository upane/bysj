package com.pan.main.menu.entity;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Title)表实体类
 *
 * @author makejava
 * @since 2020-05-01 09:43:15
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class Title extends Model<Title> {

    @TableId(type = IdType.AUTO)    
        
    private Integer id;

        
        
    private String title;

        
        
    private Object content;

        
        
    private Date creattime;
}