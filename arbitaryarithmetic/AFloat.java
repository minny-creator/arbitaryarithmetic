package com.project1;


public class AFloat{
    String AFloat;


    public AFloat(){
        this.AFloat="0";
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
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                break;
            }
        }
        AInteger a1=new AInteger(a.AFloat.substring(0,i));
        AInteger a2=new AInteger(a.AFloat.substring(i+1,d));
        int d2=a2.AInteger.length();
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i, i+1).equals(".")){
                break;
            }
        }
        AInteger b1=new AInteger(b.AFloat.substring(0,i));
        AInteger b2=new AInteger(b.AFloat.substring(i+1,e));
        int e2=b2.AInteger.length();
        if(d2>e2){
            int j=(d2-e2);
            for(i=0;i<j;i++){
                b2.AInteger=b2.AInteger+"0";
            }
            i=d2;
        }
        else{
            int j=(e2-d2);
            if(j!=0){
                for(i=0;i<j;i++){
                    a2.AInteger=a2.AInteger+"0";
                }
            }
            i=e2;
        }
        a1.AInteger=a1.AInteger+a2.AInteger;
        b1.AInteger=b1.AInteger+b2.AInteger;
        a2=a1.addAIntegers(a1,b1);
        int e3=a2.AInteger.length();
        int d3=(e3-i);
        a.AFloat=a2.AInteger.substring(0,d3)+"."+a2.AInteger.substring(d3,e3);
        return a;
    }


    public AFloat subAFloat(AFloat a,AFloat b){
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                break;
            }
        }
        AInteger a1=new AInteger(a.AFloat.substring(0,i));
        AInteger a2=new AInteger(a.AFloat.substring(i+1,d));
        int d2=a2.AInteger.length();
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i, i+1).equals(".")){
                break;
            }
        }
        AInteger b1=new AInteger(b.AFloat.substring(0,i));
        AInteger b2=new AInteger(b.AFloat.substring(i+1,e));
        int e2=b2.AInteger.length();
        if(d2>e2){
            int j=(d2-e2);
            for(i=0;i<j;i++){
                b2.AInteger=b2.AInteger+"0";
            }
            i=d2;
        }
        else{
            int j=(e2-d2);
            if(j!=0){
                for(i=0;i<j;i++){
                    a2.AInteger=a2.AInteger+"0";
                }
            }
            i=e2;
        }
        a1.AInteger=a1.AInteger+a2.AInteger;
        b1.AInteger=b1.AInteger+b2.AInteger;
        a2=a1.subAIntegers(a1,b1);
        e=a2.AInteger.length();
        d=(e-i);
        a.AFloat=a2.AInteger.substring(0,d)+"."+a2.AInteger.substring(d,e);
        return a;
    }


    public AFloat mulAFloat(AFloat a,AFloat b){
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                break;
            }
        }
        AInteger a1=new AInteger();
        a1.AInteger=a.AFloat.substring(0,i)+a.AFloat.substring(i+1,d);
        i=(d-i-1);
        int j;
        for(j=0;j<d;j++){
            if(b.AFloat.substring(i,i+1).equals(".")){
                break;
            }
        }
        AInteger b1=new AInteger();
        b1.AInteger=b.AFloat.substring(0,j)+b.AFloat.substring(j+1,e);
        j=(e-j-1);
        a1=a1.mulAIntegers(a1, b1);
        d=a1.AInteger.length();
        a.AFloat=a1.AInteger.substring(0,(d-i-j))+"."+a1.AInteger.substring((d-i-j),d);
        return a;
    }


    public AFloat divAFloat(AFloat a,AFloat b){
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i;
        for(i=0;i<d;i++){
            if(a.AFloat.substring(i,i+1).equals(".")){
                break;
            }
        }
        AInteger a1=new AInteger(a.AFloat.substring(0,i));
        AInteger a2=new AInteger(a.AFloat.substring(i+1,d));
        for(i=0;i<e;i++){
            if(b.AFloat.substring(i,i+1).equals(".")){
                break;
            }
        }
        AInteger b1=new AInteger(b.AFloat.substring(0,i));
        AInteger b2=new AInteger(b.AFloat.substring(i+1,e));
        d=a2.AInteger.length();
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

