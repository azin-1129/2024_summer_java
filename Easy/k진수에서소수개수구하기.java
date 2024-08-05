package Easy;

import java.util.*;

public class k진수에서소수개수구하기 {
    public static void main(String[] args) {
        String convertedNumber=Integer.toString(437674,3)+"0";
        int answer = 0;
        Queue<String> decimalStack=new LinkedList<>();

        for(int i=0;i<convertedNumber.length();i++){
            if(Integer.valueOf(String.valueOf(convertedNumber.charAt(i)))!=0){
                decimalStack.offer(String.valueOf(convertedNumber.charAt(i)));
            }else{
                if(decimalStack.isEmpty()){
                    continue;
                }else{
                    if(decimalStack.size()==1 & Integer.valueOf(decimalStack.peek())==1){
                        decimalStack.poll();
                        continue;
                    }
                    
                    System.out.println("소수 여부를 판별할 숫자 원본입니다:"+decimalStack);
                    int stackSize=decimalStack.size();
                    StringBuilder decimalCalc=new StringBuilder();
                    
                    for(int j=0;j<stackSize;j++){
                        // decimalCalc+=Integer.valueOf(decimalStack.pop())*((int)(Math.pow(k,j)));
                        decimalCalc.append(decimalStack.poll());
                    }
                    
                    System.out.println("소수 여부를 판별할 숫자입니다:"+decimalCalc);
                    answer+=isPrime(Integer.valueOf(decimalCalc.toString()));
                }
            }
        }
        
        System.out.println(answer);
    }

    public static int isPrime(int number){
        if(number==1){
            return 0;
        }
        
        for(int i=number+1;i<=Math.sqrt(number);i++){
            if(number%i==0){
                return 0;
            }
        }

        System.out.println(number+"는 소수입니다.");

        return 1;
    }
}
