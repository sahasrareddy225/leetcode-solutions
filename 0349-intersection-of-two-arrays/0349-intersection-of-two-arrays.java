class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int x:nums1){
            set.add(x);
        }
        List<Integer> res=new ArrayList<>();
        for(int x : nums2){
            if(set.contains(x)){
                res.add(x);
                set.remove(x);
            }
        }
        int[] res1=new int[res.size()];
        for(int i=0;i<res.size();i++){
            res1[i]=res.get(i);
        }
        return res1;
    }
}