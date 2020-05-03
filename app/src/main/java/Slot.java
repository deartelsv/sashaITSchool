import android.media.Image;
import android.view.View;

import com.artelsv.sashaitschool.Item;

public class Slot {
    private Item item;
    private Image image;
    private View view;

    public Slot(Item item, Image image, View view) {
        this.item = item;
        this.image = image;
        this.view = view;
    }
}
