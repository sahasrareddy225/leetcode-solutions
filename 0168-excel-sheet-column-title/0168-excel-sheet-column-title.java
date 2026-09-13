class Solution {
    public String convertToTitle(int columnNumber) {
        int n=columnNumber;
        StringBuilder sb=new StringBuilder();
        while(n>0){
            n--;
            int curr=n%26;
            n/=26;
            sb.append((char)(curr+'A'));
        }
        return sb.reverse().toString();
    }
}