class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        System.out.println(Arrays.toString(products));
        List<List<String>> result=new ArrayList<>();
        int n=searchWord.length();
        for(int i=1;i<=n;i++)
        {
            String sub=searchWord.substring(0,i);
            int ind=find(sub,products);
            if(ind==-1)
            {
                result.add(new ArrayList<>());
            }
            else
            {
                List<String> temp=new ArrayList<>();
                for(int j=0;j<3;j++)
                {
                    if((ind+j)<products.length && products[ind+j].indexOf(sub)==0)
                    {
                        temp.add(products[ind+j]);
                    }
                    else
                    {
                        break;
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
    public static int find(String sub,String[] products)
    {
        int low=0;
        int high=products.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(products[mid].compareTo(sub)>=0)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}