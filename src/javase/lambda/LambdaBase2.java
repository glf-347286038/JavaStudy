package javase.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: gaolingfeng
 * @date: 2021/1/15 19:26
 * @description:
 */
public class LambdaBase2 {
    public static void main(String[] args) {
        group();

        filter();

        sum();

        sort();

        distinct();

        bestValue();

        listToMap();

        joining();
    }

    /**
     * 分组 groupingBy
     */
    public static void group() {
        List<Person> personList = queryPerson();
        Map<String, List<Person>> map;
        // 组合分组，以sex+address分组
        map = personList.stream().collect(Collectors.groupingBy(Person::groupKey));
        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
            System.out.println("groupBy" + entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("====================");

        // 单一分组
        map = personList.stream().collect(Collectors.groupingBy(Person::getAddress));
        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
            System.out.println("groupBy" + entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 过滤 filter
     */
    public static void filter() {
        System.out.println("====================");
        System.out.println("====================");
        Person person = new Person("高", 29, "女", "美国", BigDecimal.valueOf(1800.00));
        List<Person> personList = queryPerson();
        List<Person> personList1 = personList.stream().filter(obj -> person.getName().equals(obj.getName()) && person.getAge().equals(obj.getAge())).collect(Collectors.toList());
        System.out.println("filter" + personList1);
    }

    /**
     * 求和
     */
    public static void sum() {
        List<Person> personList = queryPerson();
        // 基本类型用map和sum
        int totalAge = personList.stream().mapToInt(Person::getAge).sum();
        System.out.println("年龄总和为" + totalAge);
        BigDecimal totalPrice = personList.stream().map(Person::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("金钱总额为:" + totalPrice);
    }

    /**
     * 排序
     */
    public static void sort() {
        List<Person> personList = queryPerson();
        // 正序排序
        personList.sort(Comparator.comparing(Person::getAge));
        personList.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getPrice));
        // 根据年龄倒序
        personList.sort(Comparator.comparing(Person::getAge).reversed());
    }

    /**
     * 去重
     */
    public static void distinct() {
        List<Person> personList = queryPerson();
        List<String> nameList = personList.stream().map(Person::getName).distinct().collect(Collectors.toList());
        System.out.println("distinct" + nameList);
    }

    /**
     * 最值
     */
    public static void bestValue() {
        List<Person> personList = queryPerson();
        Integer minAge = personList.stream().map(Person::getAge).min(Integer::compareTo).orElse(0);
        Integer maxAge = personList.stream().map(Person::getAge).max(Integer::compareTo).orElse(0);
        OptionalDouble optionalDouble = personList.stream().mapToDouble(Person::getAge).average();
        System.out.println("最小年龄:" + minAge + " 最大年龄:" + maxAge + "平均值:" + optionalDouble);
        BigDecimal minPrice = personList.stream().map(Person::getPrice).min(BigDecimal::compareTo).orElse(BigDecimal.valueOf(0));
        BigDecimal maxPrice = personList.stream().map(Person::getPrice).max(BigDecimal::compareTo).orElse(BigDecimal.valueOf(0));
        System.out.println("最低价格" + minPrice + " 最高价格" + maxPrice);
    }

    /**
     * list转map
     */
    public static void listToMap() {
        List<Person> personList = queryPerson();
        // Map<String,Person> personMap = personList.stream().collect(Collectors.toMap(Person::getName, account -> account)); key重复时会报错
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getName, person -> person, (person1, person2) -> person1));
        System.out.println("mapToList" + personMap);
    }

    /**
     * list中的某一列抽取出来合并
     */
    public static void joining() {
        List<Person> personList = queryPerson();
        // joining中可以为空,也可以加内容进行连接
        String joinStr = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(joinStr);
    }

    public static List<Person> queryPerson() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("高", 17, "男", "中国", BigDecimal.valueOf(2000.00)));
        personList.add(new Person("赵", 18, "男", "中国", BigDecimal.valueOf(1000.05)));
        personList.add(new Person("钱", 17, "男", "美国", BigDecimal.valueOf(1000.95)));
        personList.add(new Person("孙", 19, "男", "美国", BigDecimal.valueOf(3000.00)));
        personList.add(new Person("李", 15, "男", "英国", BigDecimal.valueOf(4000.00)));
        personList.add(new Person("周", 11, "女", "美国", BigDecimal.valueOf(2000.00)));
        personList.add(new Person("吴", 24, "女", "美国", BigDecimal.valueOf(3000.00)));
        personList.add(new Person("郑", 25, "男", "香港", BigDecimal.valueOf(7000.00)));
        personList.add(new Person("王", 26, "男", "香港", BigDecimal.valueOf(7000.00)));
        personList.add(new Person("应", 27, "男", "法国", BigDecimal.valueOf(8000.00)));
        personList.add(new Person("董", 28, "男", "法国", BigDecimal.valueOf(9000.00)));
        personList.add(new Person("高", 29, "男", "德国", BigDecimal.valueOf(10000.00)));
        return personList;
    }

}

@Data
@AllArgsConstructor
class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 分组依据
     *
     * @return 分组依据
     */
    public String groupKey() {
        return sex + "," + address;
    }
}