import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.IProduitRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProduitServiceTest {

    @Mock
    private IProduitRepository produitRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenAddProduit_thenProduitIsSaved() {
        // Arrange
        Produit produit = /* create a Produit object for testing */;
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
        Produit produit = /* create a Produit object for testing */;
        when(produitRepository.findById(produitId)).thenReturn(Optional.of(produit));

        // Act
        Produit foundProduit = produitService.retrieveProduit(produitId);

        // Assert
        assertNotNull(foundProduit);
        assertEquals(produitId, foundProduit.getIdProduit());
    }

    
}
