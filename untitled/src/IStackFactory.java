public class IStackFactory {
    public IStack<Integer>getStack(int eleccion){
        if(eleccion == 1){
            return new StackUsingArrayList<Integer>();
        }
        if(eleccion == 2){
            return new StackVector<Integer>();
        }
        if(eleccion == 3){
            return new StackDouble<Integer>();
        }
        if(eleccion == 4){
            return new StackDoubleReally<Integer>();
        }

        else{
            return null;
        }
    }
}
