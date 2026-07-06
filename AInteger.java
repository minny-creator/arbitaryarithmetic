package com.project1;
import java.util.regex.Pattern;


public class AInteger{
    String AInteger;

    public AInteger(){
        this.AInteger = "0" ;
    }

    public AInteger parse(String a){
        AInteger b=new AInteger(a);
        return b;
    }

    public AInteger(String A){
        if(A.isEmpty()){
            throw new NumberFormatException("Invalid float value: " + A);
        }
        int i;
        if(A.substring(0,1).equals("+") || A.substring(0,1).equals("-")){
            i=1;
        }
        else i=0;
        int num=0;
        for(;i<A.length();i++){
            if(!Pattern.matches("[0-9]", A.substring(i,i+1))){
                throw new IllegalArgumentException("Invalid Integer value!!!");
            }
            else{
                num=1;
            }
        }
        if(num==0){
            throw new NumberFormatException("Invalid float value: " + A);
        }
    //     if(A.substring(0,1).equals("+") || A.substring(0,1).equals("-")){
    //         i=0;
    //         String sign=A.substring(0, 1);
    //         A=A.substring(1);
    //         while(i<A.length()){
    //         if(A.substring(i,i+1).equals("0")){
    //             A=A.substring(i+1);
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     A=sign+A;
    //     }
    //     else {i=0;
    //     while(i<A.length()){
    //         if(A.substring(i,i+1).equals("0")){
    //             A=A.substring(i+1);
    //         }
    //         else{
    //             break;
    //         }
    //     }
    // }
    // if(A.length()==0){
    //     A="0";
    // }
    // else if(A.length()==1){
    //     A=A+"0";
    // }
        this.AInteger = A;
    }
//function to tell whether a is greater or not.
    public boolean func(String a,String b){
        if(a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            a=a.substring(1);
            b=b.substring(1);
            return func(b,a);
        }
        else if(a.substring(0,1).equals("-") && !b.substring(0,1).equals("-")){
            return false;
        }
        else if(!a.substring(0,1).equals("-") && b.substring(0,1).equals("-")){
            b=b.substring(1);
            if(a.substring(0,1).equals("+"))a=a.substring(1);
            int k=0;
            for(int i=0;i<a.length();i++){
                if(!a.substring(i,i+1).equals("0")){k=1;break;}
            }
            if(k!=0)return true;
            else{
                for(int i=0;i<b.length();i++){
                    if(!b.substring(i,i+1).equals("0")){k=1;break;}
                }
                if(k!=0)return true;
                else return false;
            }
        }
        while(a.length()!=0){
            if(a.substring(0,1).equals("0")){
                a=a.substring(1);
            }
            else break;
        }
        while(b.length()!=0){
            if(b.substring(0,1).equals("0")){
                b=b.substring(1);
            }
            else break;
        }
        if(a.length()==0)a="0";
        if(b.length()==0)b="0";
        int d=a.length();
        int e=b.length();
        if(d<e){
            return false;
        }
        else if(d>e){
            return true;
        }
        else{
            int i;
            d=d-1;
            for(i=0;i<=d;i++){
                if(Integer.parseInt(a.substring(i,i+1))>Integer.parseInt(b.substring(i,i+1))){
                    return true;
                }
                else if(Integer.parseInt(a.substring(i,i+1))<Integer.parseInt(b.substring(i,i+1))){
                    return false;
                }
            }
            return false;
        }
    }


