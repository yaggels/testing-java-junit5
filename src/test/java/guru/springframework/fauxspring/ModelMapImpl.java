package guru.springframework.fauxspring;

import java.util.HashMap;
import java.util.Map;

import guru.springframework.sfgpetclinic.fauxspring.Model;

public class ModelMapImpl implements Model {

    Map<String, Object> attributes = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        attributes.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
    }

    @Override
    public Object getAttribute(String key) {
        return attributes.get(key);
    }

}