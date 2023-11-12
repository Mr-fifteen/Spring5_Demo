package com.fifteen.spring.xml;
/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  16:47
 */

/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  16:47
 * 用于测试XML配置,P名称空间注入功能
 */
public class PBook {
    /**
     * id
     */
    private int id;
    /**
     * 书名
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PBook{" +
                "id=" + id +
                ", idClass=" + getType(id)+
                ", name='" + name +"\'" +
                '}';
    }

    private String getType(Object o){
        return o.getClass().toString();
    }

}
