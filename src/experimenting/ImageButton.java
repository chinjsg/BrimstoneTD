package experimenting;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class ImageButton extends Button {

    private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";
    /**
     * @param imageurl
     * @param width
     * @param height
     */
    public ImageButton(String imageurl, int width, int height) {

	ImageView imgView = new ImageView(imageurl);
	imgView.setPreserveRatio(true);
	imgView.setFitWidth(width);
	imgView.setFitHeight(height);
	
	setGraphic(imgView);
	setStyle(STYLE_NORMAL);

	setOnMousePressed(new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
		setStyle(STYLE_PRESSED);
	    }
	});

	setOnMouseReleased(new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
		setStyle(STYLE_NORMAL);
	    }
	});
    }

}
