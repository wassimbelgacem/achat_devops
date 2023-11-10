import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import tn.esprit.rh.achat.entities.Produit;

class ProduitTest {

    @Test
    void testProduitGetterAndSetter() {
        Produit produit = new Produit();
        produit.setCodeProduit("TestCode");
        produit.setLibelleProduit("Test Libelle");
        produit.setPrix(50.0f);

        assertEquals("TestCode", produit.getCodeProduit());
        assertEquals("Test Libelle", produit.getLibelleProduit());
        assertEquals(50.0f, produit.getPrix(), 0.001); // Use delta for float comparisons
    }

    
}

