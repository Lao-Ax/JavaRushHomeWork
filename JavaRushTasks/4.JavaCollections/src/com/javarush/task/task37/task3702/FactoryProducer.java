package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

import java.util.Objects;

public class FactoryProducer {
    public enum HumanFactoryType { MALE, FEMALE }

    public static AbstractFactory getFactory(HumanFactoryType type) {
        if (Objects.requireNonNull(type) == HumanFactoryType.FEMALE) {
            return new FemaleFactory();
        }
        return new MaleFactory();
    }
}
