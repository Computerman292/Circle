import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private final double[] radius = {2, 3, 5, -6, 7};
    private final double[] set_radius = {-53, 73, 50, 10, 71};

    private ArrayList<Circle> CircleList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        CircleList = new ArrayList<>();
        for (int i = 0; i < radius.length; i++) {
            Circle c = new Circle(radius[i]);
            CircleList.add(c);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        CircleList = null;
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        for (Circle c : CircleList) {
            System.out.println(c);
        }
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assert(CircleList.size() == radius.length);
        for (Circle c : CircleList) {
            Circle shallowCopy = c;
            assertEquals(c, shallowCopy);
            Circle nullPointer = null;
            assertFalse(c.equals(nullPointer));
            assertFalse(c.equals("Not a Circle"));
        }
        for (int ndx = 0; ndx < CircleList.size(); ndx++) {
            assert(CircleList.size() == radius.length);
            Circle c = CircleList.get(ndx);
            Circle actualr = new Circle(radius[ndx]);
            assertNotSame(actualr, c);
            assertEquals(actualr, c);
            Circle unequal_c = new Circle(radius[ndx] + 'x');
            assertNotEquals(unequal_c, c);
        }

    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assert(CircleList.size() == radius.length);
        for (int ndx = 0; ndx < CircleList.size(); ndx++) {
            Circle c = CircleList.get(ndx);
            Circle actualr = new Circle(radius[ndx]);
            assertNotSame(actualr, c);
            assertEquals(c.hashCode(),actualr.hashCode());
        }
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
        assertEquals(CircleList.size(), radius.length);
        for (int ndx = 0; ndx < CircleList.size(); ndx++) {
            double c = CircleList.get(ndx).getRadius();
            double exp_c = radius[ndx] > 0 ? radius[ndx] : 0 ;
            assertEquals(exp_c, c);
        }
    }

    @org.junit.jupiter.api.Test
    void setRadius() {
        assertEquals(CircleList.size(), set_radius.length);
        for (int ndx = 0; ndx < CircleList.size(); ndx++) {
            Circle c = CircleList.get(ndx);
                    c.setRadius(set_radius[ndx]);
                    double actualr = c.getRadius();
                double exp_c = set_radius[ndx] > 0 ? set_radius[ndx] : 0 ;
                assertEquals(exp_c, actualr);
        }

    }

    @org.junit.jupiter.api.Test
    void getCircumference() {
        assertEquals(CircleList.size(), radius.length);
        for (int ndx = 0; ndx < CircleList.size(); ndx++) {
            double c = CircleList.get(ndx).getCircumference();
            double exp_c = radius[ndx] > 0 ? 2 * Math.PI * radius[ndx] : 0 ;
            assertEquals(exp_c, c);
        }
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        assertEquals(CircleList.size(), radius.length);
        for (int ndx = 0; ndx < CircleList.size(); ndx++) {
            double c = CircleList.get(ndx).getArea();
            double exp_c = radius[ndx] > 0 ? Math.PI * Math.pow(radius[ndx], 2): 0 ;
            assertEquals(exp_c, c);
        }
    }
}