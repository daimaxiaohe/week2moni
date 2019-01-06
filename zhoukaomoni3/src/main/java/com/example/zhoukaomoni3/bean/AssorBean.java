package com.example.zhoukaomoni3.bean;

import java.util.List;

/**
 * はすてすゃの
 * 2019-01-05.
 */
public class AssorBean {
    public String code;
    public String msg;
    public List<Product> data;
    public static class Product{
        public String name;
        public List<Sub> list;
        public static class Sub{
            public String name;
            public String icon;
            public String pcid;
        }
    }
}
