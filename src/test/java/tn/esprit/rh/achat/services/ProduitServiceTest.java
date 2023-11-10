import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProduitServiceTest {

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenAddProduit_thenProduitIsSaved() {
        // Arrange
        Produit produit = new Produit();
        produit.setIdProduit(1L);
        produit.setCodeProduit("ABC123");
        produit.setLibelleProduit("Product 1");
        produit.setPrix(50.0f);
        
        when(produitRepository.save(any(Produit.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        Produit savedProduit = produitService.addProduit(produit);

        // Assert
        assertNotNull(savedProduit);
    }

    @Test
    void whenRetrieveProduitById_thenCorrectProduitIsReturned() {
        // Arrange
        Long produitId = 1L;
        Produit produit = new Produit();
        produit.setIdProduit(produitId);
        produit.setCodeProduit("XYZ456");
        produit.setLibelleProduit("Product 2");
        produit.setPrix(75.0f);

        when(produitRepository.findById(produitId)).thenReturn(Optional.of(produit));

        // Act
        Produit foundProduit = produitService.retrieveProduit(produitId);

        // Assert
        assertNotNull(foundProduit);
        assertEquals(produitId, foundProduit.getIdProduit());
    }
}
