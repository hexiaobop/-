package calculate.rpc;

import java.io.Serializable;

public class Detail implements Serializable {
    private static final long serialVersionUID = 3112749314769978450L;
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
