import java.util.Vector;

public class Instructions {

    private String difficulty;


    public Vector preparations = new Vector();

    public void addPreparation(TextPreparation newPreparation){
        preparations.add(newPreparation);
    }

    public Vector getPreparations(){
        return preparations;
    }

    public void removePreparation(TextPreparation e){
        preparations.remove(e);
    }
}
