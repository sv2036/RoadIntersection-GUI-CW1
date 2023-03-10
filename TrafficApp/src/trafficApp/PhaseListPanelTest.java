package trafficApp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhaseListPanelTest {

	
	private ArrayList<Object> phaseListPanelData;

	@BeforeEach
	public void setUp() {
		phaseListPanelData = PhaseListPanel.phaseListPanelData();
	}
	
	@Test
	public void testPhaseListPanelDataReturnsArrayList() {
		assertNotNull(phaseListPanelData);
		assertTrue(phaseListPanelData instanceof ArrayList);
	}
	
	@Test
	public void testPhaseListPanelDataContainsTwoArrays() {
		assertEquals(2, phaseListPanelData.size());
	}
	
	@Test
	public void testPhaseListPanelRowDataIsArrayOfStrings() {
		Object firstArray = phaseListPanelData.get(0);
		assertTrue(firstArray instanceof String[][]);
	}
	
	@Test
	public void testPhaseListPanelColumnDataIsArrayOfStrings() {
		Object secondArray = phaseListPanelData.get(1);
		assertTrue(secondArray instanceof String[]);
	}
	
	//assuming data and checking against arrays
	@Test
	public void testPhaseListPanelDataHasExpectedData() {
		String[][] firstArray = new String[][] {
			{"north", "green", "30"},
			{"east", "green", "30"},
			{"south", "red", "30"},
			{"west", "red", "30"},
			{"north", "yellow", "5"},
			{"east", "yellow", "5"},
			{"south", "red", "5"},
			{"west", "red", "5"}
		};
		String[][] expectedArray = new String[][] {
			{"north", "green", "30"},
			{"east", "green", "30"},
			{"south", "red", "30"},
			{"west", "red", "30"},
			{"north", "yellow", "5"},
			{"east", "yellow", "5"},
			{"south", "red", "5"},
			{"west", "red", "5"}
		};
		assertArrayEquals(expectedArray, firstArray);
	}
	
	

}
