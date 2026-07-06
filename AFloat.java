package com.project1;

import java.util.regex.Pattern;

public class AFloat{
    String AFloat;


    public AFloat(){
        this.AFloat="0.0";
    }


    public AFloat parse(String a){
        AFloat b = new AFloat(a);
        return b;
    }


    public AFloat(String a){
        if (a == null || a.isEmpty()) {
            throw new NumberFormatException("Invalid float value: " + a);
        }
        int i;
        if(a.substring(0,1).equals("+") || a.substring(0,1).equals("-"))i=1;
        else i=0;
        int dot=0;
        int num=0;
        for(;i<a.length();i++){
            if(a.substring(i,i+1).equals(".")){
                dot=1;
                break;
            }
            else if(!Pattern.matches("[0-9]", a.substring(i,i+1))){
                throw new IllegalArgumentException("Invalid float value!!!");
            }
            else{
                num=1;
            }
        }
        if(i==a.length() || i==a.length()-1){
            if(num==0){
                throw new NumberFormatException("Invalid float value: " + a);
            }
            if(dot==1){
                a=a+"0";
            }
            else{
                a=a+".0";
                System.out.println("Entered expected with a: " + a + "\n");
            }
        }
        else{
            if(num==0){
                a=a.substring(0,i)+"0"+a.substring(i);
                i=i+1;
            }
        
        for(i=i+1;i<a.length();i++){
            if(!Pattern.matches("[0-9]", a.substring(i,i+1))){
                throw new IllegalArgumentException("Invalid float value!!!");
            }
            else{
                num=1;
            }
        }
        if(num==0){
            throw new NumberFormatException("Invalid float value: " + a);
        }
    }
        // if(a.substring(0,1).equals("+") || a.substring(0,1).equals("-")){
        //     i=0;
        //     String sign=a.substring(0, 1);
        //     a=a.substring(1);
        //     while(i>=0 && i<a.length()){
        //     if(a.substring(i,i+1).equals("0")){
        //         a=a.substring(i+1);
        //     }
        //     else if(a.substring(i,i+1).equals(".")){
        //         a="0"+a;
        //         break;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // i=a.length()-1;
        // while(i>=0 && i<a.length()){
        //     if(a.substring(i,i+1).equals("0")){
        //         a=a.substring(0,i);
        //     }
        //     else if(a.substring(i,i+1).equals(".")){
        //         a=a+"0";
        //         break;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // a=sign+a;
        // }
        // else {
        //     i=0;
        //     while(i>=0 && i<a.length()){
        //     if(a.substring(i,i+1).equals("0")){
        //         a=a.substring(i+1);
        //     }
        //     else if(a.substring(i,i+1).equals(".")){
        //         a="0"+a;
        //         break;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // i=a.length()-1;
        // while(i>=0 && i<a.length()-1){
        //     if(a.substring(i,i+1).equals("0")){
        //         a=a.substring(0,i);
        //     }
        //     else if(a.substring(i,i+1).equals(".")){
        //         a=a+"0";
        //         break;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // }
        this.AFloat=a;
    }


