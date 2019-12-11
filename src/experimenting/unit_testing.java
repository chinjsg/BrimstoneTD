package experimenting;

import org.junit.jupiter.api.Test;

import game.TowersOfBrimstoneController;
import game.TowersOfBrimstoneModel;

public class unit_testing {

    @Test
    public void test1() {
//		Application.launch(TowersOfBrimstoneView.class, args);

	TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
	TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
	controller.createMap(1);
	for (int i = 0; i < 200000; i++) {
	    controller.frameUpdate(i);
	}

    }
}
