package be.axxes.traineeship.java.testing.cucumber;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class CucumberContext {

    private Map<Keys, Object> values = new ConcurrentHashMap<>();

    public void putValue(final Keys keys, final Object value) {
        values.put(keys, value);
    }

    public <T> T getValue(final Keys key) {
        return (T) values.get(key);
    }

    public String getValueAsString(final Keys key) {
        return (String) getValue(key);
    }

    public void clear() {
        values.clear();
    }

}
