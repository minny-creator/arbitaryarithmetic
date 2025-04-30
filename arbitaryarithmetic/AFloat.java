package arbitaryarithmetic;


public class AFloat{
    String AFloat;

    public AFloat(){
        AFloat = "0.0" ;
    }

    public AFloat parse(String a){
       AFloat b=new AFloat(a);
       return b;
    }

    public AFloat(String A){
        this.AFloat = A;
    }


    public AFloat addAFloat(AFloat a,AFloat b){
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i=0;
        for(i=0;i>=0;i++){
            if(a.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger a2=new AInteger(a.AFloat.substring(i+1,d));
        AInteger a1=new AInteger(a.AFloat.substring(0,i));
        for(i=0;i>=0;i++){
            if(b.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger b2=new AInteger(b.AFloat.substring(i+1,e));
        AInteger b1=new AInteger(b.AFloat.substring(0,i));
        int d2=b2.AInteger.length();
        int e2=a2.AInteger.length();
        int x=d2;
        if(d2>e2){
            x=(d2-e2);
            for(i=1;i<=x;i++){
                b2.AInteger=b2.AInteger+"0";
            }
            x=d2;

        }
        else if(e2>d2){
            x=(e2-d2);
            for(i=1;i<=x;i++){
                a2.AInteger=a2.AInteger+"0";
            }
            x=e2;
        }
        AInteger a3=new AInteger(a1.AInteger+a2.AInteger);
        AInteger b3=new AInteger(b1.AInteger+b2.AInteger);
        AInteger res=a3.addAIntegers(a3, b3);
        int y=res.AInteger.length();
        String v=res.AInteger.substring(0,y-x);
        String z=res.AInteger.substring(y-x,y);
        AFloat result=new AFloat(v+"."+z);
        return result;


    }


    public AFloat subAFloat(AFloat a,AFloat b){
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i=0;
        for(i=0;i>=0;i++){
            if(a.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger a2=new AInteger(a.AFloat.substring(i+1,d));
        AInteger a1=new AInteger(a.AFloat.substring(0,i));
        for(i=0;i>=0;i++){
            if(b.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger b2=new AInteger(b.AFloat.substring(i+1,e));
        AInteger b1=new AInteger(b.AFloat.substring(0,i));
        int d2=b2.AInteger.length();
        int e2=a2.AInteger.length();
        int x=d2;
        if(d2>e2){
            x=(d2-e2);
            for(i=1;i<=x;i++){
                b2.AInteger=b2.AInteger+"0";
            }
            x=d2;

        }
        else if(e2>d2){
            x=(e2-d2);
            for(i=1;i<=x;i++){
                a2.AInteger=a2.AInteger+"0";
            }
            x=e2;
        }
        AInteger a3=new AInteger(a1.AInteger+a2.AInteger);
        AInteger b3=new AInteger(b1.AInteger+b2.AInteger);
        AInteger res=a3.subAIntegers(a3, b3);
        int y=res.AInteger.length();
        String v=res.AInteger.substring(0,y-x);
        String z=res.AInteger.substring(y-x,y);
        AFloat result=new AFloat(v+"."+z);
        return result;


    
        
    }


    public AFloat mulAFloat(AFloat a,AFloat b){
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i=0;
        for(i=0;i>=0;i++){
            if(a.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger a2=new AInteger(a.AFloat.substring(i+1,d));
        AInteger a1=new AInteger(a.AFloat.substring(0,i));
        for(i=0;i>=0;i++){
            if(b.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger b2=new AInteger(b.AFloat.substring(i+1,e));
        AInteger b1=new AInteger(b.AFloat.substring(0,i));
        int d2=b2.AInteger.length();
        int e2=a2.AInteger.length();
        int x=2*d2;
        if(d2>e2){
            x=(d2-e2);
            for(i=1;i<=x;i++){
                b2.AInteger=b2.AInteger+"0";
            }
            x=2*d2;

        }
        else if(e2>d2){
            x=(e2-d2);
            for(i=1;i<=x;i++){
                a2.AInteger=a2.AInteger+"0";
            }
            x=2*e2;
        }
        AInteger a3=new AInteger(a1.AInteger+a2.AInteger);
        AInteger b3=new AInteger(b1.AInteger+b2.AInteger);
        AInteger res=a3.mulAIntegers(a3, b3);
        int y=res.AInteger.length();
        String v=res.AInteger.substring(0,y-x);
        String z=res.AInteger.substring(y-x,y);
        AFloat result=new AFloat(v+"."+z);
        return result;


    }
    


    public AFloat divAFloat(AFloat a,AFloat b){
        int d=a.AFloat.length();
        int e=b.AFloat.length();
        int i=0;
        for(i=0;i>=0;i++){
            if(a.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger a2=new AInteger(a.AFloat.substring(i+1,d));
        AInteger a1=new AInteger(a.AFloat.substring(0,i));
        for(i=0;i>=0;i++){
            if(b.AFloat.substring(i,i+1)=="."){
                
                break;
            }
        }
        AInteger b2=new AInteger(b.AFloat.substring(i+1,e));
        AInteger b1=new AInteger(b.AFloat.substring(0,i));
        int d2=b2.AInteger.length();
        int e2=a2.AInteger.length();
        int x=30;
        if(d2+30>e2){
            x=(d2+30-e2);
            for(i=1;i<=x;i++){
                b2.AInteger=b2.AInteger+"0";
            }
            x=30;

        }
        else if(e2>d2+30){
            x=(e2-d2-30);
            for(i=1;i<=x;i++){
                a2.AInteger=a2.AInteger+"0";
            }
            x=30;
        }
        AInteger a3=new AInteger(a1.AInteger+a2.AInteger);
        AInteger b3=new AInteger(b1.AInteger+b2.AInteger);
        AInteger res=a3.divAIntegers(a3, b3);
        int y=res.AInteger.length();
        String v=res.AInteger.substring(0,y-x);
        String z=res.AInteger.substring(y-x,y);
        AFloat result=new AFloat(v+"."+z);
        return result;


    }
    }
