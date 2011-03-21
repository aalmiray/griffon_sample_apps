package weld;

import javax.inject.Named;

@Named("Mjolnir")
public class Hammer {
    public void wield(WeldModel model) {
        model.setAction("Smash!");
    }
}
