import java.io.Serializable;

public class Singleton  {
    private static Singleton instance;

//private constructor
    private Singleton(){
        //if(instance!=null);
           // throw new InstanciationError("Object cannot create!");
    }

    public static Singleton getInstance(){
        if(instance==null){

            synchronized(Singleton.class){
                if(instance==null){
                    return new Singleton();
                }

            }
        }

        return null;
    }

    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }


    public Singleton readObject(){
        return Singleton.getInstance();
    }
}
