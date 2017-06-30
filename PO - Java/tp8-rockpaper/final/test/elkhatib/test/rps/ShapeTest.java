package rps;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import rps.Shape;

public class ShapeTest {
	// ROCK -> PAPER -> SCISSOR 
	@Test 
	public void testShape() {
		Shape someShape = Shape.ROCK ;
		assertNotNull(someShape) ;
	}
	@Test
	public void testNext() {
		Shape someShape = Shape.ROCK ;
		Shape someShape2 = Shape.PAPER ;
		assertTrue(someShape.next().equals((Object) someShape2)) ; 
	}
	public void testCompareShape() {
		Shape someShape = Shape.ROCK ;
		Shape someShape2 = Shape.ROCK ;
		Shape someShape3 = Shape.SCISSORS ;
		assertTrue(someShape.equals((Object) someShape2)) ;
		assertFalse(someShape.equals((Object) someShape3)) ;

	}
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rps.ShapeTest.class);
    }
}