package test.java.test.thiagodnf.doupr.core.base;

import org.junit.Test;
import thiagodnf.doupr.core.base.ParameterObject;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;

public class TestParameterObject {

    @Test
    public void shouldCloneAnObject() {
        ParameterObject main = new ParameterObject();

        main.setType("String");
        main.setTemplates(Arrays.asList("Double", "String"));

        ParameterObject copy = new ParameterObject(main);

        copy.setType("Double");
        copy.setTemplates(Arrays.asList("Integer"));

        assertFalse(main.getType().equalsIgnoreCase(copy.getType()));
        assertFalse(main.getTemplates().size() == copy.getTemplates().size());
        assertFalse(copy.getTemplates().contains("Double"));
        assertFalse(copy.getTemplates().contains("String"));
        assertFalse(main.getTemplates().contains("Integer"));
    }

}
