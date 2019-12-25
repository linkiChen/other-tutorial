package com.jacky.jvm.oom;

import java.util.ArrayList;

public class OomApplication {

    public static void main(String[] args) {
        final ArrayList<Entity> entities = new ArrayList<Entity>();
        while (true) {
            entities.add(new Entity());
        }
    }
}
