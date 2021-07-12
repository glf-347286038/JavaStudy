package javase.objectClass;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * HashSet、Hashmap、Hashtable与hashCode()和equals的密切联系
 * 当equals()方法被override时，hashcode()也要被override。
 * equals()相等的两个对象，hashcode()一定相等；
 * equals()不相等的两个对象，却并不能证明他们的hashcode()不相等。
 *hashcode()相等，equals不一定相等
 *
 * 要想弄明白hashCode()的作用，必须要先知道Java中的集合
 * Java中的集合(Collection)有两类，一类是List,再有一类是Set。前者集合内的元素是有序可重复的；
 * 后者元素无序且不可重复。若元素不可重复，如何判断？这就是Object.equals方法了。但是，如果每增加一个
 * 元素就检查一次，那么元素很多时，就会调用很多次equals方法，比如集合中已经有10000个元素，那么第100001
 * 个元素加入集合时，它就要调用10000次equals方法。这显然会大大降低效率。
 * 于是，java采用了hash表的原理。哈希算法也称散列算法，是将数据依特定算法直接指定到一个地址上。
 * 这样一来，当集合要添加新的元素时，先调用这个元素的hashCode方法，就一下子能定位到它应该应该放置的地址上，
 * 如果这个位置上没有元素，它就可以直接存储在这个位置上，不再进行任何比较了；如果这个位置上已经有元素了，
 * 就调用它的equals方法与新的元素进行比较，相同的就不存了，不相同就散列其他的地址。这样一来实际调用equals方法的
 * 的次数就大大降低了，几乎只要一两次。简而言之，在集合查找时，hashCode能大大降低对象比较次数，提高查找效率。
 *
 * 相同的对象必须具有相等的哈希码，为什么?
 *      假设A和B equals相等，但A和B的哈希码不同，那么A和B会允许同时存入HashMap，HashMap不允许存放重复元素
 * 两个对象的hashCode相同，它们不一定相同
 *      假设A、B equals()不相等，hashCode()相等，A和B存入HashMap时会发生哈希冲突，A、B存放在
 *      HashMap内部数组的位置索引相同，这时HashMap会在该位置建立一个链表，将AB串起来存放在该位置，该情况不违反
 *      HashMap的使用原则，是允许的。
 * @author gaolingfeng
 */
public class HashCode {
    public static void main(String[] a){

        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("高",11));
        personSet.add(new Person("李",18));
        personSet.add(new Person("高",11));
        Iterator iterator = personSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //运行结果为
//        Person{name='高', age=11}
//        Person{name='高', age=11}
//        Person{name='李', age=18}

        Set<Animal> animalSet = new HashSet<>();
        animalSet.add(new Animal("狗",1));
        animalSet.add(new Animal("鸡",2));
        animalSet.add(new Animal("狗",1));
        animalSet.forEach(System.out::println);
        //运行结果为
//        Animal{name='鸡', age=2}
//        Animal{name='狗', age=1}
    }
    }

/**
 * 没有重写equals方法和hashCode方法
 */
class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * 重写了equals方法
 */
class Animal{
    private String name;
    private Integer age;
    Animal(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(age, animal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
