package ioTest;

import java.io.Serializable;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk1.8中，引入了Lambda和Stream
 * 1,   stream不像传统IO流，它是用于对集合Connection的操作
 */
public class listStream {
    public static void main(String[] args) {
//        List<Integer> list=new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
        /**
        //foreach循环遍历
        for(int i:list){
            System.out.println(i);
        }

        list.stream().forEach(x-> System.out.println(x));//使用stream遍历

        Stream<Integer> stream = list.stream();//使用stream遍历
        stream.forEach(System.out::println);
    */
//        Stream<Integer> it = Stream.of(1, 2, 3,9,8,4);
//        Stream<Integer> itf = it.filter(x -> x > 3);//过滤 不满足条件的
//        Stream<Integer> sorted = it.sorted();//自然排序
//        Stream.of(1,2,3,4,5).map(i->i.doubleValue()).forEach(System.out::println); //Map映射
       // Stream.of(1,2,3,4,5).peek(System.out::println);//peek方法生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数，并且消费函数优先执行（但是如果没有执行最终操作，这个消费函数也不会运行）
//        Stream.of(4,2,1,9,5).peek(System.out::println).sorted().forEach(System.out::println);
///中间操作返回的还是stream流对象，结束操作返回的不再是Stream对象，调用了最终操作的方法，Stream才会执行
//        传统IO流是用于传输数据
//        JDK1.8的新特性Stream流与传统的IO流是不同的，Stream流用于增强集合的操作
//        Stream有两个特性：惰性求值（中间操作返回的是Stream流对象）、函数式编程接口（类Lambda）
//        Stream操作分为3步：创建Stream、中间操作、结束操作，都完成后才会完成Stream操作
//        在数据量小的情况下还是迭代器效率更高，在多核数据量大的情况下stream流操作效率更高


        Customer c1 = new listStream().new Customer("张三", 10);
        Customer c2 = new listStream().new Customer("李四",20);
        Customer c3 = new listStream().new Customer("王五",10);
        List<Customer> list = Arrays.asList(c1,c2,c3);
        //转成list
        List<Integer> ageList = list.stream().map(Customer::getAge).collect(Collectors.toList());
        System.out.println("ageList："+ageList);//ageList：[10, 20, 10]
        //转成set
        Set<Integer> ageSet = list.stream().map(Customer::getAge).collect(Collectors.toSet());
        System.out.println("ageSet："+ageSet);//ageSet：[20, 10]
//转成map,注:key不能相同，否则报错
        Map<String, Integer> CustomerMap = list.stream().collect(Collectors.toMap(Customer::getName, Customer::getAge));
        System.out.println("CustomerMap："+CustomerMap);//CustomerMap：{李四=20, 张三=10, 王五=10}
//字符串分隔符连接
        String joinName = list.stream().map(Customer::getName).collect(Collectors.joining(",", "(", ")"));
        System.out.println("joinName："+joinName);//joinName：(张三,李四,王五)
//聚合操作
//1.学生总数
        Long count = list.stream().collect(Collectors.counting());
        System.out.println("count："+count);//count：3
//2.最大年龄 (最小的minBy同理)
        Integer maxAge = list.stream().map(Customer::getAge).collect(Collectors.maxBy(Integer::compare)).get();
        System.out.println("maxAge："+maxAge);//maxAge：20
//3.所有人的年龄
        Integer sumAge = list.stream().collect(Collectors.summingInt(Customer::getAge));
        System.out.println("sumAge："+sumAge);//sumAge：40
//4.平均年龄
        Double averageAge = list.stream().collect(Collectors.averagingDouble(Customer::getAge));
        System.out.println("averageAge："+averageAge);//averageAge：13.333333333333334
//分组
        Map<Integer, List<Customer>> ageMap = list.stream().collect(Collectors.groupingBy(Customer::getAge));
        System.out.println("ageMap："+ageMap);//ageMap：{20=[com.mashibing.stream.Customer@20ad9418], 10=[com.mashibing.stream.Customer@31cefde0, com.mashibing.stream.Customer@439f5b3d]}

//分区
//分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<Customer>> partMap = list.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));
        System.out.println("partMap："+partMap);
//规约
        Integer allAge = list.stream().map(Customer::getAge).collect(Collectors.reducing(Integer::sum)).get();
        System.out.println("allAge："+allAge);//allAge：40




    }
    class Customer{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Customer(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}






