package dylar.bitb.testproject.model;

import lombok.Getter;

public class Goo extends Something {

    @Getter
    private int gooness;

    public Goo(int gooness) {
        super();
        this.gooness = gooness;
    }

}