package guru.springframework.sfgpetclinic.fauxspring;

public interface Model {

    void addAttribute(String key, Object o);

    void addAttribute(Object o);

    Object getAttribute(String key);
}
