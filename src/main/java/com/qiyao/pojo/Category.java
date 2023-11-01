package com.qiyao.pojo;

import java.time.LocalDateTime;

public class Category {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类别名
     */
    private String categoryAlias;
    /**
     * 创建人ID
     */
    private Integer createUser;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
