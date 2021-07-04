package javase.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 删除list中的值
 *
 * @Author: gaolingfeng
 * @Date: 2021-07-04 23:05
 */
public class RemoveDemo {
    public static void main(String[] args) {
        Integer removeObject = 1;
        // 使用迭代器删除
        List<Integer> list01 = listNums();
        Iterator<Integer> iterator = list01.iterator();
        while (iterator.hasNext()) {
            if (removeObject.equals(iterator.next())) {
                // list01.remove(iterator.next())
                iterator.remove();
            }
        }
        System.out.println("迭代器删除list01" + list01);


        // 倒序遍历 无论删除元素之后的元素怎么移动,之前的元素对应的下标不会发生变化
        List<Integer> list02 = listNums();
        for (int i = list02.size() -1; i >= 0; i--) {
            if (removeObject.equals(list02.get(i))) {
                list02.remove(i);
            }
        }
        System.out.println("倒序遍历list02" + list02);

        // 正序遍历 如果不进行i--,执行remove后,该位置后的元素会挤到该位置来
        List<Integer> list03 = listNums();
        for (int i = 0; i < list03.size(); i++) {
            if (removeObject.equals(list03.get(i))) {
                list03.remove(i);
                i--;
            }
        }
        System.out.println("正序遍历list03" + list03);

        // removeIf
        List<Integer> list04 = listNums();
        list04.removeIf(removeObject::equals);
        System.out.println("removeIf list04" + list04);

        // lambda
        List<Integer> list05 = listNums();
        list05 = list05.stream().filter(item -> !removeObject.equals(item)).collect(Collectors.toList());
        System.out.println("lambda filter list05" + list05);

        // foreach删除会出错
        // foreach方式遍历元素的时候,是生成iterator,然后使用iterator遍历.在生成iterator的时候,
        // 会保存一个expectedModCount参数,这个是生成iterator的时候list中修改元素的次数.如果在遍历的过程
        // 删除元素,如果这个modCount和expectedModCount不一致,就会抛出异常。
        List<Integer> list06 = listNums();
        for(Integer item:list06){
            if(removeObject.equals(item)){
                list06.remove(item);
            }
        }


    }

    private static List<Integer> listNums() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        return integerList;
    }
}
