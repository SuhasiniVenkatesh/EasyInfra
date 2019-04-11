/*
	Name		: 	filter.cpp
	author		:	Abhilash.S, Sangna.H.S
	Input(s)	:	Absolute Path to the directory containing the image, the name of the image
	Output(s)	:	3 images (Red,green & yellow filtered)
	Description	:	Given a colored image of a junction, returns the filtered images(red, green, yellow)
	Argc		:	3
	Args		:	Absolute Path to the directory containing the image, the name of the image
	
	Example		: ./filter /home/abhi/phantomjs-master/workspace 2016-01-27_11:51:44.png 

*/

#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <iostream>
#include <string>

using namespace std;
using namespace cv;

Mat redFilter(const Mat& src)
{
    assert(src.type() == CV_8UC3);

    Mat redOnly;
    inRange(src, Scalar(0, 0, 0), Scalar(31, 23, 255), redOnly);

    return redOnly;
}

Mat yellowFilter(const Mat& src)
{
    assert(src.type() == CV_8UC3);

    Mat yellowOnly;
    inRange(src, Scalar(0,100,200), Scalar(50, 170, 255), yellowOnly);

    return yellowOnly;
}

Mat greenFilter(const Mat& src)
{
    assert(src.type() == CV_8UC3);

    Mat greenOnly;
    inRange(src, Scalar(0, 75, 0), Scalar(80,255,132), greenOnly);

    return greenOnly;
}

int main(int argc,char **argv)
{

	string nameOnly = argv[2];	
	
	string img = argv[1];
	img.append("/");
	img.append(argv[2]);
	//cout<<img<<"\n";
    Mat input = imread(img);
    
    Mat redOnly = redFilter(input);
    Mat yellowOnly = yellowFilter(input);
    Mat greenOnly = greenFilter(input); 
    
	string red = argv[1];
	red.append("/");
	red.append(nameOnly.substr(0,19));
	red.append("-red.png");
	
	string yellow = argv[1];
	yellow.append("/");
	yellow.append(nameOnly.substr(0,19));
	yellow.append("-yellow.png");
	
	string green = argv[1];
	green.append("/");
	green.append(nameOnly.substr(0,19));
	green.append("-green.png");
	//cout<<red<<"\n"<<yellow<<"\n"<<green<<"\n";
    
    imwrite(red,redOnly);
    imwrite(yellow,yellowOnly);
    imwrite(green,greenOnly);
    
    return 0;
}

