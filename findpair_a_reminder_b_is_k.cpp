/******************************************************************************

                              Online C++ Debugger.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Debug" button to debug it.

*******************************************************************************/
//https://www.geeksforgeeks.org/find-pairs-b-array-b-k/
#include <iostream>
#include <vector>
#include <cmath>
#include <unordered_map>
using namespace std;

vector<int> find(int n){
    int count =0;
    vector<int>res;
    for (int i=1;i<sqrt(n);i++)
    {
        if(n%i==0){
        if(n/i==i){
         res.push_back(i);   
        }
        else{
            res.push_back(i);
            res.push_back(n/i);
        }
    }
    }
    return res;
}

int main()
{ 
    vector<int> input= { 3, 1, 2, 5, 4 }; 
    int k =2;
    vector<int> res;
    unordered_map<int ,bool>map1;
    for (auto el: input)
    {
        map1[el]=true;
    }
    vector<pair<int,int>> finalres;
    for(int i=0; i< input.size();i++){
            res= find(input[i]-k);
            for(auto ele: res)
            {
                if(map1.find(ele)!=map1.end() && input[i]!=ele){
                    finalres.push_back({input[i],ele});
                }
            }
    }
    //all output
    for(int i =0;i<finalres.size();i++)
    {
        cout<<finalres[i].first<<", "<<finalres[i].second<<endl;
    }
    return 0;
}
