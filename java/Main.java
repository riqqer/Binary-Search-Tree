import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        BST<Integer, String> students = new BST<>();

        students.put(13, "Alisher");
        students.put(26, "Yerasyl");
        students.put(56, "Ayazhan");
        students.put(18, "Nurbolat");
        students.put(16, "Vladislav");
        students.put(2, "Karina");

        Iterator<Integer> iterator = students.iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println("Key: " + key + ", Value: " + students.get(key));
        }
    }
}
