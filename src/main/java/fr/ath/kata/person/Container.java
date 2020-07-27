package fr.ath.kata.person;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Container {

    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void saveComponent(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (!instances.containsKey(clazz)) {
            T instance = clazz.newInstance();
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (instances.keySet().contains(declaredField.getType())) {
                    declaredField.setAccessible(true);
                    declaredField.set(instance, getComponent(declaredField.getType()));
                }
            }
            instances.put(clazz, instance);
        }
    }

    public <T> T getComponent(Class<T> clazz) {
        return (T) instances.get(clazz);
    }
}
