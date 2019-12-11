package enemies;

import java.util.HashMap;

import javafx.scene.image.Image;

public class ImageLoader {
	HashMap<String, Image> loader;
	public ImageLoader() {
		loader = new HashMap<String, Image>();
		loader.put("assets/desert/enemies/1/desert1.png", new Image("assets/desert/enemies/1/desert1.png"));
		loader.put("assets/ice/enemies/1/ice1.png", new Image("assets/ice/enemies/1/ice1.png"));
		loader.put("assets/volcano/enemies/1/volcano1.png", new Image("assets/volcano/enemies/1/volcano1.png"));
		
		loader.put("assets/desert/enemies/2/desert2.png", new Image("assets/desert/enemies/2/desert2.png"));
		loader.put("assets/ice/enemies/2/ice2.png", new Image("assets/ice/enemies/2/ice2.png"));
		loader.put("assets/volcano/enemies/2/volcano2.png", new Image("assets/volcano/enemies/2/volcano2.png"));
		
		loader.put("assets/desert/enemies/3/desert3.png", new Image("assets/desert/enemies/3/desert3.png"));
		loader.put("assets/ice/enemies/3/ice3.png", new Image("assets/ice/enemies/3/ice3.png"));
		loader.put("assets/volcano/enemies/3/volcano3.png", new Image("assets/volcano/enemies/3/volcano3.png"));
		
		loader.put("assets/desert/enemies/4/desert4.png", new Image("assets/desert/enemies/4/desert4.png"));
		loader.put("assets/ice/enemies/4/ice4.png", new Image("assets/ice/enemies/4/ice4.png"));
		loader.put("assets/volcano/enemies/4/volcano4.png", new Image("assets/volcano/enemies/4/volcano4.png"));
		
		loader.put("assets/desert/enemies/5/desert5.png", new Image("assets/desert/enemies/5/desert5.png"));
		loader.put("assets/ice/enemies/5/ice5.png", new Image("assets/ice/enemies/5/ice5.png"));
		loader.put("assets/volcano/enemies/5/volcano5.png", new Image("assets/volcano/enemies/5/volcano5.png"));
		
		loader.put("assets/desert/enemies/6/desert6.png", new Image("assets/desert/enemies/6/desert6.png"));
		loader.put("assets/ice/enemies/6/ice6.png", new Image("assets/ice/enemies/6/ice6.png"));
		loader.put("assets/volcano/enemies/6/volcano6.png", new Image("assets/volcano/enemies/6/volcano6.png"));
		
<<<<<<< HEAD
		loader.put("stoneammo.png", new Image("assets/towers/stone/stoneammo.png",20,20,false,false));
		loader.put("magicammo.png",new Image("assets/towers/magic/magicammo.png",20,20,false,false));
		loader.put("lightningammo.png", new Image("assets/towers/lightning/lightningammo.png",30,30,false,false));
		loader.put("iceammo.png", new Image("assets/towers/ice/iceammo.png",20,20,false,false));
		loader.put("heavyammo.png",new Image("assets/towers/heavy/heavyammo.png",30,20,false,false));
		loader.put("fireammo.png", new Image("assets/towers/fire/fireammo.png",20,20,false,false));	
=======
		loader.put("stoneammo.png", new Image("stoneammo.png",20,20,false,false));
		loader.put("magicammo.png",new Image("magicammo.png",20,20,false,false));
		loader.put("lightningammo.png", new Image("lightningammo.png",30,30,false,false));
		loader.put("iceammo.png", new Image("iceammo.png",20,20,false,false));
		loader.put("heavyammo.png",new Image("heavyammo.png",30,20,false,false));
		loader.put("fireammo.png", new Image("fireammo.png",20,20,false,false));
>>>>>>> refs/heads/rateOfFire
		
		loader.put("tower_fire.png", new Image("assets/towers/fire/tower_fire.png",65,65,false,false));	
		loader.put("tower_heavy.png", new Image("assets/towers/heavy/tower_heavy.png",65,65,false,false));
		loader.put("tower_ice.png", new Image("assets/towers/ice/tower_ice.png",65,65,false,false));
		loader.put("tower_magic.png",new Image("assets/towers/magic/tower_magic.png",65,65,false,false));
		loader.put("tower_stone.png", new Image("assets/towers/stone/tower_stone.png",65,65,false,false));
		loader.put("tower_lightning.png", new Image("assets/towers/lightning/tower_lightning.png",65,65,false,false));
	}

	public Image getImage(String path) {
		return loader.get(path);
	}


}
