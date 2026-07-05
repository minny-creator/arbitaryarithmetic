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
            }
        }
        else{
            if(num==0){
                a=a.substring(0,i)+"0"+a.substring(i);
            }
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
        this.AFloat=a;
    }


    public AFloat addAFloat(AFloat a,AFloat b){
        
        if(a.substring(0,1).equals("-") && !b.substring(0,1).equals("-")){
            a=a.substring(1);
            return subAFloat(b,a);
        }
        else if(a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            a=a.substring(1);
            b=b.substring(1);
            return "-"+addAFloat(a,b);
        }
        else if(!a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            b=b.substring(1);
            return subAFloat(a,b);
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
            a1 = new AInteger(a.substring(0,k_d));
            b1 = new AInteger(b.substring(0,k_d));
            a1.AInteger=a1.AInteger+a.substring(k_d+1);
            b1.AInteger=b1.AInteger+b.substring(k_d+1);
        }
        else{
            for(i=1;i<=e-k_e-(d-k_d);i++){
                a.AFloat=a.AFloat+"0";
            }
            a1 = new AInteger(a.substring(0,k_e));
            b1 = new AInteger(b.substring(0,k_e));
            a1.AInteger=a1.AInteger+a.substring(k_e+1);
            b1.AInteger=b1.AInteger+b.substring(k_e+1);
            k_d=k_e;
            d=e;
        }
        a1 = addAIntegers(a1,b1);
        //d-k_d-1
        a.AFloat="";
        a.AFloat=a.AFloat+a1.substring(0,a1.AInteger.length()-(d-k_d-1));
        a.AFloat=a.AFloat+".";
        a.AFloat=a.AFloat+a1.substring(a1.AInteger.length()-(d-k_d-1));
        return a;
    }


    public AFloat subAFloat(AFloat a,AFloat b){
        
        if(a.substring(0,1).equals("-") && !b.substring(0,1).equals("-")){
            a=a.substring(1);
            return "-"+addAFloat(b,a);
        }
        else if(a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            a=a.substring(1);
            b=b.substring(1);
            return subAFloat(b,a);
        }
        else if(!a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            b=b.substring(1)
            return addAFloat(a,b);
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
            a1 = new AInteger(a.substring(0,k_d));
            b1 = new AInteger(b.substring(0,k_d));
            a1.AInteger=a1.AInteger+a.substring(k_d+1);
            b1.AInteger=b1.AInteger+b.substring(k_d+1);
        }
        else{
            for(i=1;i<=e-k_e-(d-k_d);i++){
                a.AFloat=a.AFloat+"0";
            }
            a1 = new AInteger(a.substring(0,k_e));
            b1 = new AInteger(b.substring(0,k_e));
            a1.AInteger=a1.AInteger+a.substring(k_e+1);
            b1.AInteger=b1.AInteger+b.substring(k_e+1);
            k_d=k_e;
            d=e;
        }
        a1 = subAIntegers(a1,b1);
        //d-k_d-1
        if(a1.AInteger.length()==d-k_d-1){
            if(a1.AInteger.substring(0,1).equals("-")){a.AFloat="-0.0";a1.AInteger=a1.AInteger.substring(1);}
            else a.AFloat="0.";
            a.AFloat=a.AFloat+a1.AInteger;            
        }
        else if(a1.AInteger.length()>d-k_d-1){
            a.AFloat=a1.substring(0,a1.AInteger.length()-(d-k_d-1));
            a.AFloat=a.AFloat+".";
            a.AFloat=a.AFloat+a1.substring(a1.AInteger.length()-(d-k_d-1));
        }
        else{
            if(a1.AInteger.substring(0,1).equals("-")){a.AFloat="-0.";a1.AInteger=a.AInteger.substring(1);}
            else a.AFloat="0.";
            for(i=1;i<=((d-k_d-1)-a.AInteger.length());i++){
                a1.AInteger="0"+a1.AInteger;
            }
            a.AFloat=a.AFloat+a1.AInteger;
        }
        return a;
    }


    public AFloat mulAFloat(AFloat a,AFloat b){
        
        if(a.substring(0,1).equals("-") && !b.substring(0,1).equals("-")){
            a=a.substring(1);
            return "-"+mulAFloat(b,a);
        }
        else if(a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            a=a.substring(1);
            b=b.substring(1);
            return mulAFloat(a,b);
        }
        else if(!a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            b=b.substring(1);
            return "-"+mulAFloat(a,b);
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
        AInteger a1 = new AInteger(a.substring(0,k_d));
        AInteger b1 = new AInteger(b.substring(0,k_e));
        a1.AInteger=a1.AInteger+a.substring(k_d+1);
        b1.AInteger=b1.AInteger+b.substring(k_e+1);
        a1 = mulAIntegers(a1,b1);
        //d-k_d-1+e-k_e-1=total numbers after "."
        a.AFloat=a1.substring(0,a1.AInteger.length()-d-k_d-1+e-k_e-1);
        a.AFloat=a.AFloat+".";
        a.AFloat=a.AFloat+a1.substring(a1.AInteger.length()-d-k_d-1+e-k_e-1);
        return a;   
    }


    public AFloat divAFloat(AFloat a,AFloat b){
        
        if(a.substring(0,1).equals("-") && !b.substring(0,1).equals("-")){
            a=a.substring(1);
            return "-"+divAFloat(a,b);
        }
        else if(a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            a=a.substring(1);
            b=b.substring(1);
            return divAFloat(a,b);
        }
        else if(!a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            b=b.substring(1);
            return "-"+divAFloat(a,b);
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
        AInteger a1 = new AInteger(a.substring(0,k_d));
        AInteger b1 = new AInteger(b.substring(0,k_e));
        a1.AInteger=a1.AInteger+a.substring(k_d+1);
        b1.AInteger=b1.AInteger+b.substring(k_e+1);
        AInteger a2 = divAIntegers(a1,b1);
        //d-k_d-1-(e-k_e-1)=total numbers after "."
        if(d-k_d-1>e-k_e-1){
            a.AFloat=a1.substring(0,a1.AInteger.length()-(d-k_d-1-(e-k_e-1)));
            a.AFloat=a.AFloat+".";
            a.AFloat=a.AFloat+a1.substring(a1.AInteger.length()-(d-k_d-1-(e-k_e-1)));
        }
        else if(d-k_d-1==e-k_e-1){
            a.AFloat=a1.substring(0,a1.AInteger.length()+d-k_d-1-(e-k_e-1));
            a.AFloat=a.AFloat+".";
        }
        else{
            a.AFloat=a1.substring(0,a1.AInteger.length()+d-k_d-1-(e-k_e-1));
            a.AFloat=a.AFloat+".";
            a.AFloat=a.AFloat+a1.substring(a1.AInteger.length()+d-k_d-1-(e-k_e-1));
        }
        a1=divAIntegers(a1,mulAIntegers(a2,b1));
        while(a1.AInteger!="0"){
            a1.AInteger=a1.AInteger+"0";
            a2=divAIntegers(a1,b1);
            a.AFloat=a.AFloat+a2.AInteger;
            a1=divAIntegers(a1,mulAIntegers(a2,b1));
        }
        return a;
    }
}

