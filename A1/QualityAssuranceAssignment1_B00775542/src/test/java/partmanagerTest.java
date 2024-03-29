import Controller.XMLReader;
import Controller.partmanager;
import Data.order;
import Interface.PARTMANAGER;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class partmanagerTest {

    //partmanager object
    partmanager partmng;


    @Before
    public void setUp() {
        partmng = new partmanager();

    }

    @After
    public void tearDown() {
        partmng = null;

    }

    //check if we have valid part number,quantity and dealer address
    @Test
    @DisplayName("check for success")
    public void SubmitPartManagerResponseSucess(){

        assertEquals(PARTMANAGER.PartResponse.SUCCESS,partmng.SubmitPartForManufactureAndDelivery(1234,1,OrderMock.getDeliveryAddress()));

    }

    //check if we have invalid part number
    @Test
    @DisplayName("check for No Longer Manufactured")
    public void SubmitPartManagerResponseNoLongerManufactured(){

        assertEquals(PARTMANAGER.PartResponse.NO_LONGER_MANUFACTURED,partmng.SubmitPartForManufactureAndDelivery(124,1,OrderMock.getDeliveryAddress()));

    }

    //check when part no is valid but quantity in dtabase is less then quantity ordered by dealer
    @Test
    @DisplayName("check for Out Of Stock")
    public void SubmitPartManagerResponseOutOfStock(){

        assertEquals(PARTMANAGER.PartResponse.OUT_OF_STOCK,partmng.SubmitPartForManufactureAndDelivery(1234,1234,OrderMock.getDeliveryAddress()));

    }
}
