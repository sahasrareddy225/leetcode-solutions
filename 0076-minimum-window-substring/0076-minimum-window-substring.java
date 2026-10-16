class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        Map<Character,Integer> req=new HashMap<>();
        for(char ch  : t.toCharArray()){
            req.put(ch,req.getOrDefault(ch,0)+1);
        }
        int stillNeed=req.size();
        int ws=0,we=0,min=Integer.MAX_VALUE,ans_ws=-1,ans_we=-1,n=s.length();
        for(we=0;we<n;we++){
            char endCh=s.charAt(we);
            if(req.containsKey(endCh)){
                req.put(endCh,req.get(endCh)-1);
                if(req.get(endCh)==0){
                    stillNeed--;
                    if(stillNeed==0){
                        if(we-ws+1<min){
                            min=we-ws+1;
                            ans_ws=ws;
                            ans_we=we;
                        }
                        while(ws<=we){
                            char rem=s.charAt(ws);
                            ws++;
                            if(req.containsKey(rem)){
                                req.put(rem,req.get(rem)+1);
                                if(req.get(rem)>=1){
                                    stillNeed++;
                                    break;
                                }
                            }
                            if(we-ws+1<min){
                                min=we-ws+1;
                                ans_ws=ws;
                                ans_we=we;
                            }
                        }
                    }
                }
            }
        }
        if(ans_ws==-1)
        return "";
        return s.substring(ans_ws,ans_we+1);
    }
}