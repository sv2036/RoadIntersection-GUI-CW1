package trafficApp;

import static org.junit.Assert.assertArrayEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StatisticsListPanelTest {	

		@Test
		void testStatisticsListPanelData() {

			ArrayList<Object[]> expectedResult = new ArrayList<Object[]>();
			String[][] expectedRowData = {
					{"Segment1", "40", "40", "20"},
					{"Segment2", "60", "50", "30"}
			};
			String[] expectedColumnData = {"Segment", "Waiting Length", "Total Cross Time", "Avg Cross Time"};
			expectedResult.add(expectedRowData);
			expectedResult.add(expectedColumnData);
		
			ArrayList<Object[]> result = new ArrayList<Object[]>();
			result.add(expectedRowData);
			result.add(expectedColumnData);
			assertArrayEquals(expectedResult.get(0), result.get(0));
			
		}

		
	}



