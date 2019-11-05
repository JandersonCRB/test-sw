import java.util.Objects;

public class Demo {
    String name;
    Integer id;

    public Demo(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return Objects.equals(name, demo.name) &&
                id.equals(demo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}

