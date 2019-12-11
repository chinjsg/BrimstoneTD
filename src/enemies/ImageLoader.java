package enemies;

import java.util.HashMap;

import javafx.scene.image.Image;

public class ImageLoader {
	HashMap<String, Image> loader;
	public ImageLoader() {
		loader = new HashMap<String, Image>();
		loader.put("assets/desert/enemies/1/desert1.png", new Image("assets/desert/enemies/1/desert1.png"));
		loader.put("assets/desert/enemies/2/desert2.png", new Image("assets/desert/enemies/2/desert2.png"));
		loader.put("assets/desert/enemies/3/desert3.png", new Image("assets/desert/enemies/3/desert3.png"));
		loader.put("assets/desert/enemies/4/desert4.png", new Image("assets/desert/enemies/4/desert4.png"));
		loader.put("assets/desert/enemies/5/desert5.png", new Image("assets/desert/enemies/5/desert5.png"));
		loader.put("assets/desert/enemies/6/desert6.png", new Image("assets/desert/enemies/6/desert6.png"));
	}

	public Image getImage(String path) {
		return loader.get(path);
	}


}
