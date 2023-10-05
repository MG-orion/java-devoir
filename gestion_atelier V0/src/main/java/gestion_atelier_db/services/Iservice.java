package gestion_atelier_db.services;


import java.util.ArrayList;

public interface Iservice<orion> {
    int add(orion data);
    ArrayList<orion> getAll();
    orion get(int id);
    int update(orion data);
    orion show(int id);
    int remove(int id);
    int[] remove(int[] ids);
}