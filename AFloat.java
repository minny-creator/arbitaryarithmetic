package com.project1;


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
        this.AFloat=a;
    }


    public AFloat addAFloat(AFloat a,AFloat b){
        
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
            if(a1.AInteger[0]=="-"){a.AFloat="-0.0";a1.AInteger=a1.AInteger.substring(1);}
            else a.AFloat="0.";
            a.AFloat=a.AFloat+a1.AInteger;            
        }
        else if(a1.AInteger.length()>d-k_d-1){
            a.AFloat=a1.substring(0,a1.AInteger.length()-(d-k_d-1));
            a.AFloat=a.AFloat+".";
            a.AFloat=a.AFloat+a1.substring(a1.AInteger.length()-(d-k_d-1));
        }
        else{
            if(a1.AInteger[0]=="-"){a.AFloat="-0.";a1.AInteger=a.AInteger.substring(1);}
            else a.AFloat="0.";
            for(i=1;i<=((d-k_d-1)-a.AInteger.length());i++){
                a1.AInteger="0"+a1.AInteger;
            }
            a.AFloat=a.AFloat+a1.AInteger;
        }
        return a;
       
    }


    public AFloat mulAFloat(AFloat a,AFloat b){

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
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i;
        int k=0;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                k=k+1;
                break;
            }
        }
        AInteger a1=new AInteger();
        AInteger a2=new AInteger();
        if (i!=(d-1)){
            a1.AInteger=(a.AFloat.substring(0,i));
            a2.AInteger=(a.AFloat.substring(i+1,d));
        }
        else{
            if(k==1){
                a1.AInteger=(a.AFloat.substring(0,i));
                a2.AInteger="0";
            }
            else{
                a1.AInteger=(a.AFloat.substring(0,i+1));
                a2.AInteger="0";
            }
        }
        d=a2.AInteger.length();
        k=0;
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i, i+1).equals(".")){
                k=k+1;
                break;
            }
        }
        AInteger b1=new AInteger();
        AInteger b2=new AInteger();
        if (i!=(e-1)){
            b1.AInteger=(b.AFloat.substring(0,i));
            b2.AInteger=(b.AFloat.substring(i+1,e));
        }
        else{
            if(k==1){
                b1.AInteger=(b.AFloat.substring(0,i));
                b2.AInteger="0";
            }
            else{
                b1.AInteger=(b.AFloat.substring(0,i+1));
                b2.AInteger="0";
            }
        }
        e=b2.AInteger.length();
        if(d>(e+30)){
            int x=(d-e-30);
            for (i=0;i<x;i++){
                b2.AInteger=b2.AInteger+"0";
            }
        }
        else{
            int x=(e+30-d);
            if(x!=0){
                for(i=0;i<x;i++){
                    a2.AInteger=a2.AInteger+"0";
                }
            }
        }
        a1.AInteger=a1.AInteger+a2.AInteger;
        b1.AInteger=b1.AInteger+b2.AInteger;
        a1=a1.divAIntegers(a1, b1);
        d=a1.AInteger.length();
        a.AFloat=a1.AInteger.substring(0,(d-30))+"."+a1.AInteger.substring((d-30),d);
        return a;
    }






                                                                                           

}

