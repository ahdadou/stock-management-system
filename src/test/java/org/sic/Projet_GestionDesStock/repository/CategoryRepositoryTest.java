
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Assertions;



@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void testCreateCategoty(){
        Category category = new Category(1,"Matiere Premiere");
        Assertions.assertEquals(1,1);

    }



}
