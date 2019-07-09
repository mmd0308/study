package com.hzqing.study.prototype.deep;

/**
 * @author hzqing
 * @date 2019-07-02 11:17
 */
public class PersonClient {

    public static void main(String[] args) throws CloneNotSupportedException {
        Compony compony = new Compony("阿里巴巴");
        System.out.println("Compony对象 ： " + compony);

        System.out.println(" -----------分隔------------- ");
        Person person = new Person("zhangsan",compony);
        System.out.println(person);
        System.out.println(person.getCompony());
        System.out.println("公司的名称：" +person.getCompony().getName());

        System.out.println(" -----------分隔------------- ");
        Person clone = (Person) person.clone();
        System.out.println(clone);
        System.out.println(clone.getCompony());
        System.out.println("公司的名称：" +clone.getCompony().getName());

        System.out.println("person == clone ： " + (person == clone));
    }
}
