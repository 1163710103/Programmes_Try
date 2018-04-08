/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import static org.junit.Assert.*; 

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {
    
    // Testing strategy
    //   TODO
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // TODO tests
    @Test
    public void TestPeom() throws IOException{
    	String string = "Mugar Theater";
    	String string2 = "Mugar Omni Theater";
    	final GraphPoet nimoy = new GraphPoet(new File("src//P1//poet//mugar-omni-theater.txt"));
    	assertEquals(string2.toLowerCase(), nimoy.poem(string).toLowerCase());
    	
    	
    	
    	final GraphPoet test = new GraphPoet(new File("test//P1//poet//test.txt"));
    	final String string3 = "name Huqin";
    	String string4 = "name is Huqin";
    	assertEquals(string4.toLowerCase(),test.poem(string3) );
    	
    }
}
