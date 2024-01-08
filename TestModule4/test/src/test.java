import java.util.*;

public class test {
    public static void main(String[] args) {
        String regex = "^[Hh][Ii] [^(d|D)].*$";
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String text = scanner.nextLine();
            if (text.matches(regex)) {
                System.out.println(text);
            }
        }
        scanner.close();
    }
}

//5
//Hi Alex how are you doing
//hI dave how are you doing
//Good by Alex
//hidden agenda
//Alex greeted Martha by saying Hi Martha