    public AInteger addAIntegers(AInteger a,AInteger b){
        if(a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            b1.AInteger=b1.AInteger.substring(1);
            AInteger x=addAIntegers(a1,b1);
            x.AInteger="-"+x.AInteger;
            return x;
        }
        else if(a.AInteger.substring(0,1).equals("-") && !b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            if(b1.AInteger.substring(0,1).equals("+"))b1.AInteger=b1.AInteger.substring(1);
            return subAIntegers(b1,a1);
        }
        else if(!a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            b1.AInteger=b1.AInteger.substring(1);
            if(a1.AInteger.substring(0,1).equals("+"))a1.AInteger=a1.AInteger.substring(1);
            return subAIntegers(a1,b1);
        }
        AInteger a3=new AInteger(a.AInteger);
        AInteger b3=new AInteger(b.AInteger);
        if(a.AInteger.substring(0,1).equals("+")){
            a.AInteger=a.AInteger.substring(1);
        }
        if(b.AInteger.substring(0,1).equals("+")){
            b.AInteger=b.AInteger.substring(1);
        }
        while(a.AInteger.length()!=0){
            if(a.AInteger.substring(0,1).equals("0")){
                a.AInteger=a.AInteger.substring(1);
            }
            else break;
        }
        while(b.AInteger.length()!=0){
            if(b.AInteger.substring(0,1).equals("0")){
                b.AInteger=b.AInteger.substring(1);
            }
            else break;
        }
        if(a.AInteger.length()==0)a.AInteger="0";
        if(b.AInteger.length()==0)b.AInteger="0";
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        int x,f;
        if(d>=e){
            x=d-e;
            f=d-1;
                for(int i=1;i<=x;i++){
                    b.AInteger="0"+b.AInteger;
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
        a.AInteger=a3.AInteger;
        b.AInteger=b3.AInteger;
        return adAInt;
    }


    public AInteger subAIntegers(AInteger a,AInteger b){
        if(a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            b1.AInteger=b1.AInteger.substring(1);
            return subAIntegers(b1,a1);
        }
        else if(a.AInteger.substring(0,1).equals("-") && !b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            if(b1.AInteger.substring(0,1).equals("+"))b1.AInteger=b1.AInteger.substring(1);
            AInteger x=addAIntegers(a1,b1);
            x.AInteger="-"+x.AInteger;
            return x;
        }
        else if(!a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            b1.AInteger=b1.AInteger.substring(1);
            if(a1.AInteger.substring(0,1).equals("+"))a1.AInteger=a1.AInteger.substring(1);
            return addAIntegers(a1,b1);
        }
        AInteger a3=new AInteger(a.AInteger);
        AInteger b3=new AInteger(b.AInteger);
        if(a.AInteger.substring(0,1).equals("+")){
            a.AInteger=a.AInteger.substring(1);
        }
        if(b.AInteger.substring(0,1).equals("+")){
            b.AInteger=b.AInteger.substring(1);
        }
        while(a.AInteger.length()!=0){
            if(a.AInteger.substring(0,1).equals("0")){
                a.AInteger=a.AInteger.substring(1);
            }
            else break;
        }
        while(b.AInteger.length()!=0){
            if(b.AInteger.substring(0,1).equals("0")){
                b.AInteger=b.AInteger.substring(1);
            }
            else break;
        }
        if(a.AInteger.length()==0)a.AInteger="0";
        if(b.AInteger.length()==0)b.AInteger="0";
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if (d>e || (d==e && func(a.AInteger,b.AInteger))){
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
            while(subAInt.AInteger.substring(0,1).equals("0")){subAInt.AInteger=subAInt.AInteger.substring(1);}
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
            return subAInt;
        }
        else if(d<e || (d==e && func(b.AInteger,a.AInteger))){
            AInteger c = subAIntegers(b, a);
            while(c.AInteger.substring(0,1).equals("0")){c.AInteger=c.AInteger.substring(1);}
            c.AInteger = "-" + c.AInteger;
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
            return c;
        }
        else{
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
            AInteger x=new AInteger();
            return x;
        }
        
    }


    public AInteger mulAIntegers(AInteger a,AInteger b){
        if(a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            b1.AInteger=b1.AInteger.substring(1);
            return mulAIntegers(a1,b1);
        }
        else if(a.AInteger.substring(0,1).equals("-") && !b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            if(b1.AInteger.substring(0,1).equals("+"))b1.AInteger=b1.AInteger.substring(1);
            AInteger x=mulAIntegers(a1,b1);
            x.AInteger="-"+x.AInteger;
            return x;
        }
        else if(!a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            b1.AInteger=b1.AInteger.substring(1);
            if(a1.AInteger.substring(0,1).equals("+"))a1.AInteger=a1.AInteger.substring(1);
            AInteger x=mulAIntegers(a1,b1);
            x.AInteger="-"+x.AInteger;
            return x;
        }
        AInteger a3=new AInteger(a.AInteger);
        AInteger b3=new AInteger(b.AInteger);
        if(a.AInteger.substring(0,1).equals("+")){
            a.AInteger=a.AInteger.substring(1);
        }
        if(b.AInteger.substring(0,1).equals("+")){
            b.AInteger=b.AInteger.substring(1);
        }
        while(a.AInteger.length()!=0){
            if(a.AInteger.substring(0,1).equals("0")){
                a.AInteger=a.AInteger.substring(1);
            }
            else break;
        }
        while(b.AInteger.length()!=0){
            if(b.AInteger.substring(0,1).equals("0")){
                b.AInteger=b.AInteger.substring(1);
            }
            else break;
        }
        if(a.AInteger.length()==0)a.AInteger="0";
        if(b.AInteger.length()==0)b.AInteger="0";
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
                int k=(e-i);
            
                for(int j=1;j<=k;j++){
                    res.AInteger=res.AInteger+"0";
                }
                result=addAIntegers(res,result);
            }
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
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
                int k=(d-i);
                for(int j=1;j<=k;j++){
                    res.AInteger=res.AInteger+"0";
                }
                result=addAIntegers(res,result);
            }
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
            return result;
        
        }
    }


    public AInteger divAIntegers(AInteger a,AInteger b){
        int i;
        if(b.AInteger.substring(0,1).equals("+") || b.AInteger.substring(0,1).equals("-")){
            i=1;
        }
        else i=0;
        while(i<b.AInteger.length()){
            if(!b.AInteger.substring(i,i+1).equals("0"))break;
            else i++;
        }
        if(i==b.AInteger.length()){
            throw new ArithmeticException("Division By Zero!!!");
        }
        if(a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            b1.AInteger=b1.AInteger.substring(1);
            return divAIntegers(a1,b1);
        }
        else if(a.AInteger.substring(0,1).equals("-") && !b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            a1.AInteger=a1.AInteger.substring(1);
            if(b1.AInteger.substring(0,1).equals("+"))b1.AInteger=b1.AInteger.substring(1);
            AInteger x=divAIntegers(a1,b1);
            x.AInteger="-"+x.AInteger;
            return x;
        }
        else if(!a.AInteger.substring(0,1).equals("-") && b.AInteger.substring(0,1).equals("-")){
            AInteger a1=new AInteger(a.AInteger);
            AInteger b1=new AInteger(b.AInteger);
            b1.AInteger=b1.AInteger.substring(1);
            if(a1.AInteger.substring(0,1).equals("+"))a1.AInteger=a1.AInteger.substring(1);
            AInteger x=divAIntegers(a1,b1);
            x.AInteger="-"+x.AInteger;
            return x;
        }
        AInteger a3=new AInteger(a.AInteger);
        AInteger b3=new AInteger(b.AInteger);
        if(a.AInteger.substring(0,1).equals("+")){
            a.AInteger=a.AInteger.substring(1);
        }
        if(b.AInteger.substring(0,1).equals("+")){
            b.AInteger=b.AInteger.substring(1);
        }
        while(a.AInteger.length()!=0){
            if(a.AInteger.substring(0,1).equals("0")){
                a.AInteger=a.AInteger.substring(1);
            }
            else break;
        }
        while(b.AInteger.length()!=0){
            if(b.AInteger.substring(0,1).equals("0")){
                b.AInteger=b.AInteger.substring(1);
            }
            else break;
        }
        if(a.AInteger.length()==0)a.AInteger="0";
        if(b.AInteger.length()==0)b.AInteger="0";
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if((d-e)>0){
            int x=(d-e-1);
            AInteger b1=new AInteger(b.AInteger);
            AInteger result = new AInteger("1");
            for(i=0;i<x;i++){
                b1.AInteger=b1.AInteger+"0";
                result.AInteger=result.AInteger+"0";
            }
            //a=subAIntegers(a, b1);
            //d=a.AInteger.length();
            AInteger res1=new AInteger();
            res1.AInteger=b1.AInteger;
            for(i=1;i>=0;i++){
                
                if(func(res1.AInteger,a.AInteger)) {
                    res1=subAIntegers(res1,b1);
                    result.AInteger = result.AInteger.substring(1);
                    result.AInteger=Integer.toString(i-1)+result.AInteger;
                    a=subAIntegers(a,res1);
                    result=addAIntegers(result,divAIntegers(a,b));
                    a.AInteger=a3.AInteger;
                    b.AInteger=b3.AInteger;
                    return result;
                    
                }
                else if(!func(res1.AInteger,a.AInteger) && !func(a.AInteger,res1.AInteger)){
                    result.AInteger = result.AInteger.substring(1);
                    result.AInteger=Integer.toString(i)+result.AInteger;
                    a.AInteger=a3.AInteger;
                    b.AInteger=b3.AInteger;
                    return result;
                }
                res1=addAIntegers(res1,b1);    
            }
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
            return result;

        }
        else if(d<e){
            AInteger res=new AInteger("0");
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
            return res;
        }
        else{
            AInteger res = new AInteger();
            for(i=1;i>=0;i++){
                res.AInteger = Integer.toString(i);
                AInteger res1 =mulAIntegers(res, b);
        
                if(func(res1.AInteger,a.AInteger)){
                    res.AInteger = Integer.toString(i-1);
                    break;
                }
            }
            a.AInteger=a3.AInteger;
            b.AInteger=b3.AInteger;
            return res;    

        }
    }
    
}
