package com.zhongfeng.api.modules.utils.pojo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具
 * @author blueCat
 * @since 2022/2/25
 */
@Data
public class PageDataInfo implements Serializable {
    /**
     * 总数
     */
    private long total;

    /**
     * 结果集
     */
    private List<?> data;

    private PageDataInfo(){

    }

    public PageDataInfo(long total,List<?> data){
        this.total = total;
        this.data = data;
    }

    public PageDataInfo(Page page,List<?> data){
        this.total = page.getTotal();
        this.data = data;
    }

    public PageDataInfo(IPage<?> page){
        this.total = page.getTotal();
        this.data = page.getRecords();
    }
}
