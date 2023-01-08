package com.javarush.task.task33.task3309;

//import com.javarush.task.task33.task3308.Shop;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/*
Комментарий внутри xml

Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта
obj.
В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не
нужно.

Пример вызова:
toXmlWithComment(firstSecondObject, "second", "it's a comment")

Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second><![CDATA[need CDATA because of < and >]]></second>
<!--it's a comment-->
<second/>
</first>


Требования:
1. Метод toXmlWithComment должен быть статическим.
2. Метод toXmlWithComment должен быть публичным.
3. Если во входящем xml отсутствует искомый тег, то добавлять комментарии не нужно.
*/
public class Solution {
//    public static String toXmlWithComment(Object obj, String tagName, String comment) throws
//            JAXBException {
//        StringWriter writer = new StringWriter();
//        JAXBContext context = JAXBContext.newInstance(obj.getClass());
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(obj, writer);
//
//        StringBuilder sb = new StringBuilder();
//        String reg = "<" + tagName;
//        String coment = "<!--" + comment + "-->\n";
//        List<String> xml = Arrays.asList(writer.toString().split("\n"));
//        sb.append(xml.get(0).replace("standalone=\"yes\"", "standalone=\"no\"")+"\n");
//        for (int i = 1; i < xml.size(); i++) {
//            String ss = xml.get(i);
//
//            int f = ss.indexOf(reg);
//            if (f >= 0) {
//                sb.append(ss, 0, f).append(coment);
//            }
//
//            int n = ss.indexOf(">");
//            int k = ss.lastIndexOf("<");
//            String sd = "";
//            if (k > n) sd = ss.substring(n + 1, k);
//
//            if (!sd.equals("")) {
//                if (sd.matches((".*(&amp;|&lt;|&gt;|'|\").*"))) {
//                    sd = sd.replaceAll("&amp;", "&");
//                    sd = sd.replaceAll("&lt;", "<");
//                    sd = sd.replaceAll("&gt;", ">");
//                    sd = "<![CDATA[" + sd + "]]>";
//                    ss = ss.substring(0, n + 1) + sd + ss.substring(k);
//                }
//            }
//            sb.append(ss).append("\n");
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) throws JAXBException {
////        Shop shop = new Shop();
////        shop.count = 1;
////        shop.secretData = new String[]{"secret1", "<secretData>", ""};
////        System.out.println(toXmlWithComment(shop, "secretData", "comment"));
//    }
}
