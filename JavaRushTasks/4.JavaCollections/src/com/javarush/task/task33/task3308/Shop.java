package com.javarush.task.task33.task3308;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;
import org.omg.CORBA.INTERNAL;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Shop {
    public Goods goods;
    public Integer count;
    public double profit;
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    @XmlElement
    public String[] secretData;

    public static class Goods {
        public List<String> names;
    }

    @XmlCDATA
    public int getCount() {
        return count;
    }

    @XmlCDATA
    public void setCount(int count) {
        this.count = count;
    }

    public static class AdapterCDATA extends XmlAdapter<String, String> {

        @Override
        public String marshal(String arg0) throws Exception {
            if (arg0.isEmpty()) return "";
            return "<![CDATA[" + arg0 + "]]>";
        }

        @Override
        public String unmarshal(String arg0) throws Exception {
            return arg0;
        }

    }

}
