/**
 * Need to add the open curly brace for get name
 *
 * Can't set a final variable in setName
 */

public class FinalIsFinal {
    private final String name;

    public FinalIsFinal(String name) {
        this.name = name;
    }

    public String getName()
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
