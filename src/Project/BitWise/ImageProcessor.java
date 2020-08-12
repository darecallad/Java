package Project.BitWise;

import java.io.File;


public class ImageProcessor extends PPMImage{

    public ImageProcessor(File filename){
        super(filename);

    }

    // this function take message and hide message
    public void hideMessage(String message){

        char[] data=getPixelData();

        byte[] msg=new byte[message.length()+1];

        if(data.length < 8 * msg.length){

            System.err.println("Image size is less for message to be encoded");
            return;
        }

        System.arraycopy(message.getBytes(), 0, msg, 0, message.length());// copy array from source

        msg[message.length()]=0;  // null character added



        int pos=0;

        for(int i=0;i<msg.length;i++){

            byte[] arr=getBytes(msg[i]);


            for(int j=0;j<8;j++){

                data[pos]= (char)((data[pos]&0xFFFE)|arr[j]);

                pos++;
            }


        }

    }

    // this function do retrieves and return message from PPMIMAGE
    public String recoverMessage(){
        String msg="";

        char[] data=getPixelData();


        int pos=0;

        while(true){

            char x=0x0000; // 16 �脖��  hex
            for(int i=0;i<8;i++){

                byte b=(byte) (data[pos]&(0x01));   // 0000-0001
                x= (char)(x|(b<<(7-i)));
                pos++;

            }


            if(x==0)
                break;


            msg+=x;

        }

        return msg;
    }


    // get byte

    protected byte[] getBytes(byte msg){

        byte[] data=new byte[8];

        for(int i=0;i<8;i++){

            data[7-i]= (byte) ((msg>>i)&1) ;
        }




        return data;
    }

    // this function takes no parameters and return no values
    // convert pixel data into sepia color tones.
    // RGB
    public void sepia(){

        char[] data=getPixelData();

        for(int i=0;i<data.length;i+=3){

            int R,G,B;
            R= data[i];
            G=data[i+1];
            B=data[i+2];

			/*
			redResult = (R * .393) + (G *.769) + (B * .189)
			greenResult = (R * .349) + (G *.686) + (B * .168)
			blueResult = (R * .272) + (G *.534) + (B * .131)
			 */
            data[i]=clip((R * 0.393) + (G *0.769) + (B * 0.189));
            data[i+1]=clip((R * 0.349) + (G *0.686) + (B * 0.168));
            data[i+2]=clip((R * 0.272) + (G *0.534) + (B * 0.131));

        }

    }

    // clip --- function set 0~255
    protected char clip(double v){

        if(v<0)
            return 0;

        if(v>255){
            return 255;
        }
        return (char)v;
    }

    // gray function -- make image no longer in color
    public void grayscale(){
        char[] data=getPixelData();

        for(int i=0;i<data.length;i+=3){
            double R,G,B;
            R= data[i];
            G=data[i+1];
            B=data[i+2];

			/*
			 redResult = (R * .299) + (G * .587) + (B * .114)
			 greenResult = (R * .299) + (G * .587) + (B * .114)
			 blueResult = (R * .299) + (G * .587) + (B * .114)
			 */
            char v=clip((R * .299) + (G * .587) + (B * .114));

            data[i]=data[i+1]=data[i+2]=v;

        }

    }

    // this function takes no parameters and values.
    // convert pixel data into negative
    public void negative(){

        char[] data=getPixelData();

		/*
		redResult = 255 - R
		greenResult = 255 - G
		blueResult = 255 �� B
		 */

        for(int i=0;i<data.length;i++){

            data[i]=(char) (255-data[i]);

        }
    }

}