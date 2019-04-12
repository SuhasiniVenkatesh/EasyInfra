/*
	Name		: 	predictorPoly.cpp
	author		:	Abhilash.S
	Input(s)	:	standardDateTime.txt [contains values of time in seconds (0 - 86340) for one day with a difference of 60 seconds], 						coEff.txt [contains the coefficients of the polynomial]
	Output(s)	:	Y [Traffic density] values for the given X data [standardDateTime.txt] using the coefficients for polynomial from 						coEff.txt
	Description	:	Given the files mentioned in input, the program returns the Y values for the corresponding X values						(standardDateTime.txt values).Note: It is required to redirect the output using the redirect operator " > " into a file according to the naming principles. An example is shown for the same below.
	Argc		:	2
	Args		:	standardDateTime.txt, coEff.txt
	
	Example		: 	./predictorPoly standardDateTime.txt coEff.txt >standardTraffic.txt

*/

#include<iostream>
#include<fstream>
using namespace std;

#include<stdio.h>
#include<gsl/gsl_poly.h>
#include "polifitgsl.h"
#define NC 6 //Size of coefficient vector or desired degree of poly
//int NC;
void polyval(double p[],double xv[],double yv[],int n,int m);

int countlines(char *filename)
{
  	// count the number of lines in the file called filename                                    
  	FILE *fp = fopen(filename,"r");
  	int ch=0;
  	int lines=0;

  	if (fp == NULL)
  		return 0;

 	while(!feof(fp))
	{
  		ch = fgetc(fp);
  		if(ch == '\n')
  			lines++;
	}
  	
  	fclose(fp);
  	//cout<<lines;
  	return lines;
}

int main(int argc, char* argv[])
{
	const int NP = countlines(argv[1]);	//No of given data points
	const int M = NP;	//no of computed data points
	//NC = argv[3];
	
	
	//start of reading files
	
	fstream myfile (argv[1],std::ios_base::in);// standard time - x-axis
	fstream myfile2 (argv[2],std::ios_base::in);// coeff [avg] to generate poly
	double in,in2,x[NP],y[NP];
	int i;
	double coeff[NC];	//vector of coefficients
	double yc[M];
	
	for(i=0;i<NP;i++){
		myfile >> in;
		x[i] = in;
	}
	
	for(i=0;i<NC;i++){
		myfile2 >> in2;
		coeff[i] = in2;
	}	
		
		
	//end of reading files
	
	polyval(coeff,x,yc,NC,M);
	//printf("\n Data points calculated with the polynomial\n");
	for(i=0;i<M;i++)
		printf("%+.18f \n",yc[i]); 
		
		
	return 0;
}

void polyval(double p[],double xv[],double yv[],int n,int m){
	int j;
	
	yv[0]=gsl_poly_eval(p,n,xv[0]);
	
	for(j=1;j<m;j++){
		yv[j]=gsl_poly_eval(p,n,xv[j]);
	}
	
	return;
}
