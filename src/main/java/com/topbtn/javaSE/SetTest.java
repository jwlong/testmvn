package com.topbtn.javaSE;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by longjinwen on 2017/3/14.
 */
public class SetTest extends TestCase {
    @Test
    public void test1(){
        Set<Element> set = new HashSet<Element>();
        Element e1 = new Element(1);
        Element e2 = new Element(2);
        Element e3 = new Element(3);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println("before changed");
        printSet(set);
        e1.setValue(2);
        System.out.println(e1.equals(e2));
        System.out.println("after changed");
        printSet(set);
    }
    public  void printSet(Set set){
        Iterator it = set.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
    }
class Element
{
    private int value;
    public Element(int value)
    {
        this.value = value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public int getValue()
    {
        return this.value;
    }
    @Override
    public String toString()
    {
        return "" + this.value;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this ==(Element)obj)
            return true;
        if (!(obj instanceof Element))
        {
            return false;
        }
        if (((Element) obj).getValue() == this.getValue())
        {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode()
    {
        return 37 + this.value;
    }
}

