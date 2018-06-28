package be.axxes.traineeship.java.testing.cucumber;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class CucumberContext {

    private static Map<Keys, Object> values = new ConcurrentHashMap<>();

    public static void putValue(final Keys keys, final Object value) {
        values.put(keys, value);
    }

    public static <T> T getValue(final Keys key) {
        return (T) values.get(key);
    }

    public void clear() {
        values.clear();
    }

}
