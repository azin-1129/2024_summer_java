package Easy;

import java.lang.Math;
import java.util.Collections;
import java.util.PriorityQueue;

class 야근지수 {
    public static void main(String[] args) {
        int overTimes=0;

        int n=3;
        int[] works=new int[]{1,1};

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }

        System.out.println("pq 내용물:"+pq);

        while(true){
            if(overTimes==n){
                System.out.println(overTimeCalc(pq));
                break;
            }else{
                pq.offer(pq.peek()-1);
                pq.poll();
                overTimes+=1;
                System.out.println("overTimes:"+overTimes);
            }
        }
    }

    public static long overTimeCalc(PriorityQueue<Integer> pq){
        long poweredOverTimes=0;

        System.out.println(pq);
        
        while(!pq.isEmpty()){
            poweredOverTimes+=Math.pow(pq.poll(),2);
            System.out.println(poweredOverTimes);
        }

        return poweredOverTimes;
    }
}