package com.project1;


public class App{
    public static void main( String[] args )
    {
        if (args.length == 4){
            if (args[0].equals("int")){
                if(args[1].equals("add") ){
                    AInteger a = new AInteger(args[2]);
                    AInteger b = new AInteger(args[3]);
                    System.out.println(a.addAIntegers(a,b).AInteger);
                }
                else if(args[1].equals("sub")){
                    AInteger a = new AInteger(args[2]);
                    AInteger b = new AInteger(args[3]);
                    System.out.println(a.subAIntegers(a,b).AInteger);

                }
                else if(args[1].equals("mul")){
                    AInteger a = new AInteger(args[2]);
                    AInteger b = new AInteger(args[3]);
                    System.out.println(a.mulAIntegers(a,b).AInteger);
                }
                else if(args[1].equals("div")){
                    AInteger a = new AInteger(args[2]);
                    AInteger b = new AInteger(args[3]);
                    System.out.println(a.divAIntegers(a,b).AInteger);
                }
                else{
                    System.err.println("invalid_arithmetic_operation_error");
                }
                
            }
            else if(args[0].equals("float")){
                if(args[1].equals("add")){
                    AFloat a = new AFloat(args[2]);
                    AFloat b = new AFloat(args[3]);
                    System.out.println(a.addAFloat(a,b).AFloat);
                }
                else if(args[1].equals("sub")){
                    AFloat a = new AFloat(args[2]);
                    AFloat b = new AFloat(args[3]);
                    System.out.println(a.subAFloat(a,b).AFloat);

                }
                else if(args[1].equals("mul")){
                    AFloat a = new AFloat(args[2]);
                    AFloat b = new AFloat(args[3]);
                    System.out.println(a.mulAFloat(a,b).AFloat);

                }
                else if(args[1].equals("div")){
                        AFloat a = new AFloat(args[2]);
                        AFloat b = new AFloat(args[3]);
                        int num=args[4];
                        System.out.println(a.divAFloat(a,b,num).AFloat);
                }
                else{
                    System.err.println("invalid_arithmetic_operation_error");
                }

            }
            else{
                System.err.println("invalid_type_error");
            }
        }
        else{
            System.err.println("invalid_number_of_arguments_for_this_program_error");
        }
    }


}
