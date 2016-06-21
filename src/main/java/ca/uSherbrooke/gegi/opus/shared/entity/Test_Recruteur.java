package ca.uSherbrooke.gegi.opus.shared.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by tomaslopinto on 20/06/16.
 */

public class Test_Recruteur {

    public static void main (String[] args){


        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "opus" );
        EntityManager entitymanager = emf.createEntityManager();
        entitymanager.getTransaction( ).begin( );


        Query q = entitymanager.createNamedQuery("get_all_recruteur");
        List<RecruteurEntity> users = q.getResultList();


        for (RecruteurEntity a : users ) {
            System.out.println("sommaiiiiire : "+  a.getEntrepriseSommaire() );
        }


        entitymanager.close( );
        emf.close( );



}



}
