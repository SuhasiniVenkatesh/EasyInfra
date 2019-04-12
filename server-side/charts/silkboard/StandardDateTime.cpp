/*
	Name		: 	StandardDateTime.cpp
	author		:	Abhilash.S
	Input(s)	:	--No Inputs--
	Output(s)	:	The time values in seconds ranging from 0 - 86340 with a difference of 60 seconds
	Description	:	Generates time values in seconds ranging from 0 - 86340 with a difference of 60 seconds. Note: It is required 						to redirect the output using the redirect operator " > " into a file according to the naming principles. An example is 						shown for the same below
	Argc		:	0
	Args		:	--
	
	Example		: 	./StandardDateTime > standardDateTime.txt

*/

#include<iostream>
using namespace std;

int main()
{
	int sum=0,count=0;
	
	cout<<sum<<endl;
	while(sum!=86400){
		
		sum+=60;
		cout<<sum<<endl;
		count++;
	}

}
