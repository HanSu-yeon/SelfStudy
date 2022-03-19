package chap06;

class Exercise6_23 {
    //max 메서드를 작성해라
    static int max(int[] arr){
        int max = arr[0]; //배열의 첫 번째 값으로 최대값을 초기화
        if (arr == null|| arr.length==0) {
            return -999999;
        }

        for(int i=1; i<arr.length;i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값: "+max(data));
        System.out.println("최대값: "+max(null));
        System.out.println("최대값: "+max(new int[]{})); //크기가 0인 배열열

   }
}
//실행결과
//        [3, 2, 9, 4, 7]
//        최대값:9
//        최대값:-999999
//        최대값:-999999
