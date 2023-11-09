import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.rh.achat.controllers.ProduitRestController;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProduitControllerTest {

    @Mock
    private IProduitService produitService;

    @InjectMocks
    private ProduitRestController produitController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(produitController).build();
    }

    @Test
    void whenGetAllProduits_thenProduitListReturned() throws Exception {
        // Arrange
        List<Produit> allProduits = new ArrayList<>();
        Produit produit1 = new Produit();
        produit1.setIdProduit(1L);
        produit1.setCodeProduit("ABC123");
        produit1.setLibelleProduit("Product 1");
        produit1.setPrix(50.0f);

        Produit produit2 = new Produit();
        produit2.setIdProduit(2L);
        produit2.setCodeProduit("XYZ456");
        produit2.setLibelleProduit("Product 2");
        produit2.setPrix(75.0f);

        allProduits.add(produit1);
        allProduits.add(produit2);

        given(produitService.retrieveAllProduits()).willReturn(allProduits);

        // Act & Assert
        mockMvc.perform(get("/produit/retrieve-all-produits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idProduit").value(1))
                .andExpect(jsonPath("$[0].codeProduit").value("ABC123"))
                .andExpect(jsonPath("$[0].libelleProduit").value("Product 1"))
                .andExpect(jsonPath("$[0].prix").value(50.0))
                .andExpect(jsonPath("$[1].idProduit").value(2))
                .andExpect(jsonPath("$[1].codeProduit").value("XYZ456"))
                .andExpect(jsonPath("$[1].libelleProduit").value("Product 2"))
                .andExpect(jsonPath("$[1].prix").value(75.0));

        verify(produitService, times(1)).retrieveAllProduits();
    }
}
