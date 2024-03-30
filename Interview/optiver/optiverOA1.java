package Interview.optiver;
import java.util.*;
import java.lang.*;

public class optiverOA1 {

    static class SupermarketCheckout {
        Map<Long,Long> custormerItem = new HashMap<>();
        Map<Long,Long> custormerLine = new HashMap<>();
        Map<Long,Long> custormerPosition = new HashMap<>();
        Map<Long,Long> lineIndex = new HashMap<>();
        public SupermarketCheckout(){}

        public void onCustomerEnter(long customerId, long lineNumber, long numItems) {
            if(!lineIndex.containsKey(lineNumber)){
                lineIndex.put(lineNumber,Long.valueOf(1));
            }else{
                lineIndex.put(lineNumber,lineIndex.get(lineNumber)+1);
            }
            custormerItem.put(customerId,numItems);
            custormerLine.put(customerId,lineNumber);
            custormerPosition.put(customerId,lineIndex.get(lineNumber));
        }

        public void onBasketChange(long customerId, long newNumItems) {
            long oldNumItems = custormerItem.get(customerId);
            custormerItem.put(customerId,newNumItems);
            if(newNumItems-oldNumItems<0){
                long line = custormerLine.get(customerId);
                long oldPosition = custormerPosition.get(customerId);
                for(Map.Entry<Long,Long> entry:custormerLine.entrySet()){
                    Long this_customer = entry.getKey();
                    Long this_line = entry.getValue();
                    if(this_line==line){
                        Long this_position = custormerPosition.get(this_customer);
                        if(this_position>oldPosition){
                            custormerPosition.put(this_customer, this_position+1);
                        }else if(this_position==oldPosition){
                            custormerPosition.put(this_customer, lineIndex.get(this_line));
                        }
                        
                    }
                }
            }
        }

        public void onLineService(long lineNumber, long numProcessedItems) {
            while(numProcessedItems>0){
                // System.out.println("numProcessedItems: "+numProcessedItems);
                Map<Long,Long> custormerLineCopy = new HashMap<>(custormerLine);
                for(Map.Entry<Long,Long> entry:custormerLineCopy.entrySet()){
                    Long this_customer = entry.getKey();
                    Long this_line = entry.getValue();
                    if(this_line==lineNumber){
                        Long numItems = custormerItem.get(this_customer);
                        // System.out.println("this_customer: "+this_customer);
                        if(numProcessedItems>=numItems){
                            
                            customerLeave(this_customer);
                            numProcessedItems-=numItems;
                        }else{
                            custormerItem.put(this_customer, numItems-numProcessedItems);numProcessedItems-=numItems;
                        }
                    }
                }
            }
            // System.out.println("onLineService end");
        }
        private void customerLeave(long customerId){
            Long lineId = custormerLine.get(customerId);
            custormerItem.remove(customerId);
            custormerLine.remove(customerId);
            custormerPosition.remove(customerId);
            lineIndex.put(lineId, lineIndex.get(lineId)-1);
            onCustomerExit(customerId);
        }

        public void onLinesService() {
            for(Map.Entry<Long,Long> entry:lineIndex.entrySet()){
                Long line = entry.getKey();
                onLineService(line,1);
            }
            System.out.println("onLinessssssService end");
        }

        private void onCustomerExit(long customerId) {
            // Don't change this implementation.
             System.out.println(customerId);
        }
    };


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        scanner.nextLine();

        SupermarketCheckout checkoutTracker = new SupermarketCheckout();
        for (long i = 0; i < N; ++i) {
            String[] instruction = scanner.nextLine().split(" ");
            String instructionType = instruction[0];

            if (instructionType.equals("CustomerEnter")) {
                long customerId = Long.parseLong(instruction[1]);
                long lineNumber = Long.parseLong(instruction[2]);
                long numItems = Long.parseLong(instruction[3]);
                checkoutTracker.onCustomerEnter(customerId, lineNumber, numItems);
            } else if (instructionType.equals("BasketChange")) {
                long customerId = Long.parseLong(instruction[1]);
                long newNumItems = Long.parseLong(instruction[2]);
                checkoutTracker.onBasketChange(customerId, newNumItems);
            } else if (instructionType.equals("LineService")) {
                long lineNumber = Long.parseLong(instruction[1]);
                long numProcessedItems = Long.parseLong(instruction[2]);
                checkoutTracker.onLineService(lineNumber, numProcessedItems);
            } else if (instructionType.equals("LinesService")) {
                checkoutTracker.onLinesService();
            } else {
                System.out.println("Malformed input!");
                System.exit(-1);
            }
        }
    }
}
