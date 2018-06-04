package au.com.parcelpoint.coding_challenge;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RobotTest {
	
	private Robot robo ;
	
	@Before
	 public void setUp(){
	        List<ParcelColumn> columns = new ArrayList<>();
	        ParcelColumn a = new ParcelColumn("A");
	        ParcelColumn b = new ParcelColumn("B");
	        ParcelColumn c = new ParcelColumn("C");
	        ParcelColumn d = new ParcelColumn("D");
	        ParcelColumn e = new ParcelColumn("E");
	        columns.add(a);
	        columns.add(b);
	        columns.add(c);
	        columns.add(d);
	        columns.add(e);
	         robo = new Robot(columns);
	    }


    @Test
    public void shouldSimulateArm(){
        Map<String, List<String>>  statusMap =  robo.simulateArm("FD{foo}FFD{bar}RFFD{Foo}RFFD{World}D{}DA{hello}");
        System.out.println(statusMap);

    }
    
    @Test
    public void noParcelsInBoxesWithOnlyForwardMovements(){
        Map<String, List<String>>  statusMap =  robo.simulateArm("FFFFFFFF{hello}");
        System.out.println(statusMap);

    }
    
    @Test
    public void noParcelsInBoxesWithOnlyBackwardMovements(){
        Map<String, List<String>>  statusMap =  robo.simulateArm("RRRRRRRRR{hello}");
        System.out.println(statusMap);

    }
    
    @Test
    public void noParcelsInBoxesWithFFFRRRRRMovements(){
        Map<String, List<String>>  statusMap =  robo.simulateArm("FFFRRRRR{hello}");
        System.out.println(statusMap);

    }
    
    @Test
    public void noParcelsInBoxesWithFFFDMovements(){
        Map<String, List<String>>  statusMap =  robo.simulateArm("FFFD{hello}");
        System.out.println(statusMap);

    }
    
    @Test
    public void noParcelsInBoxesWithFFFFFDMovementBoundryCondition(){
        Map<String, List<String>>  statusMap =  robo.simulateArm("FFFFFD{hello}");
        System.out.println(statusMap);

    }
    
    
    @Test
    public void parcelsInBoxesWithMoreThanMaxAllowedSizeCondition(){
        Map<String, List<String>>  statusMap =  robo.simulateArm("FFFFFD{hi1}RFFFFFD{hi2}RFFFFFD{hi3}RFFFFFD{hi4}RFFFFFD{hi5}RFFFFFD{hi6}RFFFFFD{hi7}RFFFFFD{hi8}RFFFFFD{hi9}RFFFFFD{hi10}RFFFFFD{hi11}R");
        System.out.println(statusMap);

    }
    

    @Test
    public void shouldGiveLoadEnd(){
        int endPos =0 ;
        assertEquals("FD{foo}FFD{bar}RFFD{Foo}RFFD{World}D{}DA{hello}".indexOf("}",2), 6);

        assertEquals("FD{foo}FFD{bar}RFFD{Foo}RFFD{World}D{}DA{hello}".indexOf("}",10), 14);

        assertEquals("FD{foo}FFD{bar}RFFD{Foo}RFFD{World}D{}DA{hello}".indexOf("}",19), 23);
    }

}
