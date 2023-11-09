import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

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
        List<Produit> allProduits = /* create a list of Produits for testing */;
        given(produitService.retrieveAllProduits()).willReturn(allProduits);

        // Act & Assert
        mockMvc.perform(get("/produit/retrieve-all-produits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(/* add JSON path assertions here */);

        verify(produitService, times(1)).retrieveAllProduits();
    }

    
}
