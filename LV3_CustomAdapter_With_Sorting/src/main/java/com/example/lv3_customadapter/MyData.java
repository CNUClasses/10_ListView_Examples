package com.example.lv3_customadapter;
import java.util.Comparator;

public  class MyData{
	String name;
	boolean isPlanet;
	public MyData(String name,boolean isPlanet )
	{
	    this.name = name;
	    this.isPlanet = isPlanet;
	}
	public MyData(String name)
	{
	    this(name,true );
	}

}

/**
 * @author lynn
 * if both planets or both not then they are equal return 0
 * otherwise 
 */
class MyDataIsPlanetComparator implements Comparator<MyData> {
    public int compare(MyData myData1, MyData myData2) {
	//if both equal then 0
	if(myData1.isPlanet == myData2.isPlanet)
	    return 0;
	//not the same
	return(myData1.isPlanet)?1:-1;
    }   
}

class MyDataNameUPComparator implements Comparator<MyData> {
    public int compare(MyData myData1, MyData myData2) {	
	return (myData1.name.compareTo(myData2.name));
    }   
}
class MyDataNameDOWNComparator implements Comparator<MyData> {
    public int compare(MyData myData1, MyData myData2) {	
	return (myData2.name.compareTo(myData1.name));
    }   
}