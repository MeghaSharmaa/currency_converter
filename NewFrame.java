import java.awt.*;
import java.awt.event.*;

class NewFrame extends Frame implements ItemListener
 {
 	Label INR;
 	Checkbox usd,eur,gbp,res,inrusd,inreur,inrgbp;
 	CheckboxGroup rbutton;
 	TextField inp,outp;
 	NewFrame(){
 		super("Currency Converter");
		setBackground(Color.LIGHT_GRAY);
 		INR =new Label("Enter Amount : ");
 		INR.setBounds(60,40,140,30);
 		inp=new TextField("0");
 		inp.setBounds(200,40,60,30);
 		outp=new TextField("0");
 		outp.setBounds(200,190,60,30);
 		rbutton=new CheckboxGroup();
 		usd=new Checkbox("INR->USD",false,rbutton);
 		usd.setBounds(50,90,100,15);
 		eur=new Checkbox("INR->EUR", false, rbutton);
 		eur.setBounds(190,90,100,15);
 		gbp=new Checkbox("INR->GBP",false,rbutton);
 		gbp.setBounds(320,90,100,15);
		inrusd=new Checkbox("USD->INR",false,rbutton);
 		inrusd.setBounds(50,120,100,15);
 		inreur=new Checkbox("EUR->INR", false, rbutton);
 		inreur.setBounds(190,120,100,15);
 		inrgbp=new Checkbox("GBP->INR",false,rbutton);
 		inrgbp.setBounds(320,120,100,15);
        res=new Checkbox("Reset",false,rbutton);
 		res.setBounds(200,150,60,30);
		setLayout(null);
		add(INR);
		add(usd);
		add(eur);
		add(gbp);
		add(inrusd);
		add(inreur);
		add(inrgbp);
		add(res);
		add(inp);
		add(outp);
		usd.addItemListener(this);
		eur.addItemListener(this);
		gbp.addItemListener(this);
		inrusd.addItemListener(this);
		inreur.addItemListener(this);
		inrgbp.addItemListener(this);
        res.addItemListener(this);
		addWindowListener(new MyWindowAdapter());
	}

	 public void itemStateChanged(ItemEvent e) {
		 if(usd.getState()){
			 double d=Double.parseDouble(inp.getText());
			 //converting inr to usd
			 double d1= (d/72.65);
			 String str1=String.valueOf(d1);
			 outp.setText(str1);
		 }
         if(eur.getState()){
            double d2=Double.parseDouble(inp.getText());
            //converting inr to euro
            double d3= (d2/85.7312);
            String str1=String.valueOf(d3);
            outp.setText(str1);
         }
		 if(gbp.getState()){
			 double d4=Double.parseDouble(inp.getText());
			 //converting inr to british pound
			 double d5= (d4/99.3522);
			 String str1=String.valueOf(d5);
			 outp.setText(str1);
		 }
		 if(inrusd.getState()){
			double d6=Double.parseDouble(inp.getText());
			//converting usd to inr
			double d7= (d6*72.65);
			String str1=String.valueOf(d7);
			outp.setText(str1);
		}
		if(inreur.getState()){
			double d8=Double.parseDouble(inp.getText());
			//converting eur to inr
			double d9= (d8*85.7312);
			String str1=String.valueOf(d9);
			outp.setText(str1);
		}
		if(inrgbp.getState()){
			double d10=Double.parseDouble(inp.getText());
			//converting british pound to inr
			double d11= (d10*99.3522);
			String str1=String.valueOf(d11);
			outp.setText(str1);
		}
		 if(res.getState()){
            inp.setText("0");
		 	outp.setText("0");
		 }

	 }

	 class MyWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
 }
