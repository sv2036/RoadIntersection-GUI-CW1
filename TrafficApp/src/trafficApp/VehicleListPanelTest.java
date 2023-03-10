package trafficApp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleListPanelTest {

	private ArrayList<Object> vehicleListPanelData;

	@BeforeEach
	public void setUp() {
		vehicleListPanelData = VehicleListPanel.vehiclesListPanelData();
				
	}
	
	@Test
	public void testvehicleListPanelDataReturnsArrayList() {
		assertNotNull(vehicleListPanelData);
		assertTrue(vehicleListPanelData instanceof ArrayList);
	}
	
	@Test
	public void testvehicleListPanelDataContainsTwoArrays() {
		assertEquals(2, vehicleListPanelData.size());
	}
	
	@Test
	public void testvehicleListPanelRowDataIsArrayOfStrings() {
		Object firstArray = vehicleListPanelData.get(0);
		assertTrue(firstArray instanceof String[][]);
	}
	
	@Test
	public void testvehicleListPanelColumnDataIsArrayOfStrings() {
		Object secondArray = vehicleListPanelData.get(1);
		assertTrue(secondArray instanceof String[]);
	}

}
