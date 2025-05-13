import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class PracticeProblemTest {
    
    private static final double DELTA = 0.001;
    
    // Helper methods that use reflection
    private Object createCircle(double radius) {
        try {
            Class<?> circleClass = Class.forName("Circle");
            Constructor<?> constructor = circleClass.getConstructor(double.class);
            return constructor.newInstance(radius);
        } catch (ClassNotFoundException e) {
            fail("Circle class does not exist");
            return null;
        } catch (NoSuchMethodException e) {
            fail("Circle constructor with double parameter does not exist");
            return null;
        } catch (Exception e) {
            fail("Exception creating Circle: " + e.getMessage());
            return null;
        }
    }
    
    private Object createSphere(double radius) {
        try {
            Class<?> sphereClass = Class.forName("Sphere");
            Constructor<?> constructor = sphereClass.getConstructor(double.class);
            return constructor.newInstance(radius);
        } catch (ClassNotFoundException e) {
            fail("Sphere class does not exist");
            return null;
        } catch (NoSuchMethodException e) {
            fail("Sphere constructor with double parameter does not exist");
            return null;
        } catch (Exception e) {
            fail("Exception creating Sphere: " + e.getMessage());
            return null;
        }
    }
    
    private double invokeDoubleMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            return (double) method.invoke(obj);
        } catch (NoSuchMethodException e) {
            fail("Method " + methodName + " does not exist in " + obj.getClass().getName());
            return 0.0;
        } catch (Exception e) {
            fail("Exception calling " + methodName + ": " + e.getMessage());
            return 0.0;
        }
    }
    
    private void invokeSetRadius(Object obj, double value) {
        try {
            Method method = obj.getClass().getMethod("setRadius", double.class);
            method.invoke(obj, value);
        } catch (NoSuchMethodException e) {
            fail("Method setRadius does not exist in " + obj.getClass().getName());
        } catch (Exception e) {
            fail("Exception calling setRadius: " + e.getMessage());
        }
    }

    // Circle Tests
    @Test
    @DisplayName("Circle getRadius should return the radius value")
    void CircleGetRadiusTest1() {
        Object c = createCircle(5);
        assertEquals(5.0, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Circle getRadius should work with decimal values")
    void CircleGetRadiusTest2() {
        Object c = createCircle(5.5);
        assertEquals(5.5, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Circle setRadius should change the radius")
    void CircleSetRadiusTest1() {
        Object c = createCircle(5);
        invokeSetRadius(c, 1.2);
        assertEquals(1.2, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Circle setRadius should work with integer values")
    void CircleSetRadiusTest2() {
        Object c = createCircle(5);
        invokeSetRadius(c, 9);
        assertEquals(9.0, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Circle diameter should be twice the radius")
    void CircleDiameterTest1() {
        Object c = createCircle(5);
        assertEquals(10.0, invokeDoubleMethod(c, "diameter"), DELTA);
    }

    @Test
    @DisplayName("Circle diameter should be twice the radius (test 2)")
    void CircleDiameterTest2() {
        Object c = createCircle(10);
        assertEquals(20.0, invokeDoubleMethod(c, "diameter"), DELTA);
    }

    @Test
    @DisplayName("Circle perimeter should be 2πr")
    void CirclePerimeterTest1() {
        Object c = createCircle(5);
        assertEquals(10.0 * Math.PI, invokeDoubleMethod(c, "perimeter"), DELTA);
    }

    @Test
    @DisplayName("Circle perimeter should be 2πr (test 2)")
    void CirclePerimeterTest2() {
        Object c = createCircle(10.9);
        assertEquals(21.8 * Math.PI, invokeDoubleMethod(c, "perimeter"), DELTA);
    }

    @Test
    @DisplayName("Circle area should be πr²")
    void CircleAreaTest1() {
        Object c = createCircle(54.2);
        assertEquals(54.2 * 54.2 * Math.PI, invokeDoubleMethod(c, "area"), DELTA);
    }

    @Test
    @DisplayName("Circle area should be πr² (test 2)")
    void CircleAreaTest2() {
        Object c = createCircle(20);
        assertEquals(20.0 * 20.0 * Math.PI, invokeDoubleMethod(c, "area"), DELTA);
    }

    // Sphere Tests
    @Test
    @DisplayName("Sphere getRadius should return the radius value")
    void SphereGetRadiusTest1() {
        Object c = createSphere(5);
        assertEquals(5.0, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Sphere getRadius should work with decimal values")
    void SphereGetRadiusTest2() {
        Object c = createSphere(5.5);
        assertEquals(5.5, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Sphere setRadius should change the radius")
    void SphereSetRadiusTest1() {
        Object c = createSphere(5);
        invokeSetRadius(c, 1.2);
        assertEquals(1.2, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Sphere setRadius should work with integer values")
    void SphereSetRadiusTest2() {
        Object c = createSphere(5);
        invokeSetRadius(c, 9);
        assertEquals(9.0, invokeDoubleMethod(c, "getRadius"), DELTA);
    }

    @Test
    @DisplayName("Sphere diameter should be twice the radius")
    void SphereDiameterTest1() {
        Object c = createSphere(5);
        assertEquals(10.0, invokeDoubleMethod(c, "diameter"), DELTA);
    }

    @Test
    @DisplayName("Sphere diameter should be twice the radius (test 2)")
    void SphereDiameterTest2() {
        Object c = createSphere(10);
        assertEquals(20.0, invokeDoubleMethod(c, "diameter"), DELTA);
    }

    @Test
    @DisplayName("Sphere perimeter/circumference should be 2πr")
    void SpherePerimeterTest1() {
        Object c = createSphere(5);
        assertEquals(10.0 * Math.PI, invokeDoubleMethod(c, "perimeter"), DELTA);
    }

    @Test
    @DisplayName("Sphere perimeter/circumference should be 2πr (test 2)")
    void SpherePerimeterTest2() {
        Object c = createSphere(10.9);
        assertEquals(21.8 * Math.PI, invokeDoubleMethod(c, "perimeter"), DELTA);
    }

    @Test
    @DisplayName("Sphere surface area should be 4πr²")
    void SphereAreaTest1() {
        Object c = createSphere(54.2);
        assertEquals(4 * 54.2 * 54.2 * Math.PI, invokeDoubleMethod(c, "area"), DELTA);
    }

    @Test
    @DisplayName("Sphere surface area should be 4πr² (test 2)")
    void SphereAreaTest2() {
        Object c = createSphere(20);
        assertEquals(4 * 20.0 * 20.0 * Math.PI, invokeDoubleMethod(c, "area"), DELTA);
    }

    @Test
    @DisplayName("Sphere volume should be (4/3)πr³")
    void SphereVolumeTest1() {
        Object c = createSphere(20);
        assertEquals(20.0 * 20.0 * 20.0 * Math.PI * 4.0 / 3.0, invokeDoubleMethod(c, "volume"), DELTA);
    }

    @Test
    @DisplayName("Sphere volume should be (4/3)πr³ (test 2)")
    void SphereVolumeTest2() {
        Object c = createSphere(34.2);
        assertEquals(34.2 * 34.2 * 34.2 * Math.PI * 4.0 / 3.0, invokeDoubleMethod(c, "volume"), DELTA);
    }
}
