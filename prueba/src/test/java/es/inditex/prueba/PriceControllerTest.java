package es.inditex.prueba;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    /* 
      	   Test 1: peticion a las 10:00 del dia 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: peticion a las 16:00 del dia 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: peticion a las 21:00 del dia 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: peticion a las 10:00 del dia 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: peticion a las 21:00 del dia 16 del producto 35455   para la brand 1 (ZARA)
     */

    @Test
    @DisplayName("Test 1: Obtener precio con datos válidos")
    void testGetPrice1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .param("date", "2020-06-14T10:00:00")
                .param("idProduct", "35455")
                .param("idBrand", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.price").value(35.50)); 
    }

    @Test
    @DisplayName("Test 2: Obtener precio con datos válidos")
    void testGetPrice2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .param("date", "2020-06-14T16:00:00")
                .param("idProduct", "35455")
                .param("idBrand", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.price").value(25.45)); 
    }

    @Test
    @DisplayName("Test 3: Obtener precio con datos válidos")
    void testGetPrice3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .param("date", "2020-06-14T21:00:00")
                .param("idProduct", "35455")
                .param("idBrand", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.price").value(35.50)); 
    }
    @Test
    @DisplayName("Test 4: Obtener precio con datos válidos")
    void testGetPrice4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .param("date", "2020-06-15T10:00:00")
                .param("idProduct", "35455")
                .param("idBrand", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.price").value(30.50)); 
    }

    @Test
    @DisplayName("Test 5: Obtener precio con datos válidos")
    void testGetPrice5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .param("date", "2020-06-16T21:00:00")
                .param("idProduct", "35455")
                .param("idBrand", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.price").value(38.95)); 
    }
    
 
    
}
