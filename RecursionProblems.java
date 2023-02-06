import java.lang.Thread.State;

public class RecursionProblems {

    public static int TillingProblem(int n ){
        if (n==0||n==1){
            return 1;
        }
        int fnm1 = TillingProblem(n-1);
        int fnm2 = TillingProblem(n-2);
        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void UniqueCharscteres(String str, int idx, StringBuilder newStr , boolean map[]){
        if(idx == str.length()) {
          System.out.println(newStr);
          return;
       }
        char currChar = str.charAt(idx);
         if(map[currChar -'a'] == true) {
            UniqueCharscteres(str, idx+1, newStr , map);
       }else {
          map[currChar-'a']=true;
         UniqueCharscteres(str, idx+1, newStr.append(currChar), map);
       }
    }

    public static int PairingProblem(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        int fnm1 = PairingProblem(n-1);
        int fnm2 = PairingProblem(n-2);
        int PairingWays =  n-1 * fnm2;
        int totalWays = fnm1 + PairingWays;
        return totalWays;
        
    }
    
    public static int PairingProblemOptimised(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        else{
        return PairingProblemOptimised(n-1) + (n - 1) * PairingProblemOptimised(n - 2);
      } 
    }

    public static void BinaryStrings(int n, int LastPlace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        BinaryStrings(n-1 , 0 , str + "0");
        if(LastPlace == 0){
            BinaryStrings(n-1, 1 , str + "1");
        }
        
        
    }

    public static void HanoiTower(int n , char src , char dest , char help){
        if( n== 1 ){
            System.out.println("Move disk"+n+" from "+ src + " to "+ dest);
            return;
        }
        HanoiTower(n-1, src, help, dest);
        System.out.println("Move disk" + n +" from "+ src+ " to "+ dest );
        HanoiTower(n-1, help, dest, src);
        
    }

    public static void MergeSort(int arr[] , int si , int ei ){
        if(si>=  ei){
            return;
        }
        int mid = si +(ei - si)/2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1 , ei);
        merge(arr , si , mid , ei);
    }

    public static void merge(int arr[], int si , int mid , int ei){
        int temp[] = new int[ei-si+1];
        int i = si; 
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; 
            }else{
                temp[k] = arr[j];
                j++; 

                
            }
            k++;
        }
        //for leftover elements in 1st part
        while(i <= mid){       
            temp[k++] = arr[i++];
        }
        //for leftoverpart in 2nd part
        while(j <= ei){
            temp[k++] = arr[j++];

        }
        //copy temp to original array
        for(k = 0, i = si; k<temp.length; k++, i++){
           arr[i] = temp[k];
        }

    }
    public static void Printarr(int arr[] ){
           for(int i=0; i<=arr.length; i++){
           System.out.print(arr[i] + " ");
           }
           System.out.println();

    }
    public static void QuickSort(int arr[] , int si, int ei ){
        if(si >= ei){
            return;
        }
        int pIdx=Partition(arr,si,ei);
        QuickSort(arr, si, pIdx-1);
        QuickSort(arr, pIdx+1, ei);

    }
    public static int Partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;

        for(int j=si; j<ei ;j++ ){
            if(arr[j]<= pivot){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }

    public static int Search(int arr[], int tar, int si, int ei){
        if(si>ei){
            return -1;
        }


        //work   
        int mid = si + (ei-si)/2;

        //found case
        if(arr[mid] == tar){
            return mid;
        }
        //mid L1
        if(arr[si] <= arr[mid]){
            //CASE a :left
            if(arr[si] <= tar && tar <= arr[ei]){
                return Search(arr, tar, si, ei);
            }else {
                //case b : right
                return Search(arr, tar, mid+1, ei);
            }
        }
        //mid on L2
        else{
            //case c : right
            if(arr[mid] <= tar && tar <= arr[ei]){
                return Search(arr, tar, mid+1, ei);

            }else{
                //case D: Left
                return Search(arr, tar, si, mid-1);
            }

        }
        }
        









    
    public static void main(String args[]) {
       HanoiTower(7, 'a', 'c', 'b'); } 
       
}
