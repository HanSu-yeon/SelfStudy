package exception;

public class ExceptionPrac {
    public static void main(String[] args) {
        /*NullPointerException*/
        String data = null;
        System.out.println(data.toString());

        /*ArrayIndexOutOfBoundsException*/
        int[] arr = {1, 2, 3};
        int result = arr[0] + arr[3]; //index[3]은 존재하지x

        /*NumberFormatException*/
        String data1 = "100";
        String data2 = "a100";

        int value1 = Integer.parseInt(data1);
        System.out.println("value1 = " + value1);
        int value2 = Integer.parseInt(data2); //여기서 NumberFormatException예외 발생
    }


}
