package secondlargest;

public class SecondLargest {
    public static void main(String[] args) {
        int[] numbers = {10, 2, 30, 99, 1, 47};
        int largest = 0;
        int secondLargest = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                secondLargest = largest;
                largest = numbers[i];
            }
            else if (secondLargest<numbers[i]){
                secondLargest = numbers[i];
            }
        }
        System.out.println("Második legnagyobb szám: " + secondLargest);
        System.out.println("Legnagyobb szám: " + largest);
    }
}
