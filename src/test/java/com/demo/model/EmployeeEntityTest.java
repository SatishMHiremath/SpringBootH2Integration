package com.demo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeEntityTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link EmployeeEntity}
     *   <li>{@link EmployeeEntity#setEmail(String)}
     *   <li>{@link EmployeeEntity#setFirstName(String)}
     *   <li>{@link EmployeeEntity#setId(Long)}
     *   <li>{@link EmployeeEntity#setLastName(String)}
     *   <li>{@link EmployeeEntity#toString()}
     *   <li>{@link EmployeeEntity#getEmail()}
     *   <li>{@link EmployeeEntity#getFirstName()}
     *   <li>{@link EmployeeEntity#getId()}
     *   <li>{@link EmployeeEntity#getLastName()}
     * </ul>
     */
    @Test
    public void testConstructor() {
        EmployeeEntity actualEmployeeEntity = new EmployeeEntity();
        actualEmployeeEntity.setEmail("jane.doe@example.org");
        actualEmployeeEntity.setFirstName("Jane");
        actualEmployeeEntity.setId(1L);
        actualEmployeeEntity.setLastName("Doe");
        String actualToStringResult = actualEmployeeEntity.toString();
        assertEquals("jane.doe@example.org", actualEmployeeEntity.getEmail());
        assertEquals("Jane", actualEmployeeEntity.getFirstName());
        assertEquals(1L, actualEmployeeEntity.getId().longValue());
        assertEquals("Doe", actualEmployeeEntity.getLastName());
        assertEquals("EmployeeEntity [id=1, firstName=Jane, lastName=Doe, email=jane.doe@example.org]",
                actualToStringResult);
    }
}

