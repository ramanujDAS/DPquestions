public class RodCutting {


    public static void main(String[] args) {

      int n=10;
     int [] arr= new int[]{1,5,8,9,10,17,17,20,24,30};

    // int  answer= recursive(arr,arr.length);
     int [] mem= new int[arr.length+1];

     mem[0]=0;
     for(int i=1;i<mem.length;i++)
         mem[i]=Integer.MIN_VALUE;

    // int answer2 = memo(arr,arr.length,mem);
     int [] dp = new int[arr.length+1];
     dp[0]=0;
     for(int i=1;i<=n;i++)
         dp[i]=Integer.MIN_VALUE;
     int answer3= dynamicProgramming(arr,n,dp);

     System.out.println(answer3);
     for(int x:dp)
     {
         System.out.println(x);
     }

     //dynamic programming with choices for answer
      int[] choices = dpChoices(arr,n,dp);
       choicesTravers(choices,7);
    }
   static int recursive(int[] p,int n)
   {
       if(n<=0)return 0;
       int q= Integer.MIN_VALUE;
       for(int i=1;i<=n;i++)
       {
          q= Math.max(q,p[i-1]+recursive(p,n-i)) ;

       }

       return q;
   }

   static int memo(int [] p,int n,int [] memo)
   {
       if(n<=0)return 0;

       if(memo[n]>0)return memo[n];

       int q= Integer.MIN_VALUE;
       for(int i=1;i<=n;i++)
       {
           q= Math.max(q,p[i-1]+memo(p,n-i,memo));

       }
       memo[n]=q;
       System.out.println(n+ "  " + q);
       return memo[n];
   }

   static int dynamicProgramming(int [] p,int n,int [] r)
   {
      if(n<=0)return 0;

      for(int i=1;i<=n;i++)
      {
          int q= Integer.MIN_VALUE;
          for(int j=1;j<=i;j++)
          {
              q= Math.max(q,p[j-1]+r[i-j]);
          }
          r[i]=q;
      }
       return r[n];
   }

   static int[] dpChoices(int[] p, int n, int[] r)
   {
      int[] choices  = new int[n+1];



       for(int i=1;i<=n;i++)
       {
           int q= Integer.MIN_VALUE;
           for(int j=1;j<=i;j++)
           {
               if(q<p[j-1]+r[i-j])
               {
                   q=p[j-1]+r[i-j];
                   choices[i]=j;
               }
           }
           r[i]=q;
       }

      return choices;



   }
   static void choicesTravers(int [] choices,int n)
   {
       while(n>0)
       {
           System.out.print(" "+choices[n]);
           n=n-choices[n];
       }
   }
}
