import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class ChpOneLambadaExp {
    public static void main(String[] args){
        // 1========Lambada Expression No Parameter
        //LambadaExpNoParameter();

        // 2========Lambada Expression With Parameter
        LambadaExpWithParameter();
    }

    public static void LambadaExpNoParameter(){
        //Using Anonymous Inner Class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class");
            }
        }).start();

        //Using Lambada Expression
        new Thread(()-> System.out.println("Lambada Expression with Functional Interface")).start();

        //Using instance with Lambada Expression
        Runnable run = ()-> System.out.println("Instance Lambada Expression by using Function Interface");
        new Thread(run).start();
    }

    public static void LambadaExpWithParameter(){
        File directory = new File("./src");
        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        //System.out.println(Arrays.asList(names));

        System.out.println(Arrays.asList(directory.list((f,n)-> n.endsWith(".java"))));

    }
}
