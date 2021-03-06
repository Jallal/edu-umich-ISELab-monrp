package thiagodnf.doupr.export.block.parser;

import thiagodnf.doupr.core.base.ClassObject;
import thiagodnf.doupr.export.ExportParser;

import java.util.List;

public class RealizationsBlocksParser extends ExportParser {

    public String parse(List<ClassObject> classes, ClassObject cls) {

        StringBuilder builder = new StringBuilder();

        if (cls.hasInterface()) {

            for (String inter : cls.getInterfaces()) {

                builder.append("Realization(");
                builder.append(inter);
                builder.append(");").append("\n");
            }
        }

        return builder.toString();
    }
}
