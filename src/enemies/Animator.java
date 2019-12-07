package enemies;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Animator extends Transition {
	private final ImageView imageView;
    private final int count;
    int ii =  0;
    int linex =  0;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;

    private int lastIndex;

    public Animator(
            ImageView imageView, 
            Duration duration, 
            int count,   int columns,
            int offsetX, int offsetY,
            int width,   int height) {
        this.imageView = imageView;
        this.count     = count;
        this.columns   = columns;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    protected void interpolate(double k) {
    	
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        
        if (index != lastIndex) {
            final int x = (index % columns) * width  + offsetX;
            final int y = (index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            imageView.setFitHeight(50); 
            imageView.setFitWidth(50);
            lastIndex = index;
//            imageView.setX(enemy.getSpeed()*enemy.getDirection().getX());
//            imageView.setY(enemy.getSpeed()*enemy.getDirection().getY());
        }
    }
}
