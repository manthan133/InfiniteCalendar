/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Manthan's
 */
public class Calendar 
{
    
    public static int getFactor(int month,int year)
    {
        int factor=1;
        
        factor+=(year-1753);
        
        for(int i=1753;i<year;i++)
            if(checkLeap(i))
                factor+=1;
        
        for(int i=1;i<month;i++)  
            factor+=numDays(i,year)%7;
        
        return factor%7==0?7:factor%7;
    }
    
    
    public static boolean checkLeap(int year)
    {
        if((year%4==0 && year%100!=0) || (year%4==0 && year%100==0 && year%400==0))
            return true;   
        else 
            return false;
    }
    
    public static int numDays(int month,int year)
    {
        int days=30;
                
        if( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
            days=31;
        
        else if( month == 2 && checkLeap(year))
            days=29;
            
        else if(month == 2 && !checkLeap(year))
            days=28;
         
        return days;
    }
}
