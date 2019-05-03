package edu.umich.ISELab.export.block.parser;

import edu.umich.ISELab.export.ExportParser;

import java.util.List;

public class GeneralizationsBlocksParser extends ExportParser {

    public String parse(List<ClassObject> classes, ClassObject cls) {

        StringBuilder builder = new StringBuilder();

        if (cls.hasSuperClass()) {
            builder.append("Generalization(");
            builder.append(cls.getSuperClass());
            builder.append(");").append("\n");
        }

        return builder.toString();
    }
}