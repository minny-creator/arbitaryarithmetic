package com.project1;



public class AInteger{
    String AInteger;

    public AInteger(){
        this.AInteger = "0" ;
    }

    public AInteger parse(String a){
        AInteger b=new AInteger(a);
        return b;
    }

    public AInteger(String AInteger){
        this.AInteger = AInteger;
    }

    public boolean func(String a,String b){
        int d=a.length();
        int e=b.length();
        if(d<e){
            return false;
        }
        else if(d>e){
            return true;
        }
        else{
            int i,j=0;
            d=d-1;
            for(i=d;i>=0;i--){
                if(Integer.parseInt(a.substring(i,i+1))>Integer.parseInt(b.substring(i,i+1))){
                    break;
                }
                else if(Integer.parseInt(a.substring(i,i+1))==Integer.parseInt(b.substring(i,i+1))){
                    j=j+1;
                }
            }
            if(i==(j+1)){
                return true;
            }
            else{
                return false;
            }

        }
    }


    public AInteger addAIntegers(AInteger a,AInteger b){
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        int x,f;
        if(d>=e){
            x=d-e;
            f=d-1;
            if(x!=0){
                for(int i=1;i<=x;i++){
                    b.AInteger="0"+b.AInteger;
                }
            }
        }
        else{
            x=e-d;
            f=e-1;
            for(int i=1;i<=x;i++){
                a.AInteger="0"+a.AInteger;
            }
        }
        int l=0;
        String add="";
        for(int i=f;i>=0;i--){
            int k=Integer.parseInt(a.AInteger.substring(i,i+1))+Integer.parseInt(b.AInteger.substring(i,i+1))+l;
            l=k/10;
            add=Integer.toString(k%10)+add;
        }
        if(l!=0){
            add=Integer.toString(l)+add;
        }
        AInteger adAInt = new AInteger(add);
        return adAInt;
    }


    public AInteger subAIntegers(AInteger a,AInteger b){
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if (d>=e){
            int x=d-e;
            if(x!=0){
                for(int i=1;i<=x;i++){
                    b.AInteger="0"+b.AInteger;
                }
            }
            int l=0;
            String sub="";
            d=d-1;
            for(int i=d;i>=0;i--){
                int k=Integer.parseInt(a.AInteger.substring(i,i+1))-Integer.parseInt(b.AInteger.substring(i,i+1))-l;
                if (k<0 && i!=0){
                    k=10+k;
                    l=1;
                }
                else{
                    l=0;
                }
                sub=Integer.toString(k)+sub;
            }
            AInteger subAInt = new AInteger(sub);
            return subAInt;
        }
        else {
            AInteger c = subAIntegers(b, a);
            c.AInteger = "-" + c.AInteger;
            return c;
        }
        
        
        
    }


    public AInteger mulAIntegers(AInteger a,AInteger b){
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if(d>e){
            String x=b.AInteger;
            e=e-1;
            AInteger result=new AInteger();
            AInteger res=new AInteger();
            for(int i=0;i<=e;i++){
                int y=Integer.parseInt(x.substring(i,i+1));
                res.AInteger="0";
                for(int j=0;j<y;j++){
                    res=addAIntegers(a, res);
                }
                if (i!=e){
                    int k=(e-i);
                
                    for(int j=1;j<=k;j++){
                        res.AInteger=res.AInteger+"0";
                    }
                }
                result=addAIntegers(res,result);
            }
            return result;
        }
        else{
            String x=a.AInteger;
            d=d-1;
            AInteger result=new AInteger();
            AInteger res=new AInteger();
            for(int i=0;i<=d;i++){
                int y=Integer.parseInt(x.substring(i,i+1));
                res.AInteger="0";
                for(int j=0;j<y;j++){
                    res=addAIntegers(b, res);
                }
                if (i!=d){
                    int k=(d-i);
                    for(int j=1;j<=k;j++){
                        res.AInteger=res.AInteger+"0";
                    }
                }
                result=addAIntegers(res,result);
            }
            return result;
        }

    }


    public AInteger divAIntegers(AInteger a,AInteger b){
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if((d-e-1)>0){
            int x=(d-e-1);
            AInteger b1=new AInteger(b.AInteger);
            for(int i=0;i<x;i++){
                b1.AInteger=b1.AInteger+"0";
            }
            a=subAIntegers(a, b1);
            d=a.AInteger.length();
            AInteger res1=new AInteger();
            for(int i=1;i>=0;i++){
                res1.AInteger = Integer.toString(i);
                AInteger res3 = mulAIntegers(res1, b);
                if(func(res3.AInteger,a.AInteger)) {
                    res1.AInteger = Integer.toString(i-1);
                    AInteger res2 = new AInteger("1");
                    for(int j=0;j<x;j++){
                        res2.AInteger = res2.AInteger + "0";

                    }
                    res1 = addAIntegers(res1, res2);
                    break;
                    
                }
                
            }
            return res1;

        }
        else if(d<e){
            AInteger res=new AInteger("0");
            return res;
        }
        else{
            AInteger res = new AInteger();
            for(int i=1;i>=0;i++){
                res.AInteger = Integer.toString(i);
                AInteger res1 =mulAIntegers(res, b);
        
                if(func(res1.AInteger,a.AInteger)){
                    res.AInteger = Integer.toString(i-1);
                    break;
                }
            }
            return res;
        

        }
    }


}