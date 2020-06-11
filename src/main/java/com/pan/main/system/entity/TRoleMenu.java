package com.pan.main.system.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (TRoleMenu)表实体类
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class TRoleMenu extends Model<TRoleMenu> {



    private Long roleId;

        
        
    private Long menuId;
}