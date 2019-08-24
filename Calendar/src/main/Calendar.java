package main;

public class Calendar
{
    //Starting from 1753 to infinity (we might not be living till (2^31-1)th year)
    public final static int REFERENCE_YEAR = 1753;
    public final static int WEEK_DAYS = 7;
    
    public static int getStartDay(int month, int year)
    {
        int range = year-REFERENCE_YEAR+1; 
        int startDay = 0;
        
        startDay += (year-REFERENCE_YEAR);
        
        // for(int i=1753;i<year;i++)
        //     if(checkLeap(i))
        //         startDay+=1;
        
        startDay = (startDay + ( ((range/4)%WEEK_DAYS) + ((range/400)%WEEK_DAYS) - ((range/100)%WEEK_DAYS)) )%WEEK_DAYS;
        
        for(int i=1;i<month;i++)
        {  
            startDay=(startDay+numDays(i, year))%WEEK_DAYS;
        }
        
        return startDay==0 ? WEEK_DAYS:startDay;
    }
    
    public static boolean checkLeap(int year)
    {
        if(year%4==0 && (year%100!=0 || year%400==0))
        {
            return true;
        }
        // if((year%4==0 && year%100!=0) || (year%4==0 && year%100==0 && year%400==0))
        // {
        //     return true;
        // } 
        return false;
    }
    
    public static int numDays(int month, int year)
    {
        int days=30;
                
        if( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
        {
            days=31;
        }

        else if(month == 2 && checkLeap(year))
        {
            days=29;
        }

        else if(month == 2 && !checkLeap(year))
        {
            days=28;
        }

        return days;
    }
}
