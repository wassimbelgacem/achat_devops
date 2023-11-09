package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProduitServiceMockTest {

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllProduits() {
        Produit produit1 = new Produit(/* add constructor parameters */);
        Produit produit2 = new Produit(/* add constructor parameters */);

        Mockito.when(produitRepository.findAll()).thenReturn(Arrays.asList(produit1, produit2));

        List<Produit> produits = produitService.retrieveAllProduits();

        assertEquals(2, produits.size());
        // Add more assertions if needed
    }

    @Test
    public void testAddProduit() {
        Produit produit = new Produit(/* add constructor parameters */);

        Mockito.when(produitRepository.save(Mockito.any(Produit.class))).thenReturn(produit);

        Produit savedProduit = produitService.addProduit(produit);

        assertEquals(produit, savedProduit);
        // Add more assertions if needed
    }

    @Test
    public void testDeleteProduit() {
        long produitId = 1L;

        produitService.deleteProduit(produitId);

        Mockito.verify(produitRepository, Mockito.times(1)).deleteById(produitId);
    }

    // Add tests for other methods like updateProduit, retrieveProduit, assignProduitToStock, etc.
}

