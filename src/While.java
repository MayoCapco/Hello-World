public class While {
    public static void main(String[] args) throws Exception{
        int i=5;

        while(i<6){
            i+=1;
            System.out.println("While loop: "+i);
        }

        i=0;
        do{
            i+=1;
            System.out.println("Do-while loop: "+i);
        }
        while(i<6);
    }
}
