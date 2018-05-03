package dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DiceRoller
{
    //fields
    
    //methods
    public DiceRoller()
    {
    }
    
    public int rollDie(int type)
    {
        return (int)(Math.random()*type)+1;
    }
    
    public int[] rollDice(int type, int amount)
    {
        int[] result = new int[amount];
        for(int x = 0; x <= amount-1; x++)
        {
            result[x] = rollDie(type);
        }
        return result; //returns int array of all dice results, with final value being their sum.
    }
    
    public int[] rollExplodeDie(int type)
    {
        int x = 0;
        List<Integer> temp = new ArrayList<>();
        int[] result;
        int size = 0;
        int tempTemp;
        
        while(x == 0)
        {
            tempTemp = rollDie(type);
            if(tempTemp == type)
            {
                temp.add(tempTemp);
            }
            else
            {
                temp.add(tempTemp);
                x++;
            }
            size++;
        }
        result = new int[size];
        for(int i = 0; i <= result.length-1; i++)
        {
            result[i] = temp.get(i);
        }
        return result;
    }

    public int[][] rollExplodeDice(int type, int amount)
    {
        List<int[]> result = new ArrayList<>();
        for(int x = 0; x <= amount-1; x++)
        {
            result.add(rollExplodeDie(type));
        }
        int[][] res2 = new int[result.size()][];
        
        res2 = result.toArray(res2);
        return res2;
    }
    
    public int rollAdvantageDie(int type)
    {
        int[] result = new int[2];
        result[0] = rollDie(type);
        result[1] = rollDie(type);
        if(result[0] > result[1])
        {
            return result[0];
        }
        else
        {
            return result[1];
        }
    }
    
    public int rollDisadvantageDie(int type)
    {
        int[] result = new int[2];
        result[0] = rollDie(type);
        result[1] = rollDie(type);
        if(result[0] < result[1])
        {
            return result[0];
        }
        else
        {
            return result[1];
        }
    }
    
    public int[] rollAdvantageDice(int type, int amount)
    {
        int[] result = new int[amount];
        
        for(int x = 0; x <= result.length-1; x++)
        {
            result[x] = rollAdvantageDie(type);
        }
        
        return result;
    }
    
    public int[] rollDisadvantageDice(int type, int amount)
    {
        int[] result = new int[amount];
        
        for(int x = 0; x <= result.length-1; x++)
        {
            result[x] = rollDisadvantageDie(type);
        }
        
        return result;
    }
    
    public String ExplodeDiceString(int[][] result)
    {
        String result3 = "";
        
        for (int[] result1 : result)
        {
            result3 += Arrays.toString(result1) + " ";
        }
        return result3;
    }
    
    public int sumResultsOne(int[] result)
    {
        int sum = 0;
        for(int x = 0; x <= result.length-1; x++)
        {
            sum += result[x];
        }
        return sum;
    }
    
    public int sumResultsTwo(int[][] result)
    {
        int sum = 0;
        for(int x = 0; x <= result.length-1; x++)
        {
            sum += sumResultsOne(result[x]);
        }
        return sum;
    }
}
