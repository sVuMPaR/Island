package Plants;

import AnimalClass.Eatable;

public class Plant implements Eatable {
    @Override
    public void canBeEaten() {
        System.out.println("can be eaten");
    }
}
