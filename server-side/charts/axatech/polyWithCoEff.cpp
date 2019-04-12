/*
	Name		: 	polyWithCoEff.cpp
	author		:	Abhilash.S
	Input(s)	:	The file containing traffic density values (Y-axis file), The corresponding minPlot file, the name of the coEff file
	Output(s)	:	The predicted (Polynomial fitted traffic density values) values in a file & the fitted polynomial co-efficients in 						another file
	Description	:	Given the files mentioned in input, the program fits a polynomial of degree 6 and returns the Y values for the 						corresponding X values (minPlot file values). It also generates a file with the name provided as 3rd argument tothe 					program, which contains the value of coEfficients of the polynomial that was fitted for the data. Note: It is required 						to redirect the output using the redirect operator " > " into a file according to the naming principles. An example is 						shown for the same below
	Argc		:	3
	Args		:	The file containing traffic density values (Y-axis file), The corresponding minPlot file, the name of the coEff file
	
	Example		: 	./polyWithCoEff 2016-04-08-silkboard-red.txt 2016-04-08-minPlot.txt 2016-04-08-silkboard-red-coEff.txt > 						2016-04-08-silkboard-red-predicted.txt

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
  	return lines;
}

int main(int argc, char* argv[])
{
	const int NP = countlines(argv[1]);	//No of given data points
	const int M = NP;	//no of computed data points
	//NC = argv[3];
	
	//double x[] = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0};
	//double y[] = {0.0,3.0,6.0,8.0,12.0,21.0,43.0,66.0};
	
	//start of reading files
	
	fstream myfile (argv[1],std::ios_base::in);// Traffic density - y axis
	fstream myfile2 (argv[2],std::ios_base::in);//date - x axis
	double in,in2,x[NP],y[NP];
	int i;
	
	for(i=0;i<NP;i++){
		myfile >> in;
		y[i] = in;
		
		myfile2 >> in2;
		x[i] = in2;
	}	
		
	//end of reading files
	
	double coeff[NC];	//vector of coefficients
	//int i;
	//double xc[M];	//computed values for x using polynomial
	double yc[M];
	
	//printf("Program finds the best fit polynomial of the degree : %d",NC-1);
	//printf("Data Points (x,y): \n");
	//for(i=0;i<NP;i++)
	//	printf("%f %f \n",x[i],y[i]);
		
	polynomialfit(NP,NC,x,y,coeff);	//find coefficients
	//printf("\n\n\n Co-efficients of the polynomial found\n");
	//for(i=0;i<NC;i++)
		//printf("%1f\n",coeff[i]);
		
	ofstream coEfffile;
  	coEfffile.open (argv[3],ios::app);
  	for(i=0;i<NC;i++)
	{
		coEfffile << coeff[i] << "\n";
	}
  	coEfffile.close();
		
	//Evaluate the fitted polynomial
	//linspace(xc,0.0,7.0,M);
	//double xc[M] = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0,16.0,17.0,18.0,19.0,20.0,21.0,22.0,23.0,24.0,25.0,26.0,27.0,28.0,29.0};
	polyval(coeff,x,yc,NC,M);
	//printf("\n Data points calculated with the polynomial\n");
	for(i=0;i<M;i++)
		printf("%+.18f \n",yc[i]); //prints only y values
		//printf("%.1f,%+.18f \n",x[i],yc[i]); // print new x & y values
		
		
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
