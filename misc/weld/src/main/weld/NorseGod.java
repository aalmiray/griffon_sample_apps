package weld;

import javax.inject.Named;
import javax.inject.Inject;

@Named("Thor")
public class NorseGod {
    @Inject private Hammer mjolnir;

    public void act(WeldModel model) {
        mjolnir.wield(model);
    }
}
