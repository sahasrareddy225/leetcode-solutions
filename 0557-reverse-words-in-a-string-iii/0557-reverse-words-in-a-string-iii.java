class Solution {
    public String reverseWords(String s) {
        char [] arr=s.toCharArray();
        int l=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==' ' || i==arr.length-1){
                int r=(i==arr.length-1 && arr[i]!=' ') ? i+1 : i;
                while(l<r){
                    char temp=arr[l];
                    arr[l]=arr[r-1];
                    arr[r-1]=temp;
                    l++;
                    r--;
                }
                l=i+1;
            }
        }
        return new String(arr);
    }
}