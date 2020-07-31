public class pl extends RecursiveAction{
private final int[] array;
private final int[] helper;
private final int low;
private final int high;
public pl(final int[] array,final int low,final int high){
this.array=array;
Helper=new int[array.length];
this.low=low;
this.high=high;
void compute(){
if(low<high){
final int middle=(low+high)/2;
final ParallelMergeSort left=new ParallelMergeSort(array,low,middle);
final ParallelMergeSort right=newParallelMergeSort(array,middle+1,high);
invokeAll(left,right);
merge(array,helper,low,middle,high);
}
}
}
}