    public AFloat addAFloat(AFloat a,AFloat b){
        
        if(a.AFloat.substring(0,1).equals("-") && !b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(b1.AFloat.substring(0,1).equals("+"))b1.AFloat=b1.AFloat.substring(1);
            a1.AFloat=a1.AFloat.substring(1);
            return subAFloat(b1,a1);
        }
        else if(a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            AFloat x=addAFloat(a1,b1);
            x.AFloat="-"+x.AFloat;
            return x;
        }
        else if(!a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(a1.AFloat.substring(0,1).equals("+"))a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            return subAFloat(a1,b1);
        }
        AFloat a2=new AFloat(a.AFloat);
        AFloat b2=new AFloat(b.AFloat);
        if(a.AFloat.substring(0, 1).equals("+")){
            a.AFloat=a.AFloat.substring(1);
        }
        if(b.AFloat.substring(0, 1).equals("+")){
            b.AFloat=b.AFloat.substring(1);
        }
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i;
        int k_d=0;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                k_d=i;
                break;
            }
        }
        int k_e=0;
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i,i+1).equals(".")){
                k_e=i;
                break;
            }
        }
        AInteger a1,b1;
        if(d-k_d>e-k_e){
            for(i=1;i<=(d-k_d-(e-k_e));i++){
                b.AFloat=b.AFloat+"0";
            }
            a1 = new AInteger(a.AFloat.substring(0,k_d));
            b1 = new AInteger(b.AFloat.substring(0,k_d));
            a1.AInteger=a1.AInteger+a.AFloat.substring(k_d+1);
            b1.AInteger=b1.AInteger+b.AFloat.substring(k_d+1);
        }
        else{
            for(i=1;i<=e-k_e-(d-k_d);i++){
                a.AFloat=a.AFloat+"0";
            }
            a1 = new AInteger(a.AFloat.substring(0,k_e));
            b1 = new AInteger(b.AFloat.substring(0,k_e));
            a1.AInteger=a1.AInteger+a.AFloat.substring(k_e+1);
            b1.AInteger=b1.AInteger+b.AFloat.substring(k_e+1);
            k_d=k_e;
            d=e;
        }
        a1 = a1.addAIntegers(a1,b1);
        //d-k_d-1
        a.AFloat="";
        a.AFloat=a.AFloat+a1.AInteger.substring(0,a1.AInteger.length()-(d-k_d-1));
        a.AFloat=a.AFloat+".";
        a.AFloat=a.AFloat+a1.AInteger.substring(a1.AInteger.length()-(d-k_d-1));
        AFloat result=new AFloat(a.AFloat);
        a.AFloat=a2.AFloat;
        b.AFloat=b2.AFloat;
        return result;
    }


    public AFloat subAFloat(AFloat a,AFloat b){
        
        if(a.AFloat.substring(0,1).equals("-") && !b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(b1.AFloat.substring(0,1).equals("+"))b1.AFloat=b1.AFloat.substring(1);
            a1.AFloat=a1.AFloat.substring(1);
            AFloat x=addAFloat(a1,b1);
            x.AFloat="-"+x.AFloat;
            return x;
        }
        else if(a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            return subAFloat(b1,a1);
        }
        else if(!a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(a1.AFloat.substring(0,1).equals("+"))a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            return addAFloat(a1,b1);
        }
        AFloat a2=new AFloat(a.AFloat);
        AFloat b2=new AFloat(b.AFloat);
        if(a.AFloat.substring(0, 1).equals("+")){
            a.AFloat=a.AFloat.substring(1);
        }
        if(b.AFloat.substring(0, 1).equals("+")){
            b.AFloat=b.AFloat.substring(1);
        }
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i;
        int k_d=0;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                k_d=i;
                break;
            }
        }
        int k_e=0;
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i,i+1).equals(".")){
                k_e=i;
                break;
            }
        }
        AInteger a1,b1;
        if(d-k_d>e-k_e){
            for(i=1;i<=(d-k_d-(e-k_e));i++){
                b.AFloat=b.AFloat+"0";
            }
            a1 = new AInteger(a.AFloat.substring(0,k_d));
            b1 = new AInteger(b.AFloat.substring(0,k_d));
            a1.AInteger=a1.AInteger+a.AFloat.substring(k_d+1);
            b1.AInteger=b1.AInteger+b.AFloat.substring(k_d+1);
        }
        else{
            for(i=1;i<=e-k_e-(d-k_d);i++){
                a.AFloat=a.AFloat+"0";
            }
            a1 = new AInteger(a.AFloat.substring(0,k_e));
            b1 = new AInteger(b.AFloat.substring(0,k_e));
            a1.AInteger=a1.AInteger+a.AFloat.substring(k_e+1);
            b1.AInteger=b1.AInteger+b.AFloat.substring(k_e+1);
            k_d=k_e;
            d=e;
        }
        a1 = a1.subAIntegers(a1,b1);
        //d-k_d-1
        if(a1.AInteger.length()==d-k_d-1){
            if(a1.AInteger.substring(0,1).equals("-")){a.AFloat="-0.0";a1.AInteger=a1.AInteger.substring(1);}
            else a.AFloat="0.";
            a.AFloat=a.AFloat+a1.AInteger;            
        }
        else if(a1.AInteger.length()>d-k_d-1){
            if(a1.AInteger.length()==(d-k_d) && a1.AInteger.substring(0,1).equals("-")){a.AFloat="-0.";a1.AInteger=a1.AInteger.substring(1);
                a.AFloat=a.AFloat+a1.AInteger;
            }
            else{
            a.AFloat=a1.AInteger.substring(0,a1.AInteger.length()-(d-k_d-1));
            a.AFloat=a.AFloat+".";
            a.AFloat=a.AFloat+a1.AInteger.substring(a1.AInteger.length()-(d-k_d-1));
        }
        }
        else{
            if(a1.AInteger.substring(0,1).equals("-")){a.AFloat="-0.";a1.AInteger=a1.AInteger.substring(1);}
            else a.AFloat="0.";
            for(i=1;i<=((d-k_d-1)-a1.AInteger.length());i++){
                a1.AInteger="0"+a1.AInteger;
            }
            a.AFloat=a.AFloat+a1.AInteger;
        }
        AFloat result=new AFloat(a.AFloat);
        a.AFloat=a2.AFloat;
        b.AFloat=b2.AFloat;
        return result;
    }


    public AFloat mulAFloat(AFloat a,AFloat b){
        
        if(a.AFloat.substring(0,1).equals("-") && !b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(b1.AFloat.substring(0,1).equals("+"))b1.AFloat=b1.AFloat.substring(1);
            a1.AFloat=a1.AFloat.substring(1);
            AFloat x=mulAFloat(a1,b1);
            x.AFloat="-"+x.AFloat;
            return x;
        }
        else if(a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            return mulAFloat(a1,b1);
        }
        else if(!a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(a1.AFloat.substring(0,1).equals("+"))a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            AFloat x=mulAFloat(a1,b1);
            x.AFloat="-"+x.AFloat;
            return x;
        }
        int i;
        AFloat a2=new AFloat(a.AFloat);
        AFloat b2=new AFloat(b.AFloat);
        if(a.AFloat.substring(0, 1).equals("+")){
            a.AFloat=a.AFloat.substring(1);
        }
        if(b.AFloat.substring(0, 1).equals("+")){
            b.AFloat=b.AFloat.substring(1);
        }
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int k_d=0;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                k_d=i;
                break;
            }
        }
        int k_e=0;
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i,i+1).equals(".")){
                k_e=i;
                break;
            }
        }
        AInteger a1 = new AInteger(a.AFloat.substring(0,k_d));
        AInteger b1 = new AInteger(b.AFloat.substring(0,k_e));
        a1.AInteger=a1.AInteger+a.AFloat.substring(k_d+1);
        b1.AInteger=b1.AInteger+b.AFloat.substring(k_e+1);
        a1 = a1.mulAIntegers(a1,b1);
        //d-k_d-1+e-k_e-1=total numbers after "."
        a.AFloat=a1.AInteger.substring(0,a1.AInteger.length()-(d-k_d-1+e-k_e-1));
        a.AFloat=a.AFloat+".";
        a.AFloat=a.AFloat+a1.AInteger.substring(a1.AInteger.length()-(d-k_d-1+e-k_e-1));
        AFloat result=new AFloat(a.AFloat);
        a.AFloat=a2.AFloat;
        b.AFloat=b2.AFloat;
        return result;   
    }


    public AFloat divAFloat(AFloat a,AFloat b,int num){
        int i;
        if(b.AFloat.substring(0,1).equals("+") || b.AFloat.substring(0,1).equals("-"))i=1;
        else i=0;
        while(i<b.AFloat.length()){
            if(!b.AFloat.substring(i,i+1).equals("0") && !b.AFloat.substring(i,i+1).equals("."))break;
            else i++;
        }
        if(i==b.AFloat.length()){
            throw new ArithmeticException("Division By Zero!!!");
        }
        if(a.AFloat.substring(0,1).equals("-") && !b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(b1.AFloat.substring(0,1).equals("+"))b1.AFloat=b1.AFloat.substring(1);
            a1.AFloat=a1.AFloat.substring(1);
            AFloat x=divAFloat(a1,b1);
            x.AFloat="-"+x.AFloat;
            return x;
        }
        else if(a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            return divAFloat(a1,b1);
        }
        else if(!a.AFloat.substring(0,1).equals("-") && b.AFloat.substring(0,1).equals("-")){
            AFloat a1=new AFloat(a.AFloat);
            AFloat b1=new AFloat(b.AFloat);
            if(a1.AFloat.substring(0,1).equals("+"))a1.AFloat=a1.AFloat.substring(1);
            b1.AFloat=b1.AFloat.substring(1);
            AFloat x=divAFloat(a1,b1);
            x.AFloat="-"+x.AFloat;
            return x;
        }
        AFloat a3=new AFloat(a.AFloat);
        AFloat b3=new AFloat(b.AFloat);
        if(a.AFloat.substring(0, 1).equals("+")){
            a.AFloat=a.AFloat.substring(1);
        }
        if(b.AFloat.substring(0, 1).equals("+")){
            b.AFloat=b.AFloat.substring(1);
        }
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int k_d=0;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                k_d=i;
                break;
            }
        }
        int k_e=0;
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i,i+1).equals(".")){
                k_e=i;
                break;
            }
        }
        AInteger a1 = new AInteger(a.AFloat.substring(0,k_d));
        AInteger b1 = new AInteger(b.AFloat.substring(0,k_e));
        a1.AInteger=a1.AInteger+a.AFloat.substring(k_d+1);
        b1.AInteger=b1.AInteger+b.AFloat.substring(k_e+1);
        if(d-k_d>e-k_e){
            for(i=1;i<=(d-k_d)-(e-k_e);i++){
                b1.AInteger=b1.AInteger+"0";
            }
        }
        else{
            for(i=1;i<=-(d-k_d)+(e-k_e);i++){
                a1.AInteger=a1.AInteger+"0";
            }
        }
        AInteger a2 = a1.divAIntegers(a1,b1);
        //d-k_d-1-(e-k_e-1)=total numbers after "."
        a.AFloat=a2.AInteger.substring(0,a2.AInteger.length());
        a.AFloat=a.AFloat+".";
        a1=a1.subAIntegers(a1,a2.mulAIntegers(a2,b1));
        i=0;
        while(!a1.AInteger.equals("0")){
            i++;
            a1.AInteger=a1.AInteger+"0";
            a2=a1.divAIntegers(a1,b1);
            a.AFloat=a.AFloat+a2.AInteger;
            a1=a1.subAIntegers(a1,a2.mulAIntegers(a2,b1));
            if(i==num)break;
        }
        AFloat result =new AFloat(a.AFloat);
        a.AFloat=a3.AFloat;
        b.AFloat=b3.AFloat;
        return result;
    }
}

