package com.crazywu.dal.mysql.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserBO {
    Integer id;

    String username;

    String passwd;
}
