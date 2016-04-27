package jollyroger.enterprise;

/**
 * Created by Mark on 20/04/2016.
 */
public class RecyclerButton {

    int iconId;
    String title;

    public RecyclerButton(int iconId, String title)
    {
        this.iconId = iconId;
        this.title = title;
    }

    public int getIconId(){
        return iconId;
    }

    public void setIconId(int iconId){
        this.iconId = iconId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
