package arbitaryarithmetic;



public class AInteger{
    String AInteger;

    public AInteger(){
        AInteger = "0" ;
    }

    public AInteger parse(String a){
        AInteger b=new AInteger(a);
        return b;
    }

    public AInteger(String AInteger){
        this.AInteger = AInteger;
    }


    public AInteger addAIntegers(AInteger a,AInteger b){
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if (d>e){
            int x=d-e;
            for(int i=1;i<=x;i++){
                b.AInteger="0"+b.AInteger;
            }
            int l=0;
            String add="";
            int f=d-1;
            for(int i=f;i>=0;i--){
                int k=Integer.parseInt(a.AInteger.substring(i,i+1))+Integer.parseInt(b.AInteger.substring(i,i+1))+l;
                l=k/10;
                add=Integer.toString(k%10)+add;
            }
            add=Integer.toString(l)+add;
            AInteger adAInt = new AInteger(add);
            return adAInt;
        }
        else if (d<e){
            int x=e-d;
            for(int i=1;i<=x;i++){
                a.AInteger="0"+a.AInteger;
            }
            int l=0;
            String add="";
            int f=e-1;
            for(int i=f;i>=0;i--){
                int k=Integer.parseInt(a.AInteger.substring(i,i+1))+Integer.parseInt(b.AInteger.substring(i,i+1))+l;
                l=k/10;
                add=Integer.toString(k%10)+add;
            }
            add=Integer.toString(l)+add;
            AInteger adAInt = new AInteger(add);
            return adAInt; 
        }
        else {
            int l=0;
            String add="";
            int f=d-1;
            for(int i=f;i>=0;i--){
                int k=Integer.parseInt(a.AInteger.substring(i,i+1))+Integer.parseInt(b.AInteger.substring(i,i+1))+l;
                l=k/10;
                add=Integer.toString(k%10)+add;
            }
            add=Integer.toString(l)+add;
            AInteger adAInt = new AInteger(add);
            return adAInt; 
        }
        



    }


    public AInteger subAIntegers(AInteger a,AInteger b){
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if (d>e){
            int x=d-e;
            for(int i=1;i<=x;i++){
                b.AInteger="0"+b.AInteger;
            }
            int l=0;
            String sub="";
            int f=d-1;
            for(int i=f;i>=0;i--){
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
            AInteger adAInt = new AInteger(sub);
            return adAInt;
        }
        else if (d<e){
            int x=e-d;
            for(int i=1;i<=x;i++){
                a.AInteger="0"+a.AInteger;
            }
            int l=0;
            String sub="";
            int f=e-1;
            for(int i=f;i>=0;i--){
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
            AInteger adAInt = new AInteger(sub);
            return adAInt; 
        }
        else {
            int l=0;
            String sub="";
            int f=d-1;
            for(int i=f;i>=0;i--){
                int k=Integer.parseInt(a.AInteger.substring(i,i+1))-Integer.parseInt(b.AInteger.substring(i,i+1))-l;
                if(k<0&&i!=0){
                    k=10+k;
                    l=1;
                }
                else{
                    l=0;
                }
            sub=Integer.toString(k)+sub;
            }
            AInteger adAInt = new AInteger(sub);
            return adAInt; 
        }
        
        
        
    }


    public AInteger mulAIntegers(AInteger a,AInteger b){
        int d=a.AInteger.length();
        int e=b.AInteger.length();
        if(d>e){
            String x=b.AInteger;
            e=e-1;
            AInteger result=new AInteger();
            for(int i=e;i>=0;i--){
                int y=Integer.parseInt(x.substring(i,i+1));
                AInteger res = new AInteger();
                for(int j=0;j<y;j++){
                    res=addAIntegers(a, res);
                }
                if (i!=e){
                    int k=e-(i);
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
            for(int i=d;i>=0;i--){
                int y=Integer.parseInt(x.substring(i,i+1));
                AInteger res = new AInteger();
                for(int j=0;j<y;j++){
                    res=addAIntegers(a, res);
                }
                if (i!=d){
                    int k=d-(i);
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
            AInteger sres=new AInteger("1");
            int x=(d-e-1);
            for(int i=0;i<x;i++){
                sres.AInteger=sres.AInteger+"0";
            }
            a=subAIntegers(a, mulAIntegers(sres, b));
            AInteger sres4=new AInteger();
            for(int i=1;i>=0;i++){
                AInteger sres2=new AInteger(Integer.toString(i));
                if(Integer.parseInt(mulAIntegers(sres2, b).AInteger)>Integer.parseInt(a.AInteger)){
                    AInteger sres3 = new AInteger(Integer.toString(i-1));
                    sres4 = addAIntegers(sres, sres3);
                    
                }
                
            }
            return sres4;

        }
        else if(d<e){
            AInteger res=new AInteger("0");
            return res;
        }
        else{
            AInteger sres3 = new AInteger();
            for(int i=1;i>=0;i++){
                AInteger sres2=new AInteger(Integer.toString(i));
                if(Integer.parseInt(mulAIntegers(sres2, b).AInteger)>Integer.parseInt(a.AInteger)){
                    sres3 = new AInteger(Integer.toString(i-1));
                }
                
            }
            return sres3;

        }
    }


}