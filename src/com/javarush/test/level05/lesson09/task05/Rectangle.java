package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private double top = 0;
    private double left = 0;
    private double height = 0;
    private double width = 0;

    public Rectangle(double left, double top, double width, double height){
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
    }

    public Rectangle(double top, double left){
        this.top = top;
        this.left = left;
    }

    public Rectangle(double top, double left, double width){
        this.top = top;
        this.left = left;
        this.height = width;
        this.width = width;
    }

    public Rectangle(Rectangle rectangle){
        this.top = rectangle.top;
        this.left = rectangle.left;
        this.height = rectangle.height;
        this.width = rectangle.width;
    }

}
