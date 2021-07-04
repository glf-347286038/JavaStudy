package javase.test.compare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 比较新旧数据
 *
 * @author gaolingfeng
 */
public class Compare {

    private static final String TABLE_NAME = "tableName";
    private static final String PRIMARY_KEY = "primaryKey";
    private static final String MODIFY_CODE = "modifyCode";

    public static void main(String[] args) {
        Map<String, Object> oldData = getOldMap();
        Map<String, Object> newData = getNewMap();
        List<ModifyRecord> list = getChangeRecord(oldData, newData);
        for (ModifyRecord modifyRecord : list) {
            System.out.println(modifyRecord.toString());
        }
    }

    public static Map<String, Object> getOldMap() {
        Map<String, Object> oldMap = new HashMap<>(16);
        oldMap.put("tableName", "sys_user");
        oldMap.put("primaryKey", "16");
        oldMap.put("uName", "高凌峰");
        oldMap.put("modifyCode", "ss");
        oldMap.put("age", 15);
        oldMap.put("balance", 10);
        return oldMap;
    }

    public static Map<String, Object> getNewMap() {
        Map<String, Object> newMap = new HashMap<>(16);
        newMap.put("uName", "glf");
        newMap.put("balance", 888.258);
        return newMap;
    }

    /**
     * 封装变更前后的数据
     *
     * @param oldData 原数据
     * @param newData 新数据
     * @return List<ModifyRecord>
     */
    public static List<ModifyRecord> getChangeRecord(Map<String, Object> oldData, Map<String, Object> newData) {
        if (newData == null || newData.isEmpty()) {
            return null;
        }
        // 校验是否传入表名,主键,变更类型CODE是否为空
        checkData(oldData);

        ModifyRecord modifyRecord;
        List<ModifyRecord> modifyRecordList = new ArrayList<>(16);
        // 新数据全部是需要记录进表的数据
        for (Map.Entry<String, Object> entry : newData.entrySet()) {
            modifyRecord = new ModifyRecord() {
                {
                    setTableName(String.valueOf(oldData.get(TABLE_NAME)));
                    setPrimaryKey((Integer.valueOf(String.valueOf(oldData.get(PRIMARY_KEY)))));
                    setColumnName(String.valueOf(entry.getKey()));
                    setModifyCode(String.valueOf(oldData.get(MODIFY_CODE)));
                    setModifyBefore(String.valueOf(oldData.get(entry.getKey())));
                    setModifyAfter((String.valueOf(entry.getValue())));
                }
            };
            modifyRecordList.add(modifyRecord);
        }
        return modifyRecordList;
    }

    /**
     * 校验是否传入表名,主键,变更类型CODE
     *
     * @param oldData 原始数据
     */
    public static void checkData(Map<String, Object> oldData) {
        if (oldData.get(TABLE_NAME) == null || oldData.get(TABLE_NAME).toString().isEmpty()) {
            System.out.println("表名为空");
        }
        if (oldData.get(PRIMARY_KEY) == null || oldData.get(TABLE_NAME).toString().isEmpty()) {
            System.out.println("主键为空");
        }
        if (oldData.get(MODIFY_CODE) == null || oldData.get(TABLE_NAME).toString().isEmpty()) {
            System.out.println("修改类型为空");
        }
    }

}
