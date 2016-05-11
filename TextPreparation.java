import java.util.Vector;

public class TextPreparation {

    private String text;

    public void print(){
        System.out.println(text);
        System.out.println(PhotoPreparation);
    }

    public Vector PhotoPreparation = new Vector();

    public void addPreparation(Preparation newPreparation){
        PhotoPreparation.add(newPreparation);
    }

    public Vector getPreparations(){
        return PhotoPreparation;
    }

    public void removePreparation(Preparation e){
        PhotoPreparation.remove(e);
    }
}
