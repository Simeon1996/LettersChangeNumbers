import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        String[] input = reader.nextLine().replaceAll("\\s+"," ").split(" ");

        Double sum = 0d;

        for(Integer i = 0; i < input.length;i++){
            String currentElement = input[i];

            Character firstCharacter = currentElement.charAt(0);
            Character fixedFirstCharacter =  Character.toUpperCase(firstCharacter);
            Integer firstCharacterPosition = (int)fixedFirstCharacter - 64;

            Character lastCharacter = currentElement.charAt(currentElement.length() - 1);
            Character fixedSecondCharacter =  Character.toUpperCase(lastCharacter);
            Integer lastCharacterPosition = (int)fixedSecondCharacter - 64;

            Double elementNumber = Double.parseDouble(currentElement.substring(1, currentElement.length() - 1).toString());

            //Letter before the number
            if (firstCharacter.equals(fixedFirstCharacter)){
                sum += elementNumber / firstCharacterPosition;
            } else{
                sum += elementNumber * firstCharacterPosition;
            }

            //Letter after the number
            if(lastCharacter.equals(fixedSecondCharacter)){
                sum -= lastCharacterPosition;
            }else{
                sum += lastCharacterPosition;
            }
        }

        System.out.printf("%.2f",sum);
    }
}
