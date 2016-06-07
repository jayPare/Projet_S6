package ca.uSherbrooke.gegi.opus.shared.entity;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by tomaslopinto on 06/06/16.
 */
public class TestJPA {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "opus" );
        EntityManager entitymanager = emf.createEntityManager();
        entitymanager.getTransaction( ).begin( );
        

        Query q = entitymanager.createNamedQuery("get_all_stagiaires");
        List<UserInfosData> users = q.getResultList();


        for (UserInfosData a : users ) {
            System.out.println("Prenom de la table user : "
                    +" prenom :"+ a.getFirstName()+" nom "+ a.getLastName()+ " departement "+ a.getDepartementNom() +" num de stage "+ a.getNumeroStage() +"concept " + a.getConceptNom() + " competence " + a.getNiveauSur5Competence() + " interet " + a.getNiveauSur5Interet() );
        }


        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emf.close( );





    }




}
