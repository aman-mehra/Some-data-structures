#include<iostream>
#include<bits/stdc++.h>
#define int unsigned long long
using namespace std;
void buildSegment(int arr[],int seg[],int c,int l,int r)
{
    if(l==r)
        seg[c]=arr[l];
    else
    {
        int mid=(l+r)/2;
        buildSegment(arr,seg,2*c+1,l,mid);
        buildSegment(arr,seg,2*c+2,mid+1,r);
        seg[c]=seg[2*c+1]+seg[2*c+2];
    }
}
int rangesum(int seg[],int c,int l,int r,int x,int y)
{
    if(l>y || r<x)
        return 0;
    else if (x<=l && y>=r)
        {return seg[c];cout<<"abhi"<<endl;}
    else
    {
        //cout<<"new"<<x<<" "<<y<<endl;
        //cout<<l<<" "<<r<<endl;
        int mid = (l+r)/2;
        return rangesum(seg,2*c+1,l,mid,x,y)+rangesum(seg,2*c+2,mid+1,r,x,y);
    }
}
signed main()
{
    int n,m;
}
