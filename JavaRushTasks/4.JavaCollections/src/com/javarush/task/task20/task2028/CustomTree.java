package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(4)
Итак, основа дерева создана, пора тебе поработать немного самому.
Вспомним как должно выглядеть наше дерево.

Элементы дерева должны следовать так как показано на картинке:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Необходимо написать методы, которые бы позволили создать такую структуру дерева и проводить операции над ней.

Тебе необходимо реализовать:
1. метод add(String s) — добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName), искать
 место для вставки начинаем слева направо.
2. метод remove(String s) — удаляет элемент дерева имя которого было полученного в качестве параметра.
3. метод size() — возвращает текущее количество элементов в дереве.
4. метод getParent(String s) — возвращает имя родителя элемента дерева, имя которого было полученного в качестве
параметра.


Требования:
1. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
2. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
3. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2
 и является степенью двойки), N - размер дерева до удаления.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    private int size = 0;


    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 17; i++) {
            list.add(String.valueOf(i));
        }
//        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("3");
//        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public CustomTree() {
        this.root = new Entry<>("0");
        root.setParent(root);
    }

    public String get(int index) {
        ArrayList<Entry> stack = new ArrayList<>();
        stack.add(root);
        for (int curIndex = 0; curIndex < stack.size(); curIndex++) {
            if (curIndex == index) {
                return stack.get(index).getElementName() + " parent :: " + stack.get(index)
                        .getParent()
                        .getElementName();
            }
            if (stack.get(curIndex).getLeftChild() != null) {
                stack.add(stack.get(curIndex).getLeftChild());
            }

            if (stack.get(curIndex).getRightChild() != null) {
                stack.add(stack.get(curIndex).getRightChild());
            }
        }
        return "no such element";
    }

    @Override
    public int size() {
        return size;
    }

    private int getSize(Entry element) {
        ArrayList<Entry> stack = new ArrayList<>();
        stack.add(element);
        for (int curIndex = 0; curIndex < stack.size(); curIndex++) {
            if (stack.get(curIndex).getLeftChild() != null) {
                stack.add(stack.get(curIndex).getLeftChild());
            }
            if (stack.get(curIndex).getRightChild() != null) {
                stack.add(stack.get(curIndex).getRightChild());
            }
        }
        return stack.size();
    }

    @Override
    public boolean add(String value) {
        if (root == null) {
            root = new Entry(value);
            root.setParent(root);
            return true;
        } else {
            size++;
            return add(root, value);
        }
    }

    private boolean add(Entry element, String value) {
        ArrayList<Entry> stack = new ArrayList<>();
        stack.add(element);
        for (int curIndex = 0; curIndex < stack.size(); curIndex++) {
            Entry curElement = stack.get(curIndex);
            curElement.checkChildren();
            if (curElement.getLeftChild() == null && curElement.availableToAddLeftChildren) {
                Entry newEntry = new Entry(value);
                newEntry.setParent(curElement);
                curElement.setLeftChild(newEntry);
                return true;
            } else {
                stack.add(curElement.getLeftChild());
            }

            if (curElement.getRightChild() == null && curElement.availableToAddRightChildren) {
                Entry newEntry = new Entry(value);
                newEntry.setParent(stack.get(curIndex));
                curElement.setRightChild(newEntry);
                return true;
            } else {
                stack.add(curElement.getRightChild());
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object elementName) {
        if (root == null) return false;
        String elementName_ = String.valueOf(elementName);

        ArrayList<Entry> stack = new ArrayList<>();
        stack.add(root);
        for (int curIndex = 0; curIndex < stack.size(); curIndex++) {
            Entry curElement = stack.get(curIndex);
            curElement.checkChildren();
            if (curElement.getElementName().equals(elementName_)) {
                size -= getSize(curElement);
                if (curElement.getParent().getLeftChild() == curElement) {
                    curElement.getParent().setLeftChild(null);
                } else if (curElement.getParent().getRightChild() == curElement) {
                    curElement.getParent().setRightChild(null);
                }
                return true;
            }
            if (!curElement.availableToAddLeftChildren) {
                stack.add(curElement.getLeftChild());
            }

            if (!curElement.availableToAddRightChildren) {
                stack.add(stack.get(curIndex).getRightChild());
            }
        }
        return false;
    }

    public String getParent(String elementName) {
        ArrayList<Entry> stack = new ArrayList<>();
        stack.add(root);
        for (int curIndex = 0; curIndex < stack.size(); curIndex++) {
            Entry curElement = stack.get(curIndex);
            curElement.checkChildren();
            if (curElement.getElementName().equals(elementName)) {
                return curElement.getParent().getElementName();
            }

            if (!curElement.availableToAddLeftChildren) {
                stack.add(curElement.getLeftChild());
            }

            if (!curElement.availableToAddRightChildren) {
                stack.add(stack.get(curIndex).getRightChild());
            }
        }
        return "no such element";
    }

//    @Override
//    public String get(int index) {
//        throw new UnsupportedOperationException();
//    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry leftChild, rightChild, parent;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }

//        public Entry(String elementName, Entry leftChild, Entry rightChild, Entry parent) {
//            this.leftChild = leftChild;
//            this.rightChild = rightChild;
//            this.elementName = elementName;
//            this.parent = parent;
//        }
//
//        public Entry(String  elementName, Entry parent) {
//            this.elementName= elementName;
//            this.parent = parent;
//        }

        public Entry getLeftChild() {
            return leftChild;
        }

        public Entry getRightChild() {
            return rightChild;
        }

        public Entry getParent() {
            return parent;
        }

        public String getElementName() {
            return elementName;
        }

        public void setLeftChild(Entry leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Entry rightChild) {
            this.rightChild = rightChild;
        }

        public void setValue(String elementName) {
            this.elementName = elementName;
        }

        public void setParent(Entry parent) {
            this.parent = parent;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }
    }
}
