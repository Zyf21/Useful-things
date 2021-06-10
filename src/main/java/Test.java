import java.util.Hashtable;

public class Test {

        public static void main(String[] args) {


                int []a = {2,45,7,3,5,1,8,9};
                printSumPairs(a,46);






        }
        
        public static void printSumPairs(int []input, int k){

                Hashtable mapping = new Hashtable();

                for (int i=0; i < input.length; i++){
                        mapping.put(input[i], i);
                }
                for (int i=0; i < input.length; i++){
                        if (mapping.containsKey(k - input[i]) && (Integer)mapping.get(k-input[i]) != i){
                                System.out.println(k-input[i]+", "+ input[i]);
                                System.out.println(mapping.get(k-input[i]) + " " + mapping.get(input[i]));
                        }
                }
        }

        private void getY(){
                if(500>56){
                        return;

                }
        }
}

