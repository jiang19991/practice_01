package com.company.designModel.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 */

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好，欢迎来到996，祝大家都早日逃离996，<script>,-.-,www.baidu.com");
//        List<Filter> filters = new ArrayList<>();
//        filters.add(new HTMLFilter());
//        filters.add(new SensitiveFilter());
//
//        for (Filter f : filters) {
//            f.doFilter(msg);
//        }
        FilterChain fc = new FilterChain();

        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();

        fc2.addFilter(new FaceFilter()).addFilter(new URLFilter());

        fc.addFilter(fc2);//两个链条相连

        fc.doFilter(msg);

        System.out.println(msg.toString());
    }
}
interface Filter{
    boolean doFilter(Msg msg);
}

class HTMLFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replace('<','['));
        msg.setMsg(msg.getMsg().replace('>',']'));
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replaceAll("到996","到965"));
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replaceAll("-.-",":)"));
        return true;
    }
}

class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replaceAll("www.baidu.com","www.nowcoder.com"));
        return true;
    }
}

class Msg{
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
//链条也实现Filter接口
class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg msg){
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) return false;
        }
        return true;
    }
}
