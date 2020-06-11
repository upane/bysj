package com.pan.main.menu.entity;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (FmInfo)表实体类
 *
 * @author makejava
 * @since 2020-05-01 09:43:15
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class FmInfo extends Model<FmInfo> {

    @TableId(type = IdType.AUTO)    
        
    private Integer id;

        
        
    private String fnum;

        
        
    private String address;

        
        
    private Double intemperature;

        
        
    private Double backtemperature;

        
        
    private Double diftemperature;

        
        
    private Double roomtemperature;

        
        
    private String opennum;

        
        
    private Double pressure;

        
        
    private Date totaltime;

        
        
    private Integer jzqnum;

        
        
    private String limittime;

        
        
    private Date catchtime;

        
        
    private String kpwd;

        
        
    private String sqpwd;

        
        
    private String hardversion;

        
        
    private String softversion;

        
        
    private String updatestatus;

        
        
    private Date updatetime;

        
        
    private String wordstate;
}