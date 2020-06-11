package com.pan.main.system.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (TMenu)表实体类
 *
 * @author makejava
 * @since 2020-04-08 20:34:34
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class TMenu extends Model<TMenu> {


    @TableId(type = IdType.AUTO)
    private Long menuId;

        
        
    private String menuName;

        
    //路径    
    private String url;

        
    //权限标识    
    private String perms;
}