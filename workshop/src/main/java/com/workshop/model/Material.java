package com.workshop.model;

import java.util.HashMap;

public class Material {
    private static final  HashMap<Integer, String> MATERIALS = new HashMap<>();

    static {
        MATERIALS.put(1, "leather");
        MATERIALS.put(2, "thread");
        MATERIALS.put(3, "glue");
        MATERIALS.put(4, "paint");
    }

    public HashMap<Integer, String> getMaterials(){
        return MATERIALS;
    }

    public static String selectMaterial(Integer key){
       return MATERIALS.get(key);
    }
}
