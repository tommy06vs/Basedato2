package edu.nur.edd.dao;

import edu.nur.edd.listas.ListaDoble;

public class TestDao {
    public static void main(String[] args) {
        //FactoryDao factory = FactoryDao.getOrCreate();
        //PersonaDao dao = factory.newPersonaDao();

        PersonaDao dao = new PersonaDao();
        PersonaDto p = dao.getById(1);
        System.out.println(p);

//        p.setNombre("Pepe");
//        dao.update(p);

//        PersonaDto nuevo = new PersonaDto(5,"McPato",159);
//        PersonaDto nuevo = new PersonaDto(4,"Bonian",170);
//        dao.insert(nuevo);

//        dao.delete(4);
/*
        PersonaDto nuevo = new PersonaDto(5,"McPato",159);
        dao.insert(nuevo);

         */

        ListaDoble<PersonaDto> lista = dao.getAll();
//        System.out.println(lista);
        for (PersonaDto pd: lista) {
            System.out.println(pd);
        }


    }
}
