package com.pan.main.system.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (TAdmin)表实体类
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class TAdmin extends Model<TAdmin> {

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";
    public static final Long roleid = 2L;

    @TableId(type = IdType.AUTO)
    private Long adminId;

        
        
    private String adname;

        
        
    private String password;

        
        
    private String email;

        
        
    private String mobile;


    private transient Long rolId;

    private  transient  String roleName;


}