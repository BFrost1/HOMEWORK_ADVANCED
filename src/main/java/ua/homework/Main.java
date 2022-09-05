package ua.homework;

import java.util.ArrayList;
import java.util.List;

import ua.homework.entity.Cat;
import ua.homework.entity.DomesticCat;
import ua.homework.entity.ShowCat;
import ua.homework.entity.YardCat;
import ua.homework.factory.FreshCatFarchFactory;


public class Main 
{
    public static void main( String[] args )
    {
    	List<Cat> list = new ArrayList<Cat>();
    	list.add(new DomesticCat("DomesticCat", 5));
    	list.add(new ShowCat("ShowCat", 7));
    	list.add(new YardCat("YardCat", 3));
    	new FreshCatFarchFactory().produceMincedMeat(list);
    }
}
