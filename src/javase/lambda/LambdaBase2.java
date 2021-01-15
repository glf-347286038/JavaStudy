package javase.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: gaolingfeng
 * @date: 2021/1/15 19:26
 * @description:
 */
public class LambdaBase2 {
    public static void main(String[] args){
        group();

        filter();
    }

    /**
     * 分组 groupingBy
     */
    public static void group(){
        List<Person> personList = queryPerson();
        // 组合分组，以sex+address分组
        Map<String,List<Person>> map = personList.stream().collect(Collectors.groupingBy(ele->ele.groupKey()));
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("====================");

        // 单一分组
        Map<String,List<Person>> map1 = personList.stream().collect(Collectors.groupingBy(ele->ele.groupKey()));
        for(Map.Entry entry:map1.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * 过滤 filter
     */
    public static void filter(){
        Person person = new Person("周","11","女","美国");
        Person finalPerson = person;
        List<Person> personList = queryPerson();
        if(personList.stream().filter(ele -> finalPerson.getName().equals(ele.getName()) && finalPerson.getAge().equals(ele.getAge())).collect(Collectors.toList()).size() > 0){
            System.out.println(person.toString());;
        }else {
            System.out.println("不存在");;
        }
    }


    public static List<Person> queryPerson(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("高","17","男","中国"));
        personList.add(new Person("赵","18","男","中国"));
        personList.add(new Person("钱","17","男","美国"));
        personList.add(new Person("孙","19","男","美国"));
        personList.add(new Person("李","15","男","英国"));
        personList.add(new Person("周","11","女","美国"));
        personList.add(new Person("吴","24","女","美国"));
        personList.add(new Person("郑","25","男","香港"));
        personList.add(new Person("王","26","男","香港"));
        personList.add(new Person("应","27","男","法国"));
        personList.add(new Person("董","28","男","法国"));
        personList.add(new Person("高","29","男","德国"));
        return personList;
    }

}

class Person {
    private String name;
    private String age;
    private String sex;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(String name, String age, String sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * 分组依据
     * @return
     */
    public String groupKey() {
        return sex+","+address;
    }
}



