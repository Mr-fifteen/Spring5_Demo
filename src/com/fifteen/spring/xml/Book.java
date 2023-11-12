package com.fifteen.spring.xml;/**
 * @Author Mr.fifteen
 * @Date 2023/9/17  22:50
 */

/**
 * @Author Mr.fifteen
 * @Date 2023/9/17  22:50
 */
public class Book {

    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String bauthor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", bauthor='" + bauthor + '\'' +
                '}';
    }
}
