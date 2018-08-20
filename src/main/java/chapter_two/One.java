package chapter_two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class One {
    public List<Integer> deleteDups(List<Integer> list){
        HashSet hash = new HashSet();
        List<Integer> resultList = new ArrayList<>();
        for(Integer i : list){
            if(!hash.contains(i)){
                hash.add(i);
                resultList.add(i);
            }
        }
        return resultList;
    }
    //with lambda
    public List<Integer> deleteDupsWithLambda(List<Integer> list){
        HashSet hash = new HashSet();
        List<Integer> resultList = new ArrayList<>();
        list.forEach((i)->{
            if(!hash.contains(i)){
                hash.add(i);
                resultList.add(i);
            }
        });
        return resultList;
    }
    //with lambda 2
    public List<Integer> deleteDupsWithLambda2(List<Integer> list){
        HashSet hash = new HashSet();
        list.removeIf((i)-> hash.contains(i) || !hash.add(i));
        return list;
    }
}
