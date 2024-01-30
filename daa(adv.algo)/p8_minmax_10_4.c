#include <stdio.h>
#include <conio.h>
 
int main()
{
    int a[1000],i,n,min,max;
    printf("Enter the size of the array : ");
    scanf("%d",&n);
    printf("Enter the elements in array : ");
    for(i=0; i<n; i++)
    {
        scanf("%d",&a[i]);
    }

    // INITIALLY CHOOSE 1st element 
    min=max=a[0];

    for(i=1; i<n; i++)
    {
        if(min>a[i])
		    min=a[i];   
		if(max<a[i])
		    max=a[i];       
    }
    printf("minimum element of array is : %d",min);
    printf("\nmaximum element of array is : %d",max);
    return 0;
}