/*
	Name		: 	percent.cpp
	author		:	Abhilash.S, Sangna.H.S
	Input(s)	:	name of a filtered image, filename where the output is to be written [optional]
	Output(s)	:	percentage value of the filtered color in the image
	Description	:	Given a color filtered image returns the percentage value of that color in the image
	Argc		:	3
	Args		:	name of a filtered image, filename where the output is to be written [optional]
	
	Example		: 	percent 2016-01-27_11\:49\:48-red.png

*/

#include<opencv2/core/core.hpp>
#include<opencv2/opencv.hpp>
#include<opencv2/objdetect/objdetect.hpp>
#include<opencv2/highgui/highgui.hpp>
#include<opencv2/imgproc/imgproc.hpp>

#include <iostream>
#include<fstream>

using namespace std;
using namespace cv;

float calculate_percent(Mat input)
{
	int count_black = 0;
    int count_white = 0;
	float total=0.0;
 	float black_total;
    float white_total;
    float percentage_black;
    float percentage_white;
    float percentage;
                    
    for( int y = 0; y < input.rows; y++ ) 
    {
     	for( int x = 0; x < input.cols; x++ ) 
        {
        	if ( input.at<cv::Vec3b>(y,x) == cv::Vec3b(0,0,0) ) 
            {
            	count_black++;
              	black_total = count_black +count_black;
            } 
                     	  
     		if ( input.at<cv::Vec3b>(y,x) == cv::Vec3b(255,255,255) ) 
           	{
           		count_white++;
           		white_total = count_white + count_white;
            }
       	}

   	}
		   
	total = black_total+white_total;
	percentage_white = white_total/total*100;
   	percentage_black = black_total/total*100;
  	
  	percentage = (percentage_white * 100)/(4.28025);
  	
  	return percentage;
}

int main(int argc, char** argv)
{
    Mat img = imread(argv[1]);
   	float percent;
    percent = calculate_percent(img);
    
    cout<<percent<<"\n";
    //ofstream myfile;
  	//myfile.open (argv[2],ios::app);
  	//myfile << percent;
  	//myfile << "\n";
  	//myfile.close();
    
    
    
}
