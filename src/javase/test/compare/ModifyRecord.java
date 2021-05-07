package javase.test.compare;

import lombok.Data;

import java.io.Serializable;

/**
 * 对应变更记录表
 *
 * @author Administrator
 */
@Data
public class ModifyRecord implements Serializable {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 主键
     */
    private Integer primaryKey;
    /**
     * 列名
     */
    private String columnName;
    /**
     * 变更类型字典码
     */
    private String modifyCode;
    /**
     * 变更前数据
     */
    private String modifyBefore;
    /**
     * 变更后数据
     */
    private String modifyAfter;
}
