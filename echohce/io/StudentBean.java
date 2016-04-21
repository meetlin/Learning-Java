package cn.echohce.io;

import java.io.Serializable;

/**
 * Created by lin on 2016/4/18.
 */
public class StudentBean implements Serializable {
    private String name;
    private int id;

    public StudentBean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
