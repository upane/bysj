package com.pan.main.menu.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2020-05-01 09:43:15
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)    
        
    private Integer id;

        
        
    private String name;

        
        
    private Integer phone;

        
        
    private String usertype;

        
        
    private String fnum;

        
        
    private Integer area;

        
        
    private String address;

        
        
    private String addressinfo;
}