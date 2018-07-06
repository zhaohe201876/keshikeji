package com.djxs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class CreateQRcode2 {

	
	public static void main(String[] args) throws Exception  {
		
		int version=6;
		int width=123;
		int height=123;
		Qrcode qrcode=new Qrcode();
		qrcode.setQrcodeErrorCorrect('L');
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(version);
		  String content="http://www.dijiaxueshe.com";
		byte[] data=content.getBytes("utf-8");//����ת��ʽ��Ҫ�׳��쳣
		boolean[][] qrdata=qrcode.calQrcode(data);
		
		
		//����ͼƬ������
		BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//ͼƬ�滭
		Graphics2D gs=bufferedImage.createGraphics();
		//���ñ�����ɫ
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.GREEN);
		//�������
		gs.clearRect(0,0,width,height);
		
		int pixoff=2;
	      int startR=255,startG=0,startB=0;
	      int endR=0,endG=0,endB=255;
	      for(int i=0;i<qrdata.length;i++){
	    	  for(int j=0;j<qrdata.length;j++){
	    		  if(qrdata[i][j]){
	    			  int num1=startR+(endR-startR)*(i+1)/qrdata.length;
	    			  int num2=startG+(endG-startG)*(i+1)/qrdata.length;
	    			  int num3=startB+(endB-startB)*(i+1)/qrdata.length;
	    			  Color color =new Color(num1,num2,num3);
	    			  gs.setColor(color);
	    		  gs.fillRect(i*3+pixoff, j*3+pixoff, 3, 3);
	    		  }
	    	  }
	      }
	     
	      gs.dispose();
	      bufferedImage.flush();
	      try{
	    	  ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));
	      }catch(Exception e){
	    	  e.printStackTrace();
	    	  System.out.println("����������");
	      }
	      System.out.println("��ά�����ɣ�");
		}

}