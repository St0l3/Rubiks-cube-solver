public class Pruner
{
    public static boolean isPrunable(Cube.MOVE prev, Cube.MOVE curr){
        char prevName = prev.name().charAt(0);
        char currName = curr.name().charAt(0);

        if(prevName == currName)
            return true;
        if(prevName == 'L' && currName =='R')
            return true;
        if(prevName == 'B' && currName =='F')
            return true;
        if(prevName == 'D' && currName =='U')
            return true;

        return false;
    }
}
