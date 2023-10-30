package loadbalancer;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LoadBalancer {

    public static List<Integer> loadBalancing(int k, List<Integer> arrival, List<Integer> load) {
        //Store the arrival and its corresponding load in a pair in an ascending order.
        PriorityQueue<int[]> arrivalAndLoadMinHeap = new PriorityQueue<>((arr1, arr2) ->
        {
            return arr1[0] - arr2[0]; //sorting ascending on basis of arrival
        });

        //Populate the arrivalAndLoad heap.
        //Arrival and Load size are the same
        for (int i = 0; i < arrival.size(); i++) {
            int[] arr = new int[2];
            arr[0] = arrival.get(i);
            arr[1] = load.get(i);
            arrivalAndLoadMinHeap.add(arr);
        }

        //Most important formula: finish = arrival + load - 1
        PriorityQueue<int[]> finishTimeAndServerMinHeap = new PriorityQueue<>((arr1, arr2) ->
        {
            return arr1[0] - arr2[0]; //sorted based on earliest finish time.
        });

        //first allocate the 'k' servers
        for (int i = 0; i < k; i++) {
            int[] arr = arrivalAndLoadMinHeap.poll();
            int server = i + 1;
            assert arr != null;
            int finishTime = arr[0] + arr[1] - 1; //arrival + load - 1
            int loadTime = arr[1]; // This heap will hold the [latest finish time, server, load handled by server]
            finishTimeAndServerMinHeap.add(new int[]{finishTime, server, loadTime});
        }
        //Server availability will be maintained in such a fashion that whichever server gets free first
        //will be allocated to the incoming arrival.
        //Server availability will be of size 'k' provided.
        //Server availability is an array of [finish time, server].
        //Comparison made with the arrival time.

        while (!arrivalAndLoadMinHeap.isEmpty()) {
            int[] arr = arrivalAndLoadMinHeap.poll();
            int arrivalTime = arr[0]; //polled array object from the arrivalAndLoadMinHeap.
            int loadTime = arr[1];
            assert finishTimeAndServerMinHeap.peek() != null;
            if (arrivalTime < finishTimeAndServerMinHeap.peek()[0])
                continue; //arrival time dropped
            else {
                int[] earliestAvailability = finishTimeAndServerMinHeap.poll();
                int updatedFinishTime = arrivalTime + loadTime - 1;
                // replace the olf finish time with the new one
                earliestAvailability[0] = updatedFinishTime;
                // update the load handled by the server
                earliestAvailability[2] += loadTime; // put the modified array object into finishTimeAndServerMinHeap
                finishTimeAndServerMinHeap.add(earliestAvailability);
            }
        }
        //find out the heaviest server from the finishTimeAndServerMinHeap
        //Using HashMap because we cannot loop over the Min Heap in a guaranteed order.
        // key = load,value = list of servers
        Map<Integer, List<Integer>> hmap = new HashMap<>();

        while (!finishTimeAndServerMinHeap.isEmpty()) {
            int[] arr = finishTimeAndServerMinHeap.poll();
            List<Integer> valueList = hmap.getOrDefault(arr[2], new ArrayList<>());
            valueList.add(arr[1]);
            hmap.put(arr[2], valueList);
        }

        //Now get the max out of the hashmap.
        int maxLoad = 0;
        for (Map.Entry<Integer, List<Integer>> entry : hmap.entrySet()) {
            maxLoad = Math.max(maxLoad, entry.getKey());
        }
        List<Integer> resultList = hmap.get(maxLoad);
        Collections.sort(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        //test case - 1
        int k = 3;
        Integer[] arrivalArr = {1, 2, 12, 5, 6, 30, 32};
        Integer[] loadArr = {15, 10, 10, 10, 10, 15, 10};

        //test case - 2
        //int k = 3;
        //Integer[] arrivalArr = {1,2,3,4,5};
        //Integer[] loadArr = {6,3,4,4,4};

        //test case -3
        //int k = 3;
        //Integer[] arrivalArr = {1,10,100};
        //Integer[] loadArr = {5,5,5};

        List<Integer> arrival = Arrays.asList(arrivalArr);
        List<Integer> load = Arrays.asList(loadArr);

        List<Integer> resultList = loadBalancing(k, arrival, load);
        for (Integer i : resultList) {
            System.out.println(i);
        }
    }
}
