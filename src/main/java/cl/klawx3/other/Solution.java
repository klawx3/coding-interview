package cl.klawx3.other;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

class alphanumeric {
    public String name;
    public int count;
    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
};

class Solution {
    alphanumeric[] sortedStrings(int N, String A[]) {
        Map<String, alphanumeric> m = new TreeMap<>();
        for(String val : A){
            alphanumeric aux = m.get(val);
            if(aux != null){
                aux.count++;
            }else{
                m.put(val,new alphanumeric(val,1));    
            }
        }
        
        alphanumeric[] list = new alphanumeric[m.size()];
        int i = 0;
        for (Entry<String, alphanumeric> entry : m.entrySet()) {
            alphanumeric element = entry.getValue();
            list[i++] = element;
        }
        
        return list;
        
        
        
    }
};