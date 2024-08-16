package model.bo;

public class ClasseDados {
    
    private static ClasseDados instance;
    
    public static synchronized ClasseDados getInstance() {
        if (instance == null) {
            instance = new ClasseDados();
        } 
        return instance;
    }
    
}
