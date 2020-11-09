package test.collection.map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 高凌峰
 * @date 2020-11-08
 */

/**
 * hashMap实现原理
 * HashMap的主干是一个Entry数组，Entry是HashMap的基本组成单元，每个Entry包含一个key-value键值对（其实就是保存了两个对象之间的映射关系）
 * Entry是HashMap的一个静态内部类
 * HashMap是由数组+链表组成的，数组是HashMap的主体，链表是解决哈希冲突而存在的，如果定位到数组的位置不含链表(当前的entry的next指向null),
 * 那么查找、添加等操作很快，仅需一次寻址即可；如果定位到的数组总含有链表，对于添加操作，，其时间复杂度为O(n),首先遍历链表，存在即覆盖，
 * 否则新增；对于查找操作来讲，仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，性能考虑，HashMap中的链表出现越少，性能越好。
 *
 */
public class HashMapBase {
    public static void main(String[] args){
        //创建一个数组，设置初始容量位16  加载因子为0.75
        //如果加入的长度大于16/0.75 = 20(阈值)   那么就要进行扩容
        Map<Integer,String> map = new HashMap<>(16);
        map.put(1,"gao");
        map.put(2,"ling");
        map.put(3,"feng");

        //
        System.out.println("数组的size为"+map.size());


        //遍历数组
        //这种方法足以 一次循环既可以得到key,也可以得到value
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println("方法一："+entry.getKey()+"---value"+entry.getValue());
        }

        for(Integer key:map.keySet()){
            System.out.println("方法二:key="+key);
        }
        for(String value:map.values()){
            System.out.println("方法二:value="+value);
        }

        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println("方法三:key="+entry.getKey()+"value="+entry.getValue());
        }

        for(Integer key:map.keySet()){
            String value = map.get(key);
            System.out.println("方法四:+key"+key + "value="+value);
        }
    }


    /**
     * hash函数
     * 用了很多的异或，移位等运算符，对key的hashcode进一步计算以及二进制位的调整等来保证最终获取的存储位置尽量分布均匀
     *     final int hash(Object k){
     *         int h = hashCode();
     *         if(0 != h && k instanceof String){
     *             return sun.misc.Hashing.StringHash32((String) k);
     *         }
     *         h ^= k.hashCode();
     *
     *         h ^= (h >>20 ) ^ (h >> 12);
     *         return h ^ (h >>> 7) ^ (h >> 4);
     *     }
     * 以上hash函数计算出的值，通过indexFor进一步处理来获取实际的存储位置
     * 返回数组下标
     *     static int indexFor(int h,int length){
     *         return h & (length-1);
     *     }
     *     h & (length-1)保证获取得到index一定在数组范围内，举个例子，默认容量16，length - 1 = 15，h = 18,
     *     转换成二进制计算为index=2.位运算对于计算机来说效率更高。
     *     所以存储位置的流程大概是这样的
     *     key 通过hashCode()  获得  hashcode  通过  hash()   获得  h  通过  indexFor()方法的h&(length-1)  得到存储下标
     */

    /**
     * hash扩容
     * 如果数组进行扩容，数组长度发生变化，而存储位置index=h&(length-1),index也可能会发生变化，需要重新计算index
     * 通过transfer重新计算index的，这个方法将老数组中的数据逐个链表的遍历，扔到新的扩容后的数组中，数组索引位置的计算
     * 是通过key的hashcode进行hash扰乱运算后，再通过和length-1进行位运算最终得到数组的索引位置。
     * HashMap的数组长度一定保持2的次幂，
     * 比如16的二进制表示为10000，那么legth-1就是15，二进制位01111，
     * 同理扩容后的数组长度为32，二进制表示为100000，length-1为31，二进制表示为011111。
     * 这样保证地位全为1，而扩容之后只有一位差异，也就是最左边的1,这样通过h&(length-1)的时候，只要h对应的最左边的那一个差异位为0，
     * 就能保证得到的新的数组索引和老数组索引一致（大大减少了之前已经散列良好的老数组的数据位置重新调换，个人理解）。
     *   h   ...0 1 0 1 0 1
     *   &        0 1 1 1 1   old  16-1
     *   length 0 1 1 1 1 1   new  32-1
     * 还有保证数组长度为2的次幂，length-1的低位都为1，会使得获得数组索引index更加均匀
     *
     *      0 1 0 1 0 1 0 1 0 1   h
     *   &  0 0 0 0 1 1 1 1 1 1   length-1
     *      0 0 0 0 0 1 0 1 0 1   index = 21
     *  上面的&运算，高位是不会对结果产生影响(hash函数采用各种位运算可能也是为了使得地位更加散列)
     *  我们只关注低位bit，如果低位全部为1，那么对于h低位部分来说，任何一位得变化都会对结果产生影响，
     *  也就是说，要得到index = 21 这个存储位置，h得低位只有这一种组合。这也是数组长度设计必须为2得
     *  次幂得原因。
     *      0 1 0 1 0 1 0 1 0/1 1   h
     *   &  0 0 0 0 1 1 1 1  0  1   length-1
     *      0 0 0 0 0 1 0 1  0  1   index =21
     *  如果不是2得次幂，也就是低位不是全为1此时，要使得index = 21,h的低位部分不再具有唯一性了，
     *  hash冲突的几率会变得更大，同时，index对应的这个bit位无论如何不会等于1了，而对应的数组位置
     *  也就拜拜浪费了。
     *
     *
     *  JDK1.8中的HashMap的性能优化
     *  假如一个数组槽位上的链上数据过多，导致性能下降怎么办？
     *  JDK1.8在JDK1.7的基础上增加了红黑树来进行优化。当链表超过8时，链表就转换为红黑树。
     *
     */




}
