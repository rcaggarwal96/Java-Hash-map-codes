// https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/  3 solutions   3rd solution
// https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/?ref=lbp   1 solution

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        
        int n=A.size();
        HashMap<HashMap<Character,Integer>,ArrayList<Integer>> hm = new HashMap< HashMap<Character,Integer>, ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            HashMap<Character,Integer> temp = new HashMap<Character,Integer>();
            for(int j=0;j<A.get(i).length();j++){
                if(temp.get(A.get(i).charAt(j))==null){
                    temp.put(A.get(i).charAt(j),1);
                }else{
                    temp.replace(A.get(i).charAt(j),temp.get(A.get(i).charAt(j))+1);
                }
            }
            if(hm.get(temp)!=null){
                ArrayList<Integer> li = hm.get(temp);
                li.add(i+1);
                hm.replace(temp,li);
            }
            else {
                ArrayList<Integer> li = new ArrayList<Integer>();
                li.add(i+1);
                hm.put(temp, li);
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        // iterate the outerhasmpa
        Iterator itr = hm.entrySet().iterator();
        for (int i=0;i<hm.size();i++)
        {
            if(itr.hasNext()){
                Map.Entry mapElement
                = (Map.Entry)itr.next();
                res.add((ArrayList)mapElement.getValue());
            }
        }
        
        return res;
    }
}
