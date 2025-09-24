package com.hsh.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xrkhy
 * @date 2025/9/8 21:49
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("smbms_user")
public class User {
    private Long id;// 主键ID
    private String userCode;// 用户编码
    private String userName;// 用户名称
    private String userPassword;// 用户密码
    private Integer gender;// 性别（1:女、 2:男）
    private LocalDateTime birthday;//  出生日期
    private String phone;//  手机
    private String address;//  地址
    private Long userRole;// 用户角色（取自角色表-角色id）
    private Long createdBy;// 创建者（userId）
    private LocalDateTime creationDate;// 创建时间
    private Long modifyBy; // 更新者（userId）
    private LocalDateTime modifyDate; // 更新时间
}
